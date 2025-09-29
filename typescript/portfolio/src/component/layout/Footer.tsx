import SocialMedia from "@/static/SocialMedia";
import Image from "next/image";


function Footer() {
    return <div className="bg-sunset">
        {/* transition from 'you have a job opening' to footer */}
        <img 
            src="/transitions/transition_grey.svg" 
            alt="transition" 
            className="object-fill w-full h-32 mobile:scale-y-[-1] desktop:scale-y-[1] block" 
        />
        
        <footer className="flex flex-col items-center">
            <div className="pt-5">
                <SocialMedia size={35} />
            </div>
            <div className="flex text-white text-center p-5">&copy; {new Date().getFullYear()} All rights reserved.</div>
        </footer>
    </div>
}

export default Footer;