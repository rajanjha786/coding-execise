package com.asset.management.asset.dao;

import com.asset.management.asset.dao.graph.NamedNode;

public interface InvestorFundManager
{
  void addEdge(NamedNode theFromNode, NamedNode theToNode);
}
