function Tag({ title }: { title: string }) {
    return (
        <div className="flex items-center rounded-full bg-textHighlight/10 px-3 py-1 text-xs font-medium leading-5 text-tie">
            {title}
        </div>
    );
}

export default Tag;