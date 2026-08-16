package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.Article;
import org.skypro.skyshop.search.SearchEngine;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();

        Product milk = new SimpleProduct("Молоко", 110);
        Product egg = new SimpleProduct("Яйцо", 120);
        Product bread = new SimpleProduct("Хлеб", 40);
        Product cheese = new SimpleProduct("Сыр", 280);
        Product tomato = new SimpleProduct("Помидор", 230);
        Product tea = new SimpleProduct("Чай", 220);
        Product pommel = new SimpleProduct("Помело", 420);

        Product soap = new FixPriceProduct("Мыло");
        Product battery = new DiscountedProduct("Батарейка", 100, 15);

        basket.addProduct(milk);
        basket.addProduct(egg);
        basket.addProduct(bread);
        basket.addProduct(soap);
        basket.addProduct(battery);
        basket.addProduct(tea);

        basket.removeProduct(tea);
        basket.removeProdByName("Молоко");
        basket.removeProdByName("Молоток");
        basket.removeProdByName("");

        basket.printBasket();

        basket.getTotalPrice();

        basket.searchName("Яйцо");

        basket.searchName("Сахар");

        basket.clearBasket();

        basket.printBasket();

        basket.getTotalPrice();

        basket.searchName("Яйцо");

        SearchEngine searchEngine = new SearchEngine();

        searchEngine.add(milk);
        searchEngine.add(egg);
        searchEngine.add(bread);
        searchEngine.add(cheese);
        searchEngine.add(tomato);
        searchEngine.add(tea);
        searchEngine.add(pommel);

        Article art1 = new Article("Молочные продукты", "Они содержат много кальция");
        Article art2 = new Article("Яйцо птицы", "Яйцо называют «природным поливитаминным комплексом»");
        Article art3 = new Article("Хлеб", "Хлеб - всему голова!");

//        searchEngine.add(art1);
//        searchEngine.add(art2);
//        searchEngine.add(art3);

        System.out.println(searchEngine.search("о"));
//        System.out.println(searchEngine.search("Яйцо"));
//        System.out.println(searchEngine.search("леб"));

//        searchEngine.findBestElement("Масло");
//        searchEngine.findBestElement("");
//        searchEngine.findBestElement("Яйцо");
    }
}