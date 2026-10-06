# Write your MySQL query statement below
select e.name from Employee e where id in(select managerId from Employee where managerId is not null group by managerId having count(*)>=5);
