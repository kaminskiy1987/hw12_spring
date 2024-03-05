package ru.example.hometask_12;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.example.hometask_12.domain.Area;
import ru.example.hometask_12.domain.EquipmentFactory;
import ru.example.hometask_12.domain.Plant;
import ru.example.hometask_12.domain.entities.IMyEquipment;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Configuration
public class PlantInitializator {
    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public static Plant initialize(){
        int areaCount = new Random().nextInt(2,4);
        int equipmentCount = new Random().nextInt(2,10);
        List<Area> areaList = new ArrayList<>();
        
        for (int i = 0; i < areaCount; i++) {
            areaList.add(new Area("plant area " + i));
        }

        for (Area area : areaList) {
            List<IMyEquipment> equipmentList = new ArrayList<>();
            for (int i = 0; i < equipmentCount; i++) {
                area.addEquipment(EquipmentFactory.generateEquipment("ai sensor " + i, area, 1L));
                area.addEquipment(EquipmentFactory.generateEquipment("di sensor " + i, area, 2L));
                area.addEquipment(EquipmentFactory.generateEquipment("motor " + i, area, 3L));
                area.addEquipment(EquipmentFactory.generateEquipment("valve " + i, area, 4L));
            }
        }

        Plant plant = new Plant("fabric " + new Random().nextInt(), areaList);
        return plant;
    }
}
