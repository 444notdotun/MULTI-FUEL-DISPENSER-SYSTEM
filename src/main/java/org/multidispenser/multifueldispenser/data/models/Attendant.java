package org.multidispenser.multifueldispenser.data.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
@Document
@Data
public class Attendant {
    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private boolean active;
    private List<Transactions> transactions;

    public Attendant(String name,boolean active) {
        this.active=active;
        this.name=name;
        this.transactions = new ArrayList<>();
    }
}

