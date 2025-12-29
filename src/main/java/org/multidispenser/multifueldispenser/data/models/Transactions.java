package org.multidispenser.multifueldispenser.data.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class Transactions {
    private String fuelName;
    private boolean Status;
    private LocalDateTime timeStamp;
    private double amount;
    private String paymentId;
    private double liters;
    private double change;

    public Transactions(){
        this.timeStamp = LocalDateTime.now();
    }
}
