package com.asset.management.asset.dao.graph;

import java.util.Objects;

public class WeightedNodeImplementation extends Node implements WeightedNode
{
  private final int nodeWeight;

  public WeightedNodeImplementation(String theNodeName, NodeType theNodeType)
  {
    super(theNodeName,theNodeType);
    this.nodeWeight = 0;
  }

  public WeightedNodeImplementation(String theNodeName, NodeType theNodeType, int theNodeWeight)
  {
    super(theNodeName, theNodeType);
    this.nodeWeight = theNodeWeight;
  }

  @Override
  public int getNodeWeight()
  {
    return nodeWeight;
  }

  @Override
  public int visit(NodeVisitor theVisitor)
  {
    return theVisitor.visit(this);
  }

  @Override
  public boolean equals(Object o)
  {
    return super.equals(o);
  }

  @Override
  public int hashCode()
  {
    return Objects.hash(super.hashCode());
  }
}
