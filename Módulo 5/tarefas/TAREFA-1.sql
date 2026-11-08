-- TAREFA 1 (Duas partes)

-- TABELA DE FUNCIONÁRIOS (1/2)

CREATE TABLE employees (
	emp_id serial primary key,
	emp_name varchar(30),
	job_title varchar(20),
	salary int,
	hire_date date
);

INSERT INTO employees(emp_id, emp_name, job_title, salary, hire_date) VALUES 
(1, 'Alice', 'Manager', 60000, '2020-01-15'),
(2, 'Bob', 'Developer', 50000, '2019-05-20'),
(3, 'Charlie', 'Sales', 45000, '2021-03-10'),
(4, 'Diana', 'Manager', 62000, '2022-02-28'),
(5, 'Eve', 'Marketing', 48000, '2020-11-12');

SELECT * FROM employees;
SELECT * FROM employees WHERE employees.salary > 55000;
SELECT * FROM employees WHERE employees.hire_date > '2020-12-31';
SELECT * FROM employees WHERE employees.emp_name LIKE 'A%';

-- TABELA DE PEDIDOS (2/2)

CREATE TABLE orders (
	order_id serial primary key,
	customer_id int,
	total_amount int,
	order_date date
);

INSERT INTO orders(order_id, customer_id, total_amount, order_date) VALUES 
(1, 101, 250, '2023-01-05'),
(2, 102, 350, '2023-02-10'),
(3, 101, 150, '2023-01-20'),
(4, 103, 200, '2023-03-15'),
(5, 102, 350, '2023-02-28');

SELECT COUNT(*) AS total_pedidos
FROM orders;

SELECT customer_id, COUNT(*) AS total_pedidos
FROM orders
GROUP BY customer_id;

SELECT AVG(total_amount) AS media_valor, SUM(total_amount) AS valor_total FROM orders;