
a. 
create table ItemsInOrder
(
	orderid int,
	itemid int, 
	quantity int
)

b. 
select i.itemid, sum(io.orderTotalAmount)
into #temp_order_revenue
from item i 
join itemsinorder io
	on i.itemid = io.itemid
join order o 
	on o.orderid = io.orderid 
group by i.itemid
order by sum(io.ordertotalamount) desc


select * 
from item 
where itemid = (select top 1 itemid from #temp_order_revenue)


c. 

select i.itemid, sum(io.quantity)
into #temp_total_Items
from itemsinorder io
group by io.itemid
order by sum(io.quantity) desc

select *
from item 
where itemid = (select top 1 itemid from #temp_total_Items)

d. 

select distinct email 
from user 
where userid in (
	select o.userid
	from creditcard c 
	join order o 
		on o.cardNumber = c.cardNumber
	where o.orderTotalAmount >= 100 
)


e. 
select o.userid, sum(io.quantity) as totalItems
into #temp_items_bought
from itemsinorder io
join order o 
	on o.orderid = io.orderid 
group by i.userid
order by sum(io.quantity) desc

declare @totalItems as int = (select top 1 totalItems from #temp_items_bought)

select u.email 
from user u 
where u.userid in (select  ib.userid from #temp_items_bought ib where ib.totalItems = @totalItems)

f.
delete from user 
where userid in 
	(
		select  u.userid
		from user u
		where not exists 
			(select 1 from creditcard c where c.userid = u.userid and c.expirationdate >= getdate())
	)