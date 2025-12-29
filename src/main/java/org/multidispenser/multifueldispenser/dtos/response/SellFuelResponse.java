package org.multidispenser.multifueldispenser.dtos.response;

import lombok.Data;
import org.multidispenser.multifueldispenser.data.models.Transactions;
@Data
public class SellFuelResponse {
    private String message;
    private Transactions transaction;
}
