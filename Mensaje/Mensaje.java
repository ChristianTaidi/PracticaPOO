package Mensaje;

public abstract class  Mensaje  {
    private int codigoId;



    public void setCodigo (int codigoId){
        this.codigoId = codigoId;
    }

    public int getCodigoId() {
        return codigoId;
    }

    public abstract int ejecutar ();


}
