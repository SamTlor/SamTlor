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
            <Link href="/">Portfolio Home</Link>

            <button>
                <Link href = "BoxOfficeMaxTvDemo/queries">Queries</Link>
            </button>


            
            {/* <!-- begin which table question --> */}
            <form id="tableForm" onSubmit={handleSubmit}>
                <label htmlFor="whichTable">Choose which table you want to display:</label>
                <select 
                    name="whichTable" 
                    id="whichTable" 
                    value={selectedTable}
                    onChange={handleSelectChange}
                    required
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
                
                <button type="submit">Submit</button>
            </form>
            {/* <!-- end which table question --> */}

            {/* <!-- begin which table query result --> */}
            <div className={styles.queryResult}>
                <h3>Query Result</h3>
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
