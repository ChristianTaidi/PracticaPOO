package Banco.Personas;

import Excepciones.*;
import java.util.ArrayList;

public class AgenteBolsa extends Persona {

    private ArrayList<Mensaje> solicitudes;
    private Mensaje msg;
    public AgenteBolsa(String nombre, String dni){
        this.setDni(dni);
        this.setNombre(nombre);
        this.solicitudes=new ArrayList();
    }

    public void addSolicitud(int cod,String nombre, float dinero,int nAcc, String emp) throws InvalidCodeException{
        switch (cod) {
            case 1:
                    msg = new MensajeCompra(solicitudes.size(), nombre, dinero, emp);
                break;
            case 2:
                    msg = new MensajeVenta(solicitudes.size(),nombre,nAcc,emp);
                break;
            case 3:
                    msg = new MensajeActualizacion(solicitudes.size(),nombre);
                break;
            default:
                throw new InvalidCodeException("Código de operación erroneo");

        }
        this.solicitudes.add(msg);
    }

    public void ejecutarSolicitudes(){

    }
}
