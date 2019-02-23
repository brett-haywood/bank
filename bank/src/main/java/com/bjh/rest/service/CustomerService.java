package com.bjh.rest.service;

import com.bjh.rest.domain.Account;
import com.bjh.rest.domain.Transaction;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class CustomerService {
   private Map<String, List<Account>> accounts;
   private Map<String, Map<String, List<Transaction>>> transactions;

   public CustomerService(Map<String, List<Account>> accounts, Map<String, Map<String, List<Transaction>>> transactions) {
      this.accounts = accounts;
      this.transactions = transactions;
   }

   public List<Account> getUserAccounts(String userId) {
      if (accounts.containsKey(userId)) {
         return accounts.get(userId);
      }

      return Collections.EMPTY_LIST;
   }

   public List<Transaction> getAccountTransactions(String userId, String accountId) {
      if (transactions.containsKey(userId)) {
         if (transactions.get(userId).containsKey(accountId)) {
            return transactions.get(userId).get(accountId);
         }
      }

      return Collections.EMPTY_LIST;
   }

}
