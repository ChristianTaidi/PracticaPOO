package Solicitudes;

public abstract class  Mensaje  {
    private int codigoId;



    public void setCodigo (int codigoId){
        this.codigoId = codigoId;
    }

    public int getCodigoId() {
        return codigoId;
    }

    public abstract String codificar ();


}
