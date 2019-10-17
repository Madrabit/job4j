В системе заданы таблицы 

product(id, name, type_id, expired_date, price)

type(id, name)

Задание.

1. Написать запрос получение всех продуктов с типом "СЫР"
SELECT * FROM product as p 
INNER JOIN type as t on  p.id = t.id 
WHERE t.name = 'СЫР';

2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженное"

SELECT * FROM product as p 
WHERE p.name LIKE 'мороженное';


3. Написать запрос, который выводит все продукты, срок годности которых заканчивается в следующем месяце.

SELECT * FROM product as p 
WHERE p.expired_date < '2019-11-16 00:00:00';

4. Написать запрос, который выводит самый дорогой продукт.

SELECT * FROM product as p 
ORDER BY price DESC LIMIT 1

5. Написать запрос, который выводит количество всех продуктов определенного типа.

SELECT COUNT(*) FROM  product as p 
INNER JOIN type as t on  p.id = t.id 
WHERE t.name = 'СЫР';

6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"

SELECT * FROM product as p 
INNER JOIN type as t on  p.id = t.id 
WHERE t.name = 'СЫР' and t.name = 'МОЛОКО';

7. Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.  

SELECT t.name FROM product as p 
INNER JOIN type as t on  p.id = t.id 
WHERE (SELECT COUNT(DISTINCT p.name) FROM  product as p 
INNER JOIN type as t on  p.id = t.id) < 10;

8. Вывести все продукты и их тип.

SELECT p.id, p.name, p.type_id, p.expired_date, p.price, t.name FROM product as p 
INNER JOIN type as t on  p.id = t.id;
