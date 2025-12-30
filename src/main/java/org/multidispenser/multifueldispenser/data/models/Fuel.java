package org.multidispenser.multifueldispenser.data.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Fuel {
    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private double pricePerLiter;
    private double quantity;

    public Fuel( String name,double pricePerLiter,double quantity){
        this.name=name;
        this.pricePerLiter=pricePerLiter;
        this.quantity=quantity;
    }
}
