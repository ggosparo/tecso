package com.dev.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Mapea los datos de la inscripcion al curso.
 */
@Embeddable
public class AlumnoCarrera implements Serializable {
    private static final long serialVersionUID = 8L;
    /**
     * Almacena la persona relacionada al alumno.
     */
    @Column(name = "idalumno")
    private int alumno;
    /**
     * Almacena la carrera relacionada al alumno.
     */
    @Column(name = "idcarrera")
    private int carrera;

    /**
     * Constructor.
     *
     * @param alumno  Contiene el identificador del alumno.
     * @param carrera Contiene el identificador de la carrera.
     */
    public AlumnoCarrera(int alumno, int carrera) {
        this.alumno = alumno;
        this.carrera = carrera;
    }

    /**
     * Constructor.
     */
    public AlumnoCarrera() {
    }

    /**
     * @return Retorna el alumno que esta almacenado en la propiedad <code>alumno</code>.
     */
    public int getAlumno() {
        return alumno;
    }

    /**
     * @param alumno Contiene el alumno a setear en la propiedad <code>alumno</code>.
     * @return Retorna el objeto <code>{@link AlumnoCurso}</code>.
     */
    public AlumnoCarrera setAlumno(int alumno) {
        this.alumno = alumno;
        return this;
    }

    /**
     * @return Retorna la carrera que esta almacenado en la propiedad <code>carrera</code>.
     */
    public int getCarrera() {
        return carrera;
    }

    /**
     * @param carrera Contiene la carrera a setear en la propiedad <code>carrera</code>.
     * @return Retorna el objeto <code>{@link AlumnoCarrera}</code>.
     */
    public AlumnoCarrera setCarrera(int carrera) {
        this.carrera = carrera;
        return this;
    }

    @Override
    public String toString() {
        return "AlumnoCarrera{" +
                "alumno=" + alumno +
                ", carrera=" + carrera +
                '}';
    }
}