package Interfaz;
import Banco.*;
import Banco.Personas.AgenteBolsa;
import Bolsa.BolsaValores;
import IO.ReadFile;
import IO.WriteFile;
import Excepciones.*;
import java.io.File;
import java.io.IOException;
public class Simulador {

    private Bank banco;
    private BolsaValores bolsa;
    private AgenteBolsa broker;
    private File ficheroBanco = new File("banco.dat");
    private File ficheroBolsa = new File("bolsa.dat");

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
}
