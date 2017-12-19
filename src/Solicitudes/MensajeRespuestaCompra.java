package Solicitudes;

public class MensajeRespuestaCompra extends RespuestaCompraVenta {

    public MensajeRespuestaCompra(int codigoId, String cliente, boolean acceso, int numAcciones, float precioAcciones, float dRestante){
        super(codigoId, cliente, acceso, numAcciones, precioAcciones, dRestante);
    }

    public String codificar (){
        return "Resultado de Compra: " + String.valueOf(getCodigoId()) + "|" + getCliente() + "|" + getAcceso() + "|" + String.valueOf(getNumAcciones()) + "|" + getPrecioAcciones() + "|" + getdRestante();
    }

}
