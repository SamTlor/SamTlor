-- TEMPORARY TABLES
-- will work in other windows as well
-- will be deleted when the session ends
create temporary table temp_table
(
	first_name varchar(50),
    last_name varchar(50),
    favorite_movie varchar(100)
)
;

insert into temp_table
values(
	'sam', 'taylor', '12 angry men'
)
;

select * 
from temp_table
;

create temporary table salary_over_50k
select * 
from employee_salary
where salary >= 50000
;

select * 
from salary_over_50k
;