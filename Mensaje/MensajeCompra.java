package Mensaje;


public class MensajeCompra extends CompraVenta {

    private float dInversion;



    public void setdInversion(float dInversion) {
        this.dInversion = dInversion;
    }

    public float getdInversion() {
        return dInversion;
    }

    public MensajeCompra (int codigoId, String cliente, float dInversion, String nomEmpresa){
        super (codigoId, cliente, nomEmpresa);
        this.setdInversion(dInversion);
    }

    public String serialize(){
        return getCodigoId() + "|" + getCliente() + "|" + getdInversion() + "|" + getnomEmpresa();
    }

    public int ejecutar(){
        int codigoMensaje = 1;

        return codigoMensaje;
    }


}
