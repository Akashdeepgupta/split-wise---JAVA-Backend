package dev.akash.splitwise.service.bill_split_strategy;

import dev.akash.splitwise.model.Expense;
import dev.akash.splitwise.model.UserExpense;
import dev.akash.splitwise.model.SettlementTransaction;
import dev.akash.splitwise.model.User;

import java.util.*;

public class EqualBillSplitStrategy implements BillSplitStrategy{
    @Override
    public List<SettlementTransaction> toBePaid(List<Expense> expenses) {
        return null;
    }


    public List<SettlementTransaction> toBePaid(List<User> users, List<UserExpense> payees, double totalAmount) {
        List<UserExpense> billPerMember = new ArrayList<>();
        List<SettlementTransaction> payMap = new ArrayList<>();
        PriorityQueue<UserExpense> minHeap = new PriorityQueue<>(
                Comparator.comparingDouble(UserExpense::getAmount)
        );

        PriorityQueue<UserExpense> maxHeap = new PriorityQueue<>(
                Comparator.comparingDouble(UserExpense::getAmount).reversed()
        );
        int n = users.size();
        double billForEachMember = totalAmount/n;

        for (int i = 0; i < n; i++) {
            UserExpense tempPayee = new UserExpense();
            tempPayee.setUser(users.get(i));
            tempPayee.setAmount(billForEachMember);
            billPerMember.add(tempPayee);
        }

        for (int i = 0; i < payees.size(); i++) {
            String tempUserName = payees.get(i).getUser().getName();
            double amountTobeSubtracted = payees.get(i).getAmount();
            for (int j = 0; j < n; j++) {
                String tempUserName1 = billPerMember.get(j).getUser().getName();
                if(tempUserName.equals(tempUserName1)){
                     billPerMember.get(j).setAmount( billPerMember.get(j).getAmount() - amountTobeSubtracted );
                }
            }
        }



        return payMap;
    }
}
