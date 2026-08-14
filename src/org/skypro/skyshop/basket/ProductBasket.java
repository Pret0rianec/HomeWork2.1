package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private final Map<String, List<Product>> unit;

    public ProductBasket() {
        this.unit = new HashMap<>();
    }

    public void addProduct(Product product) {
        if (product != null && product.getName() != null) {
            unit.computeIfAbsent(product.getName(), k -> new LinkedList<>()).add(product);
        }
    }

    public void removeProduct(Product product) {
        if (product == null || product.getName() == null) {
            return;
        }
        List<Product> products = unit.get(product.getName());
        if (products != null) {
            products.remove(product);
            if (products.isEmpty()) {
                unit.remove(product.getName());
            }
        }
    }

    public List<Product> removeProdByName(String name) {
        List<Product> removedProducts = new LinkedList<>();
        if (name == null) {
            return removedProducts;
        }
        List<Product> products = unit.remove(name);
        if (products != null) {
            removedProducts.addAll(products);
        }

//        Iterator<Product> iterator = unit.iterator();
//        while (iterator.hasNext()) {
//            Product currentProd = iterator.next();
//            if (currentProd != null && name.equals(currentProd.getName())) {
//                removedProducts.add(currentProd);
//                iterator.remove();
//            }
//        }

        if (removedProducts.isEmpty()) {
            System.out.println("Товар с именем '" + name + "' не найден в корзине.");
        } else {
            System.out.println("Удалено товаров (" + name + "): " + removedProducts.size() + " шт.");
        }
        return removedProducts;
    }

    public int getTotalPrice() {
        int total = 0;
        for (List<Product> productList : unit.values()) {
            for (Product product : productList) {
                total += product.getPrice();
            }
        }
        if (total == 0) {
            System.out.println("стоимость пустой корзины = 0");
        }
        return total;
    }

    public int calculateSpecialProductsCount() {
        int specialProdCount = 0;
        for (List<Product> productList : unit.values()) {
            for (Product product : productList) {
                if (product.isSpecial()) {
                    specialProdCount++;
                }
            }
        }
        return specialProdCount;
    }

    public void printBasket() {
        if (unit.isEmpty()) {
            System.out.println("в корзине пусто");
            return;
        }
        for (List<Product> productList : unit.values()) {
            for (Product product : productList) {
                System.out.println(product);
            }
            System.out.println("Итого: " + getTotalPrice());
            System.out.println("Специальных товаров: " + calculateSpecialProductsCount());
        }
    }

    public boolean searchName(String getName) {
        if (getName == null) {
            return false;
        }
        if (unit.containsKey(getName)) {
            System.out.println(getName + " = true");
            return true;
        }
        System.out.println(getName + " = false");
        return false;
    }

    public void clearBasket() {
        unit.clear();
    }
}
