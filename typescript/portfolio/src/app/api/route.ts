import { db } from "@/db";

export async function GET(){
    return new Response("Hello", { status: 200 });
}


// if there's not a project in the database with the slug and title the function is given create one
// otherwise increment the view_count for the project
export async function POST(request: Request){
    const {slug, title } = await request.json();

    try{
        const existingProject = await db.projects.findUnique({
            where: {slug: slug},
        });

        if (!existingProject) {
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
        return new Response("failed to update DB", { status: 500});
    }

    return new Response("Succesfully updated DB", { status: 200 });
};