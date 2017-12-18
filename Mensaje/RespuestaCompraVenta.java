package Mensaje;

public abstract class RespuestaCompraVenta extends CompraVenta{
    private boolean acceso;
    private int numAcciones;
    private float precioAcciones;
    private float dRestante;

    public RespuestaCompraVenta(int codigoId, String cliente, boolean acceso, int numAcciones, float precioAcciones, float dRestante){
        super(codigoId, cliente);
        this.setAcceso(acceso);
        this.setNumAcciones(numAcciones);
        this.setPrecioAcciones(precioAcciones);
        this.setdRestante(dRestante);
    }

    public String serialize (){
        return getCodigoId() + "|" + getCliente() + "|" + getAcceso() + "|" + getNumAcciones() + "|" + getPrecioAcciones() + "|" + getdRestante();
    }

    public void setAcceso(boolean acceso) {
        this.acceso = acceso;
    }

    public boolean getAcceso(){
        return acceso;
    }

    public void setNumAcciones(int numAcciones) {
        this.numAcciones = numAcciones;
    }

    public int getNumAcciones(){
        return numAcciones;
    }

    public void setPrecioAcciones(float precioAcciones) {
        this.precioAcciones = precioAcciones;
    }

    public float getPrecioAcciones(){
        return precioAcciones;
    }

    public void setdRestante(float dRestante) {
        this.dRestante = dRestante;
    }

    public float getdRestante(){
        return dRestante;
    }
}
