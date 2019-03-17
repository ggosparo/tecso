package ejercicios.ejercicio2;

import java.util.Date;

/**
 * Clase que mapea los datos de una persona.
 */
public class Persona {
    /**
     * Almacena el tipo de documento.
     */
    private TipoDocumento TipoDocumento;
    /**
     * Almacena el numero de documento.
     */
    private Integer NroDocumento;
    /**
     * Almacena el nombre de la persona.
     */
    private String Nombre;
    /**
     * Almacena el apellido de la persona.
     */
    private String Apellido;
    /**
     * Almacena la fecha de nacimiento de la persona.
     */
    private Date FechaNacimiento;

    /**
     * Constructor.
     */
    public Persona() {
    }

    /**
     * Constructor.
     *
     * @param tipoDocumento   Contiene el tipo de documento segun la enumeracion <code>{@link TipoDocumento}</code>.
     * @param nroDocumento    Contiene el numero de documento.
     * @param nombre          Contiene el nombre de la persona.
     * @param apellido        Contiene el apellido de la persona.
     * @param fechaNacimiento Contiene la fecha de nacimiento.
     */
    public Persona(TipoDocumento tipoDocumento, Integer nroDocumento, String nombre, String apellido,
                   Date fechaNacimiento) {
        TipoDocumento = tipoDocumento;
        NroDocumento = nroDocumento;
        Nombre = nombre;
        Apellido = apellido;
        FechaNacimiento = fechaNacimiento;
    }

    /**
     * @return Retorna la enumeracion <code>{@link TipoDocumento}</code>.
     */
    public TipoDocumento getTipoDocumento() {
        return TipoDocumento;
    }

    /**
     * @param tipoDocumento Contiene el tipo de documento segun la enumeracion <code>{@link TipoDocumento}</code>.
     * @return Retorna el objeto <code>{@link Persona}</code>.
     */
    public Persona setTipoDocumento(TipoDocumento tipoDocumento) {
        TipoDocumento = tipoDocumento;
        return this;
    }

    /**
     * @return Retorna el numero de documento que esta almacenado en la propiedad <code>nroDocumento</code>.
     */
    public Integer getNroDocumento() {
        return NroDocumento;
    }

    /**
     * @param nroDocumento Contiene el numero de documento a setear en la propiedad <code>nroDocumento</code>.
     * @return Retorna el objeto <code>{@link Persona}</code>.
     */
    public Persona setNroDocumento(Integer nroDocumento) {
        NroDocumento = nroDocumento;
        return this;
    }

    /**
     * @return Retorna el nombre que esta almacenado en la propiedad <code>nombre</code>.
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param nombre Contiene el nombre a setear en la propiedad <code>nombre</code>.
     * @return Retorna el objeto <code>{@link Persona}</code>.
     */
    public Persona setNombre(String nombre) {
        Nombre = nombre;
        return this;
    }

    /**
     * @return Retorna el apellido que esta almacenado en la propiedad <code>apellido</code>.
     */
    public String getApellido() {
        return Apellido;
    }

    /**
     * @param apellido Contiene el nombre a setear en la propiedad <code>apellido</code>.
     * @return Retorna el objeto <code>{@link Persona}</code>.
     */
    public Persona setApellido(String apellido) {
        Apellido = apellido;
        return this;
    }

    /**
     * @return Retorna la fecha de nacimiento que esta almacenado en la propiedad <code>fechaNacimiento</code>.
     */
    public Date getFechaNacimiento() {
        return FechaNacimiento;
    }

    /**
     * @param fechaNacimiento Contiene el nombre a setear en la propiedad <code>fechaNacimiento</code>.
     * @return Retorna el objeto <code>{@link Persona}</code>.
     */
    public Persona setFechaNacimiento(Date fechaNacimiento) {
        FechaNacimiento = fechaNacimiento;
        return this;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "TipoDocumento=" + TipoDocumento +
                ", NroDocumento=" + NroDocumento +
                ", Nombre='" + Nombre + '\'' +
                ", Apellido='" + Apellido + '\'' +
                ", FechaNacimiento=" + FechaNacimiento +
                '}';
    }
}
