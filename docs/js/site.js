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

    // these functions make calls to index.mjs
    // index gets data from the rds
    PortfolioApp.loadRdsQuery = function (queryPayload, callback) {
        // make sure to use the database first in case it's "cold"
        $.get(rdsApiEndpoint + `?query=${encodeURIComponent("USE BoxOfficeMaxTV;")}`)
            .done(function (data) {
                console.log("Use database result:", data)
            })
            .fail(function(err) {
                console.error("Error connecting to database:", err);
            })

        // execute the query
        queryPayload = encodeURIComponent(queryPayload);
        $.get(rdsApiEndpoint + `?query=${queryPayload}`)
            .done(function (data) {
                console.log("query result:", data)
                if (callback) callback(data);
            })
            .fail(function(err) {
                console.error("error in query:", err);
            })
    }

}(jQuery));