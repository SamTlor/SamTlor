-- SUBQUERIES
-- the queries by themselves
select employee_id
from employee_demographics
;
select employee_id 
from employee_salary
where dept_id = 1
;

-- the 'in statement' has to return ONE column
select * 
from employee_demographics
where employee_id in 
	(
		select employee_id 
		from employee_salary
		where dept_id = 1
    )
;

-- easily compare every value to an aggregation of the entire column
select first_name, salary, (select avg(salary) from employee_salary)
from employee_salary
;

-- every from table has to have an alias
-- can return aggregate values of groups
-- but you also need to group by those groups
select avg(`avg(age)`)
from
	(select gender, avg(age), max(age), min(age), count(age)
	from employee_demographics
	group by gender
    ) as agg_table
;