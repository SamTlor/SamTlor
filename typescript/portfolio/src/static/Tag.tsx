function Tag({ title }: { title: string }) {
    return (
        <div className="flex items-center rounded-full bg-peach/10 px-3 py-1 text-xs font-medium leading-5 text-peach">
            {title}
        </div>
    );
}

export default Tag;