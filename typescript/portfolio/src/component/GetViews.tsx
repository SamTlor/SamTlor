'use client';

import useSWR from "swr";
import { fetchUrl, fetcher } from "@/lib/utils";
import Project from "@/static/Project";

export default function GetViews({ slug }: { slug: string }) {

    interface project {
        id: number;
        slug: string;
        title: string;
        view_count: number;
    }
    const { data, error, isLoading } = useSWR<project[]>(`${fetchUrl}?table=projects`, fetcher);

    return (
        <div className="mt-4 text-sm text-gray-400">
            
            {isLoading && <p>Loading...</p>}
            {error && <p>View count failed.</p>}
            {data && (() => {
                const project = data.find((p) => p.slug === slug);
                return <p>{project ? `${project.view_count} views` : "No views found"}</p>;
            })() }
                
            
        </div>
    );
}