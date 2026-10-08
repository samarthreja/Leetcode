# Write your MySQL query statement below
select *
from Patients
where
locate('DIAB1', conditions) = 1
or
locate(' DIAB1', conditions) != 0;