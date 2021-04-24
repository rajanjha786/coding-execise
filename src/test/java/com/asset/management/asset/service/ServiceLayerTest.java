package com.asset.management.asset.service;

import java.util.Collections;
import java.util.List;

import com.asset.management.asset.model.InvestInFunds;
import com.asset.management.asset.model.InvestInHolding;
import org.junit.jupiter.api.Test;

class ServiceLayerTest
{

  @Test
  void test()
  {
    List<InvestInFunds> aInvestInFundsList = dummyDataForInvestInFunds();
    List<InvestInHolding> aInvestInHoldingList = dummyDataForInvestInHoldings();
  }

  private List<InvestInHolding> dummyDataForInvestInHoldings()
  {
    return Collections.emptyList();
  }

  private List<InvestInFunds> dummyDataForInvestInFunds()
  {
    return Collections.emptyList();
  }
}
