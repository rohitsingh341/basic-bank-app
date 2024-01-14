package org.example.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.math.BigDecimal;

import org.example.model.Customer;
import org.junit.jupiter.api.Test;

class BankingServiceTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link BankingService}
   */
  @Test
  void testConstructor() {
    assertNull((new BankingService()).getCustomerWithMostTransactions());
  }

  /**
   * Method under test: {@link BankingService#addCustomer(Customer)}
   */
  @Test
  void testAddCustomer() {
    BankingService bankingService = new BankingService();
    Customer customer = new Customer("Name", new BigDecimal("2.3"));

    bankingService.addCustomer(customer);
    assertSame(customer, bankingService.getCustomerWithMostTransactions());
  }

  /**
   * Method under test:
   * {@link BankingService#getCustomerBalanceAfterTransactions(Customer, int)}
   */
  @Test
  void testGetCustomerBalanceAfterTransactions() {
    BankingService bankingService = new BankingService();
    BigDecimal balance = new BigDecimal("2.3");
    BigDecimal actualCustomerBalanceAfterTransactions = bankingService
            .getCustomerBalanceAfterTransactions(new Customer("Name", balance), 10);
    assertEquals(new BigDecimal("2.3"), actualCustomerBalanceAfterTransactions);
    assertSame(balance, actualCustomerBalanceAfterTransactions);
  }

  /**
   * Method under test: {@link BankingService#getCustomerWithMostTransactions()}
   */
  @Test
  void testGetCustomerWithMostTransactions() {
    BankingService bankingService = new BankingService();
    Customer customer = new Customer("Name", new BigDecimal("2.3"));

    bankingService.addCustomer(customer);
    bankingService.addCustomer(new Customer("Name", new BigDecimal("2.3")));
    assertSame(customer, bankingService.getCustomerWithMostTransactions());
  }
}
