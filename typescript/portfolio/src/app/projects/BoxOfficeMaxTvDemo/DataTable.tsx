import React from "react";

const DataTable = ({ data }: { data: any[] }) => {
    if (!data.length) return <p>No data available.</p>;

    return (
        <div>
            <table>
                <thead>
                    <tr>
                        {Object.keys(data[0] || {}).map(header => (
                            <th key={header} style={{ fontWeight: "bold" }}>{header}</th>
                        ))}
                    </tr>
                </thead>
                <tbody>
                    {data.map((row, rowIndex) => (
                        <tr key={rowIndex}>
                            {Object.keys(row).map((key, colIndex) => (
                                <td key={colIndex}>{String(row[key])}</td>
                            ))}
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};

export default DataTable;