# Write your MySQL query statement below
select temp.id, count(temp.id) num from (
select requester_id id from RequestAccepted
union all
select accepter_id id from RequestAccepted
)temp
group by temp.id
order by count(temp.id) desc
limit 1;
