import Tag from "./Tag";

function Project ({ headline, image, text, tags, link }: { headline: string, image: string, text: string, tags: string[], link: string }) {
    return (
        <a href={link} aria-label={text}>
            <div className="flex flex-col transition-all hover:scale-105 scale-100 bg-opacity-20 bg-black rounded-lg max-h-max max-w-96 m-3 text-white">
                <div className="w-full h-64 bg-black rounded-t-lg flex justify-center items-center">
                    <img className="w-full h-full object-contain" alt={text} src={image} />
                </div>
                
                <div className="p-4">
                    <div className="text-xl font-medium mb-4">{headline}</div>
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