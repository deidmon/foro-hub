create table respuestas(

    id bigint not null auto_increment,
    mensaje varchar(300) not null unique,
    fecha_creacion datetime not null,
    topico_id bigint not null,
    autor_id bigint not null,

    primary key(id),
	constraint fk_respuestas_topico_id foreign key(topico_id) references topicos(id),
    constraint fk_respuestas_autor_id foreign key(autor_id) references usuarios(id)
);
