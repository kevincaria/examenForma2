
import java.util.Scanner;

// Enunciado
// Dada la siguiente problemática: ¿puede un número X formarse usando la suma de 2 elementos
// de un array?
// Ejemplo 1
// Input: nums = [1,4,3,9], requiredSum = 8
// Output: False
// Ejemplo 2
// Input: nums = [1,2,4,4], requiredSum = 8
// Output: True
// Desarrolle (en pseudo código o su lenguaje de preferencia):
// 1. Un algoritmo que resuelva el problema asumiendo que la máquina en donde va a correrse
// el programa tiene recursos infinitos, que el tiempo de ejecución no importa y que lo más
// importante es realizar el desarrollo en el menor tiempo posible.
// 2. Un algoritmo que resuelva el problema asumiendo que los recursos son un bien preciado,
// que el tiempo de ejecución si importa y que el tiempo de desarrollo no es importante.
// Ante cualquier duda o ambigüedad en el enunciado, es libre de hacer todas las suposiciones
// necesarias, siempre y cuando las especifique.

public class App {
    public static void main(String[] args) throws Exception {
        resolucionExamen();
    }

    public static int pedirNumeroAFormar() {
        System.out.println("Ingrese el numero que se debe formar: ");
        int requerido = new Scanner(System.in).nextInt();
        return requerido;
    }

    public static int pedirDimension() {
        System.out.println("Cuantos numeros tendra la lista?");
        int dimension = new Scanner(System.in).nextInt();
        return dimension;
    }

    public static int[] pedirNumerosArray(int dimension) {
        int listaNumeros[] = new int[dimension];
        for (int i = 0; i < dimension; i++) {
            System.out.println("Ingrese el numero de la posicion " + i);
            listaNumeros[i] = new Scanner(System.in).nextInt();
        }
        return listaNumeros;
    }

    public static boolean puedeFormarse(int requerido, int dimension,int[] listaNumeros) {
        boolean resultado = false;
        int suma;
        int posicion = 0;

        for (int j = 0; j < listaNumeros.length; j++) {
            for (int i = 0; i < listaNumeros.length; i++) {
                suma = 0;
                if (posicion != i) {
                    suma = listaNumeros[posicion] + listaNumeros[i];
                }
                if (suma == requerido) {
                    resultado = true;
                }
                if (dimension == i+1) {
                    posicion = posicion+1;
                }
            }
        }

        return resultado;
    }

    public static void resolucionExamen() {
        int requerido = pedirNumeroAFormar();
        int dimension = pedirDimension();
        int listaNumeros[] = pedirNumerosArray(dimension);
        boolean resultado = puedeFormarse(requerido, dimension, listaNumeros);
        System.out.println("¿Se puede formar el numeros: " + requerido + " ? " + resultado);
    }
}
