package Banco;

import Banco.Personas.*;
import Banco.Personas.Clientes.*;
import Excepciones.*;
import IO.*;
import Solicitudes.Mensaje;
import Solicitudes.MensajeActualizacion;
import Solicitudes.MensajeCompra;
import Solicitudes.MensajeVenta;
import Interfaces.Entidad;

import java.io.File;
import java.io.IOException;
import java.util.TreeMap;

public class Bank implements Entidad {

    private String nombre;
    private TreeMap<String,Cliente>clientes;
    private AgenteBolsa agente;
    private Gestor gest = new Gestor("01245786J","Antonio");
    private int contadorSolicitudes;

    public Bank(String name, AgenteBolsa agente){
        this.setAgenteBolsa(agente);
        this.setNombre(name);
        clientes = new TreeMap<>();
    }

    public int getContadorSolicitudes(){
        return this.contadorSolicitudes;
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

    public void deleteCliente(String dni) throws  InexistentClientException{
        if (clientes.containsKey(dni)){
            clientes.remove(dni);
        }else{
            throw new InexistentClientException("El cliente que desea borrar no existe, si desea añadirlo sleccione la opción <3> del menú");
        }
    }

    public void imprimirEstado(){
        for (Cliente cliente: clientes.values()){
            cliente.imprimir();
        }
    }

    public void mejorarCliente(String dni)throws InexistentClientException{
        if (clientes.containsKey(dni)){
            clientes.put(dni, new ClientePremium(clientes.get(dni),gest));
        }else {
            throw new InexistentClientException("El Cliente no existe");
        }
    }

    public void solicitarRecomendacion(String dni) throws NotPremiumClientException,InexistentClientException{
        if (clientes.containsKey(dni)) {
            if (clientes.get(dni).getClass().getName().equals("ClientePremium")) {
               gest.recomendar();
            } else {
                throw new NotPremiumClientException("El cliente no es premium, para ser premium seleccione la opción <7>");
            }
        }else {
            throw new InexistentClientException("El Cliente no existe, para añadir el cliente seleccione la opción <3>");
        }
    }
    public void realizarSolicitud(int cod,String dni, float dinero,int nAcc, String empresa) throws NoSuchEnterpriseException,NotEnoughActionsException,InvalidCodeException,InexistentClientException,NotEnoughMoneyException{

        if (clientes.containsKey(dni)){
        switch (cod){
            case 0:
                    if (clientes.get(dni).getSaldo()> dinero) {
                        agente.addSolicitud(new MensajeCompra((this.getContadorSolicitudes() * 3) + cod, clientes.get(dni).getNombre(), dinero, empresa));
                    }else{
                        throw new NotEnoughMoneyException("El cliente no tiene saldo para invertir esta cantidad: "+dinero);
                    }
                    break;
            case 1:

                        if (clientes.get(dni).tieneAcciones(empresa) > nAcc) {
                            agente.addSolicitud(new MensajeVenta((this.getContadorSolicitudes() * 3) + cod, clientes.get(dni).getNombre(), nAcc, empresa));
                        } else {
                            throw new NotEnoughActionsException("El cliente tiene menos acciones de las solicitadas para la venta:" + clientes.get(dni).tieneAcciones(empresa));
                        }

                break;
            case 2:
                agente.addSolicitud(new MensajeActualizacion((this.getContadorSolicitudes()*3)+cod));
                break;

            default:
                throw new InvalidCodeException("Fallo a la hora de ejecutar la solicitud, inténtelo de nuevo");
        }



        }else {
            throw new InexistentClientException("El Cliente no existe");
        }
    }
    public void decodificar (String Tomas) {
        String[] vector=Tomas.split("|");
        int codigo=Integer.parseInt(vector[0]);
        if (codigo % 3 == 0){
            String cliente = vector[1];
            float inversion=Float.parseFloat(vector[2]);
            String nombEmpresa = vector[3];//relacionar con cliente xDDD//
        }else if (codigo % 3==1){
            String cliente = vector[1];
            boolean acceso;
            if (vector[2]=="false")
                acceso=false;
            else
                acceso=true;
            int numAcciones =Integer.parseInt(vector[3]);
            float precioAcciones = Float.parseFloat(vector[4]);
            float dineroRestante = Float.parseFloat(vector[5]);
        }else if (codigo % 3==2){
            String nombEmpresa = vector[1];
            float precioAcciones = Float.parseFloat(vector[2]);//preguntar como recorrer esto//


        }


    }

}