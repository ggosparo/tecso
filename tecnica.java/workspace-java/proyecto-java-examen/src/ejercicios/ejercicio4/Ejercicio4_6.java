package ejercicios.ejercicio4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Ejercicio4_6 {

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
        Ejercicio4_6 e = new Ejercicio4_6();

        // EJERCICIO 4.6: implementar
        boolean b = e.tienenMismoContenido(lista1, lista2);
        System.out.println("mismo contenido: " + b);
        // misma lista
        lista1 = new ArrayList<Integer>(Arrays.asList(valoresLista1));
        lista2 = new ArrayList<Integer>(Arrays.asList(valoresLista1));
        b = e.tienenMismoContenido(lista1, lista2);
        System.out.println("mismo contenido true: " + b);
        // misma lista inicial pero la lista2 posee un elemento menos
        lista1 = new ArrayList<Integer>(Arrays.asList(valoresLista1));
        lista2 = new ArrayList<Integer>(Arrays.asList(valoresLista1));
        lista1.remove(1);
        b = e.tienenMismoContenido(lista1, lista2);
        System.out.println("mismo contenido false: " + b);
        // una lista vs null
        lista1 = new ArrayList<Integer>(Arrays.asList(valoresLista1));
        b = e.tienenMismoContenido(lista1, null);
        System.out.println("mismo contenido false: " + b);
        // misma lista solo cambia la posicion 8 de la lista 2
        lista1 = new ArrayList<Integer>(Arrays.asList(valoresLista1));
        lista2 = new ArrayList<Integer>(Arrays.asList(valoresLista1));
        lista2.remove(8);
        lista2.add(9);
        b = e.tienenMismoContenido(lista1, lista2);
        System.out.println("mismo contenido false: " + b);
    }

    /***
     * @param lista1
     * @param lista2
     *
     * devuelve true si contienen los mismos elementos
     * NO se considera valido que esten en diferente orden
     * NO se considera valido que la cantidad de repeticiones de los elementos sea diferente
     *
     */
    private boolean tienenMismoContenido(List<Integer> lista1, List<Integer> lista2) {
        if (lista1 == null && lista2 == null) {
            // las listas son iguales y no poseen elementos
            return true;
        } else if (lista1 == null || lista2 == null ||
                lista1.size() != lista2.size()) {
            // las listas son distintas porque una de las 2 es null
            // las listas son distintas por tener distinta longuitud
            return false;
        } else {
            for (int i = 0; i < lista1.size(); i++) {
                if (lista1.get(i).intValue() != lista2.get(i)) {
                    // la misma posicion de la lista posee valores diferentes
                    return false;
                } else {
                    lista1.remove(i);
                    lista2.remove(i);
                    i--;
                }
            }
            return true;
        }
    }

}