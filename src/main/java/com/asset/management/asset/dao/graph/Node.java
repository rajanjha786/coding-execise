package com.asset.management.asset.dao.graph;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
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

}
