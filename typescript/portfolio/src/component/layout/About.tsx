import Summary from "@/static/Summary";
import Timeline from "@/static/Timeline";
import Image from 'next/image';

function About() {
    return <div className="bg-slate-800" id="About">
        {/* <div className="relative w-full h-44">
            <img className="w-full h-full object-cover" src="/transitions/transition_gradient.svg" alt="transition" />
        </div> */}
        {/* <img className="w-full h-44" src="/transitions/transition_gradient.svg" alt="transition" /> */}
        



        <div className="flex justify-center items-center text-white">
            {/* <div className="flex flex-row w-full">
                <div className="flex desktop:w-1/2 mobile:w-full mobile:p-4 flex-col desktop:p-20">
                    <Summary />
                </div>
                <div className="desktop:flex mobile:hidden w-1/2 flex-col pl-10">
                    <Timeline />
                </div>
            </div> */}
            

            <div className="flex flex-col desktop:flex-row w-full">
                <div className="flex desktop:w-1/2 w-full p-4 desktop:p-20 flex-col">
                    <Summary />
                </div>

                <div className="flex desktop:w-1/2 w-full p-4 desktop:p-20 flex-col">
                    <Timeline />
                </div>
            </div>

            <div className="relative w-full h-34 bg-gradient-to-r from-gradientLeft to-gradientRight overflow-hidden">
                <img 
                    src="/transitions/transition_grey.svg" 
                    alt="transition" 
                    className="object-cover w-full h-full mobile:scale-y-100 desktop:scale-y-[-1] block"
                />
            </div>
            {/* <img className="w-full h-44" src="/transitions/transition_grey.svg" alt="transition" /> */}

        </div>
    </div>
}

export default About;