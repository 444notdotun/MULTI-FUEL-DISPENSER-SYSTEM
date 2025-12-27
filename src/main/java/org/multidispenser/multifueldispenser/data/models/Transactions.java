package org.multidispenser.multifueldispenser.data.models;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Transactions {
    private String fuelName;
    private boolean Status;
    private LocalDateTime timeStamp;
    private double amount;
    private String paymentId;
    private double liters;
    private double change;

}
