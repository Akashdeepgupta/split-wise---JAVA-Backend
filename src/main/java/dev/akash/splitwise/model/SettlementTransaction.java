package dev.akash.splitwise.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Currency;

@Getter
@Setter
@Entity
public class SettlementTransaction extends BaseModel{
    @ManyToOne
    private User fromUser;
    @ManyToOne
    private User toUser;
    private double amount;
    private Currency currency;
}
