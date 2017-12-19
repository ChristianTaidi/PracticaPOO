package Solicitudes;

public class MensajeVenta extends CompraVenta  {

    private int numAcciones;

    public void setnumAcciones(int nAcciones) {
        this.numAcciones = nAcciones;
    }

    public int getnumAcciones() {
        return numAcciones;
    }

    public MensajeVenta (int codigoId, String cliente, int numAcciones, String nomEmpresa){
        super(codigoId, cliente, nomEmpresa);
        this.setnumAcciones(numAcciones);
    }

    public String codificar (){
        return String.valueOf(getCodigoId()) + "|" + getCliente() + "|" + String.valueOf(getnumAcciones()) + "|" + getnomEmpresa();
    }

}
