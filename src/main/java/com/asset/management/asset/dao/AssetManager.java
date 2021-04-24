package com.asset.management.asset.dao;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.asset.management.asset.dao.graph.Edge;
import com.asset.management.asset.dao.graph.NamedNode;
import org.springframework.stereotype.Repository;

@Repository
public class AssetManager implements ReadOnlyAssetManager, InvestorFundManager,
    FundsHoldingsManager
{
  private final Map<NamedNode, Set<Edge>> itsGraph = new HashMap<>();
  private static final Set<Edge> EMPTY_SET = Collections.emptySet();

  @Override
  public void addEdge(NamedNode theFromNode, NamedNode theToNode)
  {
    Edge aEdge = new Edge(theToNode, 0);
    itsGraph.computeIfAbsent(theFromNode, node ->
        new HashSet<>()).add(aEdge);
  }

  @Override
  public void addEdge(NamedNode theFromNode, NamedNode theToNode, int theEdgeWeight)
  {
    Edge aEdge = new Edge(theToNode, theEdgeWeight);
    itsGraph.computeIfAbsent(theFromNode, node ->
        new HashSet<>()).add(aEdge);
  }

  @Override
  public boolean containsNode(NamedNode theNamedNode)
  {
    return itsGraph.containsKey(theNamedNode);
  }

  @Override
  public Set<Edge> getEdgeForNode(NamedNode theForNode)
  {
    return Collections.unmodifiableSet(itsGraph.getOrDefault(theForNode, EMPTY_SET));
  }

}
