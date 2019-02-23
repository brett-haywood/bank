package com.bjh.rest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.bjh.rest.domain.*;

import java.util.List;

public class RestTest extends AbstractTest {
   @Override
   @Before
   public void setUp() {
      super.setUp();
   }

   @Test
   // Test failure of ill-formed Rest Get request on accounts interface
   public void getAccountsListWithoutRequestBody() throws Exception {
      String uri = "/api/accounts";
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
              .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

      int status = mvcResult.getResponse().getStatus();
      assertEquals(400, status); // Error status
   }

   @Test
   // Test success of correctly formed Rest Get request
   public void getAccountsList() throws Exception {
      String uri = "/api/accounts";
      UserId id = new UserId();
      id.setUserId("1001");
      String body = super.mapToJson(id);

      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
         .contentType(MediaType.APPLICATION_JSON_VALUE).content(body)).andReturn();
      
      int status = mvcResult.getResponse().getStatus();
      assertEquals(200, status); // OK status

      String content = mvcResult.getResponse().getContentAsString();
      List<Account> transList = super.listFromJson(content);
      assertTrue(transList.size() == 2);
   }

   @Test
   // Test success of correctly formed Rest Get request but unknown user id
   public void getEmptyAccountsList() throws Exception {
      String uri = "/api/accounts";
      UserId id = new UserId();
      id.setUserId("1002"); // Unknown user id
      String body = super.mapToJson(id);

      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
              .contentType(MediaType.APPLICATION_JSON_VALUE).content(body)).andReturn();

      int status = mvcResult.getResponse().getStatus();
      assertEquals(200, status); // OK status

      String content = mvcResult.getResponse().getContentAsString();
      List<Account> transList = super.listFromJson(content);
      assertTrue(transList.size() == 0);
   }

   @Test
   // Test failure of ill-formed Rest Get request on transactions interface
   public void getTransactionsListWithoutRequestBody() throws Exception {
      String uri = "/api/transactions";

      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
              .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

      int status = mvcResult.getResponse().getStatus();
      assertEquals(400, status); // Error status
   }

   @Test
   // Test success of correctly formed Rest Get request
   public void getTransactionsList() throws Exception {
      String uri = "/api/transactions";
      AccountId id = new AccountId();
      id.setUserId("1001");
      id.setAccountNumber("1234");
      String body = super.mapToJson(id);

      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
              .contentType(MediaType.APPLICATION_JSON_VALUE).content(body)).andReturn();

      int status = mvcResult.getResponse().getStatus();
      assertEquals(200, status);
      String content = mvcResult.getResponse().getContentAsString();

      List<Transaction> transList = super.listFromJson(content);
      assertTrue(transList.size() == 1);
   }

   @Test
   // Test success of correctly formed Rest Get request but unknown account id
   public void getEmptyTransactionsList() throws Exception {
      String uri = "/api/transactions";
      AccountId id = new AccountId();
      id.setUserId("1001");
      id.setAccountNumber("5678");
      String body = super.mapToJson(id);

      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
              .contentType(MediaType.APPLICATION_JSON_VALUE).content(body)).andReturn();

      int status = mvcResult.getResponse().getStatus();
      assertEquals(200, status);
      String content = mvcResult.getResponse().getContentAsString();

      List<Transaction> transList = super.listFromJson(content);
      assertTrue(transList.size() == 0);
   }

}
