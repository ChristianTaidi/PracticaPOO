package Solicitudes;

public abstract class CompraVenta extends Mensaje {

    private String cliente;
    private String nomEmpresa;

    public CompraVenta (int codigo, String cliente, String nomEmpresa){
        this.setCodigo(codigo);
        this.setCliente(cliente);
        this.setnomEmpresa(nomEmpresa);
    }

    public CompraVenta (int codigo, String cliente){
        this.setCodigo(codigo);
        this.setCliente(cliente);
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getCliente() {
        return cliente;
    }

    public void setnomEmpresa(String nomEmpresa) {
        this.nomEmpresa = nomEmpresa;
    }

    public String getnomEmpresa() {
        return nomEmpresa;
    }

}
