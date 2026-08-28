'use client'

import SocialMedia from "@/static/SocialMedia";
import Typing from "@/static/Typing";
import Link from "next/link";
import Image from "next/image";

function Hello() {
    return <div id = "Hello" className="flex items-center flex-col min-h-screen desktop:px-20 bg-greetings">
        {/* spacer for nav bar */}
        <div className="hidden desktop:block h-16"></div>

        
        <div className="flex mobile:justify-center desktop:flex-row desktop:items-center mobile:flex-col-reverse items-center w-full flex-1">
            <div className="flex flex-col z-20 pointer-events-none text-white desktop:w-3/5 mobile:w-full mobile:text-center font-display">
                <p className="desktop:text-[5vw] mobile:text-[8vw] font-bold text-textHighlight w-full">Hello, I&apos;m Sam</p>
                <p className="desktop:text-[2vw] mobile:text-[5vw]">I apply data analytics principles to solve complex problems and communicate insights clearly.</p>
                <p className="desktop:text-[2vw] mobile:text-[5vw]">I have experience with <Typing /></p>
                
                <div className='flex mobile:hidden mt-6 justify-start w-[17vw]'><SocialMedia size={200} /></div>
            </div>

            <div className="relative w-1/5mobile:w-full mobile:max-w-xl self-center rounded-full overflow-hidden border-4 border-tie">
                <Image  
                    src="/images/samPicture.jpg" 
                    alt="Portrait"
                    width={300}
                    height={500}
                    className="object-cover animate-scalepulse"
                />
            </div>
        </div>

        <div className="h-16 bg-slate-800" />
    </div>

}

export default Hello;