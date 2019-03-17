package ejercicios.ejercicio3;

import ejercicios.ejercicio2.Persona;

/**
 * Clase que mapea los datos del alumno.
 */
public class Alumno {
    /**
     * Almacena el legajo del alumno.
     */
    private String Legajo;
    /**
     * Almacena los datos de la persona en la clase <code>{@link Persona}</code>.
     */
    private Persona Persona;

    /**
     * Constructor.
     *
     * @param legajo  Contiene el numero de legajo.
     * @param persona Contiene los datos de la persona segun la clase <code>{@link Persona}</code>
     */
    public Alumno(String legajo, Persona persona) {
        Legajo = legajo;
        Persona = persona;
    }

    /**
     * @return Retorna el numero de legajo que esta almacenado en la propiedad <code>legajo</code>.
     */
    public String getLegajo() {
        return Legajo;
    }

    /**
     * @param legajo Contiene el numero de legajo a setear en la propiedad <code>legajo</code>.
     * @return Retorna el objeto <code>{@link Alumno}</code>.
     */
    public Alumno setLegajo(String legajo) {
        Legajo = legajo;
        return this;
    }

    /**
     * @return Retorna la persona que esta almacenado en la propiedad <code>persona</code>.
     */
    public Persona getPersona() {
        return Persona;
    }

    /**
     * @param persona Contiene la persona a setear en la propiedad <code>pesona</code>.
     * @return Retorna el objeto <code>{@link Alumno}</code>.
     */
    public Alumno setPersona(Persona persona) {
        Persona = persona;
        return this;
    }
}
