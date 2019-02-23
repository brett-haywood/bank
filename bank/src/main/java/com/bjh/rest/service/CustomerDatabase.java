package com.bjh.rest.service;

import com.bjh.rest.domain.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CustomerDatabase {
   private static Map<String, List<Account>> accounts = new HashMap<>();
   private static Map<String, Map<String, List<Transaction>>> transactions = new HashMap<>();

   // Define static databases representing state at particular date/time
   static {
      List<Account> accountList = new LinkedList<>();
      Account acc0 = new Account("1234", "bjh", AccountType.SAVINGS, "23/01/19", CurrencyType.AUD, 1234.56);
      Account acc1 = new Account("5678", "bjh", AccountType.CURRENT, "23/01/19", CurrencyType.AUD, 34.56);

      accountList.add(acc0);
      accountList.add(acc1);

      accounts.put("1001", accountList);
   }

   static {
      Transaction trans = new Transaction("1234", "bjh", "4/5/19", CurrencyType.AUD, 0.0, 1234.56, DebitCreditType.CREDIT, "");
      List<Transaction> transList = new LinkedList<>();
      transList.add(trans);

      Map<String, List<Transaction>> accountTransactions = new HashMap<>();

      accountTransactions.put("1234", transList);

      transactions.put("1001", accountTransactions);

   };

   public static Map<String, List<Account>> getAccounts() {
      return accounts;
   }

   public static Map<String, Map<String, List<Transaction>>> getTransactions() {
      return transactions;
   }
}
