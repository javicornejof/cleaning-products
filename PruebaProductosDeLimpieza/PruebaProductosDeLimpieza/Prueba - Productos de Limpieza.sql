CREATE DATABASE productos_limpieza;
USE productos_limpieza;

--TABLA CATEGOR?A 
CREATE TABLE categoria(
id_categoria int primary key,
nombre_categoria varchar(50)
);

-- TABLA PRODUCTO
CREATE TABLE producto(
id_producto int auto_increment primary key,
nombre_producto varchar(75),
precio_producto int,
descripcion_producto varchar(200),
id_categoria int,
foreign key (id_categoria) references categoria(id_categoria)
);

INSERT INTO categoria(id_categoria, nombre_categoria)
VALUE (1, "Detergente líquido");
select * from producto;

INSERT INTO categoria(id_categoria, nombre_categoria)
VALUE (2, "Detergente en polvo");
select * from producto;

INSERT INTO producto(nombre_producto, precio_producto, descripcion_producto, id_categoria)
VALUE ("Omo", 3500, "Quita manchas", 1);

INSERT INTO producto(nombre_producto, precio_producto, descripcion_producto, id_categoria)
VALUE ("Ariel", 4400, "Quita manchas", 2);

