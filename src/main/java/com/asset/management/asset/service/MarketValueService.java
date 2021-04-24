package com.asset.management.asset.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.asset.management.asset.dao.MarketValueCalculator;
import com.asset.management.asset.dao.ReadOnlyAssetManager;
import com.asset.management.asset.dao.graph.NamedNode;
import com.asset.management.asset.dao.graph.NodeFactory;
import com.asset.management.asset.dao.graph.NodeType;
import org.springframework.stereotype.Service;

@Service
public class MarketValueService
{
  private final NodeFactory itsNodeFactory;
  private final ReadOnlyAssetManager itsAssetManager;

  public MarketValueService(NodeFactory theNodeFactory, ReadOnlyAssetManager theAssetManager)
  {
    this.itsNodeFactory = theNodeFactory;
    this.itsAssetManager = theAssetManager;
  }

  public int marketValueCalculator(String theInvestorName, NodeType theNodeType,
      List<String> theExcluded)
  {
    NamedNode aNamedNode = itsNodeFactory.createNamedNode(theInvestorName, theNodeType);
    Set<NamedNode> aExcludedNode = createExcludedNode(theExcluded);
    MarketValueCalculator aMarketValueCalculator = new MarketValueCalculator(itsAssetManager,
        aExcludedNode);
    return aMarketValueCalculator.calculateMarketValue(aNamedNode);
  }

  private Set<NamedNode> createExcludedNode(List<String> theExcluded)
  {
    Set<NamedNode> aExcludedSet = new HashSet<>();
    for(String theString: theExcluded)
    {
      aExcludedSet.add(itsNodeFactory.createNamedNode(theString, NodeType.HOLDINGS));
    }
    return aExcludedSet;
  }

}
