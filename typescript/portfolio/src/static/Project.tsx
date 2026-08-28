"use client";

import Tag from "./Tag";
import GetViews from "@/component/GetViews";
import Image from "next/image";


// this is the project when it appears on the home screen
export default function Project ({ title, image, text, tags, slug }: 
    { title: string, image: string, text: string, tags: string[], slug: string }) {

    return (<>
        <div className="overflow-hidden">
            <div className="flex">
                <a href={slug} aria-label={text}>
                    {/* each full card */}
                    <div className="
                    flex flex-col
                    transition-all
                    hover:scale-[1.02]
                    overflow-hidden
                    bg-black/20
                    rounded-xl
                    w-[900px]
                    text-white
                    ">
                        {/* project image */}
                        <div className="w-full h-80 bg-black rounded-t-lg flex justify-center items-center">
                            <img className="w-full h-full object-contain" alt={text} src={image}/>
                        </div>
                        
                        {/* project details */}
                        <div className="p-4">
                            {/* title */}
                            <div className="text-xl font-medium mb-4">{title}</div>

                            {/* view count */}
                            <GetViews slug={slug} />

                            {/* summary */}
                            <p>{text}</p>

                            {/* Technologies used tags */}
                            <ul className="mt-2 flex flex-wrap" aria-label="Technologies used:">
                                {tags.map((item, index) =>
                                    <li key={index} className="mr-1.5 mt-2"><Tag title={item} /></li>
                                )}
                            </ul>
                        </div>
                    </div>
                </a>
            </div>
        </div>
    </>);
}