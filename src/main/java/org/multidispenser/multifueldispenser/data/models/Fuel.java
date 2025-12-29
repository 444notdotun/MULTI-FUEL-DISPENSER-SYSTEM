package org.multidispenser.multifueldispenser.data.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document
public class Fuel {
    @Indexed(unique = true)
    private String name;
    private double pricePerLiter;
    private double quantity;
}
