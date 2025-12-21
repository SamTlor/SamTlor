-- WINDOW FUNCTIONS

-- doing it this way means that the aggregation value will change
select dem.first_name, dem.last_name, gender, avg(salary) as avg_salary
from employee_demographics as dem
join employee_salary as sal
	on dem.employee_id = sal.employee_id
group by dem.first_name, dem.last_name, gender
;

-- it's easier to add columns this way
select dem.first_name, dem.last_name, gender, avg(salary) 
over (partition by gender)
from employee_demographics as dem
join employee_salary as sal
	on dem.employee_id = sal.employee_id
;

-- lets you make a rolling total that increases every entry
select dem.first_name, dem.last_name, gender, salary, sum(salary) 
over (partition by gender order by dem.employee_id) as rolling_total
from employee_demographics as dem
join employee_salary as sal
	on dem.employee_id = sal.employee_id
;





-- row_number()
-- gives row number to the things you have partitioned
-- every value will be unique 
select dem.employee_id, dem.first_name, dem.last_name, gender, salary,
row_number() over(partition by gender order by salary desc) as row_num
from employee_demographics as dem
join employee_salary as sal
	on dem.employee_id = sal.employee_id
;





-- rank
-- things with the same value will have the same rank unlike row_number
-- tom and jerry both have rank 5 since they have the same salary
-- but andy has rank 7 because there are 7 males
select dem.employee_id, dem.first_name, dem.last_name, gender, salary,
row_number() over(partition by gender order by salary desc) as row_num,
rank() over(partition by gender order by salary desc) rank_num
from employee_demographics as dem
join employee_salary as sal
	on dem.employee_id = sal.employee_id
;

-- dense_rank
-- here andy has rank 6 
select dem.employee_id, dem.first_name, dem.last_name, gender, salary,
row_number() over(partition by gender order by salary desc) as row_num,
rank() over(partition by gender order by salary desc) rank_num,
dense_rank() over(partition by gender order by salary desc) dense_rank_num
from employee_demographics as dem
join employee_salary as sal
	on dem.employee_id = sal.employee_id
;