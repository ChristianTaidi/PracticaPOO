package Excepciones;

public class NotEnoughMoneyException extends Exception {

    public NotEnoughMoneyException(){
        super();
    }

    public NotEnoughMoneyException(String msg){
        super(msg);
    }
}
