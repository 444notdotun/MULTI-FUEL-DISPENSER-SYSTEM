package org.multidispenser.multifueldispenser.utils;

import org.apache.catalina.deploy.NamingResourcesImpl;
import org.jspecify.annotations.Nullable;
import org.multidispenser.multifueldispenser.data.models.Fuel;
import org.multidispenser.multifueldispenser.data.models.Transactions;
import org.multidispenser.multifueldispenser.dtos.request.AddFuelRequest;
import org.multidispenser.multifueldispenser.dtos.request.SellFuelRequest;
import org.multidispenser.multifueldispenser.dtos.response.AddFuelResponse;
import org.multidispenser.multifueldispenser.dtos.response.SellFuelResponse;

public class Mapper {
    public static Fuel mapAddFuelRequest(AddFuelRequest request) {
        if (request == null) return null;
        return new Fuel(request.getFuelType(), request.getFuelPrice(), request.getQuantity());
    }

    public static SellFuelResponse MapSellFuelResponse(SellFuelRequest request) {
        if (request == null) return null;
        SellFuelResponse response = new SellFuelResponse();
        Transactions transaction = new Transactions();
        transaction.setFuelName(request.getFuelType());
        transaction.setAmount(request.getAmount());
        transaction.setLiters(request.getLiters());
        transaction.setAttendantName(request.getAttendantName());
        transaction.setStatus(false);
        response.setTransaction(transaction);
        response.setMessage("THANK YOU FOR YOUR PATRONAGE");
        return response;
    }

    public static AddFuelResponse mapFuelResponse(Fuel fuel) {
        if (fuel == null) return null;
        AddFuelResponse response = new AddFuelResponse();
        response.setMessage("FUEL ADDED SUCCESSFULLY");
        response.setFuelPricePerLiter(fuel.getPricePerLiter());
        response.setFuelQuantity(fuel.getQuantity());
        return response;
    }
}
