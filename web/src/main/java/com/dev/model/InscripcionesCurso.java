package com.dev.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Mapea los datos de la inscripcion al curso.
 */
@Entity(name = "inscripciones_curso")
public class InscripcionesCurso implements Serializable {
    private static final long serialVersionUID = 6L;
    /**
     * Almacena la primary key de la tabla.
     */
    @EmbeddedId
    private AlumnoCurso alumnocurso;
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
    @JoinColumn(name = "idcurso", insertable = false, updatable = false)
    private Curso curso;
    /**
     * Almacena la fecha de inscripcion.
     */
    private Date fechainscripcion;
    /**
     * Almacena la nota que obtuvo el alumno.
     */
    private double nota;

    /**
     * Constructor.
     */
    public InscripcionesCurso() {
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
    public InscripcionesCurso setAlumno(Alumno alumno) {
        this.alumno = alumno;
        return this;
    }

    /**
     * @return Retorna el curso que esta almacenado en la propiedad <code>curso</code>.
     */
    public Curso getCurso() {
        return curso;
    }

    /**
     * @param curso Contiene el curso a setear en la propiedad <code>curso</code>.
     * @return Retorna el objeto <code>{@link InscripcionesCurso}</code>.
     */
    public InscripcionesCurso setCurso(Curso curso) {
        this.curso = curso;
        return this;
    }

    /**
     * @return Retorna la primary key que esta almacenado en la propiedad <code>{@link AlumnoCurso}</code>.
     */
    public AlumnoCurso getAlumnocurso() {
        return alumnocurso;
    }

    /**
     * @param alumnocuro Contiene la primary key a setear en la propiedad <code>{@link AlumnoCurso}</code>.
     * @return Retorna el objeto <code>{@link InscripcionesCurso}</code>.
     */
    public InscripcionesCurso setAlumnocurso(AlumnoCurso alumnocuro) {
        this.alumnocurso = alumnocuro;
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
    public InscripcionesCurso setFechainscripcion(Date fechainscripcion) {
        this.fechainscripcion = fechainscripcion;
        return this;
    }

    /**
     * @return Retorna la nota que esta almacenado en la propiedad <code>nota</code>.
     */
    public double getNota() {
        return nota;
    }

    /**
     * @param nota Contiene la nota a setear en la propiedad <code>nota</code>.
     * @return Retorna el objeto <code>{@link InscripcionesCurso}</code>.
     */
    public InscripcionesCurso setNota(double nota) {
        this.nota = nota;
        return this;
    }

    @Override
    public String toString() {
        return "InscripcionesCurso{" +
                "AlumnoCurso=" + alumnocurso +
                "alumno=" + alumno +
                ", curso=" + curso +
                ", fechainscripcion=" + fechainscripcion +
                ", nota=" + nota +
                '}';
    }
}