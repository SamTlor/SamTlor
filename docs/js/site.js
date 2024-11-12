var PortfolioApp = window.PortfolioApp || {};

(function scopeWrapper($) {
    var apiEndpoint = PortfolioApp.apiEndpoint;

    
    PortfolioApp.loadProjects = function () {
        $.get(apiEndpoint + '/projects').done(function (data) {
            data.forEach(function (proj) {
                $('.content-slide').append(
                    '<div class = "slide"><h1>' + proj.title + '</h1><p>' + proj.description + '</p></div>'
                )
            });
        });
    };

}(jQuery));