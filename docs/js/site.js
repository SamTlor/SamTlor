var PortfolioApp = window.PortfolioApp || {};

(function scopeWrapper($) {
    var apiEndpoint = PortfolioApp.apiEndpoint;

    // these functions make calls to Project-Proxy.mjs
    // Project-Proxy gets data from the s3 bucket called samtlorportfoliobucket
    PortfolioApp.loadProjectLinks = function () {
        $.get(apiEndpoint + '/project_links').done(function (data) {
            data.forEach(function (proj) {
                $('.content-slide').append(
                    '<div class = "slide"><a href = "project' + proj.id + '".html>' + proj.title + '</a></div>'
                )
            });
        });
    };

    PortfolioApp.loadProjectDescription = function () {
        const path = location.pathname;
        const fileName = path.substring(path.lastIndexOf('/') + 1);
        const match = fileName.match(/project(\d+)/);
        const whichProject = match ? match[0] : null;

        // will return 'no cases hit' if null
        $.get(apiEndpoint + '/projects/' + whichProject).done(function (data) {
            $('.content-slide').append(
                '<div class = "slide"><h1>' + data.title + '</h1><p>' + data.description + '</p></div>'
            )
        })
    }    

}(jQuery));