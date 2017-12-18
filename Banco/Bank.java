package Banco;

import Banco.Personas.*;
import Banco.Personas.Clientes.*;
import Excepciones.*;
import IO.*;

import java.io.File;
import java.io.IOException;
import java.util.TreeMap;

public class Bank extends Entidad{

    private String nombre;
    private TreeMap<String,Cliente>clientes;
    private AgenteBolsa agente;
    private Persona gest = new Gestor("01245786J","Antonio");

    public Bank(String name, AgenteBolsa agente){
        this.setAgenteBolsa(agente);
        this.setNombre(name);
        clientes = new TreeMap<>();
    }

    public void setAgenteBolsa(AgenteBolsa agent) {
        this.agente = agent;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void addCliente(String nombre, String dni,float saldo){
        clientes.put(dni,new Cliente(nombre,dni,saldo));
    }

    public void deleteCliente(String dni){
        if (clientes.containsKey(dni)){
            clientes.remove(dni);
        }else{

        }
    }



    public void mejorarCliente(String dni)throws InexistentClientException{
        if (clientes.containsKey(dni)){
            clientes.put(dni, new ClientePremium(clientes.get(dni),gest));
        }else {
            throw new InexistentClientException("El Cliente no existe");
        }
    }

    public void solicitarRecomendacion(String dni) throws InexistentClientException{
        if (clientes.containsKey(dni)) {
            if (clientes.get(dni).getClass().getName().equals("ClientePremium")) {
               gest.recomendar();

            } else {

            }
        }else {
            throw new InexistentClientException("El Cliente no existe");
        }
    }
    public void realizarSolicitud(int cod,String dni, float dinero,int nAcc, String empresa) throws InexistentClientException,NotEnoughMoneyException{

        if (clientes.containsKey(dni)) {
            if (clientes.get(dni).getSaldo() < dinero){
                try {
                    agente.addSolicitud(cod, clientes.get(dni).getNombre(), dinero, nAcc, empresa);
                }catch(InvalidCodeException e){
                    e.printStackTrace();
                }
            }else{
                throw new NotEnoughMoneyException("El Cliente no tiene suficiente dinero");
            }


        }else {
            throw new InexistentClientException("El Cliente no existe");
        }
    }


}