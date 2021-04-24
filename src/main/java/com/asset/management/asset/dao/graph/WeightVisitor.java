package com.asset.management.asset.dao.graph;

public class WeightVisitor implements NodeVisitor
{

  @Override
  public int visit(Node theNode)
  {
    return 0;
  }

  @Override
  public int visit(WeightedNodeImplementation theWeightedNodeImplementation)
  {
    return theWeightedNodeImplementation.getNodeWeight();
  }
}
