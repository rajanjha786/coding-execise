package com.asset.management.asset.service;

import com.asset.management.asset.dao.FundsHoldingsManager;
import com.asset.management.asset.dao.InvestorFundManager;
import com.asset.management.asset.dao.graph.NamedNode;
import com.asset.management.asset.dao.graph.NodeFactory;
import com.asset.management.asset.dao.graph.NodeType;
import com.asset.management.asset.dao.graph.WeightedNode;
import com.asset.management.asset.model.InvestInFunds;
import com.asset.management.asset.model.InvestInHolding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class InvestService
{
  private static final Logger LOGGER = LoggerFactory.getLogger(InvestService.class);

  private final InvestorFundManager itsInvestorFundManager;
  private final NodeFactory itsNodeFactory;
  private final FundsHoldingsManager itsFundsHoldingsManager;

  public InvestService(InvestorFundManager itsInvestorFundManager, FundsHoldingsManager itsFundsHoldingsManager,
      NodeFactory theNodeFactory)
  {
    this.itsInvestorFundManager = itsInvestorFundManager;
    this.itsNodeFactory = theNodeFactory;
    this.itsFundsHoldingsManager = itsFundsHoldingsManager;
  }

  public void invest(InvestInFunds theInvestInFunds)
  {
    NamedNode aInvestor = itsNodeFactory.createNamedNode(theInvestInFunds.getInvestor().getName(),
        NodeType.INVESTOR);
    NamedNode aFund = itsNodeFactory.createNamedNode(theInvestInFunds.getFund().getFundName(),
        NodeType.FUND);
    itsInvestorFundManager.addEdge(aInvestor,aFund);
  }

  public void invest(InvestInHolding theInvestInHoldings)
  {
    NamedNode aFund = itsNodeFactory.createNamedNode(theInvestInHoldings.getFund().getFundName(),
        NodeType.FUND);
    WeightedNode aHolding = itsNodeFactory.createWeightedNode(theInvestInHoldings.getHolding().getName(),
        NodeType.HOLDINGS, theInvestInHoldings.getHolding().getValue());
    itsFundsHoldingsManager.addEdge(aFund,aHolding, theInvestInHoldings.getQuantity());
  }
}
