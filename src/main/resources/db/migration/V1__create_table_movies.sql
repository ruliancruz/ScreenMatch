create table movies
(
    id bigint not null auto_increment,
    title varchar(150) not null,
    duration int not null,
    year int not null,
    genre varchar(150),
    primary key(id)
);