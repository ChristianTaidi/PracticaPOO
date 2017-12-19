package Banco.Personas.Clientes;

import Banco.Personas.Persona;

public class ClientePremium extends Cliente {

    private Persona gestor;

    public ClientePremium(Cliente c, Persona gestor){
        super(c);
        this.setGestor(gestor);
    }

    public void setGestor(Persona g){
        this.gestor=g;
    }
}
