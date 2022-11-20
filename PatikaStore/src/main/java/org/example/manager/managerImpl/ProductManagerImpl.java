package org.example.manager.managerImpl;

import org.example.manager.ProductManager;
import org.example.model.Product;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ProductManagerImpl {

    private final ProductManager productManager;
    public ProductManagerImpl(ProductManager productManager){
        this.productManager = productManager;
    }
    public void menu() throws IOException {
        productManager.menu();
    }
    public void filter() {
        productManager.filter();
    }
    public void filterbyId() {
        productManager.filterById();
    }
    public void list() throws IOException {
        productManager.list();
    }
    public void add() throws IOException{productManager.add();}
    public void delete() {productManager.delete();}

}
