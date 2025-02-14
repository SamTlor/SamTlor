import Summary from "@/static/Summary";
import Timeline from "@/static/Timeline";
import Image from 'next/image';

function About() {
    return <div className="bg-slate-800" id="About">
        <div className="flex justify-center items-center text-white">
            <div className="flex flex-col desktop:flex-row w-full">
                <div className="flex desktop:w-1/2 w-full p-4 desktop:p-20 flex-col">
                    <Summary />
                </div>

                <div className="flex desktop:w-1/2 w-full p-4 desktop:p-20 flex-col">
                    <Timeline />
                </div>
            </div>
        </div>
    </div>
}

export default About;