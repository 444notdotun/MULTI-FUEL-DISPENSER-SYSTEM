package org.multidispenser.multifueldispenser.services;

import org.multidispenser.multifueldispenser.data.models.Attendant;
import org.multidispenser.multifueldispenser.data.models.Fuel;
import org.multidispenser.multifueldispenser.data.models.FuelDispenser;
import org.multidispenser.multifueldispenser.data.repository.AttendantRepository;
import org.multidispenser.multifueldispenser.data.repository.TransactionRepository;
import org.multidispenser.multifueldispenser.dtos.request.AddFuelRequest;
import org.multidispenser.multifueldispenser.dtos.request.FuelDispenserRequest;
import org.multidispenser.multifueldispenser.dtos.request.SellFuelRequest;
import org.multidispenser.multifueldispenser.dtos.response.AddFuelResponse;
import org.multidispenser.multifueldispenser.data.repository.FuelRepo;
import org.multidispenser.multifueldispenser.dtos.response.SellFuelResponse;
import org.multidispenser.multifueldispenser.exception.ValidateFuelException;
import org.multidispenser.multifueldispenser.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class AttendantServiceImplementation implements AttendantService{
@Autowired
TransactionRepository transactionRepository;
    private final FuelRepo  fuelRepo;
    private final FuelDispenserService fuelDispenserService;
    private final AttendantRepository attendantRepository;
    public AttendantServiceImplementation(FuelRepo  fuelRepo,FuelDispenserService fuelDispenserService,AttendantRepository attendantRepository){
        this.fuelRepo = fuelRepo;
        this.fuelDispenserService=fuelDispenserService;
        this.attendantRepository=attendantRepository;
    }
    FuelDispenser fuelDispenser = FuelDispenser.getInstance();
    FuelDispenserRequest fuelDispenserRequest = new FuelDispenserRequest();

    @Override
    public AddFuelResponse addFuel(AddFuelRequest request) {
        validateDispenser(request);
        Fuel fuel = Mapper.mapAddFuelRequest(request);
        if(isNew(request)){
            fuelDispenser.setFuels(fuel.getName(),fuel);
            fuelRepo.save(fuel);
        }else {
            update(request);
            fuelRepo.save(fuelDispenser.getFuels().get(fuel.getName()));
        }
        return Mapper.mapFuelResponse(Mapper.mapAddFuelRequest(request));
    }

    @Override
    public SellFuelResponse sellFuel(SellFuelRequest request) {
       fuelDispenserRequest.setLitersToBeDischarged( literDeterminant(request));
        validateAmount(request);
        validateLiters(request);
       fuelDispenserRequest.setFuelType(request.getFuelType());
       fuelDispenserService.dispenseFuel(fuelDispenserRequest);
      Mapper.MapSellFuelResponse(request).getTransaction().setStatus(true);
        Mapper.MapSellFuelResponse(request).getTransaction().setPaymentId(generatePaymentId());
      Attendant attendant = attendantRepository.findAttendantsByName(request.getAttendantName());
      attendant.getTransactions().add(Mapper.MapSellFuelResponse(request).getTransaction());
      attendantRepository.save(attendant);
      transactionRepository.save(Mapper.MapSellFuelResponse(request).getTransaction());
      return Mapper.MapSellFuelResponse(request);
    }
    private void validateDispenser(AddFuelRequest request){
        if(fuelDispenser==null){
            throw new ValidateFuelException("FUEL DISPENSER HAS NOT BEEN CREATED");
        }
    }

    private boolean isNew(AddFuelRequest request){
        return !fuelDispenser.getFuels().containsKey(request.getFuelType());
    }
    private void update(AddFuelRequest request){
        fuelDispenser.getFuels().replace(request.getFuelType(), Mapper.mapAddFuelRequest(request));
    }

    private double literDeterminant(SellFuelRequest request){
        String option = request.getBuyOption().toLowerCase();
        double result = 0;
        switch (option){
            case "amount"->{
                result = request.getAmount()/fuelRepo.findByNameIgnoreCase(request.getFuelType()).getPricePerLiter();
                request.setLiters(result);
            }
            case "liters"->{
                result = request.getLiters();
                request.setAmount(result*fuelRepo.findByNameIgnoreCase(request.getFuelType()).getPricePerLiter());
            }
        }
        return result;
    }

    private void validateAmount(SellFuelRequest request){
        if(request.getAmount()<fuelRepo.findByNameIgnoreCase(request.getFuelType()).getPricePerLiter()){
            throw new ValidateFuelException("Amount must be greater than or equal to pricePerLiters");
        }
    }

    private void validateLiters(SellFuelRequest request){
        if(request.getLiters()<=0||request.getLiters()>fuelRepo.findByNameIgnoreCase(request.getFuelType()).getQuantity()){
            throw new ValidateFuelException("liter must be greater than  zero or less than the available");
        }
    }

    private String  generatePaymentId(){
        SecureRandom secureRandom= new SecureRandom();
      return "PAYID-"+secureRandom.nextLong(100,999);
    }
}
