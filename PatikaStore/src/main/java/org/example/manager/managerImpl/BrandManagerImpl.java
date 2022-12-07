package org.example.manager.managerImpl;
import org.example.enums.BrandName;
import org.example.manager.BrandManager;
import org.example.model.Brand;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BrandManagerImpl implements BrandManager{
    @Override
    public void run() {
        BrandManagerImpl brandManager = new BrandManagerImpl();
        List<Brand> brandList = brandManager.createBrandList();
        brandManager.list(brandList);
    }

    @Override
    public Brand getBrand(int id) {
        BrandManagerImpl brandManager = new BrandManagerImpl();
        List<Brand> brandList = brandManager.createBrandList();
        for(Brand b:brandList){
            if(id==b.getId()){
                return b;
            }
        }
        return null;
    }

    @Override
    public void list(List<Brand> brandList) {
        List<String> brandNames = new ArrayList<>();
        for(Brand b: brandList){
            brandNames.add(b.getName().toString());
        }
        System.out.println("Markalarımız:");
        brandNames = brandNames.stream().sorted().collect(Collectors.toList());
        System.out.println("-------------");
        brandNames.forEach(System.out::println);
        System.out.println("--------------");
    }

    @Override
    public void add(Brand brand) {

    }

    @Override
    public List<Brand> createBrandList() {
        List<Brand> brandList = new ArrayList<>();
        brandList.add(new Brand(1, BrandName.SAMSUNG));
        brandList.add(new Brand(2,BrandName.LENOVO));
        brandList.add(new Brand(3,BrandName.APPLE));
        brandList.add(new Brand(4,BrandName.HUAWEI));
        brandList.add(new Brand(5,BrandName.CASPER));
        brandList.add(new Brand(6,BrandName.ASUS));
        brandList.add(new Brand(7,BrandName.HP));
        brandList.add(new Brand(8,BrandName.XIOMI));
        brandList.add(new Brand(9,BrandName.MONSTER));
        return brandList;
    }


}
