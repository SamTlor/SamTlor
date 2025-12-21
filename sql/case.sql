-- CASE STATEMENTS
-- creates a new column if the when statement is true
-- first when statement to be true defines the value for the column
select first_name, last_name, age, 
case
	when age <= 30 then 'Young'
    when age between 31 and 50 then 'Old'
    when age >= 50 then 'Very old'
end as Age_bracket
from employee_demographics
;

-- can do multiple case statements
select first_name, last_name, salary,
case 
	when salary < 50000 then salary * 1.05
    when salary > 50000 then salary * 1.07
end as new_salary,
case
	when dept_id = 6 then salary * 0.1
end as bonus
from employee_salary
;


select * 
from employee_salary
;