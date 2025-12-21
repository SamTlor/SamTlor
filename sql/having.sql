-- having vs. where
select gender, avg(age)
from employee_demographics
-- "where avg(age) > 40" would not be valid here
-- because the group by has not been performed yet
-- so there's nothing to go into the avg function 
group by gender
having avg(age) > 40
;



-- the having clause will only run after the group by
-- best for filtering on the aggregated functions
select occupation, avg(salary)
from employee_salary
where occupation like '%manager%'
group by occupation
having avg(salary) > 75000
;