package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();

        Product milk = new SimpleProduct("Milk", 110);
        Product egg = new SimpleProduct("Egg", 120);
        Product bread = new SimpleProduct("Bread", 40);
        Product cheese = new SimpleProduct("Cheese", 280);
        Product tomato = new SimpleProduct("Tomato", 230);
        Product tea = new SimpleProduct("Tea", 220);

        Product soap = new FixPriceProduct("Soap");
        Product battery = new DiscountedProduct("Battery", 100, 15);

        basket.addProduct(milk);
        basket.addProduct(egg);
        basket.addProduct(bread);
        basket.addProduct(soap);
        basket.addProduct(battery);
        basket.addProduct(tea);

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