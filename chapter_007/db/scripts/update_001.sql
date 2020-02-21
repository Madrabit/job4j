create table task (
   id serial PRIMARY KEY,
   task_name VARCHAR(50),
   description VARCHAR(50),
   date TIMESTAMP without time zone
);
