package org.example.service;

import org.example.model.Customer;
import org.example.model.Transaction;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BankingService {

    private List<Customer> customers;

    public BankingService() {
        this.customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public BigDecimal getCustomerBalanceAfterTransactions(Customer customer, int numberOfTransactions) {
        return customer.getTransactions().stream()
                .limit(numberOfTransactions)
                .map(Transaction::getAmount)
                .reduce(customer.getBalance(), BigDecimal::add);
    }

    public Customer getCustomerWithMostTransactions() {
        return customers.stream()
                .max(Comparator.comparingInt(customer -> customer.getTransactions().size()))
                .orElse(null);
    }

}
