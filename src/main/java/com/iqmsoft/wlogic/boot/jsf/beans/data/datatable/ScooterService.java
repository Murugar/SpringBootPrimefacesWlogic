package com.iqmsoft.wlogic.boot.jsf.beans.data.datatable;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class ScooterService {
    private final static String[] colors;

    private final static String[] brands;

    static {
        colors = new String[10];
        colors[0] = "Black";
        colors[1] = "White";
        colors[2] = "Green";
        colors[3] = "Red";
        colors[4] = "Blue";
        colors[5] = "Orange";
        colors[6] = "Silver";
        colors[7] = "Yellow";
        colors[8] = "Brown";
        colors[9] = "Maroon";

        brands = new String[11];
        brands[0] = "Scooty0";
        brands[1] = "Scooty1";
        brands[2] = "Scooty2";
        brands[3] = "Scooty3";
        brands[4] = "Scooty4";
        brands[5] = "Scooty5";
        brands[6] = "Scooty6";
        brands[7] = "Scooty7";
        brands[8] = "Scooty8";
        brands[9] = "Scooty9";
        brands[10] = "SCooty10";
    }

    public List<Scooter> createCars(int size) {
        List<Scooter> list = new ArrayList<>();
        for(int i = 0 ; i < size ; i++) {
            list.add(new Scooter(getRandomId(), getRandomBrand(), getRandomYear(), getRandomColor(), getRandomPrice(), getRandomSoldState()));
        }

        return list;
    }

    private String getRandomId() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

    private int getRandomYear() {
        return (int) (Math.random() * 50 + 1960);
    }

    private String getRandomColor() {
        return colors[(int) (Math.random() * 10)];
    }

    private String getRandomBrand() {
        return brands[(int) (Math.random() * 10)];
    }

    public int getRandomPrice() {
        return (int) (Math.random() * 100000);
    }

    public boolean getRandomSoldState() {
        return (Math.random() > 0.5) ? true: false;
    }

    public List<String> getColors() {
        return Arrays.asList(colors);
    }

    public List<String> getBrands() {
        return Arrays.asList(brands);
    }
}
