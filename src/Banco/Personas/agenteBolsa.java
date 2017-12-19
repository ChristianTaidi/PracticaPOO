package Banco.Personas;

import Banco.Personas.persona;

import java.util.ArrayList;

public class agenteBolsa extends persona {

    private ArrayList<Mensaje> solicitudes;

    public agenteBolsa(String nombre, String dni){
        this.setDni(dni);
        this.setNombre(nombre);
        this.solicitudes=new ArrayList();
    }

    public void addSolicitud(int cod,String nombre, float dinero,int nAcc, String emp){
        switch (cod) {
            case 1:
                Mensaje msg = new MensajeCompra(solicitudes.size(), nombre, dinero, emp);
                break;
            case 2:
                Mensaje msg = new MensajeVenta(solicitudes.size,nombre,nAcc,emp);
                break;
            case 3:
                Mensaje msg = new MensajeActualizacion(solicitudes.size(),nombre);
                break;
            default:
                throw InvalidCodeException;

        }
        this.solicitudes.add(msg);
    }
}
