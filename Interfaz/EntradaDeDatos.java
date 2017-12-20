package Interfaz;

import java.util.Scanner;

public class EntradaDeDatos {
    private Scanner entrada = new Scanner(System.in);

    public String leerCadena() {
        return entrada.nextLine();
    }


    public int leerEntero() {
        return entrada.nextInt();
    }

    public float leerFloat(){
        return entrada.nextFloat();
    }

    public char leerCaracter(){
        return entrada.next().charAt(0);
    }
}