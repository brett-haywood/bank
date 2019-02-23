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
      Account ac0 = new Account("34872390", "AUSavings347", AccountType.SAVINGS, "23/01/19", CurrencyType.AUD, 1234.56);
      Account ac1 = new Account("56734901", "AUCurrent987", AccountType.CURRENT, "23/01/19", CurrencyType.AUD, 34.78);
      Account ac2 = new Account("76249814", "SGSavings489", AccountType.SAVINGS, "22/01/19", CurrencyType.SGD, 7625.96);
      Account ac3 = new Account("89361239", "AUCurrent523", AccountType.CURRENT, "19/01/19", CurrencyType.AUD, 502.67);

      List<Account> accountList = new LinkedList<>();
      accountList.add(ac0);
      accountList.add(ac1);
      accountList.add(ac2);
      accountList.add(ac3);

      // Link the userId to account list
      accounts.put("1001", accountList);

      Account acc0 = new Account("32895643", "SGSavings389", AccountType.CURRENT, "22/01/19", CurrencyType.SGD, 855.97);
      Account acc1 = new Account("48120954", "AUCurrent621", AccountType.SAVINGS, "19/01/19", CurrencyType.AUD, 604.67);

      List<Account> accountList1 = new LinkedList<>();
      accountList1.add(acc0);
      accountList1.add(acc1);

      // Associate userId to account list
      accounts.put("1004", accountList1);

   }

   static {
      // List of transactions
      Transaction trans0 = new Transaction("32895643", "SGSavings389", "1/2/18", CurrencyType.SGD, 0.0, 1234.56, DebitCreditType.CREDIT, "");
      Transaction trans1 = new Transaction("32895643", "SGSavings389", "1/3/18", CurrencyType.SGD, 0.0, 4321.56, DebitCreditType.CREDIT, "");
      Transaction trans2 = new Transaction("32895643", "SGSavings389", "1/4/18", CurrencyType.SGD, 0.0, 56.56, DebitCreditType.CREDIT, "");
      Transaction trans3 = new Transaction("32895643", "SGSavings389", "1/5/18", CurrencyType.SGD, 0.0, 78.56, DebitCreditType.CREDIT, "");
      Transaction trans4 = new Transaction("32895643", "SGSavings389", "1/6/18", CurrencyType.SGD, 0.0, 9.56, DebitCreditType.CREDIT, "");
      Transaction trans5 = new Transaction("32895643", "SGSavings389", "1/7/18", CurrencyType.SGD, 0.0, 9876.56, DebitCreditType.CREDIT, "");
      Transaction trans6 = new Transaction("32895643", "SGSavings389", "1/8/18", CurrencyType.SGD, 0.0, 98.56, DebitCreditType.CREDIT, "");
      Transaction trans7 = new Transaction("32895643", "SGSavings389", "1/9/18", CurrencyType.SGD, 0.0, 76.56, DebitCreditType.CREDIT, "");
      Transaction trans8 = new Transaction("32895643", "SGSavings389", "1/10/18", CurrencyType.SGD, 0.0, 56.56, DebitCreditType.CREDIT, "");
      Transaction trans9 = new Transaction("32895643", "SGSavings389", "1/11/18", CurrencyType.SGD, 0.0, 65.56, DebitCreditType.CREDIT, "");

      List<Transaction> transList = new LinkedList<>();
      transList.add(trans0);
      transList.add(trans1);
      transList.add(trans2);
      transList.add(trans3);
      transList.add(trans4);
      transList.add(trans5);
      transList.add(trans6);
      transList.add(trans7);
      transList.add(trans8);
      transList.add(trans9);

      // Associate account number with transaction list
      Map<String, List<Transaction>> accountTransactions = new HashMap<>();
      accountTransactions.put("32895643", transList);

      // Associate userId with account transactions
      transactions.put("1004", accountTransactions);
   };

   public static Map<String, List<Account>> getAccounts() {
      return accounts;
   }

   public static Map<String, Map<String, List<Transaction>>> getTransactions() {
      return transactions;
   }
}
