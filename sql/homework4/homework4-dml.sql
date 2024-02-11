# homework4-dml.sql

# question 1
#List all skill names and tags in alphabetical order by name

select 
    name, tag 
from 
    skills 
order by 
    name
;

# question 2
# List full name (first and last) and emails of all people in alphabetical order by last name

select 
    concat(first_name, ' ', last_name) as "Name", email 
from 
    people 
order by 
    last_name
;

# question 3
# List last name and all skills of Person 1

select 
    last_name, tag, name
from 
    peopleskills a
    join 
        people b on (peopleskills_people_id = people_id)
    join
        skills c on (peopleskills_skills_id = skills_id)
where
    1=1
    and peopleskills_people_id = 2001
;

# question 4
# List all full names of all people with Skill 6

select 
    concat(first_name, ' ', last_name)
from 
    peopleskills a
    join 
        people b on (peopleskills_people_id = people_id)
    join
        skills c on (peopleskills_skills_id = skills_id)
where
    1=1
    and tag = 'Skill 6'
;

# question 5
# List full names of people without any skills

select
    concat(first_name, ' ', last_name) as "Full name"
from
    people
        left join peopleskills on (people_id = peopleskills_people_id)
where
    1=1
    and peopleskills_id is null
;

# question 6
# List skill names and tags of unused skills

select
    name, tag
from
    skills
        left join peopleskills on (skills_id = peopleskills_skills_id)
where
    1=1
    and peopleskills_id is null
;

# question 7
# List full names and skill tags for all developers

select
    concat(first_name, ' ', last_name) as "Full name", tag
from
    peopleroles a
    join
        people b on (peopleroles_people_id = people_id)
    join
        roles c on (peopleroles_role_id = roles_id)
    join
        peopleskills d on (peopleroles_people_id = peopleskills_people_id)
    join
        skills e on (peopleskills_skills_id = skills_id)
where
    1=1
    and c.name = 'developer'
;


# question 8
# List last names and emails by role sorted by role and and last_name

select 
    name, last_name, email
from 
    peopleroles
    join 
        roles on (peopleroles_role_id = roles_id)
    join 
        people on (peopleroles_people_id = people_id)
where
    1=1
order by
    sort_priority, last_name
;
