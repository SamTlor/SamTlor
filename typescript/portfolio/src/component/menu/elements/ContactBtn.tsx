'use client'

import { useGlobalState } from "@/contexts/GlobalStateContext";
import { useEffect } from "react";

const ContactBtn = ({title}:{title:string}) => {
    
    const { isModalOpen, toggleModal, exitMenu } = useGlobalState();

    const handleClick = () => {
        exitMenu();
        toggleModal();
    }

    useEffect(() => {
        if (isModalOpen) {
            document.body.classList.add("overflow-y-hidden")
        } else {
            document.body.classList.remove("overflow-y-hidden")
        }
    }, [isModalOpen]);
    
    return (
        <button className='flex items-center cursor-pointer'>
            <div aria-label={title} className={"transition ease-in-out duration-300 text-center bg-[#84ffff] text-black border-2 border-[#84ffff] rounded-3xl px-3 py-1 hover:bg-transparent hover:text-[#84ffff]"} onClick={handleClick} >
                {title}
            </div>
        </button>
    );
}

export default ContactBtn;