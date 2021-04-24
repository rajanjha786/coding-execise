package com.asset.management.asset.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.asset.management.asset.model.Fund;
import com.asset.management.asset.model.Holding;
import com.asset.management.asset.model.InvestInFunds;
import com.asset.management.asset.model.InvestInHolding;
import com.asset.management.asset.model.Investor;
import com.asset.management.asset.service.InvestService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(InvestController.class)
class InvestorControllerTest
{
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private InvestService itsInvestService;

  @Test
  void test_WhenInvestorInvestInFund_Pass() throws Exception
  {
    Investor aInvestor = new Investor("Rajan");
    Fund aFund = new Fund("Tesla");
    InvestInFunds aInvestInFunds = new InvestInFunds(aInvestor, aFund);
    ObjectMapper objectMapper = new ObjectMapper();
    doNothing().when(itsInvestService).invest(any(InvestInFunds.class));
    this.mockMvc.perform(post("/invests/investors")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(aInvestInFunds)))
        .andExpect(status().isCreated());
    verify(itsInvestService, times(1)).invest(aInvestInFunds);
  }

  @Test
  void test_WhenFundInvestInHoldings_Pass() throws Exception
  {
    Fund aFund = new Fund("Tesla");
    Holding aHolding = new Holding("H1",10);
    InvestInHolding aInvestInHolding = new InvestInHolding(aFund,aHolding,50);
    ObjectMapper objectMapper = new ObjectMapper();
    doNothing().when(itsInvestService).invest(any(InvestInFunds.class));
    this.mockMvc.perform(post("/invests/funds")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(aInvestInHolding)))
        .andExpect(status().isCreated());
    verify(itsInvestService, times(1)).invest(aInvestInHolding);

  }
}
