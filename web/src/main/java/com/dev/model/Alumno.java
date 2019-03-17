package com.dev.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Mapea los datos del alumna.
 */
@Entity
public class Alumno implements Serializable {
    private static final long serialVersionUID = 2L;
    /**
     * Almacena el valor del identificador.
     */
    @Id
    private int identificador;
    /**
     * Alamcena el valor del numero de legajo.
     */
    private int legajo;
    /**
     * Almacena la persona relacionada al alumno.
     */
    @ManyToOne()
    @JoinColumn(name = "idpersona")
    private Persona persona;

    /**
     * Constructor.
     *
     * @param alumno Contiene el identificador del alumno.
     */
    public Alumno(int alumno) {
        identificador = alumno;
    }

    /**
     * Constructor.
     */
    public Alumno() {
    }

    /**
     * @return Retorna el identificador que esta almacenado en la propiedad <code>identificador</code>.
     */
    public int getIdentificador() {
        return identificador;
    }

    /**
     * @param identificador Contiene el numero de identificador a setear en la propiedad <code>identificador</code>.
     * @return Retorna el objeto <code>{@link Alumno}</code>.
     */
    public Alumno setIdentificador(int identificador) {
        this.identificador = identificador;
        return this;
    }

    /**
     * @return Retorna el numero de legajo que esta almacenado en la propiedad <code>legajo</code>.
     */
    public int getLegajo() {
        return legajo;
    }

    /**
     * @param legajo Contiene el numero de legajo a setear en la propiedad <code>legajo</code>.
     * @return Retorna el objeto <code>{@link Alumno}</code>.
     */
    public Alumno setLegajo(int legajo) {
        this.legajo = legajo;
        return this;
    }

    /**
     * @return Retorna la persona que esta almacenado en la propiedad <code>persona</code>.
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * @param persona Contiene la persona a setear en la propiedad <code>persona</code>.
     * @return Retorna el objeto <code>{@link Alumno}</code>.
     */
    public Alumno setPersona(Persona persona) {
        this.persona = persona;
        return this;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "identificador=" + identificador +
                ", legajo=" + legajo +
                ", persona=" + persona +
                '}';
    }
}
