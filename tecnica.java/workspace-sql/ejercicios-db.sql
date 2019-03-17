----EJERCICIOS
-- SOLO ES REQUERIDO REALIZAR LOS EJERCICIOS DE COMPLEJIDAD BAJA, realizar los demas ejercicios serán puntos extras para la evaluación del examen.


--- EJERCICIO 1 - COMPLEJIDAD BAJA: 
--Realizar una consulta para consultar todos los alumnos existentes, mostrar: TipoDoc, Documento, Nombre, Apellido, Legajo.
select 
	p.tipodoc as TipoDoc, 
	p.documento as Documento, 
	p.nombre as Nombre, 
	p.apellido as Apellido, 
	a.legajo as Legajo
from alumno as a
inner join persona as p on (
	p.identificador = a.idpersona);

--- EJERCICIO 2 - COMPLEJIDAD BAJA: 
--Realizar una consulta para consultar todas las carreras a la que un alumno esta inscripto, mostrar: Legajo, nombre, apellido, nombre carrera, fechainscripcioncarrera
--ordenado por legajo descendiente
select 
	a.legajo as Legajo,
	p.nombre as nombre, 
	p.apellido as apellido, 
	c.nombre as "nombre carrera", 
	ic.fechainscripcion as "fechainscripcioncarrera"
from inscripciones_carrera as ic
inner join alumno as a on (
	a.identificador = ic.idalumno)
inner join persona as p on (
	p.identificador = a.idpersona)
inner join carrera as c on (
	c.identificador = ic.idcarrera)
order by a.legajo desc;

--- EJERCICIO 3 - COMPLEJIDAD MEDIA: 
--Realizar una consulta para consultar la cantidad de inscriptos por curso, mostrando: nombre carrera, nombre curso, cantidad inscriptos, cupo máximo por curso
select 
	ca.nombre as "nombre carrera",
	cu.nombre as "nombre curso",
	tmp.inscriptos as "cantidad inscriptos",
	cu.cupomaximo as "cupo máximo por curso"
from (
	select 
    		ic.idcurso as idcurso,
		count(ic.idcurso) as inscriptos
	from inscripciones_curso as ic
	group by ic.idcurso) as tmp
inner join curso as cu on (
	cu.identificador = tmp.idcurso)
inner join carrera as ca on (
	ca.identificador = cu.idcarrera);


--- EJERCICIO 4 - COMPLEJIDAD ALTA: 
--Sobre la consulta anterior (copiar y pegarla y modificarla) modificar la sql para que la consulta retorne solo los cursos cuya cantidad de inscripciones 
--supera su cupo maximo
select 
	ca.nombre as "nombre carrera",
	cu.nombre as "nombre curso",
	tmp.inscriptos as "cantidad inscriptos",
	cu.cupomaximo as "cupo máximo por curso"
from (
	select 
	    	ic.idcurso as idcurso,
		count(ic.idcurso) as inscriptos
	from inscripciones_curso as ic
	inner join curso as cu on (
		cu.identificador = ic.idcurso)
	group by ic.idcurso, cu.cupomaximo
	having count(ic.idcurso) > cu.cupomaximo) as tmp
inner join curso as cu on (
	cu.identificador = tmp.idcurso)
inner join carrera as ca on (
	ca.identificador = cu.idcarrera);

--- EJERCICIO 5 -  COMPLEJIDAD BAJA: 
-- actualizar todos las cursos que posean anio 2018 y cuyo cupo sea menor a 5, y actualizar el cupo de todos ellos a 10.
do
$do$
begin
	update curso as c
	set
		cupomaximo = 10
	where 
		c.cupomaximo < 5 and
		c.anio = 2018;
	raise notice 'Transaction completed!!!!!';
exception when others then 
    raise notice 'Transaction was rolled back';
end
$do$

--- EJERCICIO 6 -  COMPLEJIDAD ALTA: 
-- actualizar todas las fechas de inscripcion a cursados que posean el siguiente error: la fecha de inscripcion al cursado de un 
-- alumno es menor a la fecha de inscripcion a la carrera. La nueva fecha que debe tener es la fecha del dia. Se puede hacer en dos pasos, primero
-- realizando la consulta y luego realizando el update manual
do
$do$
begin
	update inscripciones_curso as icu
	set
		fechainscripcion = now()
	from inscripciones_carrera as ica
	where 
		icu.idalumno = ica.idalumno and
		icu.fechainscripcion < ica.fechainscripcion;
	raise notice 'Transaction completed!!!!!';
exception when others then 
    raise notice 'Transaction was rolled back';
end
$do$

--- EJERCICIO 7 - COMPLEJIDAD BAJA:  
--INSERTAR un nuevo registro de alumno con tus datos personales, (hacer todos inserts que considera necesario)
do
$do$
begin
	insert into persona 
		(identificador, tipodoc, documento, nombre,    apellido, fechanac) values
		(6,             'DNI',   27747989,  'Gabriel', 'Gosparo', '1980-06-06');
	insert into alumno
		(identificador, idpersona, legajo) values
		(6,             6,         '9999');
exception when others then 
    raise notice 'Transaction was rolled back';
end
$do$



--- EJERCICIO 8 -  COMPLEJIDAD BAJA: 
-- si se desea comenzar a persistir de ahora en mas el dato de direccion de un alumno y considerando que este es un único cambio string de 200 caracteres.
-- Determine sobre que tabla seria mas conveniente persistir esta información y realizar la modificación de estructuras correspondientes.
La forma mas sencilla y considerando que es único (textual del enunciado).
alter table persona add column direccion character varying (200) default null;

Pero a mi entender la mejor solución seria (no tener en cuenta que faltan campos de auditoria y otras cosas):
create table direcciones_persona (
	identificador bigint primary key not null,
	idpersona     bigint REFERENCES persona(identificador) not null,
	direccion     character varying (200) not null,
	activo        boolean default true
);

