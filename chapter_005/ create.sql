create database r_system;

\connect r_system 

create table role (id serial primary key);
create table rules (id serial primary key);
create table state (id serial primary key);
create table category (id serial primary key);

create table users (id serial primary key, role_id integer references role(id));
create table role_rules (id serial primary key, role_id integer references role(id), rules_id integer references rules(id));
create table item (id serial primary key, users_id integer references users(id), category_id integer references category(id), state_id integer references state(id));

create table comments (id serial primary key, item_id integer references item(id));
create table attaches (id serial primary key, item_id integer references item(id));


ALTER TABLE users ADD name varchar(2000);
ALTER TABLE role ADD role_name varchar(2000);
ALTER TABLE rules ADD description varchar(2000);
ALTER TABLE state ADD state bool NOT NULL;
ALTER TABLE category ADD category_name varchar(2000);
ALTER TABLE item ADD item_name varchar(2000);
ALTER TABLE  comments ADD text varchar(2000);
ALTER TABLE  attaches ADD url varchar(2000);


insert into role (role_name) values ('Lazy');
insert into users (name, role_id) values ('Vasya', 2);
