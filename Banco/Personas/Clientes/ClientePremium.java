package Banco.Personas.Clientes;

import Banco.Personas.Clientes.cliente;
import Banco.Personas.persona;

public class ClientePremium extends cliente {

    private persona gestor;

    public ClientePremium(cliente c,persona gestor){
        super(c);
        this.setGestor(gestor);
    }

    public void setGestor(persona g){
        this.gestor=g;
    }
}
