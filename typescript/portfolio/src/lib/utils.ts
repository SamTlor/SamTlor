export const fetchUrl = process.env.NODE_ENV === 'development' 
    ? "http://localhost:3000/api" 
    : "https://samtaylor.vercel.app/api";