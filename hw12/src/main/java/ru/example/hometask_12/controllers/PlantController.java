package ru.example.hometask_12.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.example.hometask_12.domain.Area;
import ru.example.hometask_12.domain.Plant;
import ru.example.hometask_12.domain.entities.*;
import ru.example.hometask_12.services.PlantService;

import java.util.List;

@RestController
@RequestMapping("api")
public class PlantController {
    private final PlantService service;

    @Autowired
    public PlantController(PlantService service) {
        this.service = service;
    }

    @GetMapping("")
    public Plant plant(){
        return service.getPlant();
    }

    @GetMapping("/init")
    public Plant init(){
        service.reInit();

        return  service.getPlant();
    }

    @GetMapping("/area")
    public List<Area> areas(){
        return service.getAreas();
    }

    @GetMapping("/area/{number}")
    public Area area(@PathVariable("number") Integer number){
        System.out.println(number);
        
        return service.getArea(number);
    }

    @GetMapping("/area/{number}/equip")
    public List<IMyEquipment> equipment(@PathVariable("number") Integer number){
        return service.getAreaEquipment(number);
    }

    @GetMapping("/area/{number}/equip/ai")
    public List<IMyEquipment> ailist(@PathVariable("number") Integer number){
        return service.getAreaEquipmentByType(number, AISensor.class);
    }

    @GetMapping("/area/{number}/equip/di")
    public List<IMyEquipment> diList(@PathVariable("number") Integer number){
        return service.getAreaEquipmentByType(number, DISensor.class);
    }

    @GetMapping("/area/{number}/equip/mtr")
    public List<IMyEquipment> mtrList(@PathVariable("number") Integer number){
        return service.getAreaEquipmentByType(number, Motor.class);
    }

    @GetMapping("/area/{number}/equip/vlv")
    public List<IMyEquipment> vlvList(@PathVariable("number") Integer number){
        return service.getAreaEquipmentByType(number, Valve.class);
    }
}