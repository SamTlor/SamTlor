import Project from "@/static/Project";
import { getProjects } from "@/app/utils";import Image from "next/image";
import useEmblaCarousel from 'embla-carousel-react';
import ProjectsCarousel from "@/static/ProjectCarousel";



export default function Projects() {
    const projects = getProjects().filter((project) => project.metadata.title !== "NotFound")

    return (
        <>
            <div id="Projects" className="bg-projects pt-16">
                {/* page title */}
                <div className="text-center mb-12">
                    <p className="inline-block text-4xl bg-textHighlight text-black px-6 py-3 rounded-full font-display">
                        Featured Projects
                    </p>
                </div>

                {/* project selector */}
                <ProjectsCarousel projects={projects} />

                {/* spacer for footer */}
                <div className="hidden desktop:block h-16"></div>
            </div>
        </>
    );
}