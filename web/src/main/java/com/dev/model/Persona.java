package com.dev.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * Mapea los datos de una persona.
 */
@Entity
public class Persona implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Almacena el valor del identificador.
     */
    @Id
    private int identificador = 0;
    /**
     * Almacena el valor del tipo de documento.
     */
    private String tipodoc;
    /**
     * Almacena el numero de documento.
     */
    private long documento = 0;
    /**
     * Almacena el nombre de la persona.
     */
    private String nombre;
    /**
     * Almacena el apellido de la persona.
     */
    private String apellido;
    /**
     * Almacena la direccion.
     */
    private String direccion;
    /**
     * Almacena la fecha de naciemiento.
     */
    private Date fechanac;

    /**
     * Constructor.
     */
    public Persona() {
    }

    /**
     * Constructor.
     *
     * @param identificador Contiene el valor del identificador.
     */
    public Persona(int identificador) {
        this.identificador = identificador;
    }

    /**
     * @return Retorna el numero de documento que esta almacenado en la propiedad <code>identificador</code>.
     */
    public int getIdentificador() {
        return identificador;
    }

    /**
     * @param identificador Contiene el numero de identificador a setear en la propiedad <code>identificador</code>.
     * @return Retorna el objeto <code>{@link Persona}</code>.
     */
    public Persona setIdentificador(int identificador) {
        this.identificador = identificador;
        return this;
    }

    /**
     * @param identificador Contiene el numero de identificador a setear en la propiedad <code>identificador</code>.
     * @return Retorna el objeto <code>{@link Persona}</code>.
     */
    public Persona setIdentificador(String identificador) {
        return this.setIdentificador(Integer.valueOf(identificador));
    }

    /**
     * @return Retorna el tipo de documento que esta almacenado en la propiedad <code>tipodoc</code>.
     */
    public String getTipodoc() {
        return tipodoc;
    }

    /**
     * @param tipodoc Contiene el tipo de documento a setear en la propiedad <code>tipodoc</code>.
     * @return Retorna el objeto <code>{@link Persona}</code>.
     */
    public Persona setTipodoc(String tipodoc) {
        this.tipodoc = tipodoc;
        return this;
    }

    /**
     * @return Retorna el numero de documento que esta almacenado en la propiedad <code>documento</code>.
     */
    public long getDocumento() {
        return documento;
    }

    /**
     * @param documento Contiene el numero de documento a setear en la propiedad <code>documento</code>.
     * @return Retorna el objeto <code>{@link Persona}</code>.
     */
    public Persona setDocumento(long documento) {
        this.documento = documento;
        return this;
    }

    /**
     * @param documento Contiene el numero de documento a setear en la propiedad <code>documento</code>.
     * @return Retorna el objeto <code>{@link Persona}</code>.
     */
    public Persona setDocumento(String documento) {
        return this.setDocumento(Long.valueOf(documento));
    }

    /**
     * @return Retorna el nombre que esta almacenado en la propiedad <code>nombre</code>.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre Contiene el nombre a setear en la propiedad <code>nombre</code>.
     * @return Retorna el objeto <code>{@link Persona}</code>.
     */
    public Persona setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    /**
     * @return Retorna el apellido que esta almacenado en la propiedad <code>apellido</code>.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido Contiene el apellido a setear en la propiedad <code>apellido</code>.
     * @return Retorna el objeto <code>{@link Persona}</code>.
     */
    public Persona setApellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    /**
     * @return Retorna la direccion que esta almacenado en la propiedad <code>direccion</code>.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion Contiene la direccion a setear en la propiedad <code>direccion</code>.
     * @return Retorna el objeto <code>{@link Persona}</code>.
     */
    public Persona setDireccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    /**
     * @return Retorna la fecha de nacimiento que esta almacenado en la propiedad <code>fechanac</code>.
     */
    public Date getFechanac() {
        return fechanac;
    }

    /**
     * @param fechanac Contiene la fecha de nacimiento a setear en la propiedad <code>fechanac</code>.
     * @return Retorna el objeto <code>{@link Persona}</code>.
     */
    public Persona setFechanac(Date fechanac) {
        this.fechanac = fechanac;
        return this;
    }

    @Override
    public String toString() {
        return "persona{" +
                "identificador=" + identificador +
                ", tipodoc='" + tipodoc + '\'' +
                ", documento=" + documento +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", direccion='" + direccion + '\'' +
                ", fechanac=" + fechanac +
                '}';
    }
}
