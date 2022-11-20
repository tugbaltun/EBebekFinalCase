package org.example.model;

import lombok.Getter;
import lombok.Setter;
import org.example.enums.BrandName;

import java.math.BigDecimal;

@Getter
@Setter
public class Notebook extends Product {
    private double discountRate;

    public Notebook(int id, double price, int amountOfStock, String name, BrandName brandName, String memory, String screenSize, String ram) {
        super(id, price, amountOfStock, name, brandName, memory, screenSize, ram);
    }

    public Notebook(int id, double price, int discountRate, int amountOfStock, String name, BrandName brandName, String memory, String screenSize, String ram) {
        super(id, price, amountOfStock, name, brandName, memory, screenSize, ram);
        this.discountRate = discountRate;
    }
}
