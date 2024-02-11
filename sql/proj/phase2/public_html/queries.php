<!DOCTYPE html>
    <html>
        <head>
        <h1>20 Queries</h1>
        </head>
        <?php
            include "dbconn.php";
        ?>

        <body>
            
            <button type = "submit"><a href = "home.php">Home</a></button>
            <button type = "submit"><a href = "index.php">Login</a></button>

            <p><b>1)Do movies that get more awards have a bigger box office?</b></p>
                <?php
                    $query = "SELECT * FROM MoviesGetMoreAwardsBudget";
                    include "show_table.php";
                ?>
            <p><b>2)Do movies with a bigger budget have a bigger box office?</b></p>
                <?php
                    $query = "SELECT * FROM MoviesGetMoreGrossBudget";
                    include "show_table.php";
                ?>
            <p><b>3)How much did the top 5 most awarded movies gross?</b></p>
                <?php
                    $query = "SELECT * FROM TopMovieAwardedGross";
                    include "show_table.php";
                ?>
            <p><b>4)Which actors worked on this movie 'X-Men: Days of Future Past'?</b></p>
                <?php
                    $query = "SELECT * FROM ActorsWorkedOnAMovie";
                    include "show_table.php";
                ?>
            <p><b>5)Which director has won the most amount of awards?</b></p>
                <?php
                    $query = "SELECT * FROM WhichDirectorWonMost";
                    include "show_table.php";
                ?>
            <p><b>6)Which movie has the highest gross?</b></p>
                <?php
                    $query = "SELECT * FROM WhichMovieHighestGross";
                    include "show_table.php";
                ?>
            <p><b>7)Which directors have worked with which studio?</b></p>
                <?php
                    $query = "SELECT * FROM DirectorsHiredBySelectedStudio";
                    include "show_table.php";
                ?>
            <p><b>8)What are all the movies in the genre 'Drama'?</b></p>
                <?php
                    $query = "SELECT * FROM WhatMoviesInGenre";
                    include "show_table.php";
                ?>
            <p><b>9)What is the genre, budget, and gross of the movie 'The Lego Movie'?</b></p>
                <?php
                    $query = "SELECT * FROM WhatIsGenreBudgetGrossOfMovie";
                    include "show_table.php";
                ?>
            <p><b>10)Which studio has the highest total gross for all of their movies?</b></p>
                <?php
                    $query = "SELECT * FROM WhichStudioHasHighestGross";
                    include "show_table.php";
                ?>
            <p><b>11)What movies is this actor in?</b></p>
                <?php
                    $query = "SELECT * FROM WhatMoviesIsActorIn";
                    include "show_table.php";
                ?>
            <p><b>12)Which studio has the biggest gap in box office?</b></p>
                <?php
                    $query = "SELECT * FROM StudioHasBiggestGapBox";
                    include "show_table.php";
                ?>
            <p><b>13)What movies has Martin Charles Scorsese directed?</b></p>
                <?php
                    $query = "SELECT * FROM WhatMoviesDirectorDirected";
                    include "show_table.php";
                ?>
            <p><b>14)Which studio made the movie that won the most awards?</b></p>
                <?php
                    $query = "SELECT * FROM StudioMovieMostAwards";
                    include "show_table.php";
                ?>
            <p><b>15)What is the movie with the longest title?</b></p>
                <?php
                    $query = "SELECT * FROM MovieWithLongestTitle";
                    include "show_table.php";
                ?>
            <p><b>16)Who is the youngest director?</b></p>
                <?php
                    $query = "SELECT * FROM WhoIsYoungestDirector";
                    include "show_table.php";
                ?>
            <p><b>17)What is the movie with the highest gross made by a director not from United States?</b></p>
                <?php
                    $query = "SELECT * FROM MovieHighestGrossDirectorNotUS";
                    include "show_table.php";
                ?>
            <p><b>18)All the movies that grossed more than 100 million USD</b></p>
                <?php
                    $query = "SELECT * FROM MoviesGrossMoreThanHundredMill";
                    include "show_table.php";
                ?>
            <p><b>19)Which movie has won the most amount of awards?</b></p>
                <?php
                    $query = "SELECT * FROM WhichMovieWonMostAwards";
                    include "show_table.php";
                ?>
            <p><b>20)What is the movie with the highest budget in the database?</b></p>
                <?php
                    $query = "SELECT * FROM MovieHighestBudget";
                    include "show_table.php";
                ?>

        </body>
    </html>