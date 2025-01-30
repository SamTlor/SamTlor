import Tag from "./Tag";
import { useEffect } from "react";
import GetViews from "@/component/GetViews";

// this is the project when it appears on the home screen
function Project ({ title, image, text, tags, slug }: { title: string, image: string, text: string, tags: string[], slug: string }) {
    return (
        <a href={slug} aria-label={text}>
            <div className="flex flex-col transition-all hover:scale-105 scale-100 bg-opacity-20 bg-black rounded-lg max-h-max max-w-96 m-3 text-white">
                <div className="w-full h-64 bg-black rounded-t-lg flex justify-center items-center">
                    <img className="w-full h-full object-contain" alt={text} src={image} />
                </div>
                
                <div className="p-4">
                    <div className="text-xl font-medium mb-4">{title}</div>
                    <GetViews slug={slug} />
                    <p>{text}</p>
                    <ul className="mt-2 flex flex-wrap" aria-label="Technologies used:">
                        {tags.map((item, index) =>
                            <li key={index} className="mr-1.5 mt-2"><Tag title={item} /></li>
                        )}
                    </ul>
                </div>
            </div>
        </a>
    );
}

export default Project;