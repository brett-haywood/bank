package com.bjh.rest.controller;

import com.bjh.rest.domain.*;
import com.bjh.rest.service.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductServiceController {

   // Inject static accounts and transactions database into service
   CustomerService service = new CustomerService(CustomerDatabase.getAccounts(), CustomerDatabase.getTransactions());


   @RequestMapping(value = "/api/accounts", method = RequestMethod.GET)
   public ResponseEntity<Object> getAccounts(@RequestBody UserId id) {

      List<Account> accounts = this.service.getUserAccounts(id.getUserId());

      return new ResponseEntity<>(accounts, HttpStatus.OK);
   }

   @RequestMapping(value = "/api/transactions", method = RequestMethod.GET)
   public ResponseEntity<Object> getTransactions(@RequestBody AccountId id) {

      List<Transaction> transList = this.service.getAccountTransactions(id.getUserId(), id.getAccountNumber());

      return new ResponseEntity<>(transList, HttpStatus.OK);
   }
}
