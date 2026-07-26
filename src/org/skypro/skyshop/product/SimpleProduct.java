package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private int regularPrice;

    public SimpleProduct(String name, int regularPrice) {
        if (regularPrice <=0){
            throw new IllegalArgumentException("Цена продукта должна быть строго больше 0");
        }
        super(name);
        this.regularPrice = regularPrice;
    }

    @Override
    public int getPrice() {return regularPrice;}

    @Override
    public boolean isSpecial() {return false;}

    @Override
    public String toString() {
        return getName() + ": " + getPrice();
    }
}