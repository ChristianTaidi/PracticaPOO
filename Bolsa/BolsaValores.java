package Bolsa;

import Excepciones.NoSuchEnterpriseException;
import Solicitudes.Mensaje;
import java.util.Scanner;
import java.util.TreeMap;

import Interfaces.Entidad;
import Solicitudes.MensajeRespuestaActualizacion;
import Solicitudes.MensajeRespuestaCompra;
import Solicitudes.MensajeRespuestaVenta;

public class BolsaValores implements Entidad {
    private TreeMap <String, Empresa> empresas;


    Scanner entrada = new Scanner(System.in);


    public Mensaje recibirSolicitud(String mensaje) {
        Mensaje respuesta;
        try {

            String[] partes = mensaje.split("|");
            int codigoId = Integer.parseInt(partes[0]);

            if ((codigoId % 3) == 0) {
                String cliente = (partes[1]);
                float dInversion = Float.parseFloat(partes[2]);
                String nomEmpresa = (partes[3]);

                float precioAcciones = (empresas.get(nomEmpresa).getPrecioAcciones());

                if (empresas.containsKey(nomEmpresa)) {
                    boolean acceso = (dInversion > precioAcciones);
                    int numAcciones = (int) (precioAcciones / dInversion);
                    float dRestante = dInversion - (numAcciones * precioAcciones);

                    respuesta= new MensajeRespuestaCompra(codigoId, cliente, acceso, numAcciones, precioAcciones, dRestante);
                }

            }

            else if ((codigoId % 3) == 1){
                String cliente = (partes[1]);
                int numAcciones = Integer.parseInt(partes[2]);
                String nomEmpresa = (partes[3]);

                float precioAcciones = (empresas.get(nomEmpresa).getPrecioAcciones());

                if (empresas.containsKey(nomEmpresa)) {
                    float dineroVenta = (precioAcciones * numAcciones);


                    respuesta= new MensajeRespuestaVenta(codigoId, cliente, true, numAcciones, precioAcciones, dineroVenta);
                }
            }

            else if ((codigoId % 3) == 2){
                respuesta= new MensajeRespuestaActualizacion(codigoId);
            }


        } catch (NumberFormatException e){
            System.out.println("Error: Formato de numero incorrecto");
            e.printStackTrace();
        } catch (NullPointerException e){
            System.out.println("Error: Valor numerico nulo");
            e.printStackTrace();
        }
        return respuesta;
    }


    public void imprimirEstado() {
        for (Empresa emp: empresas.values()){
            emp.imprimir();
        }
    }

    public void  añadirEmpresa (String nomEmpresa, float precioAcciones){
        Empresa emp = new Empresa(nomEmpresa, 0 , precioAcciones);
        empresas.put(nomEmpresa, emp);
        System.out.println();
        emp.imprimir();
    }

    public void borrarEmpresa (String nomEmpresa) throws NoSuchEnterpriseException{
        if (empresas.containsKey(nomEmpresa)) {
            empresas.remove(nomEmpresa);
        }

        else {
            throw new NoSuchEnterpriseException("La empresa no existe");
        }
    }

    public void actualizarValores (){
        for (Empresa emp: empresas.values()){
            emp.actualizarValor();
        }
    }


}
