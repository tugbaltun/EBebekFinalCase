package org.example;

import org.example.manager.PatikaStoreManager;
import java.io.IOException;

public class Main  {
    public static void main(String[] args) throws IOException {

        PatikaStoreManager patikaStoreManager = new PatikaStoreManager();
        patikaStoreManager.run();
    }
}