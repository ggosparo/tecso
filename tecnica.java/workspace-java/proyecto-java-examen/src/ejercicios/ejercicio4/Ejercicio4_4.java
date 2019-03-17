package ejercicios.ejercicio4;

import java.util.*;

public class Ejercicio4_4 {

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
        Ejercicio4_4 e = new Ejercicio4_4();
        // EJERCICIO 4.4: implementar
        List<Integer> orden1 = e.ordenaListaAscendente(lista1);
        System.out.println("orden asc: " + orden1);

    }

    /***
     * @param lista1
     *
     * retornar la lista recibida, ordenada en forma ascendente
     *
     */
    private  List<Integer> ordenaListaAscendente(List<Integer> lista1) {
        // TODO:
        Collections.sort(lista1);
        return lista1;
    }

}