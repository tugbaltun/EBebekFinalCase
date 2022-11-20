package org.example.model;

import lombok.Getter;
import lombok.Setter;
import org.example.enums.BrandName;

@Getter
@Setter
public class Brand {
    private int id;
    private BrandName name;

    public Brand(int id,BrandName name){
        this.id=id;
        this.name=name;
    }
}
