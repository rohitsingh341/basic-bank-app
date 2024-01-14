package org.example;


import org.example.model.Customer;
import org.example.service.BankingService;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        BankingService bank = new BankingService();

        Customer alice = new Customer("Alice", new BigDecimal("1000"));
        Customer bob = new Customer("Bob", new BigDecimal("500"));
        Customer rohit = new Customer("Rohit", new BigDecimal("2500"));

        bank.addCustomer(alice);
        bank.addCustomer(bob);
        bank.addCustomer(rohit);

        alice.deposit(new BigDecimal("200"));
        bob.deposit(new BigDecimal("300"));
        rohit.deposit(new BigDecimal("600"));
        alice.withdraw(new BigDecimal("50"));
        bob.withdraw(new BigDecimal("100"));
        rohit.withdraw(new BigDecimal("300"));
        rohit.withdraw(new BigDecimal("100"));

        // Get balances after 2 transactions
        System.out.println("Alice's balance after 2 transactions: " +
                bank.getCustomerBalanceAfterTransactions(alice, 2));
        System.out.println("Bob's balance after 2 transactions: " +
                bank.getCustomerBalanceAfterTransactions(bob, 2));
        System.out.println("Rohit's balance after 3 transactions: " +
                bank.getCustomerBalanceAfterTransactions(rohit, 3));

        // Find customer with most transactions
        Customer mostTransactionsCustomer = bank.getCustomerWithMostTransactions();
        System.out.println("Customer with the most transactions: " +
                mostTransactionsCustomer.getName());
    }
}