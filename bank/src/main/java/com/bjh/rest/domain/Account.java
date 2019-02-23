package com.bjh.rest.domain;

public class Account {
   private String accountNumber;
   private String accountName;
   private AccountType accountType;
   private String balanceDate;
   private CurrencyType currency;
   private Double openAvailableBalance;

   public Account() {
   }

   public Account(String accountNumber, String accountName, AccountType accountType, String balanceDate, CurrencyType currency, Double openAvailableBalance) {
      this.accountNumber = accountNumber;
      this.accountName = accountName;
      this.accountType = accountType;
      this.balanceDate = balanceDate;
      this.currency = currency;
      this.openAvailableBalance = openAvailableBalance;
   }

   public String getAccountNumber() {
      return accountNumber;
   }
   public void setAccountNumber(String accountNumber) {
      this.accountNumber = accountNumber;
   }

   public String getAccountName() {
      return accountName;
   }

   public AccountType getAccountType() {
      return accountType;
   }

   public String getBalanceDate() {
      return balanceDate;
   }

   public CurrencyType getCurrency() {
      return currency;
   }

   public Double getOpenAvailableBalance() {
      return openAvailableBalance;
   }

   public void setAccountName(String accountName) {
      this.accountName = accountName;
   }

   public void setAccountType(AccountType accountType) {
      this.accountType = accountType;
   }

   public void setBalanceDate(String balanceDate) {
      this.balanceDate = balanceDate;
   }

   public void setCurrency(CurrencyType currency) {
      this.currency = currency;
   }

   public void setOpenAvailableBalance(Double openAvailableBalance) {
      this.openAvailableBalance = openAvailableBalance;
   }
}
