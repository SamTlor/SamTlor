// these are functions for the entire website. they read and process data so that it can be displayed





/**********
* IMPORTS *
**********/
import fs from 'fs';
import path from 'path';
import matter from 'gray-matter';



/********************************************
* HELPER FUNCTIONS FOR THE EXPORT FUNCTIONS *
********************************************/

// get mdx files from the contents directory 
function getMDXfiles(dir: string) {
    return fs.readdirSync(dir).filter((file) => path.extname(file) === ".mdx");
}

// read the data from those files
function readMDXfile(filepath: fs.PathOrFileDescriptor){
    let rawContent = fs.readFileSync(filepath, "utf-8");
    return matter(rawContent);
}

// present the data and metadata
function getMDXdata(dir: string){
    let mdxFile = getMDXfiles(dir)
    return mdxFile.map((file) => {
        let { data: metadata, content } = readMDXfile(path.join(dir, file));
        let slug = path.basename(file, path.extname(file));

        return {
            metadata,
            slug, 
            content,
        }
    })
}



/*******************
* EXPORT FUNCTIONS *
*******************/
export function getProjects(){
    return getMDXdata(path.join(process.cwd(), "src", "app", "projects"));
}

export function getProjectsWithAWS(){

}

export function formatDate(date: string, includeRelative = true){
    let currentDate = new Date();
    if(date.includes('T')){
        date = `${date}T00:00:00`;
    }

    let targetDate = new Date(date);
    let yearsAgo = currentDate.getFullYear() - targetDate.getFullYear();
    let monthsAgo = currentDate.getMonth() - targetDate.getMonth();
    let daysAgo = currentDate.getDate() - targetDate.getDate();

    let formattedDate = "";

    if (yearsAgo > 0){
        formattedDate = `${yearsAgo}y ago`;
    }
    else if (monthsAgo > 0){
        formattedDate = `${monthsAgo}mo ago`;
    }
    else if (daysAgo > 0){
        formattedDate = `${daysAgo}d ago`;
    } else {
        formattedDate = "Today";
    }

    let fullDate = targetDate.toLocaleString("en-us", {
        month: "long",
        day: "numeric",
        year: "numeric",
    })

    if(!includeRelative){
        return fullDate;
    }
    return `${fullDate} (${formattedDate})`;
}