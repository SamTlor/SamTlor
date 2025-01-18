import About from "@/component/layout/About";
import Footer from "@/component/layout/Footer";
import Hero from "@/component/layout/Hero";
import Navbar from "@/component/layout/Navbar";
import Projects from "@/component/layout/Projects";
import Services from "@/component/layout/Services";
import '../globals.css'
import BurgerMenu from "@/component/menu/BurgerMenu";
import Modal from "@/component/layout/Modal";
import { GlobalStateProvider } from "@/contexts/GlobalStateContext";

export default function SpotifyAdder() {
    return (
        
        <GlobalStateProvider >
            <Modal />
            <div className="bg-slate-800" id="About">
                <img className="w-full h-44" src="/transitions/transition_gradient.svg" alt="transition" />
                <a href="/#Projects">Go back home</a>
                <div className="flex justify-center items-center text-white">
                    <div className="flex flex-row w-full">
                        {/* left */}
                        <div className="flex desktop:w-1/2 mobile:w-full mobile:p-4 flex-col desktop:p-20">
                            <article className="desktop:text-xl mobile:text-md" itemScope >
                                <p className="mb-5">
                                    
                                BoxOfficeMaxTV+ | SQL, HTML, CSS, PHP
                                ●	Designed and implemented comprehensive SQL database system that efficiently stored and managed data related to movies, actors, and their respective awards.
                                ●	Designed Entity Relationship Diagram.
                                ●	Crafted user-friendly front-end website that provided easy access to stored information, enhancing user experience and accessibility.
                                ●	Implemented secure login system with role-based access control, allowing administrators to modify database content while restricting normal users to read-only access, enhancing data security.


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
    );
}