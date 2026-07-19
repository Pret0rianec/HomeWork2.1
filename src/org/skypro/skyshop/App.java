package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.Article;
import org.skypro.skyshop.search.SearchEngine;

import java.util.Arrays;

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

        SearchEngine searchEngine = new SearchEngine(10);

        searchEngine.add(milk);
        searchEngine.add(egg);
        searchEngine.add(bread);
        searchEngine.add(cheese);
        searchEngine.add(tomato);
        searchEngine.add(tea);

        Article art1 = new Article("Молочные продукты", "Они содержат много кальция");
        Article art2 = new Article("Яйцо птицы", "Яйцо называют «природным поливитаминным комплексом»");
        Article art3 = new Article("Хлеб", "Хлеб - всему голова!");

        searchEngine.add(art1);
        searchEngine.add(art2);
        searchEngine.add(art3);


        System.out.println(Arrays.toString(searchEngine.search("Мол")));
        System.out.println(Arrays.toString(searchEngine.search("Яйцо")));
        System.out.println(Arrays.toString(searchEngine.search("леб")));
    }
}