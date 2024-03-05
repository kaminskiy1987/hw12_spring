package ru.example.hometask_12.domain.entities;

import ru.example.hometask_12.domain.Area;
import java.io.Serializable;

public interface IMyEquipment extends Serializable {
    String getLocation();
    String getTag();
    Integer getType();

    String toString();
}
