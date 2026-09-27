# Write your MySQL query statement below
select name,bonus from employee left join Bonus on Employee.empId=Bonus.empId where bonus is NULL or bonus<1000;