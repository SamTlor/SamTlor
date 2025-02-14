import React from "react";

const DataTable = ({ data }: { data: any[] }) => {
    if (!data.length) return <p className="text-center text-gray-500">No data available.</p>;

    return (
        <div className="overflow-x-auto mt-4">
            <table className="w-full border-collapse border border-gray-300 shadow-lg rounded-lg">
                <thead>
                    <tr className="bg-gray-200 text-gray-700">
                        {Object.keys(data[0] || {}).map(header => (
                            <th key={header} className="px-4 py-2 border border-gray-300 text-left font-semibold">
                                {header}
                            </th>
                        ))}
                    </tr>
                </thead>
                <tbody>
                    {data.map((row, rowIndex) => (
                        <tr key={rowIndex} className={rowIndex % 2 === 0 ? "bg-white" : "bg-gray-100"}>
                            {Object.keys(row).map((key, colIndex) => (
                                <td key={colIndex} className="px-4 py-2 border border-gray-300">
                                    {String(row[key])}
                                </td>
                            ))}
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};

export default DataTable;