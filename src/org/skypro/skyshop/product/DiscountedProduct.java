package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private int basePrice;
    private int discount;

    public DiscountedProduct(String name, int basePrice, int discount) {
        if (basePrice <= 0) {
            throw new IllegalArgumentException("Базовая цена продукта должна быть строго больше 0");
        }
        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException("Процент скидки должен быть в диапазоне от 0 до 100 включительно");
        }
        super(name);
        this.basePrice = basePrice;
        this.discount = discount;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public int getDiscount() {
        return discount;
    }

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
