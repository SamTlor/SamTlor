var PortfolioApp = window.PortfolioApp || {};

(function scopeWrapper($) {
    var s3ApiEndpoint = PortfolioApp.s3ApiEndpoint;
    var rdsApiEndpoint = PortfolioApp.rdsApiEndpoint;

    // these functions make calls to Project-Proxy.mjs
    // Project-Proxy gets data from the s3 bucket called samtlorportfoliobucket
    PortfolioApp.loadProjectLinks = function () {
        $.get(s3ApiEndpoint + '/project_links').done(function (data) {
            data.forEach(function (proj) {
                $('.content-slide').append(
                    '<div class = "slide"><a href = "projects/project' + proj.id + '.html">' + proj.title + '</a></div>'
                )
            });
        });
    };

    PortfolioApp.loadProjectDescription = function () {
        const path = location.pathname;
        const fileName = path.substring(path.lastIndexOf('/') + 1);
        const match = fileName.match(/project(\d+)/);
        const whichProject = match ? match[1] : null;

        // will return 'no cases hit' if null
        $.get(s3ApiEndpoint + '/projects/' + whichProject).done(function (data) {
            $('.content-slide').append(
                '<div class = "slide"><h1>' + data.title + '</h1><p>' + data.description + '</p></div>'
            )
        })
    }    

    PortfolioApp.loadRdsQuery = function (queryPayload, callback, retries = 5) {
        // make sure to use the database first in case it's "cold"
        $.get(rdsApiEndpoint + `?query=${encodeURIComponent("USE BoxOfficeMaxTV;")}`)
            .done(function (data) {
                console.log("Use database result:", data)
            })
            .fail(function(err) {
                console.error("Error connecting to database:", err);
            })

        // sometimes the database fails so we have to query again
        const attemptQuery = (retryCount) => {
            $.get(rdsApiEndpoint + `?query=${encodeURIComponent(queryPayload)}`)
                .done(function (data) {
                    console.log("Query result:", data);
                    if (callback) callback(data);
                })
                .fail(function (err) {
                    console.error("Query failed:", err);
                    if (retryCount > 0) {
                        console.log(`Retrying... (${retries - retryCount + 1})`);
                        setTimeout(() => attemptQuery(retryCount - 1), 1000);
                    }
                });
        };
    
        attemptQuery(retries);
    };

    
    // Function to display the query results
    PortfolioApp.displayQueryResult = function (data, elementId) {
        const queryOutput = document.getElementById(elementId);
        const queryContainer = queryOutput.parentElement;

        // Show the result container and clear any previous content
        queryContainer.style.display = "block";
        queryOutput.innerHTML = "";

        if (data.length === 0) {
            queryOutput.innerHTML = "<p>No results found</p>";
            return;
        }

        // Convert the result data into a table format
        const table = document.createElement("table");
        table.border = "1";
        const headers = Object.keys(data[0]);
        const headerRow = table.insertRow();
        headers.forEach(header => {
            const headerCell = headerRow.insertCell();
            headerCell.textContent = header;
            headerCell.style.fontWeight = "bold";
        });

        // Populate the table rows
        data.forEach(row => {
            const rowElement = table.insertRow();
            headers.forEach(header => {
                const cell = rowElement.insertCell();
                cell.textContent = row[header];
            });
        });

        // Append the table to the query output area
        queryOutput.appendChild(table);
    }

}(jQuery));