package Interfaz;
import Banco.*;
import IO.ReadFile;
import IO.WriteFile;

import java.io.File;
import java.io.IOException;

public class Simulador {

    private Bank banco;
    private Bolsa bolsa;
    private AgenteBolsa broker;
    private File ficheroBanco = new File("banco.dat");
    private File ficheroBolsa = new File("bolsa.dat");

    public void backupLoad(){
        ReadFile load = new ReadFile();
        try {
            load.abrir(fichero);
            load.leer
            load.cerrar(fichero);
        }catch (IOException e){
            System.out.println("Error al guardar copia de seguridad");
            e.printStackTrace();
        }

    }

    public void backupSave(String codElem){
        WriteFile save = new WriteFile();
        Entidad entityAux;
        File fileAux;
        switch (codElem){
            case "banc":
                entityAux = banco;
                fileAux = ficheroBanco;
                break;
            case "bolsa":
                entityAux = bolsa;
                fileAux = ficheroBolsa;
                break;
            default:
                throw new InvalidBackupElement("No se puede hacer copia de seguridad del elemento: "+codElem);
        try {
            save.abrir(fileAux);
            save.escribir();
            save.cerrar(fileAux);
        }catch (IOException e){
            System.out.println("Error al guardar copia de seguridad");
            e.printStackTrace();
        }
    }
}
