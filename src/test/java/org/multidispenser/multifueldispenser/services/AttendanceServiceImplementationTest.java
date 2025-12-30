package org.multidispenser.multifueldispenser.services;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.multidispenser.multifueldispenser.data.models.Attendant;
import org.multidispenser.multifueldispenser.data.models.FuelDispenser;
import org.multidispenser.multifueldispenser.data.repository.AttendantRepository;
import org.multidispenser.multifueldispenser.data.repository.FuelRepo;
import org.multidispenser.multifueldispenser.dtos.request.AddFuelRequest;
import org.multidispenser.multifueldispenser.dtos.request.CreateAttendantRequest;
import org.multidispenser.multifueldispenser.dtos.request.FuelDispenserRequest;
import org.multidispenser.multifueldispenser.dtos.request.SellFuelRequest;
import org.multidispenser.multifueldispenser.exception.ValidateFuelException;
import org.multidispenser.multifueldispenser.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest()

class AttendanceServiceImplementationTest {
    @Autowired
    FuelRepo fuelRepo;
    @Autowired
    AttendantService attendantService;
    Attendant attendant;
    FuelDispenser fuelDispenser;
    AddFuelRequest request;
    @Autowired
    AttendantRepository attendantRepository;

    @Autowired
    FuelDispenserService fuelDispenserService;
    @Autowired
    AdminServices adminServices;


    FuelDispenserRequest fuelDispenserRequest;
    SellFuelRequest sellFuelRequest;
    CreateAttendantRequest createAttendantRequest;



    @BeforeEach
    public void setUp(){
        fuelRepo.deleteAll();
        attendantRepository.deleteAll();

        createAttendantRequest = new CreateAttendantRequest();
        attendant = new Attendant("DOTUN" ,true);
        fuelDispenser = FuelDispenser.getInstance();
        fuelDispenserRequest = new FuelDispenserRequest();
        fuelDispenserRequest.setFuelType("PETROL");
        fuelDispenserRequest.setLitersToBeDischarged(1000);
        sellFuelRequest = new SellFuelRequest();
       sellFuelRequest.setLiters(1000);
       sellFuelRequest.setFuelType("PETROL");
       sellFuelRequest.setBuyOption("liters");
       sellFuelRequest.setAttendantName("dotun");
        createAttendantRequest.setName("dotun");

    }




    @Test
    public void fuelCanBeCreated(){
        request = new AddFuelRequest();
        request.setFuelType("PETROL");
        request.setFuelPrice(500);
        request.setQuantity(5000);
        assertNotNull(Mapper.mapAddFuelRequest(request));
    }
    @Test
    public void fuelCanBeCreatedAndAddedToDispenser(){
        request = new AddFuelRequest();
//        request.setFuelDispenser(fuelDispenser);
        request.setFuelType("PETROL");
        request.setFuelPrice(500);
        request.setQuantity(5000);
        assertNotNull(Mapper.mapAddFuelRequest(request));
        attendantService.addFuel(request);
        assertNotNull(fuelDispenser.getFuels().get("PETROL"));
    }

    @Test
    public void fuelDispenserCanDispenseFuel(){
        request = new AddFuelRequest();
//        request.setFuelDispenser(fuelDispenser);
        request.setFuelType("PETROL");
        request.setFuelPrice(500);
        request.setQuantity(5000);
        assertNotNull(Mapper.mapAddFuelRequest(request));
        attendantService.addFuel(request);
        assertNotNull(fuelDispenser.getFuels().get("PETROL"));
        assertEquals("FUEL DISPENSED SUCCESSFULLY",fuelDispenserService.dispenseFuel(fuelDispenserRequest).getMessage());
        assertEquals(4000,fuelDispenser.getFuels().get(fuelDispenserRequest.getFuelType()).getQuantity());
    }

    @Test
    public void fuelDispenserCannotDispenseFuelThatIsNotAdded(){
            assertThrows(ValidateFuelException.class,()->fuelDispenserService.dispenseFuel(fuelDispenserRequest));
    }
    @Test
    public void DispenserCanNotDispenseWhenWhenFuelQuantityIsZero(){
        request = new AddFuelRequest();
//        request.setFuelDispenser(fuelDispenser);
        request.setFuelType("PETROL");
        request.setFuelPrice(500);
        request.setQuantity(5000);
        assertNotNull(Mapper.mapAddFuelRequest(request));
        request.setQuantity(0);
        attendantService.addFuel(request);
        assertNotNull(fuelDispenser.getFuels().get("PETROL"));
        assertThrows(ValidateFuelException.class,()->fuelDispenserService.dispenseFuel(fuelDispenserRequest));
    }


    @Test
    public void fuelDispenserCanBeSoldFuel(){
        request = new AddFuelRequest();
        request.setFuelType("PETROL");
        request.setFuelPrice(500);
        request.setQuantity(5000);
        assertEquals("welcome! registration successful!",adminServices.createAttendant(createAttendantRequest).getMessage());
        assertNotNull(Mapper.mapAddFuelRequest(request));
        attendantService.addFuel(request);
        assertNotNull(fuelDispenser.getFuels().get("PETROL"));
        assertEquals("THANK YOU FOR YOUR PATRONAGE",attendantService.sellFuel(sellFuelRequest).getMessage());
        assertEquals(4000,fuelDispenser.getFuels().get(fuelDispenserRequest.getFuelType()).getQuantity());
    }

    @Test
    public void fuelDispenserCanBeSellFuelOnAmount(){
        request = new AddFuelRequest();
        request.setFuelType("PETROL");
        request.setFuelPrice(500);
        request.setQuantity(5000);
        assertEquals("welcome! registration successful!",adminServices.createAttendant(createAttendantRequest).getMessage());
        assertNotNull(Mapper.mapAddFuelRequest(request));
        attendantService.addFuel(request);
        assertNotNull(fuelDispenser.getFuels().get("PETROL"));
        sellFuelRequest.setAmount(4000);
        sellFuelRequest.setLiters(0);
        sellFuelRequest.setAttendantName("dotun");
        sellFuelRequest.setBuyOption("amount");
        assertEquals("THANK YOU FOR YOUR PATRONAGE",attendantService.sellFuel(sellFuelRequest).getMessage());
        assertEquals(4992,fuelDispenser.getFuels().get(fuelDispenserRequest.getFuelType()).getQuantity());
    }




}