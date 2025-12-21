-- UNIONS
-- returns the results of the first select on top of the results of the second select
-- with the columns from the first select
select age, gender
from employee_demographics
union
select first_name, last_name
from employee_salary
;

-- by default returns DISTINCT values and removes duplicates
select first_name, last_name
from employee_demographics
union
select first_name, last_name
from employee_salary
;

-- can use union all to not remove duplicates
select first_name, last_name
from employee_demographics
union all
select first_name, last_name
from employee_salary
;





-- create labels to find cases where two labels apply
select first_name, last_name, 'Old man' as Label
from employee_demographics
where age > 40 and gender = 'Male'
union
select first_name, last_name, 'Old woman' as Label
from employee_demographics
where age > 40 and gender = 'Female'
union
select first_name, last_name, 'Highly Paid Employees' as Label
from employee_salary
where salary > 70000
order by first_name, last_name
;