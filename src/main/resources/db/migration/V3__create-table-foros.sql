create table foros(

    id bigint not null auto_increment,
    titulo varchar(100) not null,
    mensaje varchar(100) not null,
    fecha datetime not null,
    estado varchar(50) not null,
    usuario_id bigint not null,
    curso_id bigint not null,

    primary key(id)

);
