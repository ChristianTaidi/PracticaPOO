package Excepciones;

public class InvalidCodeException extends Exception{

    public InvalidCodeException(){
        super();
    }

    public InvalidCodeException(String msg){
        super(msg);
    }
}
