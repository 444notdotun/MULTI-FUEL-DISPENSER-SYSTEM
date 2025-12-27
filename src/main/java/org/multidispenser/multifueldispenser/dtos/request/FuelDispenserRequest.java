package org.multidispenser.multifueldispenser.dtos.request;

import lombok.Data;

@Data
public class FuelDispenserRequest {
    private String FuelType;
    private String buyOption;
    private int amountOption;
}
