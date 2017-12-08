package Banco.Personas.Clientes;

import Banco.Personas.Persona;

import java.io.Serializable;
import java.util.ArrayList;

public class Cliente extends Persona implements Serializable{

    private float saldo;
    private Persona gestor;
    private ArrayList<PaqueteAcciones> paquetesDeAcciones;



    public Cliente(String nomb, String dni, float saldo){
        this.setDni(dni);
        this.setNombre(nomb);
        this.saldo=saldo;
    }

    public Cliente(Cliente c){
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
