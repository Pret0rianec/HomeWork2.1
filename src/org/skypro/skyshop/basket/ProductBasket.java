package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private Product[] unit;
    private int size;

    public ProductBasket() {
        this.unit = new Product[5];
        this.size = 0;
    }

    public void addProduct(Product product) {
        if (product == null) {
            return;
        }
        if (size >= unit.length) {
            System.out.println("Невозможно добавить продукт");
            return;
        }
        unit[size] = product;
        size++;
    }

    public int getTotalPrice() {
        int total = 0;

        for (int i = 0; i < size; i++) {
            total += unit[i].getPrice();
        }
        if (total == 0) {
            System.out.println("стоимость пустой корзины = 0");
        }
        return total;
    }

    public void printBasket() {
        if (size == 0) {
            System.out.println("в корзине пусто");
            return;
        }
        int specialProdCount = 0;

        for (int i = 0; i < size; i++) {
            Product product = unit[i];
            System.out.println(product);
            if (product.isSpecial()) {
                specialProdCount++;
            }
        }
        System.out.println("Итого: " + getTotalPrice());
        System.out.println("Специальных товаров: " + specialProdCount);
    }

    public boolean searchName(String getName) {
        if (getName == null) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (unit[i] != null && getName.equals(unit[i].getName())) {
                System.out.println(getName + " = true");
                return true;
            }
        }
        System.out.println(getName + " = false");
        return false;
    }

    public void clearBasket() {
        for (int i = 0; i < unit.length; i++) {
            unit[i] = null;
        }
        size = 0;
    }
}
