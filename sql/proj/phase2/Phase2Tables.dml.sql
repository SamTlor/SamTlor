--1)Do movies that get more awards have a bigger box office?

SELECT DISTINCT Movies_FilmName, Movies_Gross FROM Movies m
JOIN MovieAwards ma ON m.Movies_ID = ma.Movies_ID
JOIN Awards a ON ma.Awards_ID = a.Awards_ID

--2)Do movies with a bigger budget have a bigger box office?

SELECT Movies_FilmName, Movies_Budget, Movies_Gross 
FROM Movies
ORDER BY Movies_Budget DESC;

--3)How much did the top 5 most awarded movies gross?

SELECT Movies_FilmName, Movies_Gross, count(*) as award_num FROM Movies
JOIN MovieAwards ON Movies.Movies_ID = MovieAwards.Movies_ID
JOIN Awards ON MovieAwards.Awards_ID = Awards.Awards_ID
GROUP BY Movies_Gross, Movies_FilmName
ORDER BY award_num DESC
limit 5;

--4)Which actors worked on this movie 'X-Men: Days of Future Past'?

SELECT Actors_LegalName, Movies_FilmName
FROM Actors a
INNER JOIN ActorsInMovies b on (a.Actors_ID=b.Actors_ID)
INNER JOIN Movies c on (b.Movies_ID=c.Movies_ID)
WHERE Movies_FilmName='X-Men: Days of Future Past';

--5)Which director has won the most amount of awards?

SELECT Directors.Directors_LegalName, Count(Awards.Awards_ID) FROM Directors
JOIN DirectorAwards ON Directors.Directors_ID = DirectorAwards.Directors_ID
JOIN Awards ON DirectorAwards.Awards_ID = Awards.Awards_ID
GROUP BY Directors_LegalName
ORDER BY Count(Awards.Awards_ID) DESC
LIMIT 1;

--6)Which movie has the highest gross?

SELECT Movies_FilmName
FROM Movies
ORDER BY Movies_Gross DESC
LIMIT 1;

--7)Which directors have worked at Paramount Global Studios?

SELECT Studios_TradeName, Directors_LegalName
FROM Studios a
    inner join StudiosHiredDirectors b on (a.Studios_ID=b.Studios_ID)
    inner join Directors c on (b.Directors_ID=c.Directors_ID)
WHERE Studios_TradeName='Paramount Global';

--8)What are all the movies in the genre 'Drama'?

SELECT Movies_FilmName
From  Movies 
WHERE Movies_Genre='Drama';

--9)What is the genre, budget, and gross of the movie 'The Lego Movie'?

SELECT Movies_FilmName, Movies_Genre, Movies_Budget, Movies_Gross
FROM Movies
WHERE Movies_FilmName='The Lego Movie';

--10)Which studio has the highest total gross for all of their movies?

SELECT DISTINCT Studios_TradeName, sum(Movies_Gross) AS Total_Gross FROM (Studios sd, Movies m)
JOIN StudiosMadeMovies sm ON sd.Studios_ID = sm.Studios_ID
GROUP BY Studios_TradeName 
ORDER BY Total_Gross DESC
LIMIT 1;

--11)What movies is this actor in?

SELECT Actors_LegalName, Movies_FilmName FROM Actors
JOIN ActorsInMovies ON Actors.Actors_ID = ActorsInMovies.Actors_ID
JOIN Movies ON ActorsInMovies.Movies_ID = Movies.Movies_ID
WHERE Actors_LegalName = "Chris Pratt";

--12)Which studio has the biggest gap in box office?

SELECT Studios_TradeName, (max(Movies_Gross) - min(Movies_Gross)) FROM Studios
JOIN StudiosMadeMovies ON Studios.Studios_ID = StudiosMadeMovies.Studios_ID
JOIN Movies ON StudiosMadeMovies.Movies_ID = Movies.Movies_ID
GROUP BY Studios_TradeName
ORDER BY (max(Movies_Gross) - min(Movies_Gross)) DESC
LIMIT 1;

--13)What movies has this director directed?

SELECT * FROM Directors
JOIN MovieDirectors ON Directors.Directors_ID = MovieDirectors.Directors_ID
JOIN Movies ON MovieDirectors.Movies_ID = Movies.Movies_ID
WHERE Directors_LegalName = "Martin Charles Scorsese";

--14)
SELECT * FROM Movies ORDER BY Movies_FilmName;

--15)What is the movie with the longest title?

SELECT *
FROM Movies
WHERE LENGTH(Movies_FilmName) = (
	SELECT MAX(LENGTH(Movies_FilmName))
	FROM Movies);

--16) who is the youngest director?

SELECT Directors_LegalName, max(Directors_DateofBirth) 
FROM Directors
GROUP BY Directors_LegalName
ORDER BY max(Directors_DateofBirth) DESC;

--17) what is the movie with the highest gross made by a director not from united states?

WITH directors_cte AS (
    SELECT DISTINCT * FROM Directors
    WHERE Directors_Nationality != 'United States of America'
)
SELECT Directors_LegalName, max(Movies_Gross) FROM directors_cte
JOIN MovieDirectors ON directors_cte.Directors_ID = MovieDirectors.Directors_ID
JOIN Movies ON MovieDirectors.Movies_ID = Movies.Movies_ID
GROUP BY Directors_LegalName
ORDER BY max(Movies_Gross) DESC
limit 1;

--18) All the movies that grossed more than 100 million USD

SELECT Movies_FilmName, Movies_Gross
FROM Movies
WHERE Movies_Gross >= 100000000
ORDER BY Movies_Gross DESC;


--19)Which movie has won the most amount of awards?

SELECT Movies_FilmName, count(*) FROM Movies
JOIN MovieAwards ON Movies.Movies_ID = MovieAwards.Movies_ID
JOIN Awards ON MovieAwards.Awards_ID = Awards.Awards_ID
GROUP BY Movies_FilmName
ORDER BY count(*) DESC
limit 1;

--20)What is the movie with the highest budget in the database?

SELECT Movies_FilmName, Movies_Budget
FROM Movies
ORDER BY Movies_Budget DESC
LIMIT 1;