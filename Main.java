package Juego_21_palitos;

import java.util.*;

public class Main {

    static int n_palos = 21;
    static Scanner teclado = new Scanner(System.in);

    public static void pintar_palos() {

        for (int i = 1; i <= n_palos; i++) {

            System.out.print(" | ");

        }
        System.out.println();

    }

    public static void pedir_palos() {

        while (n_palos > 1) {

            System.out.print("\nintroduce cuantos palos quieres tachar: ");
            int tirada_jugador = teclado.nextInt();

            if (tirada_jugador >= 1 && tirada_jugador <= 4) {

                System.out.println("has tachado " + tirada_jugador + " palos");
                n_palos = n_palos - tirada_jugador;
                pintar_palos();

                if (n_palos > 1) {

                    System.out.println("turno de la ia: ");

                    // MINIMO + MAXIMO = NUMERO MAGICO
                    // 1 + 4 = 5

                    // EL NUMERO MAGICO ES 5
                    // LA IA VA A TIRAR 5 MENOS LA TIRADA DEL JUGADOR QUE SOLO PUEDE SER ENTRE 1 Y 4
                    // ENTRE LA IA Y NUESTRA TIRADA SIEMPRE SUMA 5, para que gane siempre la ia
                    int tirada_maquina = 5 - tirada_jugador;

                    // POR SI QUEDAN POCOS PALOS AL FINAL PARA QUE LA IA NO RESTE DE MAS Y DEJE
                    // SIEMPRE 1 PALO
                    if (n_palos - tirada_maquina < 1) {
                        tirada_maquina = n_palos - 1;
                    }

                    n_palos = n_palos - tirada_maquina;

                    System.out.println("la ia ha quitado " + tirada_maquina + " palos");
                    pintar_palos();
                    System.out.println("quedan " + n_palos + " por tachar");

                }

            } else {
                System.out.println("solo puedes tachar entre 1 y 4 palos por tirada, no se pueden mas ni menos");

            }
        }
    }

    public static void decidir_ganador() {
        System.out.println(" has perdido, queda 1 palo y te toca");
    }

    public static void main(String[] args) {

        pintar_palos();
        pedir_palos();
        decidir_ganador();

    }

}
