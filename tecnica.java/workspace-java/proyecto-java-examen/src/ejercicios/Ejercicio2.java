package ejercicios;

import ejercicios.ejercicio2.Persona;
import ejercicios.ejercicio2.TipoDocumento;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A. Crear una clase Persona con los siguientes campos
 * (con sus respectivos getters, setters y constructor)
 * <p>
 * TipoDocumento - enum (dni/libretacivica)
 * NroDocumento - Integer
 * Nombre - String
 * Apellido - String
 * FechaNacimiento - Date
 * <p>
 * B. En el método main de la clase "ejercicio2" crear una nueva instancia
 * de la clase persona y settearle valores reales con tus datos
 * <p>
 * <p>
 * C. En el método main de la clase "Ejercicio 2" imprimir los valores en
 * consola
 * (crear método main e imprimir valores)
 *
 * @author examen
 */
public class Ejercicio2 {

    /**
     * Constructor.
     */
    public Ejercicio2() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @param args Argumentos de entrada.
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        // Inicio seccion B
        Date fechaNacimiento = null;
        try {
            fechaNacimiento = new SimpleDateFormat("yyyy-MM-dd").parse("1980-06-06");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Persona persona = new Persona(TipoDocumento.DNI, 27747989, "Gabriel",
                "Gosparo", fechaNacimiento);
        // Fin seccion B

        // Inicio seccion C
        // Para esta seccion implemente el metodo toString en la clase persona.
        System.out.println(persona);
        // Fin seccion C
    }
}
