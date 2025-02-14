import Service from "@/static/Service";
import ContactBtn from "../menu/elements/ContactBtn";
import Image from "next/image";
// import TransitionGradient  from "@/transitions/transition_grey.svg";


function Services() {
    return <div id="Services" className="flex text-white min-h-full flex-col items-center bg-slate-800">
        <p className="desktop:text-[40px] mobile:text-[24px] font-bold text-center mb-4">You have a job opening?</p>
        <ContactBtn title={"Contact Me"} />

    </div>
}

export default Services;