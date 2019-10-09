package vending_machines;

import custom_exceptions.*;
import products.Chocolate;
import products.Products;
import products.SaltySnacks;
import products.SoftDrinks;

public class VendingMachine {
    private int chocolateStock;
    private int saltySanacks;
    private int softDrink;

    public void buy(Products products) throws ProductNotFoundException {


        if (products instanceof Products) {

            if (products instanceof Chocolate) {
                if (this.chocolateStock <= 0) {
                    throw new ChocolateAllGoneException();
                } else {
                    this.chocolateStock--;
                }
            } else if (products instanceof SaltySnacks) {
                if (this.saltySanacks <= 0) {
                    throw new SaltyCracksAllEatenException();
                } else {
                    this.saltySanacks--;
                }
            } else if (products instanceof SoftDrinks) {
                if (this.softDrink <= 0) {
                    throw new SoftDrinkOutOfStockException();
                } else {
                    this.softDrink--;
                }
            } else {
                throw new ProductNotFoundException();
            }

        } else {
            throw new InvalidProductException();
        }
    }

    public void addStock(Products products, int newStock) {

        if (products instanceof Chocolate) {
            this.chocolateStock += newStock;
        }
        if (products instanceof SaltySnacks) {
            this.saltySanacks += newStock;
        }
        if (products instanceof SoftDrinks) {
            this.softDrink += newStock;
        }
    }

    public int getStock() {
        return this.chocolateStock + this.softDrink + this.saltySanacks;
    }
}