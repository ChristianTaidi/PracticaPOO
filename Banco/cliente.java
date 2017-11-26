package Banco;

import java.util.ArrayList;

public class cliente extends persona{

    private float saldo;
    private persona gestor;
    private ArrayList<paqueteAcciones> paquetesDeAcciones;


    public void addGestor(persona g){
        this.gestor=g;
    }
}
