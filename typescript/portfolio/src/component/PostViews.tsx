'use client'

import { useEffect } from "react";
import { fetchUrl } from "@/lib/utils";

export default function PostViews({title, slug}: {title: string, slug: string}) {
    useEffect(() => {
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


    return <></>;
};