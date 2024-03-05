package ru.example.hometask_12.domain;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.example.hometask_12.PlantInitializator;

import java.util.ArrayList;
import java.util.List;

public class Plant {
    private Long id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Area> areaList;

    public Plant(String name, List<Area> areaList) {
        this.name = name;
        this.areaList = areaList;
    }

    public Plant(String name) {
        this.name = name;
        areaList = new ArrayList<>();
    }

    @Autowired
    public Plant() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Area> getAreaList() {
        return areaList;
    }

    public void setAreaList(List<Area> areaList) {
        this.areaList = areaList;
    }

    public Area addEquipment(Area area){
        this.areaList.add(area);

        return  area;
    }

    public Area removeEquipment(Area area){
        this.areaList.remove(area);
        
        return  area;
    }
}