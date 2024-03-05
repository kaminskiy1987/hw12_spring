package ru.example.hometask_12.domain.entities;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.example.hometask_12.domain.Area;

import java.util.Random;

public class Motor implements IMyEquipment {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String area;
    private IMyEquipment partner;

    public Motor(String name, String area, IMyEquipment partner) {
        this.name = name;
        this.area = area;
        this.partner = partner;
    }

    @Autowired
    public Motor(){
        this.name = this.getClass().getName() + new Random().nextInt();
    }
    
    @Override
    public String getLocation() {
        return area;
    }

    @Override
    public String getTag() {
        return name;
    }

    @Override
    public Integer getType() {
        return 3;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public IMyEquipment getPartner() {
        return partner;
    }

    public void setPartner(IMyEquipment partner) {
        this.partner = partner;
    }

    @Override
    public String toString() {
        return "Motor{" +
                "name='" + name + '\'' +
                ", area='" + area + '\'' +
                ", partner=" + partner +
                '}';
    }
}
