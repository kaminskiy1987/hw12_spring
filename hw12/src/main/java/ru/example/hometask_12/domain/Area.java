package ru.example.hometask_12.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.beans.factory.annotation.Autowired;
import ru.example.hometask_12.domain.entities.*;

import java.util.ArrayList;
import java.util.List;

public class Area{
    private Long id;
    private String name;
    private List<IMyEquipment> equipmentList;

    private List<Area> areaList;

    public Area(String name) {
        this.name = name;
        equipmentList = new ArrayList<>();
    }

    @Autowired
    public Area() {
        this.name = "new Area " + this.hashCode();
        equipmentList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<IMyEquipment> getEquipmentList() {
        return equipmentList;
    }

    public void setEquipmentList(List<IMyEquipment> equipmentList) {
        this.equipmentList = equipmentList;
    }

    public List<Area> getAreaList() {
        return areaList;
    }

    public void setAreaList(List<Area> areaList) {
        this.areaList = areaList;
    }

    public Area addArea(Area area){
        this.areaList.add(area);

        return  area;
    }

    public Area removeAre(Area area){
        if (this.areaList.contains(area)){
            this.areaList.remove(area);
        }

        return  area;
    }

    public IMyEquipment addEquipment(IMyEquipment equipment){
        this.equipmentList.add(equipment);

        return  equipment;
    }

    public IMyEquipment removeEquipment(IMyEquipment equipment){
        if (this.equipmentList.contains(equipment)){
            this.equipmentList.remove(equipment);
        }
        
        return  equipment;
    }
}
