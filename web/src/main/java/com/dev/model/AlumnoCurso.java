package com.dev.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Mapea los datos de la inscripcion al curso.
 */
@Embeddable
public class AlumnoCurso implements Serializable {
    private static final long serialVersionUID = 7L;
    /**
     * Almacena la persona relacionada al alumno.
     */
    @Column(name = "idalumno")
    private int alumno;

    /**
     * Almacena la persona relacionada al alumno.
     */
    @Column(name = "idcurso")
    private int curso;

    /**
     * Constructor.
     *
     * @param alumno Contiene el identificador del alumno.
     * @param curso  Contiene el identificador del curso.
     */
    public AlumnoCurso(int alumno, int curso) {
        this.alumno = alumno;
        this.curso = curso;
    }

    /**
     * Constructor.
     */
    public AlumnoCurso() {
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
    public AlumnoCurso setAlumno(int alumno) {
        this.alumno = alumno;
        return this;
    }

    /**
     * @return Retorna el curso que esta almacenado en la propiedad <code>curso</code>.
     */
    public int getCurso() {
        return curso;
    }

    /**
     * @param curso Contiene el curso a setear en la propiedad <code>curso</code>.
     * @return Retorna el objeto <code>{@link AlumnoCurso}</code>.
     */
    public AlumnoCurso setCurso(int curso) {
        this.curso = curso;
        return this;
    }

    @Override
    public String toString() {
        return "AlumnoCurso{" +
                "alumno=" + alumno +
                ", curso=" + curso +
                '}';
    }
}