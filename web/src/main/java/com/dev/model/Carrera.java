package com.dev.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Mapea los datos de la carrera.
 */
@Entity
public class Carrera implements Serializable {
    private static final long serialVersionUID = 3L;
    /**
     * Almacena el valor del identificador.
     */
    @Id
    private int identificador;
    /**
     * Alamcena el nombre de la carrera.
     */
    private String nombre;
    /**
     * Almacena la descripcion de la carrera.
     */
    private String descripcion;
    /**
     * Almacena la fecha de inicio de la carrera.
     */
    private Date fechadesde;
    /**
     * Almacena la fecha de finalizacion o cierre de la carrera.
     */
    private Date fechahasta;

    /**
     * @return Retorna el identificador que esta almacenado en la propiedad <code>identificador</code>.
     */
    public int getIdentificador() {
        return identificador;
    }

    /**
     * @param identificador Contiene el numero de identificador a setear en la propiedad <code>identificador</code>.
     * @return Retorna el objeto <code>{@link Carrera}</code>.
     */
    public Carrera setIdentificador(int identificador) {
        this.identificador = identificador;
        return this;
    }

    /**
     * @return Retorna el nombre que esta almacenado en la propiedad <code>nombre</code>.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre Contiene el nombre la carrera a setear en la propiedad <code>nombre</code>.
     * @return Retorna el objeto <code>{@link Carrera}</code>.
     */
    public Carrera setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    /**
     * @return Retorna la descripcion de la carrera que esta almacenado en la propiedad <code>descripcion</code>.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion Contiene la descripcion de la carrera a setear en la propiedad <code>descripcion</code>.
     * @return Retorna el objeto <code>{@link Carrera}</code>.
     */
    public Carrera setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    /**
     * @return Retorna la fecha de inicio de la carrera que esta almacenado en la propiedad <code>fechadesde</code>.
     */
    public Date getFechadesde() {
        return fechadesde;
    }

    /**
     * @param fechadesde Contiene la fecha de inicio de la carrera a setear en la propiedad <code>fechadesde</code>.
     * @return Retorna el objeto <code>{@link Carrera}</code>.
     */
    public Carrera setFechadesde(Date fechadesde) {
        this.fechadesde = fechadesde;
        return this;
    }

    /**
     * @return Retorna la fecha de fin o cierre de la carrera que esta almacenado en la propiedad <code>fechahasta</code>.
     */
    public Date getFechahasta() {
        return fechahasta;
    }

    /**
     * @param fechahasta Contiene la fecha de fin o cierre de la carrera a setear en la propiedad <code>fechahasta</code>.
     * @return Retorna el objeto <code>{@link Carrera}</code>.
     */
    public Carrera setFechahasta(Date fechahasta) {
        this.fechahasta = fechahasta;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Carrera carrera = (Carrera) o;

        return identificador == carrera.identificador;
    }

    @Override
    public int hashCode() {
        return identificador;
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "identificador=" + identificador +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fechadesde=" + fechadesde +
                ", fechahasta=" + fechahasta +
                '}';
    }
}
