package ru.example.hometask_12.domain;

import ru.example.hometask_12.domain.entities.AISensor;
import ru.example.hometask_12.domain.entities.DISensor;
import ru.example.hometask_12.domain.entities.Motor;
import ru.example.hometask_12.domain.entities.Valve;
import ru.example.hometask_12.domain.entities.IMyEquipment;

public class EquipmentFactory {
    public static IMyEquipment generateEquipment(String name, Area area, Long type) {
        IMyEquipment result = null;
        
        switch (type.intValue()) {
            case (1):
                result = new AISensor(name, area.getName(), null);
                break;
            case (2):
                result = new DISensor(name, area.getName(), null);
                break;
            case (3):
                result = new Motor(name, area.getName(), null);
                break;
            case (4):
                result = new Valve(name, area.getName(), null);
                break;
        }
        
        return result;
    }
}
