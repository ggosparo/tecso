package com.dev.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Mapea los datos de la inscripcion al curso.
 */
@Embeddable
public class ProfesorCurso implements Serializable {
    private static final long serialVersionUID = 10L;
    /**
     * Almacena la persona relacionada al profesor.
     */
    @Column(name = "idprofesor")
    private int profesor;

    /**
     * Almacena la persona relacionada al profesor.
     */
    @Column(name = "idcurso")
    private int curso;

    /**
     * Constructor.
     *
     * @param profesor Contiene el identificador del profesor.
     * @param curso  Contiene el identificador del curso.
     */
    public ProfesorCurso(int profesor, int curso) {
        this.profesor = profesor;
        this.curso = curso;
    }

    /**
     * Constructor.
     */
    public ProfesorCurso() {
    }

    /**
     * @return Retorna el profesor que esta almacenado en la propiedad <code>profesor</code>.
     */
    public int getProfesor() {
        return profesor;
    }

    /**
     * @param profesor Contiene el profesor a setear en la propiedad <code>profesor</code>.
     * @return Retorna el objeto <code>{@link ProfesorCurso}</code>.
     */
    public ProfesorCurso setProfesor(int profesor) {
        this.profesor = profesor;
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
     * @return Retorna el objeto <code>{@link ProfesorCurso}</code>.
     */
    public ProfesorCurso setCurso(int curso) {
        this.curso = curso;
        return this;
    }

    @Override
    public String toString() {
        return "ProfesorCurso{" +
                "profesor=" + profesor +
                ", curso=" + curso +
                '}';
    }
}