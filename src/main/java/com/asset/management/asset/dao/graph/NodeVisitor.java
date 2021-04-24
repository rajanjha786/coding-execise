package com.asset.management.asset.dao.graph;

public interface NodeVisitor
{
  int visit(Node theNode);
  int visit(WeightedNodeImplementation theWeightedNodeImplementation);
}
