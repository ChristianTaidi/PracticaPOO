package Banco.Personas.Clientes;

import Banco.Personas.persona;

import java.io.Serializable;
import java.util.ArrayList;

public class cliente extends persona implements Serializable{

    private float saldo;
    private persona gestor;
    private ArrayList<paqueteAcciones> paquetesDeAcciones;



    public cliente(String nomb,String dni,float saldo){
        this.setDni(dni);
        this.setNombre(nomb);
        this.saldo=saldo;
    }

    public cliente(cliente c){
        this.setDni(c.getDni());
        this.setNombre(c.getNombre());
        this.setSaldo(c.getSaldo());
    }

    public void setSaldo(float s){
        this.saldo=s;
    }

    public float getSaldo(){
        return this.saldo;
    }



}
