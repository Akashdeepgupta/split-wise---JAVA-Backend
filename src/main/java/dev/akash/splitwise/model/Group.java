package dev.akash.splitwise.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity(name = "SPLITWISE_GROUP")
public class Group extends BaseModel{
    private String name;
    @ManyToOne
    private User admin;
    @ManyToMany
    private List<User> members;
    @OneToMany
    private List<Expense> expenses;
    @OneToMany
    private List<SettlementTransaction> paymentMappings;
    private double totalAmountSpent;
    private LocalDateTime createdAt;

}

/*
    Group - Admin(User)
     1    -   1
     m    -   1

     Group - memebrs
        1   -  M
        M   -  1

     Group - Expense
        1  -   M
        1   -   1
 */
