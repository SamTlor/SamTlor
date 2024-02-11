# homework4-ddl.sql

## Code specifications
# 0. Homework 4 will form a basis for homework 5. Be sure to follow the specs!!
# 1. Complete all sections below.
# 2. Table names must MATCH EXACTLY to schemas provided.
# 3. Define primary keys in each table as appropriate;
# 4. Don't worry about foreign keys, that's next time!
# 5. Assign ID to skills, people, roles manually (you pick the ID number!)
# 6. Assign ID in the peopleskills and peopleroles automatically (use auto_increment)
# 7. Roles_id is manually assigned, peopleroles_id is auto_increment
# 8. Data types: ONLY use "int", "varchar(255)", "varchar(4096)" or "date" as appropriate.

# Section 1
# Drops all tables.  This section should be amended as new tables are added.

drop table if exists skills;
drop table if exists people;
drop table if exists peopleskills;
drop table if exists roles;
drop table if exists peopleroles;

# Section 2
# Create skills( id,name, description, tag, url, time_commitment)
# ID, name, tag cannot be NULL. Other fields can default to NULL.

drop table if exists skills;
create table skills (
    skills_id int not null,
    name varchar(255) not null,
    description varchar(255),
    tag varchar(255) not null,
    url varchar(255),
    time_commitment int,
    primary key (skills_id)
);

# Section 3
# Populate skills
# Populates the skills table with six skills, their tag fields must exactly contain “Skill 1”, “Skill 2”, etc.
# You can assign skill names.

insert into skills (skills_id, name, tag) values
    (1001, 'Juggling', 'Skill 1'),
    (1002, 'Dancing', 'Skill 2'),
    (1003, 'Skating', 'Skill 3'),
    (1004, 'Coding', 'Skill 4'),
    (1005, 'Sleeping', 'Skill 5'),
    (1006, 'Drinking', 'Skill 6')
;
#select * from skills;

# Section 4
# Create people( id,first_name, last_name, email, 
# linkedin_url, headshot_url, discord_handle, brief_bio, date_joined)
# ID cannot be null, Last name cannot be null, date joined cannot be NULL.
# All other fields can default to NULL.

drop table if exists people;
create table people(
    people_id int not null,
    first_name varchar(255),
    last_name varchar(255) not null,
    email varchar(255), 
    linkedin_url varchar(255), 
    headshot_url varchar(255), 
    discord_handle varchar(255), 
    brief_bio varchar(255), 
    date_joined date not null,
    primary key (people_id)
);

# Section 5
# Populate people with six people.
# Their last names must exactly be “Person 1”, “Person 2”, etc.
# Other fields are for you to assign.

insert into people (people_id,first_name, last_name, email, linkedin_url, headshot_url, 
                        discord_handle, brief_bio, date_joined) values
    (2001, "AlexTurner", "Person 1", "person1@gmail.com", "linkedin.com", "boomheadshot.url", "dischand.com", "brief", '1998-05-18'),
    (2002, "NickOMalley", "Person 2", "person2@gmail.com", "linkedin.com", "boomheadshot.url", "dischand.com", "brief", '1998-05-18'),
    (2003, "MattHelders", "Person 3", "person3@gmail.com", "linkedin.com", "boomheadshot.url", "dischand.com", "brief", '1998-05-18'),
    (2004, "JamieCook", "Person 4", "person4@gmail.com", "linkedin.com", "boomheadshot.url", "dischand.com", "brief", '1998-05-18'),
    (2005, "KevinParker", "Person 5", "person5@gmail.com", "linkedin.com", "boomheadshot.url", "dischand.com", "brief", '1998-05-18'),
    (2006, "me", "Person 6", "person6@gmail.com", "linkedin.com", "boomheadshot.url", "dischand.com", "brief", '1998-05-18')
;
#select * from people;

# Section 6
# Create peopleskills( id, skills_id, people_id, date_acquired )
# None of the fields can be NULL. ID can be auto_increment.

drop table if exists peopleskills;
create table peopleskills(
    peopleskills_id int not null auto_increment,
    peopleskills_people_id int not null,
    peopleskills_skills_id int not null,
    peopleskills_date_acquired date,
    primary key (peopleskills_id)
#    constraint unique (peopleskills_people_id,peopleskills_skills_id),
#    constraint foreign key (peopleskills_people_id) 
#    references people(people_id)
#    on delete cascade
);

# Section 7
# Populate peopleskills such that:
# Person 1 has skills 1,3,6;
# Person 2 has skills 3,4,5;
# Person 3 has skills 1,5;
# Person 4 has no skills;
# Person 5 has skills 3,6;
# Person 6 has skills 1,3,4,5,6;

insert into peopleskills (peopleskills_people_id, peopleskills_skills_id, peopleskills_date_acquired) values
    (2001,1001, '2022-10-28'),
    (2001,1003, '2022-10-28'),
    (2001,1006, '2022-10-28'),
    
    (2002,1003, '2022-10-28'),
    (2002,1004, '2022-10-28'),
    (2002,1005, '2022-10-28'),
    
    (2003,1001, '2022-10-28'),
    (2003,1005, '2022-10-28'),
    
    (2005,1003, '2022-10-28'),
    (2005,1006, '2022-10-28'),
    
    (2006,1001, '2022-10-28'),
    (2006,1003, '2022-10-28'),
    (2006,1004, '2022-10-28'),
    (2006,1005, '2022-10-28'),
    (2006,1006, '2022-10-28')
;
#select * from peopleskills;

# Section 8
# Create roles( id, name, sort_priority )
# sort_priority is an integer and is used to provide an order for sorting roles

drop table if exists roles;
create table roles (
    roles_id int not null,
    name varchar(255),
    sort_priority int, 
    primary key (roles_id)
);

# Section 9
# Populate roles
# Designer, Developer, Recruit, Team Lead, Boss, Mentor
# Sort priority is assigned numerically in the order listed above (Designer=10, Developer=20, Recruit=30, etc.)

insert into roles (roles_id, name, sort_priority) values
    (3001, "designer", 10),
    (3002, "developer", 20),
    (3003, "recruit", 30),
    (3004, "team_lead", 40),
    (3005, "boss", 50),
    (3006, "mentor", 60)
;
#select * from roles;

# Section 10
# Create peopleroles( id, people_id, role_id, date_assigned )
# None of the fields can be null.  ID can be auto_increment

drop table if exists peopleroles;
create table peopleroles(
    peopleroles_id int not null auto_increment,
    peopleroles_people_id int not null,
    peopleroles_role_id int not null,
    date_assigned date not null,
    primary key (peopleroles_id)
);

# Section 11
# Populate peopleroles
# Person 1 is Developer 
# Person 2 is Boss, Mentor
# Person 3 is Developer and Team Lead
# Person 4 is Designer
# person 5 is Recruit
# Person 6 is Developer and Designer

insert into peopleroles (peopleroles_people_id, peopleroles_role_id, date_assigned) values
    (2001, 3002, "2022-10-30"),
    (2002, 3005, "2022-10-30"),
    (2002, 3006, "2022-10-30"),
    (2003, 3002, "2022-10-30"),
    (2003, 3004, "2022-10-30"),
    (2004, 3001, "2022-10-30"),
    (2005, 3003, "2022-10-30"),
    (2006, 3002, "2022-10-30"),
    (2006, 3001, "2022-10-30")
;
#select * from peopleroles;



# port for file zilla is 7822