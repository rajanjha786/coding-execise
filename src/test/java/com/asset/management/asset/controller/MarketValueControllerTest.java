package com.asset.management.asset.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyList;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.asset.management.asset.dao.graph.NodeType;
import com.asset.management.asset.exception.NoNodeFoundException;
import com.asset.management.asset.service.MarketValueService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(MarketValueController.class)
class MarketValueControllerTest
{
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private MarketValueService itsMarketValueService;

  @Test
  void test_WhenCalculationForInvestor_Pass() throws Exception
  {
    when(itsMarketValueService.marketValueCalculator(anyString(),any(NodeType.class),
        anyList()))
        .thenReturn(50);
    this.mockMvc.perform(get("/value/investors/rajan"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("type", is("INVESTOR")))
        .andExpect(jsonPath("value", is(50)));
    verify(itsMarketValueService, times(1))
        .marketValueCalculator("rajan", NodeType.INVESTOR, Collections.emptyList());
  }

  @Test
  void test_WhenCalculationForFunds_Pass() throws Exception
  {
    when(itsMarketValueService.marketValueCalculator(anyString(),any(NodeType.class),
        anyList()))
        .thenReturn(50);
    this.mockMvc.perform(get("/value/funds/F1"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("type", is("FUND")))
        .andExpect(jsonPath("value", is(50)));
    verify(itsMarketValueService, times(1))
        .marketValueCalculator("F1", NodeType.FUND, Collections.emptyList());
  }

  @Test
  void test_WhenCalculationForFundsWithExcludingHoldings_Pass() throws Exception
  {
    when(itsMarketValueService.marketValueCalculator(anyString(),any(NodeType.class),
        anyList()))
        .thenReturn(50);
    this.mockMvc.perform(get("/value/funds/F1")
    .param("exclude", "H1","H2"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("type", is("FUND")))
        .andExpect(jsonPath("value", is(50)));

    List<String> aExcludedList = new ArrayList<>();
    aExcludedList.add("H1");
    aExcludedList.add("H2");
    verify(itsMarketValueService, times(1))
        .marketValueCalculator("F1", NodeType.FUND, aExcludedList);
  }

  @Test
  void test_WhenCalculationForFundsNoNodeFoundException_Pass() throws Exception
  {
    when(itsMarketValueService.marketValueCalculator(anyString(),any(NodeType.class),
        anyList()))
        .thenThrow(new NoNodeFoundException("FUND F1 not found"));
    this.mockMvc.perform(get("/value/funds/F1"))
        .andExpect(status().isNotFound())
        .andExpect(jsonPath("message", is("FUND F1 not found")))
        ;
    verify(itsMarketValueService, times(1))
        .marketValueCalculator("F1", NodeType.FUND, Collections.emptyList());
  }


}
