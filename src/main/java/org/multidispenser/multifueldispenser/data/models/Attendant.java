package org.multidispenser.multifueldispenser.data.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Document
@Data
@AllArgsConstructor
public class Attendant {
    @Indexed(unique = true)
    private String name;
    private boolean active;
    private List<Transactions> transactions;
}

