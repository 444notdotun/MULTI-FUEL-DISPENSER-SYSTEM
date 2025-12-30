package org.multidispenser.multifueldispenser.services;

import org.multidispenser.multifueldispenser.data.models.Fuel;
import org.multidispenser.multifueldispenser.data.models.FuelDispenser;
import org.multidispenser.multifueldispenser.data.models.Transactions;
import org.multidispenser.multifueldispenser.data.repository.FuelRepo;
import org.multidispenser.multifueldispenser.dtos.request.FuelDispenserRequest;
import org.multidispenser.multifueldispenser.dtos.response.FuelDispenserResponse;
import org.multidispenser.multifueldispenser.exception.ValidateFuelDecision;
import org.multidispenser.multifueldispenser.exception.ValidateFuelException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuelDispenserImplementation implements FuelDispenserService {

    FuelDispenser fuelDispenser = FuelDispenser.getInstance();
    @Autowired
    FuelRepo fuelRepo;
    @Override
    public FuelDispenserResponse dispenseFuel(FuelDispenserRequest request) {
        checkForFuel(request);
        Fuel fuel =fuelDispenser.getFuels().get(request.getFuelType());
        checkFuelQuantity(fuel);
        fuel.setQuantity(fuel.getQuantity()-request.getLitersToBeDischarged());
        fuelRepo.save(fuel);
        FuelDispenserResponse response = new FuelDispenserResponse();
        response.setMessage("FUEL DISPENSED SUCCESSFULLY");
        return response;
    }

    private void checkForFuel(FuelDispenserRequest request){
       if(!fuelDispenser.getFuels().containsKey(request.getFuelType())){
           throw new ValidateFuelException("FUEL TYPE NOT AVAILABLE");
       }
    }

    private void checkFuelQuantity(Fuel fuel){
        if(fuel.getQuantity() ==0){
            throw new ValidateFuelException("FUEL TANK IS EMPTY");
        }
    }


}
