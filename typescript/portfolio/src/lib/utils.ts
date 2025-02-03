export const fetchUrl = process.env.NODE_ENV === 'development' 
    ? "http://localhost:3000/api" 
    : "https://samtaylor.vercel.app/api";

type ResponseProjectData = {
    slug: string;
    title: string;
    view_count: Int16Array;
}

export const projectFetcher = (
    ...args: Parameters<typeof fetch>
): Promise<ResponseProjectData> => fetch(...args).then((res) => res.json());