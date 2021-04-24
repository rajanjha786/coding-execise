package com.asset.management.asset.dao;

import com.asset.management.asset.dao.graph.NamedNode;

public interface FundsHoldingsManager
{
  void addEdge(NamedNode theFromNode, NamedNode theToNode, int theEdgeWeight);
}
