package com.dev.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Mapea los datos del curso.
 */
@Entity
public class Curso implements Serializable {
    private static final long serialVersionUID = 4L;
    /**
     * Almacena el valor del identificador.
     */
    @Id
    private int identificador;
    /**
     * Almacena la persona relacionada al alumno.
     */
    @ManyToOne()
    @JoinColumn(name = "idcarrera")
    private Carrera carrera;
    /**
     * Alamcena el nombre de la carrera.
     */
    private String nombre;
    /**
     * Almacena la descripcion de la carrera.
     */
    private String descripcion;
    /**
     * Almacena el cupo maximo del curso.
     */
    private short cupomaximo;
    /**
     * Almacena el valor del anio.
     */
    private short anio;

    /**
     * Constructor.
     *
     * @param curso Contiene el identificador del curso.
     */
    public Curso(int curso) {
        identificador = curso;
    }

    /**
     * Constructor.
     */
    public Curso() {
    }

    /**
     * @return Retorna el identificador que esta almacenado en la propiedad <code>identificador</code>.
     */
    public int getIdentificador() {
        return identificador;
    }

    /**
     * @param identificador Contiene el numero de identificador a setear en la propiedad <code>identificador</code>.
     * @return Retorna el objeto <code>{@link Curso}</code>.
     */
    public Curso setIdentificador(int identificador) {
        this.identificador = identificador;
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
     * @return Retorna el objeto <code>{@link Curso}</code>.
     */
    public Curso setCarrera(Carrera carrera) {
        this.carrera = carrera;
        return this;
    }

    /**
     * @return Retorna el nombre que esta almacenado en la propiedad <code>nombre</code>.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre Contiene el nombre del curso a setear en la propiedad <code>nombre</code>.
     * @return Retorna el objeto <code>{@link Curso}</code>.
     */
    public Curso setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    /**
     * @return Retorna la descripcion del curso que esta almacenado en la propiedad <code>descripcion</code>.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion Contiene la descripcion de la carrera a setear en la propiedad <code>descripcion</code>.
     * @return Retorna el objeto <code>{@link Curso}</code>.
     */
    public Curso setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    /**
     * @return Retorna el cupo maximo que esta almacenado en la propiedad <code>cupomaximo</code>.
     */
    public short getCupomaximo() {
        return cupomaximo;
    }

    /**
     * @param cupomaximo Contiene lel cupo maximo del curso a setear en la propiedad <code>cupomaximo</code>.
     * @return Retorna el objeto <code>{@link Curso}</code>.
     */
    public Curso setCupomaximo(short cupomaximo) {
        this.cupomaximo = cupomaximo;
        return this;
    }

    /**
     * @return Retorna el anio del curso que esta almacenado en la propiedad <code>anio</code>.
     */
    public short getAnio() {
        return anio;
    }

    /**
     * @param anio Contiene el anio del curso a setear en la propiedad <code>anio</code>.
     * @return Retorna el objeto <code>{@link Curso}</code>.
     */
    public Curso setAnio(short anio) {
        this.anio = anio;
        return this;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "identificador=" + identificador +
                ", carrera=" + carrera +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", cupomaximo=" + cupomaximo +
                ", anio=" + anio +
                '}';
    }
}