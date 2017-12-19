package Solicitudes;

public class MensajeRespuestaActualizacion extends MensajeActualizacion {

    public MensajeRespuestaActualizacion (int codigoId){
        super(codigoId);
    }

    public String codificar(){
        return String.valueOf(getCodigoId());
    }

}
