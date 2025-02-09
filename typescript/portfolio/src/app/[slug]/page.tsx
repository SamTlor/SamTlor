import { getProjects } from "@/app/utils";
import PostViews from "@/component/PostViews";

import { GlobalStateProvider } from "@/contexts/GlobalStateContext";
import Modal from "@/component/layout/Modal";
import Navbar from "@/component/layout/Navbar";
import BurgerMenu from "@/component/menu/BurgerMenu";
import Footer from "@/component/layout/Footer";
import Image from "next/image";

import { CustomMDX } from "@/component/mdx";

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

                {/* PostViews updates the view_count but doesn't add text or anything */}
                {/* TODO: it doesn't work when deployed on vercel */}
                {/* npx prisma migrate dev --name init */}
                <PostViews title={project.metadata.title} slug={project.slug} />

                <div className="bg-slate-800" id="About">
                    <Image className="w-full h-44" src="/transitions/transition_gradient.svg" alt="transition" />
                    <a href="/#Projects">Go back home</a>
                    <div className="flex justify-center items-center text-white">
                        <div className="flex flex-row w-full">
                            








                            {/* left */}
                            {/* <div className="flex desktop:w-1/2 mobile:w-full mobile:p-4 flex-col desktop:p-20">
                                <article className="desktop:text-xl mobile:text-md" itemScope >
                                    <p className="mb-5">
                                        title: {project.content}
                                    </p>
                                </article>
                            </div> */}


                            {/* right */}
                            {/* <div className="desktop:flex mobile:hidden w-1/2 flex-col pl-10 space-y-6">
                            </div> */}
                            
                            <CustomMDX source={project.content}/>
                        </div>
                    </div>
                </div>
                
                <Footer />
            </GlobalStateProvider>
        );
    }
};