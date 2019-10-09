package custom_exceptions;

public class ChocolateAllGoneException extends ProductNotFoundException {
    public ChocolateAllGoneException(){
        super();
        System.out.println("Chocolates All Gone");
    }
}
