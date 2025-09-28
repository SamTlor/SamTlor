import Project from "@/static/Project";
import { getProjects } from "@/app/utils";import Image from "next/image";


export default function Projects() {
    
    return (
        <>
            <div id="Projects" className="bg-aqua">
                <img className="w-full h-32" src="/transitions/transition_grey.svg" alt="transition" />
                <p className="flex text-4xl backdrop-blur-xs p-6">Featured Projects</p>
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

            {/* transitions to 'you have a job opening' */}
            <div className="relative w-full h-32 bg-aqua overflow-hidden">
                <div className="group-mobile">
                    <img 
                        src="/transitions/transition_grey.svg" 
                        alt="transition" 
                        className="object-cover w-full h-full desktop:scale-y-[-1] block"
                    />
                </div>
            </div>
        </ >
    );
}