import { getProjects } from "@/app/utils";
import PostViews from "@/component/PostViews";

import { GlobalStateProvider } from "@/contexts/GlobalStateContext";
import Modal from "@/component/layout/Modal";
import Navbar from "@/component/layout/Navbar";
import BurgerMenu from "@/component/menu/BurgerMenu";
import Footer from "@/component/layout/Footer";
import Image from "next/image";

import { CustomMDX } from "@/component/mdx";

// this is the page you get when you click on a project
export default function Page({ params }: {params: { slug: string }}){
    
    const allProjects = getProjects();
    let project = allProjects.find((project) => project.slug === params.slug)
                || allProjects.find((project) => project.slug === "NotFound");

    if (project) {
        return (
            <GlobalStateProvider >
                <Navbar />
                <Modal />
                <BurgerMenu />

                <PostViews title={project.metadata.title} slug={project.slug} />

                <div className="bg-slate-800" id="About">
                    {/* spacer for nav bar */}
                    <div className="h-16"></div>
                    
                    <a href="/#Projects" className="
                        inline-flex
                        items-center
                        gap-2
                        ml-4
                        mb-6
                        px-4
                        py-2
                        rounded-full
                        border
                        border-tie
                        text-tie
                        hover:bg-tie
                        hover:text-slate-900
                        transition-all">← Back to Projects
                    </a>
                    <div className="flex justify-center items-center text-white">
                        <div className="flex flex-row w-full">
                            <CustomMDX source={project.content}/>
                        </div>
                    </div>
                </div>
                
                <Footer />
            </GlobalStateProvider>
        );
    }
};