import { db } from "@/db";

// export async function GET(){
//     return new Response("Hello", { status: 200 });
// }

export async function GET(request: Request) {
    try {
        // Extract query params from the URL
        const { searchParams } = new URL(request.url);
        const slug = searchParams.get("slug"); // Get 'slug' parameter

        if (!slug) {
            return new Response("Missing slug parameter", { status: 400 });
        }

        // Find the project by slug
        const existingPost = await db.projects.findUnique({
            where: { slug },
            select: { view_count: true }, // Only fetch the view_count
        });

        if (!existingPost) {
            return new Response("Project not found", { status: 404 });
        }

        return new Response(JSON.stringify({ view_count: existingPost.view_count }), {
            status: 200,
            headers: { "Content-Type": "application/json" },
        });
    } catch (error) {
        console.error("Failed to get page view:", error);
        return new Response("Failed to get page view", { status: 500 });
    }
}

// if there's not a project in the database with the slug and title the function is given create one
// otherwise increment the view_count for the project
export async function POST(request: Request){
    const {slug, title } = await request.json();

    try{
        const existingPost = await db.projects.findUnique({
            where: {slug: slug},
        });

        if (!existingPost) {
            await db.projects.create({
                data: {
                    slug: slug,
                    title: title,
                }
            });
        } else {
            await db.projects.update({
                where: {slug: slug},
                data: {
                    view_count: { increment: 1 },
                }
            });
        }
    } catch(error){
        console.error("Error updating page view: ", error);
        return new Response("failed to post to DB", { status: 500});
    }

    return new Response("Succesfully posted to DB", { status: 200 });
};