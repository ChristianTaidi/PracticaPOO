package Banco.Personas;

import Bolsa.BolsaValores;
import Excepciones.*;
import Solicitudes.*;

import java.util.ArrayList;

public class AgenteBolsa extends Persona {

    private ArrayList<Mensaje> solicitudes;
    private ArrayList <Mensaje> respuestas;
    private BolsaValores bolsa;

    public BolsaValores getBolsa() {
        return bolsa;
    }

    public void setBolsa(BolsaValores bolsa) {
        this.bolsa = bolsa;
    }

    public AgenteBolsa(String nombre, String dni, BolsaValores bols) {
        this.setDni(dni);
        this.setNombre(nombre);
        this.solicitudes=new ArrayList();
        this.setBolsa(bols);

    }

    public void addSolicitud(Mensaje msg) throws InvalidCodeException{

        this.solicitudes.add(msg);
    }

    public void imprimir(){
        for(Mensaje msg: solicitudes){
            System.out.println(msg.codificar());
        }
    }

    public void ejecutarSolicitudes(){
        for (Mensaje msg:solicitudes){
            Mensaje respuesta = this.getBolsa().recibirSolicitud(msg.codificar());
            respuestas.add(respuesta);

        }
    }
}
