package com.asset.management.asset.dao.graph;

public interface NamedNode
{
  String getNodeName();
  NodeType getNodeType();
  int visit(NodeVisitor theVisitor);
}
