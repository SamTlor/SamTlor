import Project from "@/static/Project";
import { getProjects } from "@/app/utils";import Image from "next/image";


export default function Projects() {
    
    return (
        <div id="Projects" className="bg-gradient-to-r from-gradientLeft to-gradientRight">
            {/* <img className="w-full h-44" src="/transitions/transition_grey.svg" alt="transition" /> */}
            <p className="flex text-4xl my-8 justify-center text-white font-bold">Featured Projects</p>
            <div className="flex flex-wrap w-full desktop:px-20 justify-center">
                {getProjects()
                .filter((project) => project.metadata.title != "NotFound")
                .map((project) =>
                    <Project
                        key = {project.metadata.id}
                        title = {project.metadata.title} 
                        image = {project.metadata.image} 
                        text = {project.metadata.text} 
                        tags = {project.metadata.tags} 
                        slug = {project.slug} 
                    />
                )}
            </div>
        </div>
    );
}