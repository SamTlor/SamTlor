'use client'

import { fetchUrl } from "@/lib/utils";

// export async function GetViews(slug: string): Promise<number | null> {
export async function GetViews({slug}: {slug: string}){
    try {
        const response = await fetch(`${fetchUrl}/page-views?slug=${slug}`);
        if (!response.ok) throw new Error("Failed to fetch view count");
        
        const data = await response.json();
        return data.view_count;
    } catch (error) {
        console.error("Error fetching view count:", error);
        return null;
    }
}
