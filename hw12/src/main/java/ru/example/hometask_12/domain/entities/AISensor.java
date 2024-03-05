package ru.example.hometask_12.domain.entities;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import ru.example.hometask_12.domain.Area;
import java.util.Random;

public class AISensor implements IMyEquipment {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String area;

    private IMyEquipment partner;

    public AISensor(String name, String area, IMyEquipment partner) {
        this.name = name;
        this.area = area;
        this.partner = partner;
    }

    @Autowired
    public AISensor(){
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
        return 1;
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
        return "AISensor{" +
                "name='" + name + '\'' +
                ", area='" + area + '\'' +
                ", partner=" + partner +
                '}';
    }
}
