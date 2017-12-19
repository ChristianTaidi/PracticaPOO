package Interfaz;

import java.util.Scanner;

public class EntradaDeDatos {
    private Scanner entrada = new Scanner(System.in);

    public String lecturaTeclado (){
        return entrada.nextLine();
    }

    }
