package com.asset.management.asset.dao.graph;

import java.util.Objects;

public class Node implements NamedNode
{
  private final String nodeName;
  private final NodeType nodeType;

  public Node(String theNodeName, NodeType theNodeType)
  {
    this.nodeName = theNodeName;
    this.nodeType = theNodeType;
  }

  @Override
  public String getNodeName()
  {
    return nodeName;
  }

  @Override
  public NodeType getNodeType()
  {
    return nodeType;
  }

  @Override
  public int visit(NodeVisitor theVisitor)
  {
    return theVisitor.visit(this);
  }

  @Override
  public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Node node = (Node) o;
    return nodeName.equals(node.nodeName) && nodeType == node.nodeType;
  }

  @Override
  public int hashCode()
  {
    return Objects.hash(nodeName, nodeType);
  }
}
