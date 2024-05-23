package dev.akash.splitwise.service.bill_split_strategy;

import dev.akash.splitwise.model.Expense;
import dev.akash.splitwise.model.UserExpense;
import dev.akash.splitwise.model.SettlementTransaction;
import dev.akash.splitwise.model.User;

import java.util.List;

public interface BillSplitStrategy {
    List<SettlementTransaction>  toBePaid(List<Expense> expenses);
}
