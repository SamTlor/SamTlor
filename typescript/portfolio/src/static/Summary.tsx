
function Summary(){
    return (<>
        <p className="text-4xl mb-8 bg-textHighlight text-black px-4 py-2 rounded-full inline font-display">
            About Me
        </p>

        <article className="desktop:text-xl mobile:text-md font-sans" itemScope >
            <p className="mb-5">
                My experience spans software engineering, data science, and AI development. I have worked in Agile and Scrum-based development environments where I contributed to the design and development of agentic AI assistants. I translated complex requirements into practical AI-driven solutions while collaborating closely with cross-functional teams.
            </p>

            {/* TODO: redo this once you have more details about your finished projects */}
            <p className="mb-5">
                My projects have included machine learning, statistical analysis, data visualization, web development, database design, and space-weather research using data from NASA missions.
            </p>
            <p className="mb-5">
                I&apos;m particularly interested in opportunities that leverage data to support environmental initiatives, public-sector projects, and space exploration.

            </p>
        </article>
    </>);
}

export default Summary;