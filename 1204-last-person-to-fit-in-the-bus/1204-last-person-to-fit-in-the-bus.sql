# Write your MySQL query statement below
select person_name 
from (select person_name,turn,sum(weight) over (order by turn) as totalwt from Queue) q
where totalwt<=1000 order by turn desc limit 1;