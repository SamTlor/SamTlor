import { db } from "@/db";

// get the tablename or viewname 
// views aren't in the database so we select all from that view
export async function GET(req: Request){
    try {
        const { searchParams } = new URL(req.url);
        const tableName = searchParams.get("table");
        const viewName = searchParams.get("view");
        
        if (tableName){
            if (tableName in db){
                const tableData = await (db as any)[tableName].findMany();
                return Response.json(tableData, { status: 200 })
            }
        } 
        
        else if (viewName){
            const viewData = await db.$queryRawUnsafe(`SELECT * FROM ${viewName}`);

            return new Response(JSON.stringify(viewData, (_, v) => 
                typeof v === "bigint" ? v.toString() : v
            ), { status: 200 });
        }

        return Response.json({ error: "Name is missing or incorrect" }, { status: 400 });

    } catch(error){
        console.error("Get api failed: ", error);
        return Response.json(`Get api failed: ${error}`, { status: 500 })
    }
}



// if there's not a project in the database with the slug and title the function is given create one
// otherwise increment the view_count for the project
export async function POST(request: Request){

    try {
        const {slug, title } = await request.json();

        await db.projects.upsert({
            where: {slug: slug},
            update: {view_count: { increment: 1}},
            create: {slug: slug, title: title, view_count: 1}
        })

    } catch(error){
        console.error("Error updating page view: ", error);
        return new Response("failed to update DB", { status: 500});
    }

    return new Response("Succesfully updated DB", { status: 200 });
};