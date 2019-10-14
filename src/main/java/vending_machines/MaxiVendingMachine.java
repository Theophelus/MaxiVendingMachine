package vending_machines;

import custom_exceptions.*;
import products.Chocolate;
import products.Products;
import products.SaltySnacks;
import products.SoftDrinks;

public class MaxiVendingMachine extends VendingMachine{

    private int softDrink;
    private int saltySnacks;
    private int chocolate;

    @Override
    public void buy(Products products) throws ProductNotFoundException, InvalidProductException {
        super.buy(products);
    }

    //define a Soft drink buy method
    public void buy(SoftDrinks softDrinks) throws ProductNotFoundException{

            if (this.softDrink <= 0){
                throw new SoftDrinkOutOfStockException();
            }else
                this.softDrink--;
    }

    public void buy(SaltySnacks saltySnacks ) throws ProductNotFoundException {

            if (this.saltySnacks <= 0){
                throw new SaltyCracksAllEatenException();
            }
            else
                this.saltySnacks --;
    }
    public void buy(Chocolate chocolate) throws ProductNotFoundException{

            if (this.chocolate <= 0){
                throw new ChocolateAllGoneException();
            }else
                this.chocolate --;
    }


    @Override
    public void addStock(Products products, int newStock)throws InvalidProductException  {
       if (products != null){
           super.addStock(products, newStock);
       }else
           throw new InvalidProductException();
    }

    public void addStock(SoftDrinks softDrinks, int newStock){

            this.softDrink += newStock;
    }
    public void addStock(SaltySnacks saltySnacks, int newStock){

            this.saltySnacks += newStock;

    }
    public void addStock(Chocolate chocolates, int newStock){ this.chocolate += newStock;}

    public int getChocolate(Chocolate chocolate  ) {
            return this.chocolate;
    }
    public int getSoftDrink(SoftDrinks softDrinks) {
            return this.softDrink;
    }
    public int getSaltySnacks(SaltySnacks saltySnacks   ) {
        return this.saltySnacks;
    }

}
