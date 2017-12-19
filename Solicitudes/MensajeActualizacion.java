package Solicitudes;

public class MensajeActualizacion extends Mensaje  {

    public MensajeActualizacion (int codigoId){
        this.setCodigo(codigoId);
    }

    public int ejecutar(){
        int codigoMensaje = 3;

        return codigoMensaje;
    }
}
