package Excepciones;

public class InexistentClientException extends Exception {

    public InexistentClientException(){
        super();
    }

    public InexistentClientException(String msg){
        super(msg);
    }
}
