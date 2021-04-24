package com.asset.management.asset.dao.graph;

import org.springframework.stereotype.Component;

@Component
public class NodeFactory
{
  public NamedNode createNode(String theName, NodeType theNodeType)
  {
    return createNamedNode(theName, theNodeType);
  }

  public NamedNode createNode(String theName, NodeType theNodeType, int theWeight)
  {
    return createWeightedNode(theName, theNodeType, theWeight);
  }

  public NamedNode createNamedNode(String theName, NodeType theNodeType)
  {
    return new Node(theName, theNodeType);
  }

  public WeightedNode createWeightedNode(String theName, NodeType theNodeType, int theWeight)
  {
    return new WeightedNodeImplementation(theName, theNodeType, theWeight);
  }
}
