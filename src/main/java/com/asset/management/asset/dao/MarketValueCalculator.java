package com.asset.management.asset.dao;

import java.util.Set;

import com.asset.management.asset.dao.graph.Edge;
import com.asset.management.asset.dao.graph.NamedNode;
import com.asset.management.asset.dao.graph.NodeVisitor;
import com.asset.management.asset.dao.graph.WeightVisitor;
import com.asset.management.asset.exception.NoNodeFoundException;

public class MarketValueCalculator
{
  private final ReadOnlyAssetManager itsAssetManager;
  private final Set<NamedNode> itsExcludedNode;
  private static final NodeVisitor NODE_VISITOR = new WeightVisitor();

  public MarketValueCalculator(ReadOnlyAssetManager theAssetManager,
      Set<NamedNode> theExcludedNode)
  {
    this.itsAssetManager = theAssetManager;
    this.itsExcludedNode = theExcludedNode;
  }

  public int calculateMarketValue(NamedNode theForNode)
  {
    if(!itsAssetManager.containsNode(theForNode))
    {
      throw new NoNodeFoundException(theForNode.getNodeType()+" "+theForNode.getNodeName()+" not found");
    }
    return dfs(theForNode, 0);
  }

  private int dfs(NamedNode theNode, int theEdgeValue)
  {
    int aTotal = 0;
    for(Edge aEdge: itsAssetManager.getEdgeForNode(theNode))
    {
      if(itsExcludedNode.contains(aEdge.getItsDestination()))
        continue;
      aTotal = aTotal + dfs(aEdge.getItsDestination(), aEdge.getItsWeight());
    }
    return aTotal + theNode.visit(NODE_VISITOR) * theEdgeValue;
  }
}
