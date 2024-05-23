package dev.akash.splitwise.model;

import dev.akash.splitwise.model.constants.UserExpenseType;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class UserExpense extends BaseModel {
    @ManyToOne
    private User user;
    private double amount;
    @Enumerated
    private UserExpenseType userExpenseType;
}
