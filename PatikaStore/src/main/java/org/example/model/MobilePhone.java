package org.example.model;

import lombok.Getter;
import lombok.Setter;
import org.example.enums.*;

import java.math.BigDecimal;

@Getter
@Setter
public class MobilePhone extends Product {
    private int batteryPower;
    private Color color;


    public MobilePhone(int id, double price, int amountOfStock, String name, BrandName brandName, String memory, String screenSize, String ram) {
        super(id, price, amountOfStock, name, brandName, memory, screenSize, ram);
    }
    public MobilePhone(int id, double price, int amountOfStock, String name, BrandName brandName, String memory, String screenSize, int batteryPower, String ram, Color color) {
        super(id, price, amountOfStock, name, brandName, memory, screenSize, ram);
        this.batteryPower = batteryPower;
        this.color = color;
    }


}
