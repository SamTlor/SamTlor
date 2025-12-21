-- order by
select *
from employee_demographics
order by first_name desc
;


-- order by two columns
select *
from employee_demographics
order by gender, age desc
;



-- make sure that the less unique column goes first
-- otherwise the second column isn't used. ex:
select *
from employee_demographics
order by age desc, gender
;