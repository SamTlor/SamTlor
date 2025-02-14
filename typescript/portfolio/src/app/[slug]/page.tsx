import { getProjects } from "@/app/utils";
import PostViews from "@/component/PostViews";

import { GlobalStateProvider } from "@/contexts/GlobalStateContext";
import Modal from "@/component/layout/Modal";
import Navbar from "@/component/layout/Navbar";
import BurgerMenu from "@/component/menu/BurgerMenu";
import Footer from "@/component/layout/Footer";
import Image from "next/image";

import { CustomMDX } from "@/component/mdx";

// import TransitionGradient  from "@/transitions/transition_grey.svg";

export default function Page({ params }: {params: { slug: string }}){
    
    // TODO: maybe use AWS for the getProjects function like just move all the mdx file to a s3 bucket
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
                    <img className="w-full h-44" src="/transitions/transition_gradient.svg" alt="transition" />
                    {/* <TransitionGradient className="w-full h-44" /> */}
                    <a href="/#Projects">Go back home</a>
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