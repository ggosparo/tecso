package ejercicios.ejercicio4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ejercicio4_1 {

    // listas de ejemplo, pueden variarse su contenido,
    static Integer[] valoresLista1 = {1, 2, 5, 8, 10, 30, 20, 8, 9, 10};
    static Integer[] valoresLista2 = {1, 2, 4, 20, 5, 10, 7, 8, 10, 9};

    /**
     * Para ejecutar el método main se debe hacer boton derecho sobre la clase
     * "Run As --> Java Application"
     *
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("**** inicializando datos ****");

        List<Integer> lista1 = new ArrayList<Integer>(Arrays.asList(valoresLista1));
        List<Integer> lista2 = new ArrayList<Integer>(Arrays.asList(valoresLista2));

        System.out.println("**** inicializacion exitosa ****");

        // EJERCICIO 4.1: explicar salidas y sugerir mejoras
        Ejercicio4_1 e = new Ejercicio4_1();
        e.informacion(lista1, 10);
    }

    private void informacion(List<Integer> lista1, Integer numero) {
        // TODO: explicar salidas de los system out y sugerir alguna mejora a la implementacion
        int pares = 0,
                p = lista1.size() / 2,
                c = 0;
        // se puede sugerir el cambio de List por Set, pero deberia comprender mejor la necesidad de este metodo.
        // si el alcance es solo que se ve en codigo seria mejor implementar Set para una mejor eficiencia.
        if (lista1 != null) {
            List<Integer> impares = new ArrayList<Integer>();
            for (Integer n : lista1) {
                if (n % 2 == 0) {
                    pares = pares + 1;
                } else {
                    impares.add(n);
                }
                if (n > numero) {
                    c = c + 1;
                }
            }
            // muestra la cantidad de numero pares
            System.out.println("... " + pares);
            // muestra la lista de numeros impares
            System.out.println("... " + impares.toString());
            // muestra la posicion en la que se encuentra el resultado de la division de (lista1.size() / 2) = 10 / 2 = 5
            // el numero 5 se encuentra en la posicion 2 de la lista de numeros impares
            System.out.println("..." + lista1.indexOf(p));
            // se cambio (lista1.size() / 2) por el valor de la variable 'p' para que no se tenga que hacer
            // nuevamente la division
            if (c > p) {
                System.out.println("...");
            } else if (c > 0) {
                System.out.println("...");
            } else {
                System.out.println("...");
            }
        }
    }
}