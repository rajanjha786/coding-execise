package com.asset.management.asset.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.asset.management.asset.dao.AssetManager;
import com.asset.management.asset.dao.graph.NodeFactory;
import com.asset.management.asset.dao.graph.NodeType;
import com.asset.management.asset.exception.NoNodeFoundException;
import com.asset.management.asset.model.Fund;
import com.asset.management.asset.model.Holding;
import com.asset.management.asset.model.InvestInFunds;
import com.asset.management.asset.model.InvestInHolding;
import com.asset.management.asset.model.Investor;
import com.asset.management.asset.model.MarketValueDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ServiceLayerTest
{

  InvestService aInvestService;
  MarketValueService aMarketValueService;
  private static final List<String> EMPTY_STRING = Collections.emptyList();

  @BeforeEach
  public void before()
  {
    List<InvestInFunds> aInvestInFundsList = dummyDataForInvestInFunds();
    List<InvestInHolding> aInvestInHoldingList = dummyDataForInvestInHoldings();
    NodeFactory aNodeFactory = new NodeFactory();
    AssetManager aAssetManager = new AssetManager();
    aInvestService = new InvestService(aAssetManager, aAssetManager, aNodeFactory);
    aMarketValueService = new MarketValueService(aNodeFactory, aAssetManager);
    aInvestInFundsList.forEach(aInvestService::invest);
    aInvestInHoldingList.forEach(aInvestService::invest);
  }


  @Test
  void test_WhenInvestorExistsInSystem_Pass()
  {
    MarketValueDTO aMarketValueDTOExpected = MarketValueDTO.create(NodeType.INVESTOR, 6500);
    MarketValueDTO aMarketValueDTOActual = MarketValueDTO.create(NodeType.INVESTOR,
        aMarketValueService.marketValueCalculator("INV1",
        NodeType.INVESTOR, EMPTY_STRING));

    Assertions.assertEquals(aMarketValueDTOExpected,aMarketValueDTOActual);
  }

  @Test
  void test_WhenFundExistsInSystem_Pass()
  {
    MarketValueDTO aMarketValueDTOExpected = MarketValueDTO.create(NodeType.FUND, 4000);
    MarketValueDTO aMarketValueDTOActual = MarketValueDTO.create(NodeType.FUND,
        aMarketValueService.marketValueCalculator("F1",
        NodeType.FUND, EMPTY_STRING));

    Assertions.assertEquals(aMarketValueDTOExpected,aMarketValueDTOActual);
  }

  @Test
  void test_WhenFundNotExistsInSystem_Fail()
  {
     Assertions.assertThrows(NoNodeFoundException.class,() ->
         aMarketValueService.marketValueCalculator("F10",
         NodeType.FUND, EMPTY_STRING));

  }

  @Test
  void test_WhenFundExistsAndExcludedListAlsoExits_Pass()
  {
    List<String> aExcludedList = new ArrayList<>();
    aExcludedList.add("H1");
    aExcludedList.add("H4");

    MarketValueDTO aMarketValueDTOExpected = MarketValueDTO.create(NodeType.FUND, 2000);
    MarketValueDTO aMarketValueDTOActual = MarketValueDTO.create(NodeType.FUND,
        aMarketValueService.marketValueCalculator("F1",
            NodeType.FUND, aExcludedList));

    Assertions.assertEquals(aMarketValueDTOExpected,aMarketValueDTOActual);

  }

  private List<InvestInHolding> dummyDataForInvestInHoldings()
  {
    List<InvestInHolding> aInvestInHoldingList = new ArrayList<>();
    aInvestInHoldingList.add(createInvestInHolding("F1",
        "H1",10,100));

    aInvestInHoldingList.add(createInvestInHolding("F1",
        "H2",20,100));

    aInvestInHoldingList.add(createInvestInHolding("F1",
        "H4",10,100));

    aInvestInHoldingList.add(createInvestInHolding("F2",
        "H3",15,100));

    aInvestInHoldingList.add(createInvestInHolding("F2",
        "H1",10,100));

    aInvestInHoldingList.add(createInvestInHolding("F3",
        "H1",10,100));

    aInvestInHoldingList.add(createInvestInHolding("F3",
        "H4",10,100));
    return aInvestInHoldingList;
  }

  private InvestInHolding createInvestInHolding(String theFundName,
      String theHoldingName, int theHoldingValue, int theQuantity)
  {
    Fund aFund = new Fund(theFundName);
    Holding aHolding = new Holding(theHoldingName, theHoldingValue);
    return new InvestInHolding(aFund, aHolding, theQuantity);
  }

  private List<InvestInFunds> dummyDataForInvestInFunds()
  {
    List<InvestInFunds> aInvestInFundsList = new ArrayList<>();
    aInvestInFundsList.add(createInvestInFund("INV1","F1"));
    aInvestInFundsList.add(createInvestInFund("INV1","F2"));
    aInvestInFundsList.add(createInvestInFund("INV2","F2"));
    aInvestInFundsList.add(createInvestInFund("INV2","F3"));
    return aInvestInFundsList;
  }

  private InvestInFunds createInvestInFund(String theInvestorName, String theFundName)
  {
    Investor aInvestor = new Investor(theInvestorName);
    Fund aFund = new Fund(theFundName);
    return new InvestInFunds(aInvestor,aFund);
  }
}
