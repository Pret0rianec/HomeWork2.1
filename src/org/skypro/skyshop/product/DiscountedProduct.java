package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private int basePrice;
    private int discount;

    public DiscountedProduct(String name, int basePrice, int discount) {
        super(name);
        this.basePrice = basePrice;
        this.discount = discount;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public int getDiscount() {return discount;}

    public void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public int getPrice() {
        return getBasePrice() * (100 - getDiscount()) / 100;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice() + " (" + getDiscount() + "%)";
    }
}
