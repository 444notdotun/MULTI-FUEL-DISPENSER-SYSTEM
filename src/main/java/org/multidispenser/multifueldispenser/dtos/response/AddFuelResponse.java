package org.multidispenser.multifueldispenser.dtos.response;


import lombok.Data;

@Data
public class AddFuelResponse {
private String message;
private double fuelPricePerLiter;
private double fuelQuantity;
}
