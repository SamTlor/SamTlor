-- INNER JOINS
-- puts the columns from the second table to the right of the first one
-- but only where they have the same value for the "on" statement
-- employee_id 2 is null for employee_demographics so it does not appear
select *
from employee_demographics as dem
inner join employee_salary as sal
	on dem.employee_id = sal.employee_id
;

-- you have to specify which table to select from if column names are the same
select dem.employee_id, age, occupation
from employee_demographics as dem
inner join employee_salary as sal
	on dem.employee_id = sal.employee_id
;





-- RIGHT JOINS
-- left joins / left outer joins
-- returns every value from the left table
-- employee_id 2 is not in employee_demographics so it doesn't appear
-- if there isn't a match in the right table null values will show for the right table columns
select *
from employee_demographics as dem
left join employee_salary as sal
	on dem.employee_id = sal.employee_id
;

-- right join / right outer joins
-- returns every value from the right table
-- if there isn't a match in the left table null values will show for the left table columns
-- employee_id 2 is not a match so there are null values for the left table columns
select *
from employee_demographics as dem
right join employee_salary as sal
	on dem.employee_id = sal.employee_id
;





-- SELF JOIN
-- used to mix, create connections, and compare rows within a table
-- aliases are needed 
select e1.employee_id as santa, 
		e1.first_name as first_name_santa, 
		e1.last_name as last_name_santa,
		e2.employee_id as given, 
		e2.first_name as first_name_given, 
		e2.last_name as last_name_given
from employee_salary as e1
join employee_salary as e2
	on e1.employee_id + 1 = e2.employee_id
;





-- joining multiple tables together
-- has to be joined on a column from employee_salary 
-- because employee_demographics has no columns in common
select *
from employee_demographics as dem
inner join employee_salary as sal
	on dem.employee_id = sal.employee_id
inner join parks_departments as pd
	on sal.dept_id = pd.department_id
;