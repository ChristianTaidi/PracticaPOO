package Bolsa;

import java.util.Random;

public class Empresa {
    private String nomEmpresa;
    private int numAcciones;
    private float precioAcciones;
    private float precioAntiguoAcc;
    private float incremento = precioAcciones - precioAntiguoAcc;

    public Empresa (String nomEmpresa, int numAcciones, float precioAcciones){
        this.setNomEmpresa(nomEmpresa);
        this.setNumAcciones(numAcciones);
        this.setPrecioAcciones(precioAcciones);
    }

    public void setNomEmpresa(String nomEmpresa) {
        this.nomEmpresa = nomEmpresa;
    }

    public String getNomEmpresa (){
        return nomEmpresa;
    }

    public void setNumAcciones(int numAcciones) {
        this.numAcciones = numAcciones;
    }

    public int getNumAcciones(){
        return numAcciones;
    }

    public void setPrecioAcciones(float precioAcciones) {
        this.precioAcciones = precioAcciones;
    }

    public float getPrecioAcciones(){
        return precioAcciones;
    }

    public void setPrecioAntiguoAcc(float precioAntiguoAcc) {
        this.precioAntiguoAcc = precioAntiguoAcc;
    }

    public float getPrecioAntiguoAcc (){
        return precioAntiguoAcc;
    }

    public void setIncremento(float incremento) {
        this.incremento = incremento;
    }

    public float getIncremento(){
        return incremento;
    }

    public void actualizarValor (){
        Random random = new Random();
       int valor = random.nextInt(250);
       precioAntiguoAcc = precioAcciones;
       precioAcciones = valor;
    }
}
