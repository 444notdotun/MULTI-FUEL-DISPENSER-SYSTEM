package org.multidispenser.multifueldispenser.data.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.HashMap;

@Getter
public class FuelDispenser {
    private HashMap<String,Fuel> fuels;

    public void setFuels(String name, Fuel fuel) {
        fuels.put(name,fuel);
    }
    private FuelDispenser(){
        fuels = new HashMap<>();
    }
    private static FuelDispenser instance;
    public static FuelDispenser getInstance(){
        if(instance == null){
            instance = new FuelDispenser();
        }
        return instance;
    }

}
