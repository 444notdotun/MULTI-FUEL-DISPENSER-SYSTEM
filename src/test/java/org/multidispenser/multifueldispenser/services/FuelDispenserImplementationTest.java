package org.multidispenser.multifueldispenser.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.multidispenser.multifueldispenser.data.models.Attendant;
import org.multidispenser.multifueldispenser.data.models.Fuel;
import org.multidispenser.multifueldispenser.data.models.FuelDispenser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class FuelDispenserImplementationTest {
    @Autowired
    AttendantService attendantService;
    Fuel fuel;
    Attendant attendant;
    FuelDispenser fuelDispenser;
//    @Autowired


    @BeforeEach
    public void setUp(){
       fuel = new Fuel("PETROL",500,5000);
       attendant = new Attendant("DOTUN" ,new ArrayList<>());
       fuelDispenser = new FuelDispenser(new HashMap<>());


    }


    @Test
    public void fuelCanBeCreated(){
     assertNotNull(fuel);
    }
    @Test
    public void fuelCanBeCreatedAndAddedToDispenser(){
        assertNotNull(fuel);
        attendantService.addfuel(fuel,fuelDispenser);
        assertNotNull(fuelDispenser.getFuels().get("PETROL"));
    }

    @Test
    public void fuelDispenserCanDispenseFuel(){
        assertNotNull(fuel);
        attendantService.addfuel(fuel,fuelDispenser);
        assertNotNull(fuelDispenser.getFuels().get("PETROL"));

    }

}