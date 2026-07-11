package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private int regularPrice;

    public SimpleProduct(String name, int regularPrice) {
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