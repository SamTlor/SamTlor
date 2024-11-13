var PortfolioApp = window.PortfolioApp || {};

(function scopeWrapper($) {
    var apiEndpoint = PortfolioApp.apiEndpoint;

    
    PortfolioApp.loadProjectLinks = function () {
        $.get(apiEndpoint + '/projects.json').done(function (data) {
            data.forEach(function (proj) {
                $('.content-slide').append(
                    '<div class = "slide"><a href = "project.html#' + proj.id + '">' + proj.title + '</a></div>'
                )
            });
        });
    };

    PortfolioApp.loadProjectDescription = function () {
        $.get(apiEndpoint + '/projects/' + location.hash.substring(1) + '.json').done(function (data) {
            $('.content-slide').append(
                '<div class = "slide"><h1>' + proj.title + '</h1><p>' + proj.description + '</p></div>'
            )
        })
    }    

}(jQuery));