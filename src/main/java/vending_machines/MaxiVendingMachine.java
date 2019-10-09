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
    //define a Soft drink buy method
    public void buy(SoftDrinks softDrinks) throws ProductNotFoundException {
        if (softDrinks != null){
            if (this.softDrink <= 0){
                throw new SoftDrinkOutOfStockException();
            }else
                this.softDrink--;
        }

    }

    public void buy(SaltySnacks saltySnacks ) throws ProductNotFoundException{
        if (saltySnacks != null){
            if (this.saltySnacks <= 0){
                throw new SaltyCracksAllEatenException();
            }
            else
                this.saltySnacks --;
        }
    }
    public void buy(Chocolate chocolate) throws ProductNotFoundException {

        if (chocolate !=null){
            if (this.chocolate <= 0){
                throw new ChocolateAllGoneException();
            }else
                this.chocolate --;
        }
    }


    @Override
    public void buy(Products products) throws InvalidProductException {
        throw new InvalidProductException();
    }


    public void addStock(SoftDrinks softDrinks, int newStock){

        if (softDrinks !=null){
            this.softDrink += newStock;
        }

    }
    public void addStock(SaltySnacks saltySnacks, int newStock){

        if (saltySnacks !=null){
            this.saltySnacks += newStock;
        }

    }
    public void addStock(Chocolate chocolates, int newStock){

        if (chocolates !=null){
            this.chocolate += newStock;
        }
    }

    public int getChocolate(Chocolate chocolate  ) {
        if (chocolate instanceof Chocolate) {
            return this.chocolate;
        }else{
        return 0;
        }
    }
    public int getSoftDrink(SoftDrinks softDrinks) {
        if (softDrinks instanceof SoftDrinks) {
            return this.softDrink;
        }else{
            return 0;
        }
    }

    public int getSaltySnacks(SaltySnacks saltySnacks   ) {
        if (saltySnacks instanceof SaltySnacks) {
            return chocolate;
        }else{
            return 0;
        }
    }
}
