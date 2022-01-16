package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    
    static final int OPCIO_INTRODUIR_ELEMENTS = 1;
    static final int LLISTAR_ELEMENTS = 2;
    static final int MODIFICAR_ELEMENT = 3;

    static final Scanner teclat = new Scanner(System.in);

    public static void main(String[] args) {
        String[] elementsCarta = new String[20];
        mostrarMenu();
        int opcio = obtenerOpcio();
        switch (opcio) {
            case OPCIO_INTRODUIR_ELEMENTS:
                elementsCarta = obtenerElementsCarta(elementsCarta);
                
            case LLISTAR_ELEMENTS:
                llistarElements(elementsCarta);

            case MODIFICAR_ELEMENT:
                cambiarElement(elementsCarta);
                
        }

    }
    public static void mostrarMenu() {
        System.out.println(OPCIO_INTRODUIR_ELEMENTS + "- Introdueix nous elements a la carta");
        System.out.println(LLISTAR_ELEMENTS + "- Llista els elements que es troben en la carta");
        System.out.println(MODIFICAR_ELEMENT + "- Modifica un element de la carta");
        
    }

    public static String[][] obtenerElementsCarta(String[][] elementsCarta) {
        String missatge = "¿Cuantos elementos quieres añadir";
        int elementos = demanarEnterUsuari(missatge);
        System.out.println("Introduce nuevos elementos en la carta: ");
        for (int i = 0; i < elementsCarta.length; i++) {
            for (int j = 0; j < elementsCarta[i].length; j++) {
                System.out.println("Elemento " + i + ": ");
                String elemento = teclat.nextLine();
                elementsCarta[i][j] = elemento;
            }
        }
        return elementsCarta;
    }
    
    public static void llistarElements(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }

    public static int demanarEnterUsuari (String missatge){
        do {
            System.out.print(missatge);
            if (teclat.hasNextInt()){
                int valorLeido = teclat.nextInt();
                teclat.nextLine();
                return valorLeido;
            }
            System.out.println("Error! Has d'introduir un valor numéric\n");
            teclat.next();
        } while (true);
    }

    public static int obtenerOpcio () {
        int opcion;
        do {
            String missatge ="Introdueix l'opció [1-3]: ";
            opcion = demanarEnterUsuari(missatge);
            if (opcion < 1 || opcion > 3){
                System.out.println("Error! Has de introduïr un valor entre 1 i 3\n" );
            }
        } while (opcion < 1 || opcion > 3);
        return opcion;
    }

    public static void cambiarElement(String[] array){
        System.out.print("Que elemento quieres modificar? ");
        int num = teclat.nextInt();
        System.out.println("Que quieres cambiar?");
        String frase = teclat.nextLine();
        array[num] = frase;
    }
}
