package Solicitudes;

public class MensajeRespuestaCompra extends RespuestaCompraVenta {

    public MensajeRespuestaCompra(int codigoId, String cliente, boolean acceso, int numAcciones, float precioAcciones, float dRestante){
        super(codigoId, cliente, acceso, numAcciones, precioAcciones, dRestante);
    }

    public String serialize (){
        return "Resultado de Compra: " + getCodigoId() + "|" + getCliente() + "|" + getAcceso() + "|" + getNumAcciones() + "|" + getPrecioAcciones() + "|" + getdRestante();
    }
    public int ejecutar(){
        int codigoMensaje = 1;

        return codigoMensaje;
    }
}
