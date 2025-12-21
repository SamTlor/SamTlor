--- Semster Project Phase 2
--- DDL File
--- Team 30:
-- Gabriella Rivera
-- Sam Taylor



--only has two possible logins 
DROP TABLE IF EXISTS users;
CREATE TABLE users (
    id INT(10) unsigned NOT NULL AUTO_INCREMENT,
    Username VARCHAR(25) NOT NULL, 
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY Username (Username)
) ENGINE = InnoDB DEFAULT CHARSET = utf8 COLLATE = utf8_unicode_ci AUTO_INCREMENT = 1;
INSERT INTO users(id, Username, password) VALUES
    (1, 'admin', 'database'),
    (2, 'user', 'database');



-- logger table to hold info of insert, update, or delete changes
--keep track of record id
DROP TABLE IF EXISTS logger;
CREATE TABLE logger(
    logger_id INT NOT NULL AUTO_INCREMENT, 
    logger_operation VARCHAR(255) NOT NULL,
    logger_table VARCHAR(255) NOT NULL,
    logger_record_id INT NOT NULL,
    logger_timestamp DATETIME default NOW(),
    primary key (logger_id)
);
SELECT * FROM logger;


--drop tables
--you can't drop the bottom 6 tables without dropping the top 9 first
--because of foreign keys so these go first so you can delete them all
--by selecting all of them
DROP TABLE IF EXISTS MovieDirectors;
DROP TABLE IF EXISTS AwarderGivesAward;
DROP TABLE IF EXISTS ActorAwards;
DROP TABLE IF EXISTS MovieAwards;
DROP TABLE IF EXISTS DirectorAwards;
DROP TABLE IF EXISTS ActorsInMovies;
DROP TABLE IF EXISTS StudiosMadeMovies;
DROP TABLE IF EXISTS ActorshiredbyStudios;
DROP TABLE IF EXISTS StudiosHiredDirectors;

DROP TABLE IF EXISTS Movies;
DROP TABLE IF EXISTS Studios;
DROP TABLE IF EXISTS Actors;
DROP TABLE IF EXISTS Directors;
DROP TABLE IF EXISTS Awarders;
DROP TABLE IF EXISTS Awards;

--table for logging info and for the website
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS logger;



-- "Movies" table that holds all the movies
DROP TABLE IF EXISTS Movies;
CREATE TABLE Movies(
    Movies_ID int NOT NULL AUTO_INCREMENT,
    Movies_FilmName VARCHAR(255) NOT NULL,
    Movies_Genre VARCHAR(255) NOT NULL,
    Movies_Gross BIGINT NOT NULL,
    Movies_Budget INT NOT NULL,
    PRIMARY KEY(Movies_ID)
);
ALTER TABLE Movies AUTO_INCREMENT = 51;
INSERT INTO Movies( Movies_ID, Movies_FilmName, Movies_Genre, Movies_Gross, Movies_Budget) VALUES
    (1,'Gone Girl','Drama',167700000,61000000),
    (2,'Gaurdians of the Galaxy','Action',333180000,232300000),
    (3,'X-Men: Days of Future Past','Action',233920000,205000000),
    (4,'Boyhood','Drama',25380000,4000000),
    (5,'The Lego Movie','Animation',257760000,60000000),
    (6,'The Grand Budapest Hotel','Comedy',59100000,25000000),
    (7,'The Wolf of Wall Street','Comedy',116900000,100000000),
    (8,'Frozen','Animation',400740000,150000000),
    (9,'Gravity','Drama',274090000,80000000),
    (10,'Man of Steel','Action',291050000,225000000),
    (11,'Rush','Action',26950000,38000000),
    (12,'Her','Drama',25570000,23000000),
    (13,'12 Years a Slave','Drama',56670000,20000000),
    (14,'The Dark Knight Rises','Action',448140000,250000000),
    (15,'The Avengers','Action',623280000,220000000),
    (16,'Django Unchained','Drama',162810000,100000000),
    (17,'Skyfall','Action',304360000,150000000),
    (18,'The Artist','Drama',44670000,15000000),
    (19,'Drive','Action',35060000,15000000),
    (20,'The Girl with the Dragon Tattoo','Drama',102520000,90000000),
    (21,'Tinker Tailor Soldier Spy','Drama',24150000,21000000),
    (22,'Warrior','Action',13660000,25000000),
    (23,'Harry Potter and the Deathly Hallows: Part 2','Fantasy',381010000,250000000),
    (24,'The Help','Drama',169710000,25000000),
    (25,'Midnight in Paris','Romance',56820000,17000000),
    (26,'Hugo','Drama',73860000,150000000),
    (27,'Inception','Action',292580000,160000000),
    (28,'Kick-Ass','Comedy',48070000,28000000),
    (29,'The Social Network','Drama',96960000,40000000),
    (30,'Toy Story 3','Animation',415000000,200000000),
    (31,'Black Swan','Drama',106950000,13000000),
    (32,'The Fighter','Action',93620000,25000000),
    (33,'Shutter Island','Mystery',128010000,80000000),
    (34,'The Kings Speech','Drama',138800000,15000000),
    (35,'How to Train Your Dragon','Animation',217580000,165000000),
    (36,'Avatar','Fantasy',760510000,237000000),
    (37,'Inglourious Basterds','Drama',120540000,70000000),
    (38,'Star Trek','Action',257730000,15000000),
    (39,'District 9','Action',115650000,30000000),
    (40,'The Hangover','Comedy',277320000,35000000),
    (41,'A Prophet','Drama',2080000,13000000),
    (42,'The Dark Knight','Action',534860000,185000000),
    (43,'The Wrestler','Drama',26240000,6000000),
    (44,'Gran Torino','Drama',148100000,25000000),
    (45,'The Hurt Locker','Drama',17020000,15000000),
    (46,'In Bruges','Comedy',7760000,15000000),
    (47,'WALL-E','Animation',223810000,180000000),
    (48,'The Reader','Romance',34190000,32000000),
    (49,'Juno','Comedy',143500000,6500000),
    (50,'Into the Wild','Drama',18350000,20000000);

SELECT * FROM Movies;
-------------------------------------------------- TRIGGERS  -------------------------------------------------------------

--trigger for the table Movies for inserting, to add a new movie
DROP trigger IF EXISTS Movies_insert_trigger;
CREATE trigger Movies_insert_trigger
AFTER INSERT ON Movies
for each ROW
BEGIN
    insert into logger (logger_operation,logger_table,logger_record_id) VALUES
      ('INSERT','MOVIES',new.Movies_ID);
end;

--trigger for the table Movies for updating, incase information needs updating
DROP trigger IF EXISTS Movies_update_trigger;
CREATE trigger Movies_update_trigger
AFTER UPDATE ON Movies
for each ROW
BEGIN
    insert into logger (logger_operation,logger_table,logger_record_id) VALUES
      ('UPDATE','MOVIES',new.Movies_ID);
end;

--trigger for the table Movies for deleting, incase a Movie needs to be deleted
DROP trigger IF EXISTS Movies_delete_trigger;
CREATE trigger Movies_delete_trigger
AFTER DELETE ON Movies
for each ROW
BEGIN
    insert into logger (logger_operation,logger_table,logger_record_id) VALUES
      ('DELETE','MOVIES',new.Movies_ID);
end;

---------------------------------------------- END OF TRIGGERS -----------------------------------------------------



-- "Studios" table that holds all the studios
DROP TABLE IF EXISTS Studios;
CREATE TABLE Studios(
    Studios_ID int NOT NULL AUTO_INCREMENT,
    Studios_DateFounded VARCHAR(255) NOT NULL,
    Studios_TradeName VARCHAR(255) NOT NULL,
    PRIMARY KEY(Studios_ID)
);
ALTER TABLE Studios AUTO_INCREMENT = 906;
INSERT INTO Studios( Studios_ID, Studios_DateFounded, Studios_TradeName) VALUES
    (901,'1923-10-16','Walt Disney Studios'),
    (902,'2004-08-02','NBCUniversal'),
    (903,'2019-12-04','Paramount Global'),
    (904,'1923-04-04','Warner Bros Entertainment'),
    (905,'1987-12-21','Sony Pictures');

SELECT * FROM Studios;

--------------------------------------------------- TRIGGERS  --------------------------------------------------------

--trigger for the table Studios for inserting, to insert a new studio
DROP trigger IF EXISTS Sutdios_insert_trigger;
CREATE trigger Studios_insert_trigger
AFTER INSERT ON Studios
for each ROW
BEGIN
    insert into logger (logger_operation,logger_table,logger_record_id) VALUES
      ('INSERT','STUDIOS',new.Movies_ID);
end;

--trigger for the table Studios for updating, incase information needs updating
DROP trigger IF EXISTS Studios_update_trigger;
CREATE trigger Studios_update_trigger
AFTER UPDATE ON Studios
for each ROW
BEGIN
    insert into logger (logger_operation,logger_table,logger_record_id) VALUES
      ('UPDATE','STUDIOS',new.Studios_ID);
end;

--trigger for the table Studios for deleting, incase a Studio needs to be deleted
DROP trigger IF EXISTS Studios_delete_trigger;
CREATE trigger Studios_delete_trigger
AFTER DELETE ON Studios
for each ROW
BEGIN
    insert into logger (logger_operation,logger_table,logger_record_id) VALUES
      ('DELETE','STUDIOS',new.Studios_ID);
end;

--------------------------------------------- END OF TRIGGERS -----------------------------------------------------



-- "Actors" table that holds all the actors
DROP TABLE IF EXISTS Actors;
CREATE TABLE Actors(
    Actors_ID int NOT NULL AUTO_INCREMENT,
    Actors_DateofBirth DATE NOT NULL,
    Actors_Nationality VARCHAR(255) NOT NULL,
    Actors_LegalName VARCHAR(255) NOT NULL,
    PRIMARY KEY(Actors_ID)
);
ALTER TABLE Actors AUTO_INCREMENT = 1074;
INSERT INTO Actors(Actors_ID, Actors_DateofBirth, Actors_Nationality, Actors_LegalName) VALUES
    (1001,'1972-08-15','United States of America','Ben Affleck'), 
    (1002,'1979-01-27','England','Rosamund Pike'),  
    (1003,'1973-06-15','United States of America','Neil Patrick Harris'),  
    (1004,'1979-06-21','United States of America','Chris Pratt'),  
    (1005,'1967-07-18','United States of America','Vin Diesel'),  
    (1006,'1975-01-05','United States of America','Bradley Cooper'),  
    (1007,'1978-06-19','United States of America','Zoe Saldana'),  
    (1008,'1940-07-13','England','Patrick Stewart'), 
    (1009,'1939-05-25','England','Ian McKellan'),  
    (1010,'1968-10-12','Australia','Hugh Jackman'),  
    (1011,'1979-04-21','Scotland','James McAvoy'), 
    (1012,'1977-04-02','Germany','Michael Fassbender'), 
    (1013,'1990-08-15','United States of America','Jennifer Lawrence'), 
    (1014,'1987-02-21','Canada','Elliot Page'),  
    (1015,'1994-08-27','United States of America','Ellar Coltrane'),  
    (1016,'1967-07-16','United States of America','Will Ferrell'),  
    (1017,'1973-04-14','United States of America','Adrien Brody'),  
    (1018,'1955-07-22','United States of America','Willem Dafoe'),  
    (1019,'1974-11-11','United States of America','Leonardo DiCaprio'), 
    (1020,'1983-12-20','United States of America','Jonah Hill'),  
    (1021,'1990-07-02','Australia','Margot Robbie'),  
    (1022,'1969-11-04','United States of America','Matthew McConaughey'), 
    (1023,'1980-07-18','United States of America','Kristen Bell'),  
    (1024,'1971-05-30','United States of America','Idina Menzel'), 
    (1025,'1964-07-26','United States of America','Sandra Bullock'),  
    (1026,'1961-05-06','United States of America','George Clooney'),  
    (1027,'1983-05-05','England','Henry Cavill'),  
    (1028,'1974-08-20','Italy','Amy Adams'),  
    (1029,'1983-08-11','Australia','Chris Hemsworth'),  
    (1030,'1984-03-10','United States of America','Olivia Wilde'),  
    (1031,'1974-10-28','United States of America','Joaquin Phoenix'), 
    (1032,'1984-11-22','United States of America','Scarlett Johansson'),  
    (1033,'1963-12-18','United States of America','Brad Pitt'), 
    (1034,'1974-01-30','Wales','Christian Bale'), 
    (1035,'1982-11-12','United States of America','Anne Hathaway'), 
    (1036,'1981-02-17','United States of America','Joseph Gordon-Levitt'),  
    (1037,'1937-06-01','United States of America','Morgan Freeman'),  
    (1038,'1981-06-13','United States of America','Chris Evans'), 
    (1039,'1965-04-04','United States of America','Robert Downey Jr.'), 
    (1040,'1956-10-08','Austria','Christoph Waltz'), 
    (1041,'1948-12-21','United States of America','Samuel L. Jackson'),  
    (1042,'1968-03-02','England','Daniel Craig'),  
    (1043,'1972-06-19','France','Jean Dujardin'),  
    (1044,'1980-11-12','Canada','Ryan Gosling'),  
    (1045,'1985-04-17','United States of America','Rooney Mara'),  
    (1046,'1977-09-15','England','Tom Hardy'),  
    (1047,'1976-06-19','England','Benedict Cumberbatch'),  
    (1048,'1960-09-10','England','Colin Firth'), 
    (1049,'1989-07-23','England','Daniel Radcliffe'), 
    (1050,'1988-11-06','United States of America','Emma Stone'),  
    (1051,'1968-11-18','United States of America','Owen Wilson'),  
    (1052,'1978-11-17','Canada','Rachel McAdams'),  
    (1053,'1943-12-31','England','Ben Kingsley'),  
    (1054,'1922-05-27','England','Christopher Lee'),  
    (1055,'1964-01-07','United States of America','Nicolas Cage'),  
    (1056,'1983-10-05','United States of America','Jesse Eisenberg'),  
    (1057,'1983-08-20','United States of America','Andrew Garfield'),  
    (1058,'1956-07-09','United States of America','Tom Hanks'), 
    (1059,'1981-06-09','Israel','Natalie Portman'),  
    (1060,'1967-11-22','United States of America','Mark Ruffalo'),
    (1061,'1969-11-13','Scotland','Gerard Butler'),  
    (1062,'1980-08-26','United States of America','Chris Pine'), 
    (1063,'1973-11-27','South Africa','Sharlto Copley'), 
    (1064,'1969-10-01','United States of America','Zach Galifianakis'),  
    (1065,'1981-07-04','France','Tahar Rahim'),  
    (1066,'1952-09-16','United States of America','Mickey Rourke'),  
    (1067,'1930-05-31','United States of America','Clint Eastwood'),  
    (1068,'1971-01-07','United States of America','Jeremy Renner'),  
    (1069,'1976-05-31','Ireland','Colin Farrell'), 
    (1070,'1962-06-05','United States of America','Jeff Garlin'), 
    (1071,'1962-12-22','England','Ralph Fiennes'),  
    (1072,'1955-01-09','United States of America','J.K. Simmons'),  
    (1073,'1970-03-28','United States of America','Vince Vaughn');  

SELECT * FROM Actors;

--------------------------------------------------- TRIGGERS  --------------------------------------------------------

--trigger for the table Actors for inserting, adding a new actor
DROP trigger IF EXISTS Actors_insert_trigger;
CREATE trigger Actors_insert_trigger
AFTER INSERT ON Actors
for each ROW
BEGIN
    insert into logger (logger_operation,logger_table,logger_record_id) VALUES
      ('INSERT','ACTORS',new.Actors_ID);
end;

--trigger for the table Actors for updating, incase information needs updating
DROP trigger IF EXISTS Actors_update_trigger;
CREATE trigger Actors_update_trigger
AFTER UPDATE ON Actors
for each ROW
BEGIN
    insert into logger (logger_operation,logger_table,logger_record_id) VALUES
      ('UPDATE','ACTORS',new.Actors_ID);
end;

--trigger for the table Actors for deleting, incase a actor needs to be deleted
DROP trigger IF EXISTS Actors_delete_trigger;
CREATE trigger Actors_delete_trigger
AFTER DELETE ON Actors
for each ROW
BEGIN
    insert into logger (logger_operation,logger_table,logger_record_id) VALUES
      ('DELETE','ACTORS',new.Actors_ID);
end;

---------------------------------------------- END OF TRIGGERS ------------------------------------------------------



-- "Directors" table that holds all the directors
DROP TABLE IF EXISTS Directors;
CREATE TABLE Directors(
    Directors_ID INT NOT NULL AUTO_INCREMENT,
    Directors_DateofBirth DATE NOT NULL,
    Directors_Nationality VARCHAR(255) NOT NULL,
    Directors_LegalName VARCHAR(255) NOT NULL,
    PRIMARY KEY(Directors_ID)
);
ALTER TABLE Directors AUTO_INCREMENT = 2046;
INSERT INTO Directors(Directors_ID, Directors_DateofBirth, Directors_Nationality, Directors_LegalName) VALUES
    (2001, '1962-08-28', 'United States of America', 'David Andrew Leo Fincher'),       
    (2002, '1966-08-05', 'United States of America', 'James Francis Gunn Jr.'),         
    (2003, '1965-09-17', 'United States of America', 'Bryan Jay Singer'),               
    (2004, '1960-07-30', 'United States of America', 'Richard Stuart Linklater'),      
    (2005, '1975-07-12', 'United States of America', 'Philip Anderson Lord'),           
    (2006, '1975-09-03', 'United States of America', 'Christopher Robert Miller'),      
    (2007, '1969-05-01', 'United States of America', 'Wesley Wales Anderson'),          
    (2008, '1942-11-17', 'United States of America', 'Martin Charles Scorsese'),        
    (2009, '1958-02-24', 'United States of America', 'Christopher James Buck'),        
    (2010, '1971-10-22', 'United States of America', 'Jennifer Michelle Rebecchi'),    
    (2011, '1961-11-28', 'Mexico', 'Alfonso Cuarón Orozco'),                            
    (2012, '1966-03-01', 'United States of America', 'Zachary Edward Snyder'),         
    (2013, '1954-03-01', 'United States of America', 'Ronald William Howard'),         
    (2014, '1969-10-22', 'United States of America', 'Adam H. Spiegel (aka Spike Jonze)'),  
    (2015, '1969-10-09', 'England', 'Steve Rodney McQueen'),                            
    (2016, '1970-07-30', 'England', 'Christopher Nolan'),                               
    (2017, '1964-06-23', 'United States of America', 'Joseph Hill Whedon'),            
    (2018, '1963-03-27', 'United States of America', 'Quentin Jerome Tarantino'),       
    (2019, '1965-08-01', 'England', 'Samuel Alexander Mendes'),                         
    (2020, '1967-03-29', 'France', 'Michel Hazanavicius'),                              
    (2021, '1970-09-29', 'Denmark', 'Nicolas Winding Refn'),                          
    (2022, '1965-04-01', 'Sweden', 'Hans Christian Tomas Alfredson'),                   
    (2023, '1963-12-24', 'United States of America', 'Gavin O''connor'),                
    (2024, '1963-10-08', 'England', 'David Yates'),                                     
    (2025, '1969-06-03', 'United States of America', 'Tate Taylor'),                   
    (2026, '1935-11-30', 'United States of America', 'Allan Stewart Konigsberg (aka woody allen)'), 
    (2027, '1971-03-07', 'England', 'Matthew Allard Robert Vaughn'),                   
    (2028, '1967-08-08', 'United States of America', 'Lee Edward Unkrich'),            
    (2029, '1969-12-02', 'United States of America', 'Darren Aronofsky'),               
    (2030, '1958-02-08', 'United States of America', 'David O. Russell'),               
    (2031, '1972-10-05', 'England', 'Thomas George Hooper'),                           
    (2032, '1962-03-12', 'United States of America', 'Christopher Michael Sanders'),    
    (2033, '1970-06-07', 'Canada', 'Dean DeBlois'),                                     
    (2034, '1954-08-16', 'Canada', 'James Francis Cameron'),                            
    (2035, '1966-06-27', 'United States of America', 'Jeffery Jacob Abrams'),           
    (2036, '1979-09-17', 'South Africa', 'Niell Blomkamp'),                            
    (2037, '1970-12-20', 'United States of America', 'Todd Philip Bunzl'),              
    (2038, '1952-04-30', 'France', 'Jacques Audiard'),                                 
    (2039, '1930-05-31', 'United States of America', 'Clinton Eastwood Jr.'),          
    (2040, '1951-11-27', 'United States of America', 'Kathryn Ann Bigelow'),            
    (2041, '1970-03-26', 'England', 'Martin Faranan McDonagh'),                     
    (2042, '1965-12-03', 'United States of America', 'Andrew Ayers Stanton'),           
    (2043, '1960-05-02', 'United States of America', 'Stephen David Daldry'),          
    (2044, '1977-10-19', 'Canada', 'Jason R. Reitman'),                              
    (2045, '1960-08-17', 'United States of America', 'Sean Justin Penn');              

SELECT * FROM Directors;

--------------------------------------------------- TRIGGERS  --------------------------------------------------------

--trigger for the table Directors for inserting, adding new directors
DROP trigger IF EXISTS Directors_insert_trigger;
CREATE trigger Directors_insert_trigger
AFTER INSERT ON Directors
for each ROW
BEGIN
    insert into logger (logger_operation,logger_table,logger_record_id) VALUES
      ('INSERT','DIRECTORS',new.Directors_ID);
end;

--trigger for the table Directors for updating, incase information needs updating
DROP trigger IF EXISTS Directors_update_trigger;
CREATE trigger Directors_update_trigger
AFTER UPDATE ON Directors
for each ROW
BEGIN
    insert into logger (logger_operation,logger_table,logger_record_id) VALUES
      ('UPDATE','DIRECTORS',new.Directors_ID);
end;

--trigger for the table Directors for deleting, incase a director needs to be deleted
DROP trigger IF EXISTS Directors_delete_trigger;
CREATE trigger Directors_delete_trigger
AFTER DELETE ON Directors
for each ROW
BEGIN
    insert into logger (logger_operation,logger_table,logger_record_id) VALUES
      ('DELETE','DIRECTORS',new.Directors_ID);
end;

--------------------------------------------- END OF TRIGGERS -----------------------------------------------------



-- "Awarders" table that holds all the awarders
DROP TABLE IF EXISTS Awarders;
CREATE TABLE Awarders(
    Awarders_ID INT NOT NULL AUTO_INCREMENT,
    Awarders_DateCreated DATE NOT NULL,
    Awarders_Country VARCHAR(255) NOT NULL,
    Awarders_Name VARCHAR(255) NOT NULL,
    PRIMARY KEY(Awarders_ID)
);
ALTER TABLE Awarders AUTO_INCREMENT = 3005;
INSERT INTO Awarders(Awarders_ID, Awarders_DateCreated, Awarders_Country, Awarders_Name) VALUES
    (3001, '1929-05-16', 'United States of America', 'Academy Awards'),
    (3002, '1995-02-25', 'United States of America', 'Screen Actors Guild Awards'),
    (3003, '1944-01-20', 'United States of America', 'Golden Globe Awards'),
    (3004, '1996-02-22', 'United States of America', 'Critics\ Choice Movie Awards');

SELECT * FROM Awarders;

--------------------------------------------------- TRIGGERS  --------------------------------------------------------

--trigger for the table Awarders for inserting, adding new a awarder
DROP trigger IF EXISTS Awarders_insert_trigger;
CREATE trigger Awarders_insert_trigger
AFTER INSERT ON Awarders
for each ROW
BEGIN
    insert into logger (logger_operation,logger_table,logger_record_id) VALUES
      ('INSERT','AWARDERS',new.Directors_ID);
end;

--trigger for the table Awarders for updating, incase information needs updating
DROP trigger IF EXISTS Awarders_update_trigger;
CREATE trigger Awarders_update_trigger
AFTER UPDATE ON Awarders
for each ROW
BEGIN
    insert into logger (logger_operation,logger_table,logger_record_id) VALUES
      ('UPDATE','AWARDERS',new.Awarders_ID);
end;

--trigger for the table Awarders for deleting, incase a awarder needs to be deleted
DROP trigger IF EXISTS Awarders_delete_trigger;
CREATE trigger Awarders_delete_trigger
AFTER DELETE ON Awarders
for each ROW
BEGIN
    insert into logger (logger_operation,logger_table,logger_record_id) VALUES
      ('DELETE','AWARDERS',new.Awarders_ID);
end;

--------------------------------------------- END OF TRIGGERS -----------------------------------------------------



-- "Awards" table that holds all the awards--
--each Award is given by a different award giver but we decided we not to combine 
--the names of the awards because we didn't want to change the name of the awards
--and it makes it easier to tell which giver gave the award
DROP TABLE IF EXISTS Awards;
CREATE TABLE Awards(
    Awards_ID INT NOT NULL AUTO_INCREMENT,
    Awards_Name VARCHAR(255) NOT NULL,
    PRIMARY KEY(Awards_ID)
);
ALTER TABLE Awards AUTO_INCREMENT = 5030;
INSERT INTO Awards(Awards_ID, Awards_Name) VALUES
    (5001, 'Best Picture'),
    (5002, 'Best Director'),
    (5003, 'Best Actor'),
    (5004, 'Best Supporting actor'),
    (5005, 'Best Actress'),
    (5006, 'Best Supporting Actress'),
    (5007, 'Best Animated Feature Film'),

    (5008, 'Best Picture'),
    (5009, 'Best Director'),
    (5010, 'Best Actor'),
    (5011, 'Best Supporting actor'),
    (5012, 'Best Actress'),
    (5013, 'Best Supporting Actress'),
    (5014, 'Best Animated Feature'),

    (5015, 'Best Motion Picture – Drama'),
    (5016, 'Best Motion Picture – Musical or Comedy'),
    (5017, 'Best Motion Picture – Foreign Language'),
    (5018, 'Best Motion Picture – Animated'),
    (5019, 'Best Director – Motion Picture'),
    (5020, 'Best Actor in a Motion Picture – Drama'),
    (5021, 'Best Actor in a Motion Picture – Musical or Comedy'),
    (5022, 'Best Actress in a Motion Picture – Drama'),
    (5023, 'Best Actress in a Motion Picture – Musical or Comedy'),
    (5024, 'Best Supporting Actor – Motion Picture'),
    (5025, 'Best Supporting Actress – Motion Picture'),
    
    (5026, 'Outstanding Performance by a Male Actor in a Leading Role in a Motion Picture'),
    (5027, 'Outstanding Performance by a Female Actor in a Leading Role in a Motion Picture'),
    (5028, 'Outstanding Performance by a Male Actor in a Supporting Role in a Motion Picture'),
    (5029, 'Outstanding Performance by a Female Actor in a Supporting Role in a Motion Picture');

SELECT * FROM Awards;

--------------------------------------------------- TRIGGERS  --------------------------------------------------------

--trigger for the table Directors for inserting, adding new directors
DROP trigger IF EXISTS Directors_insert_trigger;
CREATE trigger Directors_insert_trigger
AFTER INSERT ON Directors
for each ROW
BEGIN
    insert into logger (logger_operation,logger_table,logger_record_id) VALUES
      ('INSERT','DIRECTORS',new.Directors_ID);
end;

--trigger for the table Directors for updating, incase information needs updating
DROP trigger IF EXISTS Directors_update_trigger;
CREATE trigger Directors_update_trigger
AFTER UPDATE ON Directors
for each ROW
BEGIN
    insert into logger (logger_operation,logger_table,logger_record_id) VALUES
      ('UPDATE','DIRECTORS',new.Directors_ID);
end;

--trigger for the table Directors for deleting, incase a Director needs to be deleted
DROP trigger IF EXISTS Directors_delete_trigger;
CREATE trigger Directors_delete_trigger
AFTER DELETE ON Directors
for each ROW
BEGIN
    insert into logger (logger_operation,logger_table,logger_record_id) VALUES
      ('DELETE','DIRECTORS',new.Directors_ID);
end;

--------------------------------------------- END OF TRIGGERS -----------------------------------------------------



DROP TABLE IF EXISTS MovieDirectors;
CREATE TABLE MovieDirectors(
    MovieDirectors_ID INT NOT NULL AUTO_INCREMENT,
    Movies_ID int,
    Directors_ID int,
    FOREIGN KEY(Movies_ID) 
        REFERENCES Movies(Movies_ID) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(Directors_ID) 
        REFERENCES Directors(Directors_ID) ON DELETE CASCADE ON UPDATE CASCADE,
    PRIMARY KEY(MovieDirectors_ID)
);
INSERT INTO MovieDirectors(Movies_ID, Directors_ID) VALUES
    (1, 2001),
    (2, 2002),
    (3, 2003),
    (4, 2004),
    (5, 2005),
    (5, 2006),
    (6, 2007),
    (7, 2008),
    (8, 2009),
    (8, 2010),
    (9, 2011),
    (10, 2012),
    (11, 2013),
    (12, 2014),
    (13, 2015),
    (14, 2016),
    (15, 2017),
    (16, 2018),
    (17, 2019),
    (18, 2020),
    (19, 2021),
    (20, 2001),
    (21, 2022),
    (22, 2023),
    (23, 2024),
    (24, 2025),
    (25, 2026),
    (26, 2008),
    (27, 2016),
    (28, 2027),
    (29, 2001),
    (30, 2028),
    (31, 2029),
    (32, 2030),
    (33, 2008),
    (34, 2031),
    (35, 2032),
    (35, 2033),
    (36, 2034),
    (37, 2018),
    (38, 2035),
    (39, 2036),
    (40, 2037),
    (41, 2038),
    (42, 2016),
    (43, 2029),
    (44, 2039),
    (45, 2040),
    (46, 2041),
    (47, 2042),
    (48, 2043),
    (49, 2044),
    (50, 2045);
SELECT * FROM MovieDirectors;

--------------------------------------------------- TRIGGERS  --------------------------------------------------------

--trigger for the table MovieDirectors for inserting, for new connections
DROP trigger IF EXISTS MovieDirectors_insert_trigger;
CREATE trigger MovieDirectors_insert_trigger
AFTER INSERT ON MovieDirectors
for each ROW
BEGIN
    insert into logger (logger_operation,logger_table,logger_record_id) VALUES
      ('INSERT','MovieDirectors',new.MovieDirectors_ID);
end;

--trigger for the table MovieDirectors for updating, incase information needs updating
DROP trigger IF EXISTS MovieDirectors_update_trigger;
CREATE trigger MovieDirectors_update_trigger
AFTER UPDATE ON MovieDirectors
for each ROW
BEGIN
    insert into logger (logger_operation,logger_table,logger_record_id) VALUES
      ('UPDATE','MovieDirectors',new.MovieDirectors_ID);
end;

--trigger for the table MovieDirectors for deleting, incase information needs to be deleted
DROP trigger IF EXISTS MovieDirectors_delete_trigger;
CREATE trigger MovieDirectors_delete_trigger
AFTER DELETE ON MovieDirectors
for each ROW
BEGIN
    insert into logger (logger_operation,logger_table,logger_record_id) VALUES
      ('DELETE','MovieDirectors',new.MovieDirectors_ID);
end;

--------------------------------------------- END OF TRIGGERS -----------------------------------------------------



DROP TABLE IF EXISTS AwarderGivesAward;
CREATE TABLE AwarderGivesAward(
    AwarderGivesAwards_ID INT NOT NULL AUTO_INCREMENT,
    Awarders_ID INT,
    Awards_ID INT,
    FOREIGN KEY(Awarders_ID)
        REFERENCES Awarders(Awarders_ID) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(Awards_ID)
        REFERENCES Awards(Awards_ID) ON DELETE CASCADE ON UPDATE CASCADE,
    PRIMARY KEY(AwarderGivesAwards_ID)
);
INSERT INTO AwarderGivesAward (Awarders_ID, Awards_ID) VALUES
    (3001, 5001),
    (3001, 5002),
    (3001, 5003),
    (3001, 5004),
    (3001, 5005),
    (3001, 5006),
    (3001, 5007),

    (3002, 5008),
    (3002, 5009),
    (3002, 5010),
    (3002, 5011),
    (3002, 5012),
    (3002, 5013),
    (3002, 5014),

    (3003, 5015),
    (3003, 5016),
    (3003, 5017),
    (3003, 5018),
    (3003, 5019),
    (3003, 5020),
    (3003, 5021),
    (3003, 5022),
    (3003, 5023),
    (3003, 5024),
    (3003, 5025),

    (3004, 5026),
    (3004, 5027),
    (3004, 5028),
    (3004, 5029);
SELECT * FROM AwarderGivesAward;

--------------------------------------------------- TRIGGERS  --------------------------------------------------------

--trigger for the table AwarderGivesAward for inserting, for new connections
DROP trigger IF EXISTS AwarderGivesAward_insert_trigger;
CREATE trigger AwarderGivesAward_insert_trigger
AFTER INSERT ON AwarderGivesAward
for each ROW
BEGIN
    insert into logger (logger_operation,logger_table,logger_record_id) VALUES
      ('INSERT','AwarderGivesAward',new.AwarderGivesAward_ID);
end;

--trigger for the table AwarderGivesAward for updating, incase information needs updating
DROP trigger IF EXISTS AwarderGivesAward_update_trigger;
CREATE trigger AwarderGivesAward_update_trigger
AFTER UPDATE ON AwarderGivesAward
for each ROW
BEGIN
    insert into logger (logger_operation,logger_table,logger_record_id) VALUES
      ('UPDATE','AwarderGivesAward',new.AwarderGivesAward_ID);
end;

--trigger for the table AwarderGivesAward for deleting, incase information needs to be deleted
DROP trigger IF EXISTS AwarderGivesAward_delete_trigger;
CREATE trigger AwarderGivesAward_delete_trigger
AFTER DELETE ON AwarderGivesAward
for each ROW
BEGIN
    insert into logger (logger_operation,logger_table,logger_record_id) VALUES
      ('DELETE','AwarderGivesAward',new.AwarderGivesAward_ID);
end;

--------------------------------------------- END OF TRIGGERS -----------------------------------------------------



DROP TABLE IF EXISTS ActorAwards;
CREATE TABLE ActorAwards (
    ActorAwards_ID INT NOT NULL AUTO_INCREMENT,
    Actors_ID INT,
    Awards_ID INT,
    FOREIGN KEY(Actors_ID)
        REFERENCES Actors(Actors_ID) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(Awards_ID)
        REFERENCES Awards(Awards_ID) ON DELETE CASCADE ON UPDATE CASCADE,
    PRIMARY KEY(ActorAwards_ID)
);
INSERT INTO ActorAwards(Actors_ID, Awards_ID) VALUES
    (1040, 5004),
    (1040, 5024),
    (1043, 5003),
    (1043, 5021),
    (1043, 5026),
    (1059, 5005),
    (1059, 5012),
    (1059, 5022),
    (1059, 5027),
    (1034, 5004),
    (1034, 5011),
    (1034, 5024),
    (1034, 5028),
    (1048, 5003),
    (1048, 5010),
    (1048, 5020),
    (1048, 5026),
    (1040, 5004),
    (1040, 5024),
    (1040, 5028),
    (1066, 5020),
    (1069, 5021);
SELECT * FROM ActorAwards;

--------------------------------------------------- TRIGGERS  --------------------------------------------------------

--trigger for the table ActorAwards for inserting, for new connections
DROP trigger IF EXISTS ActorAwards_insert_trigger;
CREATE trigger ActorAwards_insert_trigger
AFTER INSERT ON ActorAwards
for each ROW
BEGIN
    insert into logger (logger_operation,logger_table,logger_record_id) VALUES
      ('INSERT','ActorAwards',new.ActorAwards_ID);
end;

--trigger for the table ActorAwards for updating, incase information needs updating
DROP trigger IF EXISTS ActorAwards_update_trigger;
CREATE trigger ActorAwards_update_trigger
AFTER UPDATE ON ActorAwards
for each ROW
BEGIN
    insert into logger (logger_operation,logger_table,logger_record_id) VALUES
      ('UPDATE','ActorAwards',new.ActorAwards_ID);
end;

--trigger for the table ActorAwards for deleting, incase information needs to be deleted
DROP trigger IF EXISTS ActorAwards_delete_trigger;
CREATE trigger ActorAwards_delete_trigger
AFTER DELETE ON ActorAwards
for each ROW
BEGIN
    insert into logger (logger_operation,logger_table,logger_record_id) VALUES
      ('DELETE','ActorAwards',new.ActorAwards_ID);
end;

--------------------------------------------- END OF TRIGGERS -----------------------------------------------------




DROP TABLE IF EXISTS MovieAwards;
CREATE TABLE MovieAwards (
    MovieAwards_ID INT NOT NULL AUTO_INCREMENT,
    Movies_ID INT,
    Awards_ID INT,
    FOREIGN KEY(Movies_ID)
        REFERENCES Movies(Movies_ID) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(Awards_ID)
        REFERENCES Awards(Awards_ID) ON DELETE CASCADE ON UPDATE CASCADE,
    PRIMARY KEY(MovieAwards_ID)
);
INSERT INTO MovieAwards(Movies_ID, Awards_ID) VALUES
    (4, 5008),
    (4, 5015),
    (8, 5007),
    (8, 5014),
    (8, 5018),
    (13, 5001),
    (18, 5001),
    (18, 5008),
    (18, 5016),
    (29, 5008),
    (29, 5015),
    (30, 5007),
    (30, 5014),
    (30, 5018),
    (34, 5001),
    (36, 5015),
    (40, 5016),
    (45, 5001),
    (45, 5008),
    (47, 5007),
    (47, 5014),
    (47, 5018);
SELECT * FROM MovieAwards;

--------------------------------------------------- TRIGGERS  --------------------------------------------------------

--trigger for the table MovieAwards for inserting, for new connections
DROP trigger IF EXISTS MovieAwards_insert_trigger;
CREATE trigger MovieAwards_insert_trigger
AFTER INSERT ON MovieAwards
for each ROW
BEGIN
    insert into logger (logger_operation,logger_table,logger_record_id) VALUES
      ('INSERT','MovieAwards',new.MovieAwards_ID);
end;

--trigger for the table MovieAwards for updating, incase information needs updating
DROP trigger IF EXISTS MovieAwards_update_trigger;
CREATE trigger MovieAwards_update_trigger
AFTER UPDATE ON MovieAwards
for each ROW
BEGIN
    insert into logger (logger_operation,logger_table,logger_record_id) VALUES
      ('UPDATE','MovieAwards',new.MovieAwards_ID);
end;

--trigger for the table MovieAwards for deleting, incase information needs to be deleted
DROP trigger IF EXISTS MovieAwards_delete_trigger;
CREATE trigger MovieAwards_delete_trigger
AFTER DELETE ON MovieAwards
for each ROW
BEGIN
    insert into logger (logger_operation,logger_table,logger_record_id) VALUES
      ('DELETE','MovieAwards',new.MovieAwards_ID);
end;

--------------------------------------------- END OF TRIGGERS -----------------------------------------------------
 


DROP TABLE IF EXISTS DirectorAwards;
CREATE TABLE DirectorAwards (
    DirectorAwards_ID INT NOT NULL AUTO_INCREMENT,
    Directors_ID INT,
    Awards_ID INT,
    FOREIGN KEY(Directors_ID)
        REFERENCES Directors(Directors_ID) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(Awards_ID)
        REFERENCES Awards(Awards_ID) ON DELETE CASCADE ON UPDATE CASCADE,
    PRIMARY KEY(DirectorAwards_ID)
);
INSERT INTO DirectorAwards(Directors_ID, Awards_ID) VALUES
    (2004, 5009),
    (2004, 5019),
    (2011, 5002),
    (2011, 5009),
    (2011, 5019),
    (2020, 5002),
    (2020, 5009),
    (2008, 5019),
    (2001, 5009),
    (2001, 5019),
    (2031, 5002),
    (2034, 5019),
    (2040, 5002),
    (2040, 5009);
SELECT * FROM DirectorAwards;

--------------------------------------------------- TRIGGERS  --------------------------------------------------------

--trigger for the table DirectorAwards for inserting, for new connections
DROP trigger IF EXISTS DirectorAwards_insert_trigger;
CREATE trigger DirectorAwards_insert_trigger
AFTER INSERT ON DirectorAwards
for each ROW
BEGIN
    insert into logger (logger_operation,logger_table,logger_record_id) VALUES
      ('INSERT','DirectorAwards',new.DirectorAwards_ID);
end;

--trigger for the table DirectorAwards for updating, incase information needs updating
DROP trigger IF EXISTS DirectorAwards_update_trigger;
CREATE trigger DirectorAwards_update_trigger
AFTER UPDATE ON DirectorAwards
for each ROW
BEGIN
    insert into logger (logger_operation,logger_table,logger_record_id) VALUES
      ('UPDATE','DirectorAwards',new.DirectorAwards_ID);
end;

--trigger for the table DirectorAwards for deleting, incase information needs to be deleted
DROP trigger IF EXISTS DirectorAwards_delete_trigger;
CREATE trigger DirectorAwards_delete_trigger
AFTER DELETE ON DirectorAwards
for each ROW
BEGIN
    insert into logger (logger_operation,logger_table,logger_record_id) VALUES
      ('DELETE','DirectorAwards',new.DirectorAwards_ID);
end;

--------------------------------------------- END OF TRIGGERS -----------------------------------------------------



---table that will connect actors and movies
DROP TABLE IF EXISTS ActorsInMovies;
CREATE TABLE ActorsInMovies(
    ActorsInMovies_ID INT NOT NULL AUTO_INCREMENT,
    Actors_ID INT, 
    Movies_ID INT,
    FOREIGN KEY(Actors_ID)
        REFERENCES Actors(Actors_ID) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(Movies_ID)
        REFERENCES Movies(Movies_ID) ON DELETE CASCADE ON UPDATE CASCADE,
    PRIMARY KEY(ActorsInMovies_ID)
);
---inserting info for the relationship of actors in movies
INSERT INTO ActorsInMovies(Actors_ID, Movies_ID) VALUES
    (1001, 1),

    (1002, 1),

    (1003, 1),

    (1004, 2),
    (1004, 5),
    (1004, 12),

    (1005, 2),

    (1006, 2),
    (1006, 40),

    (1007, 2),
    (1007, 36),
    (1007, 38),

    (1008, 3),

    (1009, 3),

    (1010, 3),

    (1011, 3),

    (1012, 3),
    (1012, 13),
    (1012, 37),

    (1013, 3),

    (1014, 3),
    (1014, 27),
    (1014, 49),

    (1015, 4),

    (1016, 5),

    (1017, 6),

    (1018, 6),

    (1019, 7),
    (1019, 16),
    (1019, 27),
    (1019, 33),

    (1020, 7),

    (1021, 7),

    (1022, 7),

    (1023, 8),

    (1024, 8),

    (1025, 9),

    (1026, 9),

    (1027, 9),

    (1028, 10),
    (1028, 12),
    (1028, 32),

    (1029, 11),
    (1029, 15),
    (1029, 38),

    (1030, 11),

    (1031, 12),

    (1032, 12),
    (1032, 15),

    (1033, 13),
    (1033, 37),

    (1034, 14),
    (1034, 32),
    (1034, 42),

    (1035, 14),

    (1036, 14),
    (1036, 27),

    (1037, 14),

    (1038, 15),

    (1039, 15),

    (1040, 16),
    (1040, 37),

    (1041, 16),

    (1042, 20),

    (1043, 18),
    (1043, 7),

    (1044, 19),

    (1045, 20),
    (1045, 29),

    (1046, 21),
    (1046, 22),
    (1046, 27),

    (1047, 21),

    (1048, 21),
    (1048, 34),

    (1049, 23),

    (1050, 24),

    (1051, 25),

    (1052, 25),

    (1053, 26),
    (1053, 33),

    (1054, 26),

    (1055, 28),

    (1056, 29),

    (1057, 29),

    (1058, 30),

    (1059, 31),

    (1060, 33),
    (1060, 15),

    (1061, 35),

    (1062, 38),

    (1063, 39),

    (1064, 40),
    (1064, 50),

    (1065, 41),

    (1066, 43),

    (1067, 44),

    (1068, 45),
    (1068, 15),

    (1069, 46),

    (1070, 47),

    (1071, 48),
    (1071, 6),
    (1071, 17),
    (1071, 23),
    (1071, 46),

    (1072, 49),

    (1073, 50);
SELECT * FROM ActorsInMovies;

--------------------------------------------------- TRIGGERS  --------------------------------------------------------

--trigger for the table ActorsInMovies for inserting, for new connections
DROP trigger IF EXISTS ActorsInMovies_insert_trigger;
CREATE trigger ActorsInMovies_insert_trigger
AFTER INSERT ON ActorsInMovies
for each ROW
BEGIN
    insert into logger (logger_operation,logger_table,logger_record_id) VALUES
      ('INSERT','ActorsInMovies',new.ActorsInMovies_ID);
end;

--trigger for the table ActorsInMovies for updating, incase information needs updating
DROP trigger IF EXISTS ActorsInMovies_update_trigger;
CREATE trigger ActorsInMovies_update_trigger
AFTER UPDATE ON ActorsInMovies
for each ROW
BEGIN
    insert into logger (logger_operation,logger_table,logger_record_id) VALUES
      ('UPDATE','ActorsInMovies',new.ActorsInMovies_ID);
end;

--trigger for the table ActorsInMovies for deleting, incase information needs to be deleted
DROP trigger IF EXISTS ActorsInMovies_delete_trigger;
CREATE trigger ActorsInMovies_delete_trigger
AFTER DELETE ON ActorsInMovies
for each ROW
BEGIN
    insert into logger (logger_operation,logger_table,logger_record_id) VALUES
      ('DELETE','ActorsInMovies',new.ActorsInMovies_ID);
end;

--------------------------------------------- END OF TRIGGERS -----------------------------------------------------



--Table for Which Studios produced which Movies
DROP TABLE IF EXISTS StudiosMadeMovies;
CREATE TABLE StudiosMadeMovies(
    StudiosMadeMovies_ID INT NOT NULL AUTO_INCREMENT,
    Studios_ID INT,
    Movies_ID INT,
    FOREIGN KEY(Studios_ID)
        REFERENCES Studios(Studios_ID) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(Movies_ID)
        REFERENCES Movies(Movies_ID) ON DELETE CASCADE ON UPDATE CASCADE,
    PRIMARY KEY(StudiosMadeMovies_ID)
);
--Inserting information to with studios id and movies i
INSERT INTO StudiosMadeMovies(Studios_ID, Movies_ID) VALUES
    (901, 1),
    (901, 2),
    (901, 3),
    (902, 4),
    (904, 5),
    (901, 6),
    (903, 7),
    (901, 8),
    (904, 9),
    (904, 10),
    (902, 11),
    (904, 12),
    (901, 13),
    (904, 14),
    (901, 15),
    (905, 16),
    (905, 17),
    (904, 18),
    (903, 19),
    (905, 20),
    (903, 21),
    (903, 22),
    (904, 23),
    (901, 24),
    (905, 25),
    (903, 26),
    (904, 27),
    (902, 28),
    (905, 29),
    (901, 30),
    (901, 31),
    (903, 32),
    (903, 33),
    (903, 34),
    (902, 35),
    (901, 36),
    (902, 37),
    (904, 38),
    (905, 39),
    (904, 40),
    (902, 41),
    (904, 42),
    (901, 43),
    (904, 44),
    (902, 45),
    (902, 46),
    (901, 47),
    (904, 48),
    (901, 49),
    (903, 50);
SELECT * FROM StudiosMadeMovies;

--------------------------------------------------- TRIGGERS  --------------------------------------------------------

--trigger for the table StudiosMadeMovies for inserting, for new connections
DROP trigger IF EXISTS StudiosMadeMovies_insert_trigger;
CREATE trigger StudiosMadeMovies_insert_trigger
AFTER INSERT ON StudiosMadeMovies
for each ROW
BEGIN
    insert into logger (logger_operation,logger_table,logger_record_id) VALUES
      ('INSERT','StudiosMadeMovies',new.StudiosMadeMovies_ID);
end;

--trigger for the table StudiosMadeMovies for updating, incase information needs updating
DROP trigger IF EXISTS StudiosMadeMovies_update_trigger;
CREATE trigger StudiosMadeMovies_update_trigger
AFTER UPDATE ON StudiosMadeMovies
for each ROW
BEGIN
    insert into logger (logger_operation,logger_table,logger_record_id) VALUES
      ('UPDATE','StudiosMadeMovies',new.StudiosMadeMovies_ID);
end;

--trigger for the table StudiosMadeMovies for deleting, incase information needs to be deleted
DROP trigger IF EXISTS StudiosMadeMovies_delete_trigger;
CREATE trigger StudiosMadeMovies_delete_trigger
AFTER DELETE ON StudiosMadeMovies
for each ROW
BEGIN
    insert into logger (logger_operation,logger_table,logger_record_id) VALUES
      ('DELETE','StudiosMadeMovies',new.StudiosMadeMovies_ID);
end;

--------------------------------------------- END OF TRIGGERS -----------------------------------------------------




--Table for which Actors were hired by which studios
DROP TABLE IF EXISTS ActorshiredbyStudios;
CREATE TABLE ActorshiredbyStudios(
    ActorshiredbyStudios_ID INT NOT NULL AUTO_INCREMENT, 
    Actors_ID INT,
    Studios_ID INT,
    FOREIGN KEY(Actors_ID)
        REFERENCES Actors(Actors_ID) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(Studios_ID)
        REFERENCES Studios(Studios_ID) ON DELETE CASCADE ON UPDATE CASCADE,
    PRIMARY KEY(ActorshiredbyStudios_ID)
);
INSERT INTO ActorshiredbyStudios(Actors_ID, Studios_ID) VALUES
    (1001, 901),
    (1002, 901),
    (1003, 901),
    (1004, 901),
    (1004, 904),
    (1005, 901),
    (1006, 901),
    (1006, 904),
    (1007, 901),
    (1007, 905),
    (1008, 901),
    (1009, 901),
    (1010, 901),
    (1011, 901),
    (1012, 901),
    (1012, 902),
    (1013, 901),
    (1014, 901),
    (1014, 904),
    (1015, 902),
    (1016, 904),
    (1017, 901),
    (1018, 901),
    (1019, 903),
    (1019, 905),
    (1019, 904),
    (1020, 903),
    (1021, 903),
    (1022, 903),
    (1023, 901),
    (1024, 901),
    (1025, 904),
    (1026, 904),
    (1027, 904),
    (1028, 904),
    (1028, 903),
    (1029, 902),
    (1029, 901),
    (1029, 904),
    (1030, 902),
    (1031, 904),
    (1032, 904),
    (1032, 901),
    (1033, 901),
    (1033, 902),
    (1034, 903),
    (1034, 904),
    (1035, 904),
    (1036, 904),
    (1037, 904),
    (1038, 901),
    (1039, 901),
    (1040, 905),
    (1040, 902),
    (1041, 905),
    (1042, 905),
    (1043, 904),
    (1043, 903),
    (1044, 903),
    (1045, 905),
    (1046, 903),
    (1046, 904),
    (1047, 903),
    (1048, 903),
    (1049, 904),
    (1050, 901),
    (1051, 905),
    (1052, 905),
    (1053, 903),
    (1054, 903),
    (1055, 902),
    (1056, 905),
    (1057, 905),
    (1058, 901),
    (1059, 901),
    (1060, 901),
    (1060, 903),
    (1061, 902),
    (1062, 904),
    (1063, 905),
    (1064, 903),
    (1064, 904),
    (1065, 902),
    (1066, 901),
    (1067, 904),
    (1068, 902),
    (1068, 901),
    (1069, 902),
    (1070, 901),
    (1071, 901),
    (1071, 902),
    (1071, 904),
    (1071, 905),
    (1072, 901),
    (1073, 903);
--SELECT * FROM ActorshiredbyStudios;

--------------------------------------------------- TRIGGERS  --------------------------------------------------------

--trigger for the table ActorshiredbyStudios for inserting, for new connections
DROP trigger IF EXISTS ActorshiredbyStudios_insert_trigger;
CREATE trigger ActorshiredbyStudios_insert_trigger
AFTER INSERT ON ActorshiredbyStudios
for each ROW
BEGIN
    insert into logger (logger_operation,logger_table,logger_record_id) VALUES
      ('INSERT','ActorshiredbyStudios',new.ActorshiredbyStudios_ID);
end;

--trigger for the table ActorshiredbyStudios for updating, incase information needs updating
DROP trigger IF EXISTS ActorshiredbyStudios_update_trigger;
CREATE trigger ActorshiredbyStudios_update_trigger
AFTER UPDATE ON ActorshiredbyStudios
for each ROW
BEGIN
    insert into logger (logger_operation,logger_table,logger_record_id) VALUES
      ('UPDATE','ActorshiredbyStudios',new.ActorshiredbyStudios_ID);
end;

--trigger for the table ActorshiredbyStudios for deleting, incase information needs to be deleted
DROP trigger IF EXISTS ActorshiredbyStudios_delete_trigger;
CREATE trigger ActorshiredbyStudios_delete_trigger
AFTER DELETE ON ActorshiredbyStudios
for each ROW
BEGIN
    insert into logger (logger_operation,logger_table,logger_record_id) VALUES
      ('DELETE','ActorshiredbyStudios',new.ActorshiredbyStudios_ID);
end;

--------------------------------------------- END OF TRIGGERS -----------------------------------------------------



--Table for which studios hired what actors
DROP TABLE IF EXISTS StudiosHiredDirectors;
CREATE TABLE StudiosHiredDirectors(
    StudiosHiredDirectors_ID INT NOT NULL AUTO_INCREMENT,
    Studios_ID INT,
    Directors_ID INT,
    FOREIGN KEY(Studios_ID)
        REFERENCES Studios(Studios_ID) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(Directors_ID)
        REFERENCES Directors(Directors_ID) ON DELETE CASCADE ON UPDATE CASCADE,
    PRIMARY KEY(StudiosHiredDirectors_ID)
);
INSERT INTO StudiosHiredDirectors(Studios_ID, Directors_ID) VALUES
    (901, 2001),
    (905, 2001),
    (901, 2002),
    (901, 2003),
    (902, 2004),
    (904, 2005),
    (904, 2006),
    (901, 2007),
    (903, 2008),
    (901, 2009),
    (901, 2010),
    (904, 2011),
    (904, 2012),
    (902, 2013),
    (904, 2014),
    (901, 2015),
    (904, 2016),
    (901, 2017),
    (902, 2017),
    (905, 2018),
    (902, 2018),
    (905, 2019),
    (904, 2020),
    (903, 2021),
    (903, 2022),
    (903, 2023),
    (904, 2024),
    (905, 2025),
    (905, 2026),
    (902, 2027),
    (901, 2028),
    (901, 2029),
    (903, 2030),
    (903, 2031),
    (902, 2032),
    (902, 2033),
    (904, 2034),
    (904, 2035),
    (905, 2036),
    (904, 2037),
    (902, 2038),
    (904, 2039),
    (902, 2040),
    (902, 2041),
    (901, 2042),
    (904, 2043),
    (901, 2044),
    (903, 2045);
--SELECT * FROM StudiosHiredDirectors;


--------------------------------------------------- TRIGGERS  --------------------------------------------------------

--trigger for the table StudiosHiredDirectors for inserting, for new connections
DROP trigger IF EXISTS StudiosHiredDirectors_insert_trigger;
CREATE trigger StudiosHiredDirectors_insert_trigger
AFTER INSERT ON StudiosHiredDirectors
for each ROW
BEGIN
    insert into logger (logger_operation,logger_table,logger_record_id) VALUES
      ('INSERT','StudiosHiredDirectors',new.StudiosHiredDirectors_ID);
end;

--trigger for the table StudiosHiredDirectors for updating, incase information needs updating
DROP trigger IF EXISTS StudiosHiredDirectors_update_trigger;
CREATE trigger StudiosHiredDirectors_update_trigger
AFTER UPDATE ON StudiosHiredDirectors
for each ROW
BEGIN
    insert into logger (logger_operation,logger_table,logger_record_id) VALUES
      ('UPDATE','StudiosHiredDirectors',new.StudiosHiredDirectors_ID);
end;

--trigger for the table StudiosHiredDirectors for deleting, incase information needs to be deleted
DROP trigger IF EXISTS StudiosHiredDirectors_delete_trigger;
CREATE trigger StudiosHiredDirectors_delete_trigger
AFTER DELETE ON StudiosHiredDirectors
for each ROW
BEGIN
    insert into logger (logger_operation,logger_table,logger_record_id) VALUES
      ('DELETE','StudiosHiredDirectors',new.StudiosHiredDirectors_ID);
end;

--------------------------------------------- END OF TRIGGERS -----------------------------------------------------------------------



--------------------------------------------------- VIEWS ALONG WITH 20 QUERIES --------------------------------------------------------

---Created views that display our 20 queries

--1)Do movies that get more awards have a bigger box office?
DROP VIEW MoviesGetMoreAwardsBudget;
CREATE VIEW MoviesGetMoreAwardsBudget as(
    SELECT DISTINCT 
        Movies_FilmName AS 'Movie',
        Movies_Gross as 'Gross'
    FROM 
        Movies m
    JOIN 
        MovieAwards ma ON m.Movies_ID = ma.Movies_ID
    JOIN 
        Awards a ON ma.Awards_ID = a.Awards_ID
)
--SELECT * FROM MoviesGetMoreAwardsBudget


--2)Do movies with a bigger budget have a bigger box office?
DROP VIEW MoviesGetMoreGrossBudget;
CREATE VIEW MoviesGetMoreGrossBudget as (
    SELECT 
        Movies_FilmName AS 'Movie', 
        Movies_Budget AS 'Budget', 
        Movies_Gross as 'Gross'
    FROM 
        Movies
    ORDER BY 
        Movies_Budget DESC
)
--SELECT * FROM MoviesGetMoreGrossBudget


--3)How much did the top 5 most awarded movies gross?
DROP VIEW TopMovieAwardedGross;
CREATE VIEW TopMovieAwardedGross AS(
    SELECT 
        Movies_FilmName AS 'Movie', 
        Movies_Gross AS 'Gross', 
        count(*) AS 'Awards number'
    FROM 
        Movies
    JOIN MovieAwards ON Movies.Movies_ID = MovieAwards.Movies_ID
    JOIN Awards ON MovieAwards.Awards_ID = Awards.Awards_ID
    GROUP BY 
        Movies_Gross, 
        Movies_FilmName
    ORDER BY 
        count(*) DESC
    limit 5
)
--SELECT * FROM TopMovieAwardedGross


--4)Which actors worked on this movie 'X-Men: Days of Future Past'?
DROP VIEW ActorsWorkedOnAMovie;
CREATE VIEW ActorsWorkedOnAMovie AS (
    SELECT 
        Actors_LegalName AS 'Actor'
    FROM 
        Actors a
    INNER JOIN ActorsInMovies b on a.Actors_ID = b.Actors_ID
    INNER JOIN Movies c on b.Movies_ID = c.Movies_ID
    WHERE 
        Movies_FilmName = 'X-Men: Days of Future Past'
)
--SELECT * FROM ActorsWorkedOnAMovie


--5)Which director has won the most amount of awards?
DROP VIEW WhichDirectorWonMost;
CREATE VIEW WhichDirectorWonMost AS (
    SELECT 
        Directors.Directors_LegalName AS 'Director',
        Count(Awards.Awards_ID) AS 'Awards Number'
    FROM 
        Directors
    JOIN DirectorAwards ON Directors.Directors_ID = DirectorAwards.Directors_ID
    JOIN Awards ON DirectorAwards.Awards_ID = Awards.Awards_ID
    GROUP BY 
        Directors_LegalName
    ORDER BY Count(Awards.Awards_ID) DESC
    LIMIT 1
)
--SELECT * FROM WhichDirectorWonMost


--6)Which movie has the highest gross?
DROP VIEW WhichMovieHighestGross;
CREATE VIEW WhichMovieHighestGross AS(
    SELECT 
        Movies_FilmName AS 'Movie',
        Movies_Gross as 'Gross'
    FROM 
        Movies
    ORDER BY 
        Movies_Gross DESC
    LIMIT 1
)
--SELECT * FROM WhichMovieHighestGross

--7)Which directors have worked at at which studios?
DROP VIEW DirectorsHiredBySelectedStudio;
CREATE VIEW DirectorsHiredBySelectedStudio as(
    SELECT 
        Directors_LegalName AS 'Director',
        Studios_TradeName AS 'Studio'
    FROM
        Studios a
        inner join StudiosHiredDirectors b on (a.Studios_ID=b.Studios_ID)
        inner join Directors c on (b.Directors_ID=c.Directors_ID)
    ORDER BY
        Directors_LegalName
)
--SELECT * FROM DirectorsHiredBySelectedStudio;


--8)What are all the movies in the genre 'Drama'?
DROP VIEW WhatMoviesInGenre;
CREATE VIEW WhatMoviesInGenre AS(
    SELECT 
        Movies_FilmName AS 'Movie'
    FROM 
        Movies 
    WHERE 
        Movies_Genre = 'Drama'
)
--SELECT * FROM WhatMoviesInGenre;


--9)What is the genre, budget, and gross of the movie 'The Lego Movie'?
DROP VIEW WhatIsGenreBudgetGrossOfMovie;
CREATE VIEW WhatIsGenreBudgetGrossOfMovie AS (
    SELECT 
        Movies_FilmName AS 'Movie', 
        Movies_Genre AS 'Genre', 
        Movies_Budget AS 'Budget', 
        Movies_Gross AS 'Gross'
    FROM 
        Movies
    WHERE 
        Movies_FilmName = 'The Lego Movie'
)
--SELECT * FROM WhatIsGenreBudgetGrossOfMovie;


--10)Which studio has the highest total gross for all of their movies?
DROP VIEW WhichStudioHasHighestGross;
CREATE VIEW WhichStudioHasHighestGross AS (
    SELECT 
        DISTINCT Studios_TradeName 'Studio',
        sum(Movies_Gross) AS 'Gross'
    FROM 
        (Studios sd, Movies m)
    JOIN StudiosMadeMovies sm ON sd.Studios_ID = sm.Studios_ID
    GROUP BY 
        Studios_TradeName 
    ORDER BY 
        sum(Movies_Gross) DESC
    LIMIT 1
)
--SELECT * FROM WhichStudioHasHighestGross;


--11)What movies is Chris Pratt in?
DROP VIEW WhatMoviesIsActorIn;
CREATE VIEW WhatMoviesIsActorIn AS (
    SELECT 
        Actors_LegalName AS 'Actor', 
        Movies_FilmName AS 'Movie' 
    FROM 
        Actors
    JOIN ActorsInMovies ON Actors.Actors_ID = ActorsInMovies.Actors_ID
    JOIN Movies ON ActorsInMovies.Movies_ID = Movies.Movies_ID
    WHERE 
        Actors_LegalName = "Chris Pratt"
)
--SELECT * FROM WhatMoviesIsActorIn;


--12)Which studio has the biggest gap in box office?
DROP VIEW StudioHasBiggestGapBox;
CREATE VIEW StudioHasBiggestGapBox AS (
    SELECT 
        Studios_TradeName AS 'Studio', 
        (max(Movies_Gross) - min(Movies_Gross)) as Gap
    FROM 
        Studios
    JOIN StudiosMadeMovies ON Studios.Studios_ID = StudiosMadeMovies.Studios_ID
    JOIN Movies ON StudiosMadeMovies.Movies_ID = Movies.Movies_ID
    GROUP BY 
        Studios_TradeName
    ORDER BY 
        Gap DESC
    LIMIT 1
);
--SELECT * FROM StudioHasBiggestGapBox;


--13)What movies has this director directed?
DROP VIEW WhatMoviesDirectorDirected;
CREATE VIEW WhatMoviesDirectorDirected AS (
    SELECT 
        Movies_FilmName AS 'Movie' 
    FROM 
        Directors
    JOIN MovieDirectors ON Directors.Directors_ID = MovieDirectors.Directors_ID
    JOIN Movies ON MovieDirectors.Movies_ID = Movies.Movies_ID
    WHERE 
        Directors_LegalName = "Martin Charles Scorsese"
);
--SELECT * FROM WhatMoviesDirectorDirected;


--14)Which studio made the movie that won the most awards?
DROP VIEW StudioMovieMostAwards;
CREATE VIEW StudioMovieMostAwards AS (
    WITH mostAwardsCTE AS(
        SELECT 
            Movies.Movies_ID, 
            Movies.Movies_FilmName AS 'Movie',
            count(*) AS varname
        FROM 
            Movies
        JOIN MovieAwards ON Movies.Movies_ID = MovieAwards.Movies_ID
        GROUP BY 
            Movies_ID, Movies_FilmName
        ORDER BY 
            count(*) DESC, Movies_ID
        limit 1
    )
    SELECT 
        Studios_TradeName AS 'Studio',
        mostAwardsCTE.Movie,
        varname AS 'Awards number'
    FROM 
        mostAwardsCTE
    JOIN StudiosMadeMovies on mostAwardsCTE.Movies_ID = StudiosMadeMovies.Movies_ID
    JOIN Studios on StudiosMadeMovies.Studios_ID = Studios.Studios_ID
)
--SELECT * FROM AllMoviesListed;


--15)What is the movie with the longest title?
DROP VIEW MovieWithLongestTitle;
CREATE VIEW MovieWithLongestTitle AS (
    SELECT
        Movies_FilmName as 'Movie'
    FROM 
        Movies
    WHERE LENGTH(Movies_FilmName) = (
        SELECT MAX(LENGTH(Movies_FilmName))
        FROM Movies)
)
--SELECT * FROM MovieWithLongestTitle;


--16)Who is the youngest director?
DROP VIEW WhoIsYoungestDirector;
CREATE VIEW WhoIsYoungestDirector AS (
    SELECT 
        Directors_LegalName AS 'Director',
        max(Directors_DateofBirth) 'Birthday'
    FROM 
        Directors
    GROUP BY 
        Directors_LegalName
    ORDER BY 
        max(Directors_DateofBirth) DESC 
    limit 1
)
--SELECT * FROM WhoIsYoungestDirector;

--17) what is the movie with the highest gross made by a director not FROM united states?
DROP VIEW MovieHighestGrossDirectorNotUS;
CREATE VIEW MovieHighestGrossDirectorNotUS AS (
    WITH directors_cte AS (
        SELECT 
            DISTINCT * 
        FROM
            Directors
        WHERE 
            Directors_Nationality != 'United States of America'
    )
    SELECT 
        Directors_LegalName AS 'Director', 
        max(Movies_Gross) AS 'Gross'
    FROM 
        directors_cte
    JOIN MovieDirectors ON directors_cte.Directors_ID = MovieDirectors.Directors_ID
    JOIN Movies ON MovieDirectors.Movies_ID = Movies.Movies_ID
    GROUP BY 
        Directors_LegalName
    ORDER BY 
        max(Movies_Gross) DESC
    limit 1
)
--SELECT * FROM MovieHighestGrossDirectorNotUS;


--18) All the movies that grossed more than 100 million USD
DROP VIEW MoviesGrossMoreThanHundredMill;
CREATE VIEW MoviesGrossMoreThanHundredMill AS (
    SELECT 
        Movies_FilmName AS 'Movie', 
        Movies_Gross AS 'Gross'
    FROM 
        Movies
    WHERE 
        Movies_Gross >= 100000000
    ORDER BY 
        Movies_Gross DESC
)
--SELECT * FROM MoviesGrossMoreThanHundredMill;


--19)Which movie has won the most amount of awards?
DROP VIEW WhichMovieWonMostAwards;
CREATE VIEW WhichMovieWonMostAwards AS (
    SELECT 
        Movies_FilmName AS 'Movie', 
        count(*) 'Awards number'
    FROM 
        Movies
    JOIN MovieAwards ON Movies.Movies_ID = MovieAwards.Movies_ID
    JOIN Awards ON MovieAwards.Awards_ID = Awards.Awards_ID
    GROUP BY 
        Movies_FilmName
    ORDER BY 
        count(*) DESC
    limit 1
)
--SELECT * FROM WhichMovieWonMostAwards;


--20)What is the movie with the highest budget in the database?
DROP VIEW MovieHighestBudget;
CREATE VIEW MovieHighestBudget AS (
    SELECT 
        Movies_FilmName AS 'Movie', 
        Movies_Budget AS 'Budget'
    FROM 
        Movies
    ORDER BY 
        Movies_Budget DESC
    LIMIT 1
);
--SELECT * FROM MovieHighestBudget;

---------------------------------------------- END OF VIEWS/QUERIES -----------------------------------------------------