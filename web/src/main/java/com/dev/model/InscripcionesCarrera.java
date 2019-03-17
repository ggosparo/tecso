package com.dev.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Mapea los datos de la inscripcion a la carrera.
 */
@Entity(name = "inscripciones_carrera")
public class InscripcionesCarrera implements Serializable {
    private static final long serialVersionUID = 5L;
    /**
     * Almacena la primary key de la tabla.
     */
    @EmbeddedId
    private AlumnoCarrera alumnocarrera;

    /**
     * Almacena la persona relacionada al alumno.
     */
    @ManyToOne()
    @JoinColumn(name = "idalumno", insertable = false, updatable = false)
    private Alumno alumno;
    /**
     * Almacena la persona relacionada al alumno.
     */
    @ManyToOne()
    @JoinColumn(name = "idcarrera", insertable = false, updatable = false)
    private Carrera carrera;
    /**
     * Almacena la fecha de inscripcion.
     */
    private Date fechainscripcion;

    /**
     * @return Retorna la primary key que esta almacenado en la propiedad <code>{@link AlumnoCarrera}</code>.
     */
    public AlumnoCarrera getAlumnocarrera() {
        return alumnocarrera;
    }

    public InscripcionesCarrera setAlumnocarrera(AlumnoCarrera alumnocarrera) {
        this.alumnocarrera = alumnocarrera;
        return this;
    }

    /**
     * @return Retorna el alumno que esta almacenado en la propiedad <code>{@link Alumno}</code>.
     */
    public Alumno getAlumno() {
        return alumno;
    }

    /**
     * @param alumno Contiene el alumno a setear en la propiedad <code>alumno</code>.
     * @return Retorna el objeto <code>{@link InscripcionesCurso}</code>.
     */
    public InscripcionesCarrera setAlumno(Alumno alumno) {
        this.alumno = alumno;
        return this;
    }

    /**
     * @return Retorna la carrera que esta almacenado en la propiedad <code>carrera</code>.
     */
    public Carrera getCarrera() {
        return carrera;
    }

    /**
     * @param carrera Contiene la carrera a setear en la propiedad <code>carrera</code>.
     * @return Retorna el objeto <code>{@link InscripcionesCarrera}</code>.
     */
    public InscripcionesCarrera setCarrera(Carrera carrera) {
        this.carrera = carrera;
        return this;
    }

    /**
     * @return Retorna la fecha de inscripcion al curso que esta almacenado en la propiedad <code>curso</code>.
     */
    public Date getFechainscripcion() {
        return fechainscripcion;
    }

    /**
     * @param fechainscripcion Contiene la fecha de inscripcion al curso a setear en la propiedad <code>fechainscripcion</code>.
     * @return Retorna el objeto <code>{@link InscripcionesCurso}</code>.
     */
    public InscripcionesCarrera setFechainscripcion(Date fechainscripcion) {
        this.fechainscripcion = fechainscripcion;
        return this;
    }

    @Override
    public String toString() {
        return "InscripcionesCarrera{" +
                "alumnocarrera=" + alumnocarrera +
                ", alumno=" + alumno +
                ", carrera=" + carrera +
                ", fechainscripcion=" + fechainscripcion +
                '}';
    }
}