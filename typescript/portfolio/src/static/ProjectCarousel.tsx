"use client";

import useEmblaCarousel from "embla-carousel-react";
import Project from "@/static/Project";

// maybe move this all over to Project.tsx so that i don't get the implicitly 'any' error
export default function ProjectsCarousel({ projects }: {projects : any}) {
    const [emblaRef, emblaApi] = useEmblaCarousel({ loop: true });

    return (<>
        <div className="overflow-hidden" ref={emblaRef}>
            <div className="flex">
                {projects.map((project: any) => (
                    <div key={project.metadata.title} className="flex-[0_0_100%] flex justify-center px-4">
                        <p>{project.metadata.id == 'undefined'}</p>
                        <Project
                            title={project.metadata.title}
                            image={project.metadata.image}
                            text={project.metadata.text}
                            tags={project.metadata.tags}
                            slug={project.slug}
                        />
                    </div>
                ))}
            </div>
        </div>

        <div className="flex justify-center gap-4 mt-8">
            <button
                onClick={() => emblaApi?.scrollPrev()}
                className="px-4 py-2 rounded-full bg-slate-700 text-white"
            >
                ←
            </button>

            <button
                onClick={() => emblaApi?.scrollNext()}
                className="px-4 py-2 rounded-full bg-slate-700 text-white"
            >
                →
            </button>
        </div>
    </>);
}