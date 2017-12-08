package Banco.Personas.Clientes;

public class PaqueteAcciones {
    private int nAcciones;
    private String nombEmpresa;
    private float valorTitulo;


public PaqueteAcciones(int nAcc, String nEmp, float valor){
    this.setnAcciones(nAcc);
    this.setNombEmpresa(nEmp);
    this.setValorTitulo(valor);
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
}
