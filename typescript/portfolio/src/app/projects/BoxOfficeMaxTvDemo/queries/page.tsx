'use client'

import styles from "../BoxOfficeMaxTv.module.css";

import Link from "next/link";
import { useState } from "react";
import useSWR from "swr";
import { fetchUrl, fetcher } from "@/lib/utils";
import DataTable from "../DataTable";



const viewsDictionary: Record<string, string> = {
    "moviesgetmoreawardsbudget": "1) Do movies that get more awards have a bigger box office?",
    "moviesgetmoregrossbudget": "2) Do movies with a bigger budget have a bigger box office?",
    "topmovieawardedgross": "3) How much did the top 5 most awarded movies gross?",
    "actorsworkedonamovie": "4) Which actors worked on this movie 'X-Men: Days of Future Past'?",
    "whichdirectorwonmost": "5) Which director has won the most amount of awards?",
    "whichmoviehighestgross": "6) Which movie has the highest gross?",
    "directorshiredbyselectedstudio": "7) Which directors have worked with which studio?",
    "whatmoviesingenre": "8) What are all the movies in the genre 'Drama'?",
    "whatisgenrebudgetgrossofmovie": "9) What is the genre, budget, and gross of the movie 'The Lego Movie'?",
    "whichstudiohashighestgross": "10) Which studio has the highest total gross for all of their movies?",
    "whatmoviesisactorin": "11) What movies is Chris Pratt in?",
    "studiohasbiggestgapbox": "12) Which studio has the biggest gap in box office?",
    "whatmoviesdirectordirected": "13) What movies has Martin Charles Scorsese directed?",
    "studiomoviemostawards": "14) Which studio made the movie that won the most awards?",
    "moviewithlongesttitle": "15) What is the movie with the longest title?",
    "whoisyoungestdirector": "16) Who is the youngest director?",
    "moviehighestgrossdirectornotus": "17) What is the movie with the highest gross made by a director not from United States?",
    "moviesgrossmorethanhundredmill": "18) Which are the movies that grossed more than 100 million USD?",
    "whichmoviewonmostawards": "19) Which movie has won the most amount of awards?",
    "moviehighestbudget": "20) What is the movie with the highest budget in the database?"        
}

export default function queriesPage() {
    
    const views = Object.keys(viewsDictionary);

    return (
        <div 
            className={styles.page}
            style = {{backgroundImage: "url(/images/boxOfficeOtherPage.png)"}}
        >
            <h1 className={styles.heading}>BoxOfficeMaxTV+</h1>
            <button>
                <Link href = "/projects/BoxOfficeMaxTvDemo">Go back</Link>
            </button>


            {views.map((view) => {
                const { data, error, isLoading } = useSWR(`${fetchUrl}?view=${view}`, fetcher);

                return (
                    <div key={view} className={styles.queryResult}>
                        <h2>{viewsDictionary[view]}</h2>
                        
                        {isLoading && <p>Loading...</p>}
                        {error && <p>Error: {error.message}</p>}
                        {data && 
                            <div>
                                <DataTable data={data} />
                            </div>
                            }
                    </div>
                );
            })}
        </div>
    );
}