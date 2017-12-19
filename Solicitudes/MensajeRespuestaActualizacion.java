package Solicitudes;

public class MensajeRespuestaActualizacion extends MensajeActualizacion {

    public MensajeRespuestaActualizacion (int codigoId){
        super(codigoId);
    }

    public int ejecutar(){
        int codigoMensaje = 3;

        return codigoMensaje;
    }

}
