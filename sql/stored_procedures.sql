-- STORED PROCEDURES
-- kinda like functions
create procedure large_salaries ()
	select * 
	from employee_salary
	where salary >= 50000
	;	
call large_salaries ();



-- create delimiters so that you can do multiple queries in one procedure
-- make sure to change it back when you're done
delimiter $$
create procedure large_salaries2 ()
begin
	select * 
	from employee_salary
	where salary >= 50000;
	select * 
	from employee_salary
	where salary >= 10000;
end $$
delimiter ;
call large_salaries2();



-- pass parameters to the procedure 
create procedure large_salaries3 (employee_id_param int)
	select * 
	from employee_salary
    where employee_id = employee_id_param
    ;
call large_salaries3(1);