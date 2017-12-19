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

    public String serialize (){
        return getCodigoId() + "|" + getCliente() + "|" + getnumAcciones() + "|" + getnomEmpresa();
    }

    public int ejecutar(){
        int codigoMensaje = 2;

        return codigoMensaje;
    }
}
