-- CTEs
-- like a subquery that you can call as a variable 
-- but only from right after where you defined it
with cte_example (gender, avg_salary, max_salary, min_salary, count_salary) as
(
	select gender, avg(salary), max(salary), min(salary), count(salary)
	from employee_demographics as dem
	join employee_salary as sal
		on dem.employee_id = sal.employee_id
	group by gender
)
select *
from cte_example
;

-- subquery version
-- less readable because alias at the end is confusing and the main select goes at beginning 
select avg(`avg(salary)`)
from (
	select gender, avg(salary), max(salary), min(salary), count(salary)
	from employee_demographics as dem
	join employee_salary as sal
		on dem.employee_id = sal.employee_id
	group by gender
) as example_subquery
;


-- multiple CTEs within one query
with cte_example as
(
	select employee_id, gender, birth_date
	from employee_demographics 
	where birth_date > '1985-01-01'
),
cte_example2 as
(
	select employee_id, salary
    from employee_salary
    where salary > 50000
)
select *
from cte_example
join cte_example2
	on cte_example.employee_id = cte_example2.employee_id
;