package Solicitudes;

public class MensajeRespuestaVenta extends RespuestaCompraVenta {

    public MensajeRespuestaVenta(int codigoId, String cliente, boolean acceso, int numAcciones, float precioAcciones, float dRestante){
        super(codigoId, cliente, acceso, numAcciones, precioAcciones, dRestante);
    }

    public String codificar (){
        return "Resultado de Venta: " + String.valueOf(getCodigoId()) + "|" + getCliente() + "|" + getAcceso() + "|" + String.valueOf(getNumAcciones()) + "|" + getPrecioAcciones() + "|" + getdRestante();
    }

}
