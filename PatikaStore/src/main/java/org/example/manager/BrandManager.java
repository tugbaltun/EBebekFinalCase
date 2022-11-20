package org.example.manager;

import org.example.model.Brand;

import java.util.List;

public interface BrandManager {

    void run();

    Brand getBrand(int id);
    void list(List<Brand> brandList);
    void add(Brand brand);

    List<Brand> createBrandList();
}
