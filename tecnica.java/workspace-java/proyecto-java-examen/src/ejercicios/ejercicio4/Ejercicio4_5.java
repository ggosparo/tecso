package ejercicios.ejercicio4;

import java.util.*;

public class Ejercicio4_5 {

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
        Ejercicio4_5 e = new Ejercicio4_5();

        // EJERCICIO 4.5: implementar
        List<Integer> orden2 = e.ordenaListaDescendente(lista2);
        System.out.println("orden desc: " + orden2);

    }

    /***
     * @param lista2
     *
     * retornar la lista recibida, ordenada en forma descendente
     *
     */
    private List<Integer> ordenaListaDescendente(List<Integer> lista2) {
        // TODO:
        Collections.sort(lista2, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        return lista2;
    }
}