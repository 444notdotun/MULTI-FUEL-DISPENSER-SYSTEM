package org.multidispenser.multifueldispenser.dtos.request;

import lombok.Data;

@Data
public class SellFuelRequest {
    private String fuelType;
    private String buyOption;
    private double amount;
    private  double liters;
    private String attendantName;

}
