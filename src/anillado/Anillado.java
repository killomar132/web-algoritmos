/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package anillado;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author ACER
 */
public class Anillado {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Random random=new Random();

        System.out.print("Ingrese la dimensión de la matriz: ");
        int A=scanner.nextInt();

        int[][] matriz=new int[A][A];
        for (int i=0;i<A;i++) {
            for (int j = 0; j < A; j++) {
                matriz[i][j] = random.nextInt(31) - 0;
            }
        }

        System.out.println("Matriz generada: ");
        imprimirMatriz(matriz);

        // Sumar y mostrar cada anillo
        sumarYMostrarCadaAnillo(matriz);
    }

    public static void imprimirMatriz(int[][] matriz) {
        for (int[] fila : matriz) {
            for (int elemento : fila) {
                System.out.print(elemento + "  ||  ");
            }
            System.out.println();
        }
    }

    public static int sumarAnillo(int[][] matriz, int k) {
        int d=matriz.length;
        int suma=0;

        // Definir los límites del anillo
        int inicio=k;
        int fin=d-k-1;

        // Sumar los elementos del borde superior del anillo
        for (int j=inicio; j<=fin; j++) {
            suma+=matriz[inicio][j];
        }

        // Sumar los elementos del borde derecho del anillo
        for (int i = inicio+1; i<=fin; i++) {
            suma+=matriz[i][fin];
        }

        // Sumar los elementos del borde inferior del anillo
        for (int j=fin-1; j>=inicio; j--) {
            suma+=matriz[fin][j];
        }

        // Sumar los elementos del borde izquierdo del anillo
        for (int i=fin-1; i>inicio; i--) {
            suma+=matriz[i][inicio];
        }

        return suma;
    }

    public static void sumarYMostrarCadaAnillo(int[][] matriz) {
        int d=matriz.length;

        // Determinar el número de anillos (d/2 para una matriz cuadrada)
        int numeroDeAnillos=d/2;

        for (int i = 0; i <= numeroDeAnillos; i++) {
            int sumaAnillo = sumarAnillo(matriz, i);
            System.out.println("La suma del anillo " + (i+1) + " es: " + sumaAnillo);
        }
    }
}
