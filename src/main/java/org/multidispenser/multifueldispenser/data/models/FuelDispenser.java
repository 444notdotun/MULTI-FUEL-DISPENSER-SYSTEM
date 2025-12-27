package org.multidispenser.multifueldispenser.data.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
@Data
@AllArgsConstructor
public class FuelDispenser {
    private HashMap<String,Fuel> fuels;

    public void setFuels(String name, Fuel fuel) {
        fuels.put(name,fuel);
    }
}
