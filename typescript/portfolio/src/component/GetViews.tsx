'use client';

import useSWR from "swr";
import { fetchUrl, fetcher } from "@/lib/utils";
import Project from "@/static/Project";

// gets the view count for a project and displays it
// this is only used in the featured projects section
// https://vercel.com/sams-projects-082b6bfb/samtaylor/integrations/neon/icfg_peseunubTFPM3Z33Hl9m0mrD/resources/storage/store_0nvb9ZvB0qjvsisz/schema?schema=public
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