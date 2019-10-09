package custom_exceptions;

public class ProductNotFoundException extends Exception{
    public ProductNotFoundException(){
        this("Product not found..!");
    }
    public ProductNotFoundException(String s){
        System.out.println("Product not found");
    }
}
