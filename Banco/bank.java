package Banco;

import java.util.ArrayList;

public class bank {

    private String nombre;
    private ArrayList<cliente>clientes;
    private cliente agenteBolsa;

    public bank(String name,cliente agente){
        this.setAgenteBolsa(agente);
        this.setNombre(name);
        clientes = new ArrayList<cliente>();
    }

    public void setAgenteBolsa(cliente agenteBolsa) {
        this.agenteBolsa = agenteBolsa;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void addCliente(cliente c){
        clientes.add(c);
    }

    public void backupSave(){

    }

    public void backupLoad(){

    }

    public void mejorarCliente(cliente c, persona g){
        int i=this.clientes.indexOf(c);
        this.clientes.get(i).addGestor(g);
    }

    public void solicitarRecomendacion(cliente c){
        if (clientes.contains(c)){

        }
    }
}