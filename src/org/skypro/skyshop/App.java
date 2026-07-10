package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args){
        ProductBasket basket = new ProductBasket();

        Product milk = new Product("Milk", 110) ;
        Product egg = new Product("Egg", 120) ;
        Product bread = new Product("Bread", 40) ;
        Product cheese = new Product("Cheese", 280) ;
        Product tomato = new Product("Tomato", 230) ;
        Product tea = new Product("Tea", 220) ;

        basket.addProduct(milk) ;
        basket.addProduct(egg) ;
        basket.addProduct(bread) ;
        basket.addProduct(cheese) ;
        basket.addProduct(tomato) ;
        basket.addProduct(tea) ;

        basket.printBasket();

        basket.getTotalPrice();

        basket.searchName("Egg");

        basket.searchName("Sugar");

        basket.clearBasket();

        basket.printBasket();

        basket.getTotalPrice();

        basket.searchName("Egg");
    }
}