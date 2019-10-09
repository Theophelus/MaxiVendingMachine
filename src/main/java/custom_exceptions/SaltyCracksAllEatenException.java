package custom_exceptions;

public class SaltyCracksAllEatenException extends ProductNotFoundException {
    public SaltyCracksAllEatenException(){
        super();
        System.out.println( "Salty Snacks All Eaten..!" );
    }
}
