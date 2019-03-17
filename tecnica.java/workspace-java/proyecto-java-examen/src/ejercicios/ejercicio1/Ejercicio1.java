package ejercicios;

/**
 * Ejercicio: analizar la siguente clase y realizar las correcciones
 * necesarias para que compile
 *
 * @author examen
 */
public class Ejercicio1 {

    int count1;
    static int count2;

    public Ejercicio1() {
        count1 = 0;
        count2++;
    }

    public void incrementa1() {
        count1++;
    }

    public void incrementa2() {
        count2++;
    }
    /*
     * Quite static al metodo 'incrementa'.
     * Esto lo hice porque supuse que el metodo 'incrementa' fue el ultimo en escribirse y
     * no debe ser 'static' porque la variable 'count1' no lo es y dicha variable ya esta
     * siendo utilizada en un entorno/contexto el cual se debe modificar lo menos posible.
     *
     * Tengo que aclarar que existen otras soluciones posibles y que para aplicar la mejor
     * solucion debo conocer el contexto donde se encuentra esta clase.
     */
    public void incrementa() {
        count1++;
    }

}
