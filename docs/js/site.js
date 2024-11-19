var PortfolioApp = window.PortfolioApp || {};

(function scopeWrapper($) {
    var s3ApiEndpoint = PortfolioApp.s3ApiEndpoint;

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


        queryPayload = encodeURIComponent("use BoxOfficeMaxTV;");
        $.get(PortfolioApp.rdsApiEndpoint + `/query=${queryPayload}`)
            .done(function (data) {
                console.log("query result:", data)
            })
            .fail(function(err) {
                console.error("error in query:", err);
            })
    }    

}(jQuery));