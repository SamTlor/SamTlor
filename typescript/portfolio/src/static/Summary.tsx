
function Summary(){
    return (<>
        <p className="text-4xl mb-8 bg-[#84ffff] text-black px-4 py-2 rounded-full inline">
            About me
        </p>

        <article className="desktop:text-xl mobile:text-md" itemScope >
            <p className="mb-5">
                I&apos;m a fullstack developer with experience in a lot of different fileds. So far 
                I&apos;ve worked on prompt engineering for custom AI bots, integrating APIs to safeguard 
                sensitive information and implementing AWS services. 
            </p>
        </article>
    </>);
}

export default Summary;