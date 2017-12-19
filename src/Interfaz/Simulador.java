package Interfaz;
import Banco.*;
import Banco.Personas.AgenteBolsa;
import Bolsa.BolsaValores;
import IO.ReadFile;
import IO.WriteFile;
import Excepciones.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Simulador {

    private Bank banco;
    private BolsaValores bolsa;
    private AgenteBolsa broker;
    private File ficheroBanco = new File("banco.dat");
    private File ficheroBolsa = new File("bolsa.dat");

    public Simulador(){
        this.bolsa = new BolsaValores();
        this.broker = new AgenteBolsa("Pedro","76514859G",this.bolsa);
        this.banco = new Bank("Banco Simulador",this.broker);


    }

    public void printMenu(){
        System.out.println("***** MENU *****");
        System.out.println("0.- Salir");
        System.out.println("<<<<< ESTADO >>>>>");
        System.out.println("1.- Imprimir estado de los clientes");
        System.out.println("2.- Imprimir estado de la bolsa");
        System.out.println("<<<<< BANCO >>>>>");
        System.out.println("3.- Añadir cliente");
        System.out.println("4.- Eliminar cliente");
        System.out.println("5.- Realizar copia de seguridad");
        System.out.println("6.- Restaurar copia de seguridad");
        System.out.println("7.- Mejorar cliente a premium");
        System.out.println("8.- Solicitar recomendación de inversión");
        System.out.println("<<<<< BOLSA >>>>>");
        System.out.println("9.- Añadir empresa a la bolsa");
        System.out.println("10.- Eliminar empresa de la bolsa");
        System.out.println("11.- Actualización de valores");
        System.out.println("12.- Realizar copia de seguridad");
        System.out.println("13.- Restaurar copia de seguridad");
        System.out.println("<<<<< OPERACIONES >>>>>");
        System.out.println("14.- Solicitar compra de acciónes");
        System.out.println("15.- Solicitar venta de acciónes");
        System.out.println("16.- Solicitar actualizacion de valores");
        System.out.println("<<<<< BRÓKER >>>>>");
        System.out.println("17.- Imprimir operaciones pendientes");
        System.out.println("18.- Ejecutar operaciones");
    }

    public void backupLoad(String codElem) throws InvalidBackupElementException{
        ReadFile load = new ReadFile();
        File fileAux;
        try {
        switch (codElem) {
            case "banc":
                fileAux = ficheroBanco;

                    load.abrir(fileAux);
                    banco = (Bank) load.read();
                    load.cerrar(fileAux);
                break;
            case "bolsa":
                fileAux = ficheroBolsa;

                    load.abrir(fileAux);
                    bolsa = (BolsaValores) load.read();
                    load.cerrar(fileAux);
                break;
            default:
                throw new InvalidBackupElementException("No se puede hacer copia de seguridad del elemento: " + codElem);
        }
        } catch (IOException e) {
            System.out.println("Error al guardar copia de seguridad");
            e.printStackTrace();
        }
    }

    public void backupSave(String codElem) throws InvalidBackupElementException{
        WriteFile save = new WriteFile();
        File fileAux;
        try {
            switch (codElem) {
                case "banc":

                    fileAux = ficheroBanco;

                    save.abrir(fileAux);
                    save.write(banco);
                    save.cerrar(fileAux);

                    break;
                case "bolsa":
                    fileAux = ficheroBolsa;
                    save.abrir(fileAux);
                    save.write(bolsa);
                    save.cerrar(fileAux);

                    break;
                default:
                    throw new InvalidBackupElementException("No se puede hacer copia de seguridad del elemento: " + codElem);

            }
            }catch (IOException e){
                    System.out.println("Error al guardar copia de seguridad");
                    e.printStackTrace();

        }
    }

    public void printClients() {
        banco.imprimirEstado();
    }

    public void printBolsa() {
        bolsa.imprimirEstado();
    }

    public void addCliente() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca los datos del cliente(Formato -> nombre/dni/saldo inicial)");
        String cadena = sc.nextLine();
        String[] div =cadena.split("/");
    }

    public void addEmpresa(){
        Scanner entrada = new Scanner(System.in);

        System.out.print("Introduzca el numero de empresas desea añadir: ");
        int numeroEmpresas = entrada.nextInt();
        for (int i = 0; i < numeroEmpresas; i++){
            System.out.print("Introduzca el nombre de la empresa: ");
            String nomEmpresa = entrada.nextLine();
            System.out.print("Introduzca el precio de las acciones de la empresa: ");
            float precioAcciones = entrada.nextFloat();

            bolsa.añadirEmpresa(nomEmpresa, precioAcciones);
            System.out.println();
        }
    }

    public void deleteEmpresa (){
        Scanner entrada =  new Scanner(System.in);

        bolsa.imprimirEstado();
        System.out.println();
        System.out.println("Introduzca el nombre de la empresa a borrar: ");
        try {
            bolsa.borrarEmpresa(entrada.nextLine());
            System.out.println("La empresa ha sido borrada con exito");
        } catch (NoSuchEnterpriseException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void updateValores (){
        Scanner entrada =  new Scanner(System.in);

        System.out.print("Realmente desea actualizar los valores (S / N): ");
        char acceso = entrada.next().charAt(0);


        if (acceso == 'S' && acceso == 's'){
            bolsa.actualizarValores();
            System.out.println("Los valores han sido actualizados");
        }
        else {
            System.out.println("Volviendo al menu, hasta la proxima");
        }

    }
}
