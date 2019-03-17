package ejercicios.ejercicio4;

import java.util.*;

public class Ejercicio4_3 {

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
        Ejercicio4_3 e = new Ejercicio4_3();

        // EJERCICIO 4.3: implementar
        List<Integer> interseccion = e.interseccionListas(lista1, lista2);
        System.out.println("interseccion: " + interseccion.toString());
        // nuevamente se recomienda llamar al metodo 'unionListasSet' utilizando Set en lugar de List
        // tener la precaucion que el metodo 'interseccionListas' borra las lista para mejorar la performance
//        Set<Integer> interseccionSet = e.interseccionListasSet(lista1, lista2);
//        System.out.println("interseccion: " + interseccionSet.toString());
    }

    /***
     * @param lista1
     * @param lista2
     *
     * retornar una lista que contenga los elementos que estan presentes en ambas listas, sin elementos repetidos
     *
     */
    private List<Integer> interseccionListas(List<Integer> lista1, List<Integer> lista2) {
        // TODO:
        List<Integer> interseccion = new ArrayList<Integer>();
        if (lista1 != null && lista2 != null) {
            for (Iterator<Integer> i1 = lista1.iterator(); i1.hasNext(); ) {
                Integer l1 = i1.next();
                boolean notFound = true;
                for (Iterator<Integer> i2 = lista2.iterator(); i2.hasNext() && notFound; ) {
                    Integer l2 = i2.next();
                    if (l2 == l1) {
                        // si utilizamos un Set se evita esta verificacion
                        if (!interseccion.contains(l1)) {
                            interseccion.add(l1);
                        }
                        i2.remove();
                        i1.remove();
                        notFound = false;
                    }
                }
            }
        }
        return interseccion;
    }

    /***
     * @param lista1
     * @param lista2
     *
     * retornar una lista que contenga los elementos que estan presentes en ambas listas, sin elementos repetidos
     *
     */
    private Set<Integer> interseccionListasSet(List<Integer> lista1, List<Integer> lista2) {
        // TODO:
        Set<Integer> interseccion = new HashSet<Integer>();
        if (lista1 != null && lista2 != null) {
            for (Iterator<Integer> i1 = lista1.iterator(); i1.hasNext(); ) {
                Integer l1 = i1.next();
                boolean notFound = true;
                for (Iterator<Integer> i2 = lista2.iterator(); i2.hasNext() && notFound; ) {
                    Integer l2 = i2.next();
                    if (l2 == l1) {
                        interseccion.add(l1);
                        i2.remove();
                        i1.remove();
                        notFound = false;
                    }
                }
            }
        }
        return interseccion;
    }
}