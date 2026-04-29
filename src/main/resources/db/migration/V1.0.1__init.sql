create table specialty
(
    id   bigint       not null auto_increment,
    name varchar(100) not null,
    primary key (id)
);

create table doctor
(
    id           bigint       not null auto_increment,
    name         varchar(100) not null,
    last_name    varchar(100) not null,
    email        varchar(100) not null,
    phone        varchar(100) not null,
    specialty_id bigint       not null,
    primary key (id)
);

alter table doctor
    add constraint fk_specialty
        foreign key (specialty_id) references specialty (id);


insert into specialty (name)
values ('Cardiology');
insert into specialty (name)
values ('Dermatology');
insert into specialty (name)
values ('Neurology');
insert into specialty (name)
values ('Pediatrics');
insert into specialty (name)
values ('Psychiatry');


insert into doctor (name, last_name, email, phone, specialty_id)
values ('John', 'Doe', 'john@doctor.cl', '123456789', 1),
       ('Jane', 'Doe', 'jane@doctor.cl', '1231234', 2),
       ('Alice', 'Smith', 'alice@doctor.cl', '987654321', 3),
       ('Bob', 'Johnson', 'bob@doctor.cl', '456789123', 4);
