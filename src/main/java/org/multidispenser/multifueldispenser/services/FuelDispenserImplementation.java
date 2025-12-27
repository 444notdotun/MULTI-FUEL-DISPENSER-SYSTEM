package org.multidispenser.multifueldispenser.services;

import org.multidispenser.multifueldispenser.data.models.Transactions;
import org.springframework.stereotype.Service;

@Service
public class FuelDispenserImplementation implements FuelDispenserService {
    @Override
    public Transactions dispenseFuel(String fuelType, double amount, String BuyOption) {
        return null;
    }

}
