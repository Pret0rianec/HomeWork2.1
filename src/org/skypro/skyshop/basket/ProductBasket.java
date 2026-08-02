package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.LinkedList;
import java.util.Iterator;
import java.util.List;

public class ProductBasket {
    private final List<Product> unit;

    public ProductBasket() {
        this.unit = new LinkedList<Product>();
    }

    public void addProduct(Product product) {
        if (product != null) {
            unit.add(product);
        }
    }

    public void removeProduct(Product product) {
        unit.remove(product);
    }

    public List<String> removeProdByName(String name) {
        List<String> removedProducts = new LinkedList<>();
        if (name == null) {
            return removedProducts;
        }
        Iterator<Product> iterator = unit.iterator();
        while (iterator.hasNext()) {
            Product currentProd = iterator.next();
            if (currentProd != null && name.equals(currentProd.getName())) {
                removedProducts.add(currentProd.getName());
                iterator.remove();
            }
        }
        if (removedProducts.isEmpty()) {
            System.out.println("Список пуст");
        } else {
            System.out.println(removedProducts + " - Удалённый товар!");
        }
        return removedProducts;
    }


    public int getTotalPrice() {
        int total = 0;
        for (Product product : unit) {
            total += product.getPrice();
        }
        if (total == 0) {
            System.out.println("стоимость пустой корзины = 0");
        }
        return total;
    }

    public int calculateSpecialProductsCount() {
        int specialProdCount = 0;
        for (Product product : unit) {
            if (product.isSpecial()) {
                specialProdCount++;
            }
        }
        return specialProdCount;
    }

    public void printBasket() {
        if (unit.isEmpty()) {
            System.out.println("в корзине пусто");
            return;
        }
        for (Product product : unit) {
            System.out.println(product);
        }
        System.out.println("Итого: " + getTotalPrice());
        System.out.println("Специальных товаров: " + calculateSpecialProductsCount());
    }

    public boolean searchName(String getName) {
        if (getName == null) {
            return false;
        }
        for (Product product : unit) {
            if (product != null && getName.equals(product.getName())) {
                System.out.println(getName + " = true");
                return true;
            }
        }
        System.out.println(getName + " = false");
        return false;
    }

    public void clearBasket() {
        unit.clear();
    }
}
