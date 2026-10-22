# Write your MySQL query statement below
select s.machine_id,
(round(avg(e.timestamp-s.timestamp),3)) as processing_time
from Activity e join Activity s  
on e.machine_id=s.machine_id
and e.process_id=s.process_id
and e.activity_type='end'
and s.activity_type='start'
group by machine_id;

