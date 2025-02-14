'use client'

import { useState } from "react";
import styles from "./BoxOfficeMaxTv.module.css";
import Link from "next/link";

import useSWR from "swr";
import { fetchUrl, fetcher } from "@/lib/utils";

import DataTable from "./DataTable";

export default function BoxOfficeMaxTvDemo() {

    // use state variables and other global variables like the useSWR stuff
    const [selectedTable, setSelectedTable] = useState("");
    const [fetchUrlPlusTable, setFetchUrlPlusTable] = useState<string | null>(fetchUrl);
    const { data, error, isLoading } = useSWR(fetchUrlPlusTable, fetcher);
    
    // use state functions activation
    const handleSelectChange = (event: React.ChangeEvent<HTMLSelectElement>) => {
        setSelectedTable(event.target.value);
    };

    const handleSubmit = (event: React.FormEvent) => {
        event.preventDefault();
        setFetchUrlPlusTable(`${fetchUrl}?table=${selectedTable.toLowerCase()}`);
    };



    return (
        <div className={styles.page}>
            <h1 className={styles.heading}>BoxOfficeMaxTV+</h1>

            {/* begin navigation links  */}
            <div className="flex flex-col space-y-4 items-start pl-6">
                <Link href="/BoxOfficeMaxTv" className="text-white text-lg hover:underline">
                    Portfolio Home
                </Link>

                <Link href="/BoxOfficeMaxTv" className="text-white text-lg hover:underline">
                    Go back
                </Link>

                <Link href="/projects/BoxOfficeMaxTvDemo/queries" 
                    className="px-6 py-3 bg-[#84ffff] text-black font-semibold text-lg rounded-full shadow-md hover:bg-black hover:text-white transition duration-300 ease-in-out text-center">
                    🔍 Queries
                </Link>
            </div>
            {/* end navigation links  */}


            
            {/* <!-- begin which table question --> */}
            <div className="flex justify-center items-center min-h-[90vh] mt-[-45vh]">
                <form 
                    id="tableForm" 
                    onSubmit={handleSubmit} 
                    className="flex flex-col items-center bg-white p-6 rounded-lg shadow-md w-full max-w-md"
                >
                    <label htmlFor="whichTable" className="text-lg font-medium mb-2">
                        Choose which table you want to display:
                    </label>
                    <select 
                        name="whichTable" 
                        id="whichTable" 
                        value={selectedTable}
                        onChange={handleSelectChange}
                        required
                        className="w-full p-2 border border-gray-300 rounded-md"
                    >
                        <option disabled value="">--Select an option--</option>
                        <option value="Actors">Actors</option>
                        <option value="Awarders">Awarders</option>
                        <option value="Awards">Awards</option>
                        <option value="Directors">Directors</option>
                        <option value="Movies">Movies</option>
                        <option value="Studios">Studios</option>
                        <option value="projects">projects</option>
                    </select>

                    <button type="submit" className="mt-4 px-6 py-2 bg-blue-500 text-white rounded-md hover:bg-blue-700">
                        Submit
                    </button>
                </form>
            </div>
            {/* <!-- end which table question --> */}

            {/* <!-- begin which table query result --> */}
            <div className={styles.queryResult}>
                {isLoading && <p>Fetching data for {selectedTable}...</p>}
                {error && <p>Failed to load: {error.message}</p>}
                {data && <pre id="queryOutput">{
                    <div>
                        <DataTable data={data} /> 
                    </div>
                }</pre>}
            </div>
            {/* <!-- end which table result --> */}

        </div>
    );
}
