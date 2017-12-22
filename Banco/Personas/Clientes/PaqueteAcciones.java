package Banco.Personas.Clientes;
import Interfaces.Imprimible;
public class PaqueteAcciones implements Imprimible{
    private int nAcciones;
    private String nombEmpresa;
    private float valorTitulo;


public PaqueteAcciones(int nAcc, String nEmp, float valor){
    this.setnAcciones(nAcc);
    this.setNombEmpresa(nEmp);
    this.setValorTitulo(valor);
}

    public String getNombEmpresa(){
        return this.nombEmpresa;
    }
    public int getnAcciones(){
        return this.nAcciones;
    }

    public float getValorTitulo(){
        return this.valorTitulo;
    }
    public void setnAcciones(int nAcciones) {
        this.nAcciones = nAcciones;
    }

    public void setNombEmpresa(String nombEmpresa) {
        this.nombEmpresa = nombEmpresa;
    }

    public void setValorTitulo(float valorTitulo) {
        this.valorTitulo = valorTitulo;
    }

    public float valorPaquete(){
        return this.valorTitulo*this.nAcciones;
    }


    public void actualizarValor( float valor){
        this.setValorTitulo(valor);
    }

    public void imprimir(){
        System.out.println(this.getnAcciones()+" Acciones de la empresa: "+this.getNombEmpresa()+ " por valor de "+this.getValorTitulo()+"€ cada una.");
    }
}
