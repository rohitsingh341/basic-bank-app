package org.example.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Customer {

    private int customerId = 0;

    private final String name;

    private final BigDecimal balance;
    private List<Transaction> transactions;

    public String getName() {
        return name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }


    public Customer(String name, BigDecimal balance) {
        this.customerId = customerId++;
        this.name = name;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    public void deposit(BigDecimal depositAmount) {
//        balance = balance.add(depositAmount);
        transactions.add(new Transaction(depositAmount));
    }

    public void withdraw(BigDecimal withdrawAmount) {
        if (withdrawAmount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Withdraw amount cannot be less than or equal to zero");
        }

//        balance = balance.subtract(withdrawAmount);
        transactions.add(new Transaction(withdrawAmount.negate()));
    }


}
