package Banco;

import Banco.Personas.*;
import Banco.Personas.Clientes.*;

import java.io.File;
import java.util.HashMap;

public class bank {

    private String nombre;
    private HashMap<String,cliente>clientes;
    private agenteBolsa agente;
    private File fichero;
    private persona gest = new gestor("01245786J","Antonio");

    public bank(String name,agenteBolsa agente){
        this.setAgenteBolsa(agente);
        this.setNombre(name);
        clientes = new HashMap();
    }

    public void setAgenteBolsa(agenteBolsa agent) {
        this.agente = agent;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void addCliente(String nombre, String dni,float saldo){
        clientes.put(dni,new cliente(nombre,dni,saldo));
    }

    public void deleteCliente(String dni){
        if (clientes.containsKey(dni)){
            clientes.remove(dni);
        }else{

        }
    }

    public void backupSave(){

    }

    public void backupLoad(){

    }

    public void mejorarCliente(String dni){
        if (clientes.containsKey(dni)){
            clientes.put(dni, new ClientePremium(clientes.get(dni),gest));
        }
    }

    public void solicitarRecomendacion(String dni){
        if (clientes.containsKey(dni)){
           if (clientes.get(dni).getClass().getName().equals("ClientePremium")){
                recomendar();
           }
        }else{

        }
    }else{

    }

    public void realizarSolicitud(int cod,String dni, float dinero,int nAcc, String empresa) throws ClientException{

        if (clientes.containsKey(dni)) {
            if (clientes.get(dni).getSaldo() < dinero){
                agente.addSolicitud(cod, clientes.get(dni).getNombre(), dinero,nAcc, empresa);
            }else{
                throw NotEnoughMoneyException("El cliente no tiene suficiente dinero");
            }


        }else {
            throw ClientNotExistsException("El cliente no existe")
        }
    }


}