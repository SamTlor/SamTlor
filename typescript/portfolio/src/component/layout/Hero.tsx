'use client'

import Arrow from "@/static/Arrow";
import SocialMedia from "@/static/SocialMedia";
import Typing from "@/static/Typing";
import Link from "next/link";
import Image from "next/image";

function Hero() {
    return <>
        <div className="flex items-center flex-col min-h-screen desktop:px-20 mobile:p-6 bg-gradient-to-r from-gradientLeft to-gradientRight">
            <div className="flex mobile:justify-center desktop:flex-row desktop:items-center mobile:flex-col-reverse items-center w-full flex-1">
                    <div className="flex flex-col z-20 pointer-events-none text-white desktop:w-3/5 mobile:w-full mobile:text-center">
                        <p className="desktop:text-[5vw] mobile:text-[8vw] font-bold text-lightcyan w-full">Greetings, I&apos;m Sam</p>
                        <p className="desktop:text-[3vw] mobile:text-[5vw]">a developer with experience in <Typing /></p>
                        
                        <div className='flex mobile:hidden mt-6 justify-start w-[17vw]'><SocialMedia size={200} /></div>
                    </div>

                    <div className="relative w-1/5mobile:w-full mobile:max-w-xl self-center rounded-full overflow-hidden border-4 border-[#84ffff]">
                        <Image  
                            src="/images/samPicture.jpg" 
                            alt="Portrait"
                            width={300}
                            height={500}
                            className="object-cover animate-scalepulse"
                        />
                    </div>


                </div>
                <div className="desktop:absolute desktop:bottom-10 inset-0 flex items-end py-2 justify-center z-10">
                <Link href={"/#About"} aria-label='About' >
                    <Arrow />
                </Link>
            </div>
        </div>
        <div className="relative w-full h-34 bg-gradient-to-r from-gradientLeft to-gradientRight overflow-hidden">
            <img 
                src="/transitions/transition_grey.svg" 
                alt="transition" 
                className="object-cover w-full h-full mobile:scale-y-100 desktop:scale-y-[-1] block"
            />
        </div>
    </>
}

export default Hero;