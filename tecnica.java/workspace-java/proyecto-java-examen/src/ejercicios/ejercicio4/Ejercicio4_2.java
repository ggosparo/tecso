package ejercicios.ejercicio4;

import java.util.*;

public class Ejercicio4_2 {

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

        Ejercicio4_2 e = new Ejercicio4_2();
        // EJERCICIO 4.2: corregir el metodo
        List<Integer> union = e.unionListas(lista1, lista2);
        System.out.println("union: " + union.toString());

        // nuevamente se recomienda llamar al metodo 'unionListasSet' utilizando Set en lugar de List
//        Set<Integer> unionSet = e.unionListasSet(lista1, lista2);
//        System.out.println("union: " + unionSet.toString());
    }

    /***
     * @param lista1
     * @param lista2
     *
     * retornar una lista que contenga los elementos de ambas listas, sin elementos repetidos
     *
     */
    private List<Integer> unionListas(List<Integer> lista1, List<Integer> lista2) {
        // TODO: corregir el metodo para que funcione correctamente
        // la solucion inicial es agregar el 'new ArrayList<Integer>()' para que la lista este inicializada
//        List<Integer> union = new ArrayList<Integer>();
//        // esta linea no sive porque la lista original (lista1) puede tener elementos repetidos, por lo tanto los agregamos de a no.
//        union.addAll(lista1);

        List<Integer> union = agregarValores(null, lista1);
        union = agregarValores(union, lista2);
        return union;
    }

    /**
     * Verifica que cada valor agregado sea unico.
     *
     * @param sinDuplicados Contiene una lista sin valores duplicados y es la lista de resultado o retorno.
     * @param base          Contiene la lista con los valores.
     * @return Retorna una lista sin valores repetidos.
     */
    private List<Integer> agregarValores(List<Integer> sinDuplicados, List<Integer> base) {
        if (sinDuplicados == null) {
            sinDuplicados = new ArrayList<Integer>();
        }
        if (base != null) {
            for (Integer m : base) {
                if (!sinDuplicados.contains(m)) {
                    sinDuplicados.add(m);
                }
            }
        }
        return sinDuplicados;
    }

    private Set<Integer> unionListasSet(List<Integer> lista1, List<Integer> lista2) {
        Set<Integer> union = new HashSet<Integer>();
        if (lista1 != null && lista2 != null) {
            union.addAll(lista1);
            union.addAll(lista2);
        } else if (lista1 != null) {
            union.addAll(lista1);
        } else if (lista2 != null) {
            union.addAll(lista2);
        }
        return union;
    }
}