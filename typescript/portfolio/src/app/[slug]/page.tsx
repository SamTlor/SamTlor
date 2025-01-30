import { getProjects } from "@/app/utils";

import Modal from "@/component/layout/Modal";
import { GlobalStateProvider } from "@/contexts/GlobalStateContext";
import Footer from "@/component/layout/Footer";
import NotFound from "../NotFound";
import PostViews from "@/component/PostViews";

export default function Page({ params }: {params: { slug: string }}){
    let project = getProjects().find((project) => project.slug === params.slug);
    
    if (!project){
        return ( 
            <GlobalStateProvider >
                <div className="flex items-center flex-col min-h-screen desktop:px-20 mobile:p-6 bg-gradient-to-r from-gradientLeft to-gradientRight">
                    <div className="flex mobile:justify-center desktop:flex-row desktop:items-center mobile:flex-col-reverse items-center w-full flex-1">
                        <div className="flex flex-col z-20 pointer-events-none text-white desktop:w-3/5 mobile:w-full mobile:text-center">
                            <NotFound />
                        </div>
                    </div>
                </div>
                <Footer />
            </GlobalStateProvider>
        );
    } else {
        return (
            <GlobalStateProvider >
                {/* updates the view_count but nothing else */}
                <PostViews title={project.metadata.title} slug={project.slug} />

                <div className="bg-slate-800" id="About">
                    <img className="w-full h-44" src="/transitions/transition_gradient.svg" alt="transition" />
                    <a href="/#Projects">Go back home</a>
                    <div className="flex justify-center items-center text-white">
                        <div className="flex flex-row w-full">
                            {/* left */}
                            <div className="flex desktop:w-1/2 mobile:w-full mobile:p-4 flex-col desktop:p-20">
                                <article className="desktop:text-xl mobile:text-md" itemScope >
                                    <p className="mb-5">
                                        title: {project.metadata.title}
                                    </p>
                                </article>
                            </div>


                            {/* right */}
                            <div className="desktop:flex mobile:hidden w-1/2 flex-col pl-10 space-y-6">
                            </div>

                        </div>
                    </div>
                </div>
                
                <Footer />
            </GlobalStateProvider>
        )
    }
};