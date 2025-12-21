#find the department names containing IT
select
    department_name
from
    departments
where
    1=1
    and department_name like 'IT%'
;



#find the employees working for the purchasing department
select
    *
from
    employees
where
    1=1
    and department_id = 30
;


#find the employees whose manager is the president: steven king

select
    *
from
    employees
where
    1=1
    and manager_id = 100
;


#find the employees not working for any department
select
    *
from
    employees
where
    1=1
    and department_id is null
;