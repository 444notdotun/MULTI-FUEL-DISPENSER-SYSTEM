package org.multidispenser.multifueldispenser.services;

import org.multidispenser.multifueldispenser.data.models.FuelDispenser;
import org.multidispenser.multifueldispenser.data.models.Transactions;
import org.multidispenser.multifueldispenser.dtos.request.FuelDispenserRequest;
import org.multidispenser.multifueldispenser.dtos.response.FuelDispenserResponse;
import org.springframework.stereotype.Service;

@Service
public interface FuelDispenserService {
    FuelDispenserResponse dispenseFuel(FuelDispenserRequest request);
}
