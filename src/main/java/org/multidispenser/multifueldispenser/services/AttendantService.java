package org.multidispenser.multifueldispenser.services;

import org.multidispenser.multifueldispenser.data.models.Fuel;
import org.multidispenser.multifueldispenser.data.models.FuelDispenser;
import org.springframework.stereotype.Service;

@Service
interface   AttendantService  {

    void addfuel(Fuel fuel, FuelDispenser fuelDispenser);
}
