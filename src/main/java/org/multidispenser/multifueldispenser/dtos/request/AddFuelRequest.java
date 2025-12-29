package org.multidispenser.multifueldispenser.dtos.request;

import lombok.Data;
import org.multidispenser.multifueldispenser.data.models.FuelDispenser;
@Data
public class AddFuelRequest {
    private String FuelType;
    private double fuelPrice;
    private double quantity;
    private FuelDispenser fuelDispenser;
}
