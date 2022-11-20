package org.example.enums;

import lombok.Getter;

@Getter
public enum BrandName {
    SAMSUNG(0),
    LENOVO(1),
    APPLE(2),
    HUAWEI(3),
    CASPER(4),
    ASUS(5),
    HP(6),
    XIOMI(7),
    MONSTER(8);

    private final int id;
    BrandName(int id){
        this.id=id;
    }
}
