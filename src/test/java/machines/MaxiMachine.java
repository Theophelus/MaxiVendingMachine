package machines;

import custom_exceptions.ProductNotFoundException;
import custom_exceptions.SoftDrinkOutOfStockException;
import org.junit.jupiter.api.Test;
import products.Chocolate;
import products.Products;
import products.SaltySnacks;
import products.SoftDrinks;
import vending_machines.MaxiVendingMachine;
import vending_machines.VendingMachine;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MaxiMachine {

    MaxiVendingMachine mvm = new MaxiVendingMachine();

    @Test
    public  void addAndBuySoftDrink() throws ProductNotFoundException {

        SoftDrinks coke = new SoftDrinks("Coke");
        //adding a Soft Drink Product
        mvm.addStock(coke, 5);
        // By product and catch exceptions product not found
        try {

            mvm.buy(coke);

        } catch (SoftDrinkOutOfStockException ex){
            ex.printStackTrace();
        }

        assertEquals(4,mvm.getSoftDrink(coke));

    }
    @Test
    public  void addAndBuyChocolate()  {

        Chocolate chocolate = new Chocolate("Bar One");
        //adding a Chocolate Product
        mvm.addStock(chocolate, 7);
        // By product and catch exceptions product not found
        try {
            mvm.buy(chocolate);
            mvm.buy(chocolate);
            mvm.buy(chocolate);
        } catch (SoftDrinkOutOfStockException ex){
            ex.printStackTrace();
        } catch (ProductNotFoundException e){
            e.printStackTrace();
        }
        assertEquals(4, mvm.getChocolate(chocolate));
    }

    @Test
    public  void addAndBuySaltySnacksAndCatchSaltySnacksAllEatenExceptionWhenAllProductsAreBought()  {

        SaltySnacks saltySnacks = new SaltySnacks("Peanuts");
        //adding a Salty Snacks Product
        mvm.addStock(saltySnacks, 3);
        Exception exception = assertThrows( SoftDrinkOutOfStockException.class, () -> mvm.buy(saltySnacks));
        // By product and catch exceptions product not found
        try {
            mvm.buy(saltySnacks);
            mvm.buy(saltySnacks);
            mvm.buy(saltySnacks);
            mvm.buy(saltySnacks);
        } catch (SoftDrinkOutOfStockException ex){
            ex.printStackTrace();
        } catch (ProductNotFoundException e){
            e.printStackTrace();
        }
//        assertEquals(0, mvm.getStock(saltySnacks));
        assertEquals("", exception.getMessage());
    }

    @Test
    public  void addAndBuyDifferentProducts()  {


        SaltySnacks saltySnacks = new SaltySnacks("Peanuts");
        Chocolate chocolate = new Chocolate("Bar One");
        SoftDrinks softDrinks = new SoftDrinks("Coke");
        //adding  Products
        mvm.addStock(saltySnacks, 1);
        mvm.addStock(chocolate, 1);
        mvm.addStock(softDrinks, 1);
        // By product and catch exceptions product not found
        try {

            mvm.buy(saltySnacks);
            mvm.buy(chocolate);
            mvm.buy(softDrinks);
        } catch (SoftDrinkOutOfStockException ex){
            ex.printStackTrace();
        } catch (ProductNotFoundException e){
            e.printStackTrace();
        }

        int getAllStock = mvm.getChocolate(chocolate) + mvm.getSoftDrink(softDrinks) + mvm.getSaltySnacks(saltySnacks);
        System.out.println(getAllStock);
        assertEquals(0, getAllStock);
    }
}
