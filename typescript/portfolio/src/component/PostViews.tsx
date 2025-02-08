'use client'

import { useEffect, useRef } from "react";
import { fetchUrl } from "@/lib/utils";

export default function PostViews({title, slug}: {title: string, slug: string}) {
    const hasPosted = useRef(false);

    useEffect(() => {
        if (hasPosted.current) return;
        hasPosted.current = true;

        const postData = async() => {
            try{
                await fetch(fetchUrl, {
                    method: "POST",
                    headers: {
                        "content-Type": "application/json",
                    },
                    body: JSON.stringify({ title, slug })
                });
            } catch(error){
                console.error("PostViews error: ", error)
            }
        }
        postData();
    }, [title, slug]);

    return null;
};