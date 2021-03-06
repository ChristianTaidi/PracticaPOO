package Banco.Personas.Clientes;

import Banco.Personas.Persona;

import java.io.Serializable;
import java.util.TreeMap;
import Excepciones.NoSuchEnterpriseException;
import Interfaces.Imprimible;
public class Cliente extends Persona implements Serializable,Imprimible{

    private float saldo;
    private TreeMap<String,PaqueteAcciones> paquetesDeAcciones;



    public Cliente(String nomb, String dni, float saldo){
        this.setDni(dni);
        this.setNombre(nomb);
        this.saldo=saldo;
        this.paquetesDeAcciones = new TreeMap<>();
    }

    public Cliente(Cliente c){
        this.setDni(c.getDni());
        this.setNombre(c.getNombre());
        this.setSaldo(c.getSaldo());
    }

    public int tieneAcciones(String emp) throws NoSuchEnterpriseException{
        if (paquetesDeAcciones.containsKey(emp)){
            return paquetesDeAcciones.get(emp).getnAcciones();
        }else{
            throw new NoSuchEnterpriseException("El cliente no tiene acciones de esa empresa");
        }
    }

    public void setSaldo(float s){
        this.saldo=s;
    }

    public float getSaldo(){
        return this.saldo;
    }


    public void imprimir() {
        System.out.println("Cliente: "+this.getNombre()+" con DNI: "+this.getDni()+" y saldo de: "+this.getSaldo()+"€");
        for (PaqueteAcciones paq: paquetesDeAcciones.values()){
            paq.imprimir();
        }
    }
}
