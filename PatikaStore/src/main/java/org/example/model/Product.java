package org.example.model;

import lombok.Getter;
import lombok.Setter;
import org.example.enums.BrandName;
import java.util.List;

@Getter
@Setter
public class Product {
    private int id;
    private double price;
    private int amountOfStock;
    private String name;
    private BrandName brandName;
    private String memory;
    private String screenSize;
    private String ram;

    private List<Product> productList;


    public Product(int id, double price, int amountOfStock, String name, BrandName brandName, String memory, String screenSize, String ram) {
        this.id = id;
        this.price = price;
        this.amountOfStock = amountOfStock;
        this.name = name;
        this.brandName = brandName;
        this.memory = memory;
        this.screenSize = screenSize;
        this.ram = ram;
    }

}
