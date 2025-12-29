package org.multidispenser.multifueldispenser.services;

import org.multidispenser.multifueldispenser.dtos.request.AddFuelRequest;
import org.multidispenser.multifueldispenser.dtos.request.SellFuelRequest;
import org.multidispenser.multifueldispenser.dtos.response.AddFuelResponse;
import org.multidispenser.multifueldispenser.dtos.response.SellFuelResponse;
import org.springframework.stereotype.Service;

@Service
interface   AttendantService  {
    AddFuelResponse addFuel(AddFuelRequest request);
    SellFuelResponse sellFuel(SellFuelRequest request);

}
