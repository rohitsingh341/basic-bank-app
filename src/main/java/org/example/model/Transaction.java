package org.example.model;

import java.math.BigDecimal;

public class Transaction {
    private int transactionId;
    private final BigDecimal amount;
    private final long timestamp;

    public BigDecimal getAmount() {
        return amount;
    }


    public Transaction(BigDecimal amount) {
        this.transactionId = transactionId++;
        this.amount = amount;
        this.timestamp = System.currentTimeMillis();
    }

}
