package vending_machines;

import custom_exceptions.ChocolateAllGoneException;
import custom_exceptions.ProductNotFoundException;
import custom_exceptions.SaltyCracksAllEatenException;
import custom_exceptions.SoftDrinkOutOfStockException;
import products.Chocolate;
import products.SaltySnacks;
import products.SoftDrinks;

public class RunMaxiVendingMachine {

    public static void main(String[] args) {



        MaxiVendingMachine mvm = new MaxiVendingMachine();
        //define instances
        Chocolate chocolate = new Chocolate("Bar One");
        SaltySnacks saltySnacks = new SaltySnacks("Peanuts");
        SoftDrinks softDrinks = new SoftDrinks("Coke");
        //adding products
        mvm.addStock(chocolate,2);
        mvm.addStock(saltySnacks,3);
        mvm.addStock(softDrinks,1);

        //buy products
        try {

            mvm.buy(chocolate);
            mvm.buy(saltySnacks);
            mvm.buy(softDrinks);

        }catch (ChocolateAllGoneException | SaltyCracksAllEatenException | SoftDrinkOutOfStockException ex){
            ex.printStackTrace();
        }catch (ProductNotFoundException ex){
            ex.printStackTrace();
        }

        //get specific counter for each product
        System.out.println("Chocolate(s) available in stock: " + mvm.getChocolate(chocolate));
        System.out.println("Salty Snack(s) available in stock: " + mvm.getSaltySnacks(saltySnacks));
        System.out.println("Soft Drink(s) available in stock: " + mvm.getSoftDrink(softDrinks));

        //get Grand Total of products left:
        int geandTotal = mvm.getChocolate(chocolate) + mvm.getSoftDrink(softDrinks) + mvm.getSaltySnacks(saltySnacks);
        System.out.println("Grand Total: " + geandTotal);
    }

}
