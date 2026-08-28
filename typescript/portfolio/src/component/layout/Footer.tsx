import SocialMedia from "@/static/SocialMedia";
import Image from "next/image";
import ContactBtn from "../menu/elements/ContactBtn";


function Footer() {
    return <div className="bg-footer">
        <div className="hidden desktop:block h-6"></div>
        
        <div id="Contact" className="flex text-white min-h-full flex-col items-center">
            <p className="desktop:text-[40px] mobile:text-[24px] font-bold text-center mb-4">Do you have a job opening?</p>
            <ContactBtn title={"Contact Me"} />
        </div>
        
        <footer className="flex flex-col items-center">
            <div className="pt-5">
                <SocialMedia size={35} />
            </div>
        </footer>
    </div>
}

export default Footer;