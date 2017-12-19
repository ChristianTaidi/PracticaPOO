package Interfaz;

import Excepciones.InvalidBackupElementException;

import java.util.Scanner;

public class InterfazDeUsuario {

    private Simulador sim;
    private Scanner sc;
    private int option;

    public InterfazDeUsuario(){
        sim = new Simulador();
        sc = new Scanner(System.in);
    };



    public void Ejecutar(){
        do {
            sim.printMenu();
            option = sc.nextInt();
            switch (option) {
                case 1:
                    sim.printClients();
                case 2:
                    sim.printBolsa();
                case 3:
                    sim.addCliente();
                case 4:
                    sim.deleteCliente();
                case 5:
                    try {
                        sim.backupSave("banc");
                    }catch (InvalidBackupElementException e){
                        System.out.println(e.getMessage());
                        e.printStackTrace();
                    }
                case 6:
                    try {
                        sim.backupLoad("banc");
                    }catch(InvalidBackupElementException e){
                        System.out.println(e.getMessage());
                        e.printStackTrace();
                    }
                case 7:
                    sim.mejorarCliente();
                case 8:
                    sim.recomendacion();
                case 9:
                    sim.addEmpresa();
                case 10:
                    sim.deleteEmpresa();
                case 11:
                    sim.updateValores();
                case 12:
                    try {
                        sim.backupSave("bolsa");
                    }catch(InvalidBackupElementException e){
                        System.out.println(e.getMessage());
                        e.printStackTrace();
                    }
                case 13:
                    try {
                        sim.backupLoad("bolsa");
                    }catch(InvalidBackupElementException e){
                        System.out.println(e.getMessage());
                        e.printStackTrace();
                    }
                case 14:
                    sim.solicitarCompra();
                case 15:
                    sim.solicitarVenta();
                case 16:
                    sim.solicitarActualizacion();
                case 17:
                    sim.printOperaciones();
                case 18:
                    sim.ejecutarOperaciones();
                default:
                    System.out.println("Opción no válida: " + option);


            }
        }while (option != 0);
    }
}
