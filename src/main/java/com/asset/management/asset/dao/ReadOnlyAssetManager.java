package com.asset.management.asset.dao;

import java.util.Set;

import com.asset.management.asset.dao.graph.Edge;
import com.asset.management.asset.dao.graph.NamedNode;

public interface ReadOnlyAssetManager
{
  boolean containsNode(NamedNode theNamedNode);
  Set<Edge> getEdgeForNode(NamedNode theForNode);
}
