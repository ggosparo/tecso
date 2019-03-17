## Base de datos
Dentro del directorio base de datos se pasa un archivo sql con el diseño de base de datos y también contiene los datos de pruebas utilizados.

Una persona es una profesor sino esta asociado en la tabla de alumnos.

## modificaciones al model de base de datos
Agrega la nota a la inscripción del curso
```
alter table inscripciones_curso add column nota DECIMAL default 0 ;
```

Mapea la relación entre los profesores y los cursos que dictan
```
CREATE TABLE profesores_curso
(
    idprofesor integer  REFERENCES persona (identificador) NOT NULL,
    idcurso integer  REFERENCES curso (identificador) NOT NULL,
    primary key (idprofesor, idcurso)
);
```

## tecnica.java
### workspace.sql
Dentro del archivo `ejercicios-db.sql` se encuentran las respuestas.

### workspace-java
Los ejercicios estan resueltos dentro del directorio src y cada ejercicio esta resuelto dentro de cada directorio.
