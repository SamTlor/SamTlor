import { db } from "@/db";

export default async function GetViews({ slug }: { slug: string }) {
    const project = await db.projects.findUnique({
        where: { slug: slug },
    });

    return <div className="mt-4 text-sm text-gray-400">{project?.view_count ?? 0} views</div>;
}