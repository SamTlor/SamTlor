## __<dt> Problem Statement</dt>__ </br>
<p>In 2020, the global pandemic impacted the film industry as we have never seen it before. As the population went under quarantine, it led to theaters dying and studios scrambling for ways to adapt to this new way of life. As things have started opening up, it’s more important than ever for studios to fund projects that will entertain people and bring in profit. Our project aims to facilitate the decision making of studios and help movie watchers determine what movie they'll spend their time and money on. Our project, BoxOfficeMaxTV+, will explore the connections between movies that have been made and their box office gross, awards that have been won by the actors/ directors/ special effects teams, actors that worked on the film, the genre of the movie, the studio that financed the movie, running time, and budget of the film. Through these relationships we will have a better insight into what helped high grossing films do well with audiences, and help direct studios to which films they should pursue in the future. It can also assist movie watchers in choosing what next film they should watch. </p>
<p>Our project will look at the highest grossing and most awarded movies over that past 22 years, as well as the actors and studios involved. The film industry changes and adapts constantly so we want to focus on the most recent time period in film to understand the most about the modern landscape. We also want to determine if the critical success of a movie has an effect on its commercial success. So, we will look at the reviews from online websites and the awards given by major prestigious award givers like the Oscars, Golden Globes, and SAG. We will look at lots of different information about movies like genres, runtime, and budget to find any trends that could be useful to movie studios. Over the last 15 years movie studios have gained more power and so we will include them as an entity that we will gather data on.</p>

## __<dt>Queries</dt>__ <br>
* Do movies that get more awards have a bigger box office? 
* Do movies with a bigger budget have a bigger box office? 
* Do more award winning actors help the box office? 
* Which awarder gives out the least amount of awards?
* Which director has won the most amount of awards?
* Do more award winning directors help with getting a bigger box office?
* Do more award winning directors help with getting more awards for the movie? 
* Which studio gets awarded the most? 
* Which studio makes the most amount of movies? 
* Which studio has the biggest box office? 
* What movies is this actor in? 
* Which actor/director/studio has the biggest gap in box office? 
* What movies has this director directed? 
* Which studio hires the most amount of actresses? 
* What is the movie with the longest title? 
* Which studio has won the most amount of awards?
* What is the biggest gap between movies for any actor? 
* What is the running time of the movie? 
* What is the highest grossing movie of the year “____”? 
* What is the movie with the highest budget in the database?



## __<dt>Entity Relationship Diagram</dt>__

![BOMTVREALFINAL drawio](https://user-images.githubusercontent.com/112138090/195943335-315b7b67-46f9-44b8-9b0a-7128587101cd.png)



**Boyce-Codd Normal Form** is when a database has no redundancy from functional dependencies and every non-prime attribute depends on every other prime attribute. Our diagram fits this definition because every attribute depends only on the unique ID that defines each schema. 

## __<dt>Relational Schemas</dt>__
Actors(<ins>ActorID</ins>, DateofBirth, Nationality, LegalName)</br>
ActorsPK(<ins>ActorID</ins>)</br>
Movies(<ins>MovieID</ins>, FilmName, RunTime, Gross, Budget)</br>
MoviesPK(<ins>MovieID</ins>)</br>
Awards(<ins>AwardID</ins>, Name, Year)</br>
AwardsPK(<ins>AwardsID</ins>)</br>
Awarders(<ins>AwarderID</ins>, DateCreated, AwarderCountry, AwarderName)</br>
AwardersPK(<ins>AwarderID</ins>)</br>
Studios(<ins>StudioID</ins>, DateFounded, TradeName)</br>
StudiosPK(<ins>StudiosID</ins>)</br>
Directors(<ins>DirectorID</ins>, DateofBirth, Nationality, LegalName)</br>
DirectorsPK(<ins>DirectorID</ins>)</br>

ActorsStudiosMap(<ins>ActorID</ins>, <ins>StudioID</ins>)</br>
ActorsAwardsMap(<ins>ActorID</ins>, <ins>AwardID</ins>)</br>
ActorsMoviesMap(<ins>ActorID</ins>, <ins>MovieID</ins>)</br>
MoviesAwardsMap(<ins>MovieID</ins>, <ins>AwardID</ins>)</br>
DirectorsStudiosMap(<ins>DirectorID</ins>, <ins>StudioID</ins>)</br>
DirectorsMovieMap(<ins>DirectorID</ins>, <ins>MovieID</ins>)</br>
DirectorsAwardsMap(<ins>DirectorID</ins>, <ins>AwardID</ins>)</br>
AwardersAwardsMap(<ins>AwarderID</ins>, <ins>AwardID</ins>)</br>

## __<dt>Functional Dependencies</dt>__
MovieID → FilmName, RunTime, Gross, Budget</br>
ActorID → DateofBirth, Nationality, LegalName</br>
AwardID → Name, Year</br>
AwarderID → DateCreated, AwarderCountry, AwarderName</br>
StudioID → DateFounded, TradeName</br>
DirectorID → DateoBirth, Nationality, LegalName</br>
ActorID, StudioID  →</br>
ActorID, AwardID →</br>
ActorID, MovieID →</br>
MovieID, AwardID →</br>
DirectorID, StudioID →</br>
DirectorID, MovieID →</br>
DirectorID, AwardID →</br>
AwarderID, AwardID →</br>

The Relational Schemas above show the attributes of each relation and underlined are the primary keys.</br>
My Foreign Keys will be the unique identifiers between the two tables that have a relationship. An example would be DirectorID and AwardID for the relationship between the Directors' table and the Awards' table.</br>
The Domain constraints are that the domains must contain atomic values.</br>
The Domain will follow the data type of the attribute it follows, we can see examples of this in the table below. Attribute 'FilmName' has a data type of String and so the Domain will be filled with String entries. </br>

## __<dt>Sample Data</dt>__
<img width="1141" alt="Screen Shot 2022-10-14 at 5 10 36 PM" src="https://user-images.githubusercontent.com/112138090/195944566-6c52c8ce-26a6-40b6-bcc9-05ac3c47a3ab.png">




