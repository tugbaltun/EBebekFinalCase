package org.example.manager;

import org.example.enums.BrandName;
import org.example.model.Notebook;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NotebookManager implements ProductManager {
    Scanner input = new Scanner(System.in);
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    private static final List<Notebook> notebookList=new ArrayList<>();
    @Override
    public void menu() throws IOException{
        Scanner input = new Scanner(System.in);
        System.out.println("1- Notebook ekle\n" +
                "2- Notebook listesini görüntüle\n" +
                "3- Notebook sil\n" +
                "4- Notebook id numarasına göre filtrele\n" +
                "5- Notebook markaya göre filtrele");
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
        print(notebookList);
    }

    @Override
    public void filter() {
        System.out.print("Filtrelemek istediğiniz ürün markasını giriniz :");
        int filter= input.nextInt();
        ArrayList<Notebook> filterNotebooks=new ArrayList<>();
        for (Notebook n:notebookList){
            if(filter== n.getBrandName().getId()){
                filterNotebooks.add(n);
            }
        }
        print(filterNotebooks);
    }

    @Override
    public void filterById() {
        System.out.print("Filtrelemek istediğiniz ürün id numarasını giriniz :");
        int filter= input.nextInt();
        ArrayList<Notebook> filterNotebooks=new ArrayList<>();
        for (Notebook n:notebookList){
            if(filter== n.getId()){
                filterNotebooks.add(n);
            }
        }
        print(filterNotebooks);
    }

    @Override
    public void add() throws IOException {
        int id;
        if(notebookList.isEmpty())
            id = 1;
        else{
            id = notebookList.get(notebookList.size()-1).getId()+1;
        }
        System.out.print("Ürünün fiyatı : ");
        double price= input.nextDouble();

        System.out.print("Ürünün indirim oranı : ");
        int discountRate= input.nextInt();

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

        System.out.print("Ürünün rami : ");
        String ram= br.readLine();

        Notebook notebook=new Notebook(id, price, discountRate,amountOfStock, name, brandName, screenSize, ram, memory);
        notebookList.add(notebook);
        System.out.println("Eklenen notebook'un id'si :"+notebook.getId());
//        Notebook product1= new Notebook(1, 7000.0, 5,  5, "HUAWEI Matebook 14 ", BrandName.HUAWEI,"512","14","16");
//        Notebook product2 = new Notebook(2,3699.0,10,2,"LENOVO V14 IGL",BrandName.LENOVO,"1024","14","8");
//        Notebook product3 = new Notebook(3,8199.0,15,1,"ASUS Tuf Gaming",BrandName.ASUS,"2048","15.6","32");
//        notebookList.add(product1);
//        notebookList.add(product2);
//        notebookList.add(product3);
    }

    @Override
    public void delete() {
        list();
        System.out.print("Silinmesini istediğiniz notebook'un Id numarasını giriniz : ");
        int id=input.nextInt();
        notebookList.remove(id-1);
        System.out.println("Güncel notebook listesi ");
        list();
    }

    private void print(List<Notebook> notebooks){
        System.out.println("\n----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Ürün Adı                  | Fiyatı          | Markası         | Stoğu        | İndirim Oranı      | RAM    | Ekran Boyutu      | Hafızası   |");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");

        for (Notebook n:notebooks){
            System.out.printf("| %-2s | %-25s | %-15s | %-15s | %-12s | %-18s | %-6s | %-17s | %-10s | \n",
                    n.getId(),n.getName(),n.getPrice(),n.getBrandName().name(),n.getAmountOfStock(),
                    n.getDiscountRate(),n.getRam(),n.getScreenSize(),n.getMemory());
        }
        System.out.println();
    }
}
