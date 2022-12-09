package org.example.manager;

import org.example.enums.BrandName;
import org.example.enums.Color;
import org.example.model.MobilePhone;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MobilePhoneManager implements ProductManager {
    Scanner input = new Scanner(System.in);
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    private static final List<MobilePhone> phoneList=new ArrayList<>();
    @Override
    public void menu() throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("1- Telefon ekle\n" +
                "2- Telefon listesini görüntüle\n" +
                "3- Telefon sil\n" +
                "4- Telefon id numarasına göre filtrele\n" +
                "5- Telefon markaya göre filtrele");
        System.out.print("Yapmak istediğiniz işlemi seçiniz : ");
        int value=input.nextInt();
        if(value==1) add() ;
        if(value==2) list();
        if(value==3) delete();
        if(value==4) filterById();
        if(value==5) filter();
    }

    @Override
    public void list() {
        print(phoneList);
    }

    @Override
    public void filter() {
        System.out.print("Filtrelemek istediğiniz ürün markasını giriniz :");
        int filter= input.nextInt();
        ArrayList<MobilePhone> filterPhones=new ArrayList<>();
        for (MobilePhone n:phoneList){
            if(filter== n.getBrandName().getId()){
                filterPhones.add(n);
            }
        }
        print(filterPhones);
    }

    @Override
    public void filterById() {
        System.out.print("Filtrelemek istediğiniz ürün id numarası giriniz :");
        int filter= input.nextInt();
        ArrayList<MobilePhone> filterPhones=new ArrayList<>();
        for (MobilePhone n:phoneList){
            if(filter== n.getId()){
                filterPhones.add(n);
            }
        }
        print(filterPhones);
    }

    @Override
    public void add() throws IOException {
        int id;
        if(phoneList.isEmpty())
            id = 1;
        else{
            id = phoneList.get(phoneList.size()-1).getId()+1;
        }
        System.out.print("Ürünün fiyatı : ");
        double price= input.nextDouble();

        System.out.print("Ürünün stoğu : ");
        int amountOfStock= input.nextInt();

        System.out.print("Ürünün adı : ");
        String name=br.readLine();

        System.out.print("Marka Seçiniz : ");
        BrandName brandName = BrandName.HUAWEI;

        System.out.print("Ürünün hafızası :");
        String memory= br.readLine();

        System.out.print("Ürünün ekranı : ");
        String screenSize= br.readLine();

        System.out.print("Pil Gücü : ");
        int batteryPower= input.nextInt();

        System.out.print("Ürünün rami : ");
        String ram= br.readLine();

        System.out.print("Ürünün rami : ");
        Color color = Color.BLUE;

        MobilePhone phone=new MobilePhone(id, price, amountOfStock, name, brandName, memory, screenSize, batteryPower, ram, color);
        phoneList.add(phone);
        System.out.println("Eklenen notebook'un id'si :"+phone.getId());
//        MobilePhone product1= new MobilePhone(1, 3199.0, 5,   "SAMSUNG GALAXY A51", BrandName.SAMSUNG,"128","6.5",4000,"16", Color.BLUE);
//        MobilePhone product2 = new MobilePhone(2,7379.0,10,"iPhone 11 64 GB",BrandName.APPLE,"64","6.1",3046,"8", Color.BLACK);
//        MobilePhone product3 = new MobilePhone(3,4012.0,15,"Redmi Note 10 Pro 8GB",BrandName.XIOMI,"128","6.5",4000,"32", Color.RED);
//        phoneList.add(product1);
//        phoneList.add(product2);
//        phoneList.add(product3);
    }

    @Override
    public void delete() {
        list();
        System.out.print("Silinmesini istediğiniz notebook'un Id numarasını giriniz : ");
        int id=input.nextInt();
        phoneList.remove(id-1);
        System.out.println("Güncel notebook listesi ");
        list();
    }

    private void print(List<MobilePhone> phones){
        System.out.println("\n-----------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Ürün Adı                  | Fiyatı          | Markası         | Stoğu        | Hafızası      | RAM    | Ekran Boyutu      | Pil Gücü   | Renk      |");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");

        for (MobilePhone n:phones){
            System.out.printf("| %-2s | %-25s | %-15s | %-15s | %-12s | %-13s | %-6s | %-17s | %-10s | %-9s | \n",
                    n.getId(),n.getName(),n.getPrice(),n.getBrandName().name(),n.getAmountOfStock(),n.getMemory(), n.getRam(),n.getScreenSize(),n.getBatteryPower(),n.getColor());
        }
        System.out.println();
    }
}
