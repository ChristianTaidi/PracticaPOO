package Bolsa;

import java.util.Random;
import Interfaces.Imprimible;

public class Empresa implements Imprimible {
    private String nomEmpresa;
    private int numAcciones;
    private float precioAcciones;
    private float precioAntiguoAcc;
    private float incrementoNum = precioAcciones - precioAntiguoAcc;
    private float incrementoPorcentaje = (precioAcciones / precioAntiguoAcc) * 100;

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

    public void setIncrementoNum (float incrementoNum) {
        this.incrementoNum = incrementoNum;
    }

    public float getIncrementoNum(){
        return incrementoNum;
    }

    public void setIncrementoPorcentaje(float incrementoPorcentaje) {
        this.incrementoPorcentaje = incrementoPorcentaje;
    }

    public float getIncrementoPorcentaje() {
        return incrementoPorcentaje;
    }

    public void actualizarValor (){
        Random random = new Random();
       int valor = random.nextInt(250);
       precioAntiguoAcc = precioAcciones;
       precioAcciones = valor;
    }

    public void imprimir (){
        System.out.println("Datos de la empresa: ");
        System.out.println();
        System.out.println("Nombre de la empresa: " + nomEmpresa);
        System.out.println("Acciones en mercado: " + numAcciones);
        System.out.println("Valor actual de las acciones: " + precioAcciones);
        System.out.println("Valor antiguo de las acciones: " + precioAntiguoAcc);
        if (precioAcciones > precioAntiguoAcc){
            System.out.println("↑ " + incrementoNum + " / " + incrementoPorcentaje);
        }
        else {
            System.out.println("↓ " + incrementoNum + " / " + incrementoPorcentaje);
        }

    }
}
