package ru.example.hometask_12.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.example.hometask_12.PlantInitializator;
import ru.example.hometask_12.domain.Area;
import ru.example.hometask_12.domain.Plant;
import ru.example.hometask_12.domain.entities.IMyEquipment;

import java.util.List;

@Service
public class PlantService {
    PlantInitializator serviceInitializator;
    private Plant plant;

    @Autowired
    public PlantService( PlantInitializator plantInitializator) {
        this.plant = plantInitializator.initialize();
        serviceInitializator = plantInitializator;
    }

    public void reInit(){
        this.plant = serviceInitializator.initialize();
    }

    public Plant getPlant() {
        return plant;
    }

    public void setPlant(Plant plant) {
        this.plant = plant;
    }

    public List<Area> getAreas(){
        return this.plant.getAreaList();
    }

    public List<Area> setAreas(List<Area> areaList){
        this.plant.setAreaList(areaList);
        return areaList;
    }

    public Area getArea(Integer index){
        Area retValue = this.plant.getAreaList().get(index);
        return retValue;
    }

    public List<IMyEquipment> getAreaEquipment(Integer index){
        List<IMyEquipment> retValue = this.plant.getAreaList().get(index).getEquipmentList();
        return retValue;
    }

    public List<IMyEquipment> getAreaEquipmentByType(Integer index, Class type){
        List<IMyEquipment> retValue = this.plant.getAreaList().get(index).getEquipmentList().stream().filter(i -> i.getClass().equals(type)).toList();
        return retValue;
    }
}