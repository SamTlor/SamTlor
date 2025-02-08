export const fetchUrl = process.env.NODE_ENV === 'development' 
    ? "http://localhost:3000/api" 
    : "https://samtaylor.vercel.app/api";

type FetcherResponse<T> = T[];

export const fetcher = <T>(
    ...args: Parameters<typeof fetch>
): Promise<FetcherResponse<T>> => fetch(...args).then((res) => res.json());