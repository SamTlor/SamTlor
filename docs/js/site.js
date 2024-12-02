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





    // these functions send the queryPayload to the mysql database
    // i send the 'use database' query first in case it's "cold"
    // then it uses the callback variable which is a function to display the results 
    // i hate using the retries but if the database isn't warm it doesn't work so yeah
    PortfolioApp.loadRdsQuery = function (queryPayload, callback, retries = 15) {
        return new Promise ((resolve, reject) =>{
            $.get(rdsApiEndpoint + `?query=${encodeURIComponent("USE BoxOfficeMaxTV;")}`)
                .done(function (data) {
                    console.log("Use database result:", data)
                })
                .fail(function(err) {
                    console.error("Error connecting to database:", err);
                    return reject(err);
                })

            // sometimes the database fails so we have to query again
            const attemptQuery = (retryCount) => {
                $.get(rdsApiEndpoint + `?query=${encodeURIComponent(queryPayload)}`)
                    .done(function (data) {
                        console.log("Query successful:", data);
                        if (callback) {
                            callback(data);
                        }
                        
                        resolve(data);
                    })
                    .fail(function (err) {
                        console.error("Query failed:", err);
                        if (retryCount > 0) {
                            console.log(`Retrying... (${retries - retryCount + 1})`);
                            setTimeout(() => attemptQuery(retryCount - 1), 1000);
                        } else {
                            reject(err);
                        }
                    });
            };
        
            attemptQuery(retries);
        });
    };

    // Function to display the query results
    PortfolioApp.displayQueryResult = function (data, elementId, adminHandler) {
        const queryOutput = document.getElementById(elementId);
        const queryContainer = queryOutput.parentElement;

        // Show the result container and clear any previous content
        queryContainer.style.display = "block";
        queryOutput.innerHTML = "";


        // Convert the result data into a table format using template literals
        const table = `
            <table border="1">
                <thead>
                    <tr>
                        ${Object.keys(data[0])
                            .map(header => `<th style="font-weight: bold;">${header}</th>`)
                            .join("")
                        }
                    </tr>
                </thead>
                <tbody>
                    ${
                        data.map(row => `
                            <tr>
                                ${Object.keys(row)
                                    .map(key => `<td>${row[key]}</td>`)
                                    .join("")}
                            </tr>
                        `)
                        .join("")
                    }
                </tbody>
            </table>
        `;
        const tableContainer = document.createElement("div");
        tableContainer.innerHTML = table;

        if (adminHandler) {
            adminHandler(tableContainer.firstElementChild, queryOutput);
        } else {
            queryOutput.appendChild(tableContainer.firstElementChild);
        }
    }

}(jQuery));