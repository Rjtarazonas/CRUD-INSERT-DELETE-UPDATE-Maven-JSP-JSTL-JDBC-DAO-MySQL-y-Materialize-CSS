create database if not exists PanaderiaNENA;
use PanaderiaNENA;
create table if not exists cliente(
id_cliente int not null primary key auto_increment,
nombre varchar(45) not null,
apellido varchar (45) not null
)engine InnoDB;
create table if not exists producto(
id_producto int not null primary key auto_increment,
nombre_producto varchar(100) not null
)engine InnoDB;
create table if not exists producto(
id_producto int not null primary key auto_increment,
nombre_producto varchar(100) not null
)engine InnoDB;
create table if not exists venta(
id_venta int not null primary key auto_increment,
fecha date not null,
id_cliente int not null,
id_producto int not null,
constraint fk_cliente foreign key(id_cliente) references cliente (id_cliente) on delete cascade on update cascade,
constraint fk_producto foreign key(id_producto) references producto (id_producto) on delete cascade on update cascade
)engine InnoDB;
insert into cliente (nombre,apellido) values ('Jose','Mena'),('Maria','Becerra');
insert into producto (nombre_producto) values ('Donas de chocolate'),('Torta de chocolate');
insert into venta(fecha,id_cliente,id_producto) values ('2023-12-12',1,1),('2023-12-12',2,2);
select v.id_venta,v.fecha,c.nombre,c.apellido,p.nombre_producto from venta v
inner join cliente c on c.id_cliente = v.id_cliente
inner join producto p on p.id_producto = v.id_producto