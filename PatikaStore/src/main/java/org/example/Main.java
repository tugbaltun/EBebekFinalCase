package org.example;

import org.example.enums.BrandName;
import org.example.enums.ProductType;
import org.example.manager.BrandManager;
import org.example.manager.MobilePhoneManager;
import org.example.manager.NotebookManager;
import org.example.manager.PatikaStoreManager;
import org.example.manager.managerImpl.BrandManagerImpl;
import org.example.manager.managerImpl.ProductManagerImpl;
import org.example.model.Brand;
import org.example.model.Notebook;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main  {
    public static void main(String[] args) throws IOException {
//        ProductManagerImpl mobilePhoneManager = new ProductManagerImpl(new MobilePhoneManager());
//        mobilePhoneManager.list();


        ProductManagerImpl notebookManager = new ProductManagerImpl(new NotebookManager());



        PatikaStoreManager patikaStoreManager = new PatikaStoreManager();
        patikaStoreManager.run();
    }
}