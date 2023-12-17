create table marcas(
    id bigint not null auto_increment,
    codigo bigint not null unique,
    nome varchar(100) not null,
    primary key(id)
);

create table modelos(
    id bigint not null auto_increment,
    marca_id bigint not null,
    codigo bigint not null,
    nome varchar(100) not null,
    observacoes varchar(100),
    primary key(id)
);