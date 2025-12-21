-- group by
-- they get all the unique values of a column or combination of columns
select *
from employee_demographics
;



-- when selecting a column from a group by the column has to be in the group by
select gender, avg(age)
from employee_demographics
group by gender
;



-- unless you're using an aggregate like avg, sum, etc.
select gender, avg(age), Max(age), Min(age), count(age)
from employee_demographics
group by gender
;



-- in a group by of one column 'office manager' appears once
-- in a group by of multiple columns 'office manager' appears twice. one for each salary
select occupation, salary
from employee_salary
group by occupation, salary
;