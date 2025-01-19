create table usuarios(

    id bigint not null auto_increment,
    nombre varchar(300) not null unique,
    correo_electronico varchar(100) not null,
    contrasenna varchar(300) not null,
    perfil_id bigint not null,

    primary key(id),
    constraint fk_usuarios_perfil_id foreign key(perfil_id) references perfiles(id)
);