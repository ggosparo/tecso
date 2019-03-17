package com.dev.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Date;

/**
 * Mapea los datos de la inscripcion del profesor del curso.
 */
@Entity(name = "profesores_curso")
public class ProfesoresCurso implements Serializable {
    private static final long serialVersionUID = 6L;
    /**
     * Almacena la primary key de la tabla.
     */
    @EmbeddedId
    private ProfesorCurso profesorcurso;
    /**
     * Almacena la persona relacionada al profesor.
     */
    @ManyToOne()
    @JoinColumn(name = "idprofesor", insertable = false, updatable = false)
    private Persona profesor;
    /**
     * Almacena la persona relacionada al alumno.
     */
    @ManyToOne()
    @JoinColumn(name = "idcurso", insertable = false, updatable = false)
    private Curso curso;

    /**
     * Constructor.
     */
    public ProfesoresCurso() {
    }


    /**
     * @return Retorna el profesor que esta almacenado en la propiedad <code>{@link Persona}</code>.
     */
    public Persona getProfesor() {
        return profesor;
    }

    /**
     * @param profesor Contiene el profesor a setear en la propiedad <code>profesor</code>.
     * @return Retorna el objeto <code>{@link ProfesoresCurso}</code>.
     */
    public ProfesoresCurso setAlumno(Persona profesor) {
        this.profesor = profesor;
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
     * @return Retorna el objeto <code>{@link ProfesoresCurso}</code>.
     */
    public ProfesoresCurso setCurso(Curso curso) {
        this.curso = curso;
        return this;
    }

    /**
     * @return Retorna la primary key que esta almacenado en la propiedad <code>{@link ProfesorCurso}</code>.
     */
    public ProfesorCurso getProfesorocurso() {
        return profesorcurso;
    }

    /**
     * @param profesorcurso Contiene la primary key a setear en la propiedad <code>{@link AlumnoCurso}</code>.
     * @return Retorna el objeto <code>{@link ProfesoresCurso}</code>.
     */
    public ProfesoresCurso setProfesorcurso(ProfesorCurso profesorcurso) {
        this.profesorcurso = profesorcurso;
        return this;
    }

    @Override
    public String toString() {
        return "InscripcionesCurso{" +
                "ProfesorCurso=" + profesorcurso +
                ", profesor=" + profesor +
                ", curso=" + curso +
                '}';
    }
}