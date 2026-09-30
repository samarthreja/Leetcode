# Write your MySQL query statement below
select d.name Department, e.name Employee, e.salary 
from Employee e left join Department d
on e.departmentId = d.id
where
3>(
    select count(distinct e2.salary) from Employee e2
    where e2.salary>e.salary
    and e2.departmentId=e.departmentId
)