package org.multidispenser.multifueldispenser.services;

import org.multidispenser.multifueldispenser.data.models.Fuel;
import org.multidispenser.multifueldispenser.data.models.FuelDispenser;
import org.multidispenser.multifueldispenser.data.repository.FuelRepository;
import org.multidispenser.multifueldispenser.exception.ValidateFuelException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendanceServiceImplementation implements AttendantService{

    @Override
    public void addfuel(Fuel fuel, FuelDispenser fuelDispenser){
        validateFuel(fuel);
        validateDispenser(fuelDispenser);
        fuelDispenser.setFuels(fuel.getName(),fuel);

    }

    protected void validateFuel(Fuel fuel){
        if(fuel==null){
            throw new ValidateFuelException("FUEL HAS NOT BEEN CREATED");
        }
    }

    protected void validateDispenser(FuelDispenser fuelDispenser){
        if(fuelDispenser==null){
            throw new ValidateFuelException("FUEL DISPENSER HAS NOT BEEN CREATED");
        }
    }
}
