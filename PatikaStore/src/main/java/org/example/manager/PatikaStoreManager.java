package org.example.manager;

import org.example.manager.managerImpl.BrandManagerImpl;
import org.example.manager.managerImpl.ProductManagerImpl;
import java.io.IOException;
import java.util.Scanner;

public class PatikaStoreManager {
    Scanner input = new Scanner(System.in);
    ProductManagerImpl productManager;
    public void run() throws IOException {
        while (true) {
            System.out.println("PatikaStore Ürün Yönetim Paneli !");
            System.out.println(
                    " 1 - Notebook İşlemleri\n" +
                    " 2 - Cep Telefonu İşlemleri\n" +
                    " 3 - Marka Listele\n" +
                    " 4 - Çıkış Yap"
            );
            System.out.print("Yapmak istediğiniz işlem numarasını seçiniz : ");

            switch (input.nextInt()) {
                case 1:
                    productManager = new ProductManagerImpl(new NotebookManager());
                    productManager.menu();
                    break;
                case 2:
                    productManager = new ProductManagerImpl(new MobilePhoneManager());
                    productManager.menu();
                    break;
                case 3:
                    BrandManagerImpl brandManager = new BrandManagerImpl();
                    brandManager.run();
                    break;
                case 4:
                    System.out.println("Çıkış yapılıyor.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Yanlış değer girdiniz.");
                    break;
            }
        }
    }
}
