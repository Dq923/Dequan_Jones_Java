Use northwind; 
-- What are the categories of products in the database? 
SELECT category -- Assuming we want the category for each item
FROM products


-- What products are made by dell? 
Use northwind; 
SELECT *
FROM products
WHERE product_name
LIKE '%Dell%';

-- List the orders shipped to Pennsylvania
Use northwind; 
SELECT * 
FROM orders
WHERE ship_state = 'Pennsylvania'; 


/*List the first name and last name of all employees with 
 last names that start with the letter W.
*/
Use northwind; 
SELECT first_name, last_name
FROM employees
WHERE last_name 
LIKE 'W%'; 


-- List all customers FROM zip codes that start with 55
Use northwind; 
SELECT *
FROM customers 
WHERE postal_code
Like '55%'; 


-- List all customers FROM zip codes that end with 0 
Use northwind; 
SELECT * 
FROM customers
WHERE postal_code
LIKE '%0';

/*
List the first name, last name, and email for all customers with a ".org" email address
 */
Use northwind; 
SELECT first_name, last_name, email
FROM customers 
WHERE email
LIKE '%.org'; 


/*
 List the first name, last name, and phone number for all customers FROM the 202 area code.
 */
Use northwind; 
SELECT first_name, last_name, phone
FROM customers 
WHERE phone 
LIKE '%(202)%';


/*
 List the first name, last name, and phone number for all customers FROM the 202 area code, 
 ordered by last name, first name.
 */
Use northwind; 
SELECT last_name, first_name, phone
FROM customers 
WHERE phone 
LIKE '%(202)%'
ORDER BY last_name ASC, first_name ASC; 