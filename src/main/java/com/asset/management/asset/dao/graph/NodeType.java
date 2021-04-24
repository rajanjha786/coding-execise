package com.asset.management.asset.dao.graph;

public enum NodeType
{
  INVESTOR(1),
  FUND(2),
  HOLDINGS(3);

  private int value;

  NodeType(int theValue)
  {
    this.value = theValue;
  }

  public int value()
  {
    return value;
  }
}
