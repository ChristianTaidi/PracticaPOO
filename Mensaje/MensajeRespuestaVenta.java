package Mensaje;

public class MensajeRespuestaVenta extends RespuestaCompraVenta {

    public MensajeRespuestaVenta(int codigoId, String cliente, boolean acceso, int numAcciones, float precioAcciones, float dRestante){
        super(codigoId, cliente, acceso, numAcciones, precioAcciones, dRestante);
    }

    public String serialize (){
        return "Resultado de Venta: " + getCodigoId() + "|" + getCliente() + "|" + getAcceso() + "|" + getNumAcciones() + "|" + getPrecioAcciones() + "|" + getdRestante();
    }
    public int ejecutar(){
        int codigoMensaje = 2;

        return codigoMensaje;
    }
}
