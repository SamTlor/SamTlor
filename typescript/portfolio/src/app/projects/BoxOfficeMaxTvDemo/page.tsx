import styles from "./BoxOfficeMaxTv.module.css";
import Link from "next/link";

export default function BoxOfficeMaxTvDemo() {
    return (
        <div className={styles.page}>
            <h1 className={styles.heading}>BoxOfficeMaxTV+</h1>
            <Link href="/">Go Home.</Link>

            <button type = "submit"><a href = "project3files/queries.html">Queries</a></button>
            <button type = "submit"><a href = "project3files/home.html">Home</a></button>
        </div>
    );
}
