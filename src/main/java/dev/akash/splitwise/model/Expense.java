package dev.akash.splitwise.model;

import dev.akash.splitwise.service.bill_split_strategy.BillSplitStrategy;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Currency;
import java.util.List;
@Getter
@Setter
@Entity
public class Expense extends BaseModel{
    private String description;
    private double amount;
    private LocalDateTime expenseTime;
    private Currency currency; //https://www.xe.com/currency/ list of currency with their code;
    @ManyToOne
    private User addedBy;
    @OneToMany
    private List<UserExpense> userExpenses;

//    private List<User> supposedToPay;
//    private List<SettlementTransaction> balances; // this will store which user has to pay how much
//    private BillSplitStrategy billSplitStrategy;
}
