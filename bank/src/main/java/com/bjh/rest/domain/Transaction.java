package com.bjh.rest.domain;

public class Transaction {
   private String accountNumber;
   private String accountName;
   private String valueDate;
   private CurrencyType currency;
   private Double debitAmount;
   private Double creditAmount;
   private DebitCreditType debitCredit;
   private String transactionNarrative;

   public Transaction() {
   }

   public Transaction(String accountNumber, String accountName, String valueDate, CurrencyType currency, Double debitAmount, Double creditAmount, DebitCreditType debitCredit, String transactionNarrative) {
      this.accountNumber = accountNumber;
      this.accountName = accountName;
      this.valueDate = valueDate;
      this.currency = currency;
      this.debitAmount = debitAmount;
      this.creditAmount = creditAmount;
      this.debitCredit = debitCredit;
      this.transactionNarrative = transactionNarrative;
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

   public void setAccountName(String accountName) {
      this.accountName = accountName;
   }

   public String getValueDate() {
      return valueDate;
   }

   public void setValueDate(String valueDate) {
      this.valueDate = valueDate;
   }

   public CurrencyType getCurrency() {
      return currency;
   }

   public void setCurrency(CurrencyType currency) {
      this.currency = currency;
   }

   public Double getDebitAmount() {
      return debitAmount;
   }

   public void setDebitAmount(Double debitAmount) {
      this.debitAmount = debitAmount;
   }

   public Double getCreditAmount() {
      return creditAmount;
   }

   public void setCreditAmount(Double creditAmount) {
      this.creditAmount = creditAmount;
   }

   public DebitCreditType getDebitCredit() {
      return debitCredit;
   }

   public void setDebitCredit(DebitCreditType debitCredit) {
      this.debitCredit = debitCredit;
   }

   public String getTransactionNarrative() {
      return transactionNarrative;
   }

   public void setTransactionNarrative(String transactionNarrative) {
      this.transactionNarrative = transactionNarrative;
   }
}
