package org.multidispenser.multifueldispenser.services;

import org.multidispenser.multifueldispenser.data.models.Transactions;

public interface FuelDispenserService {
public Transactions dispenseFuel(String fuelType,double amount,String BuyOption);
}
