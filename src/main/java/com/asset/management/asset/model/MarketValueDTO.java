package com.asset.management.asset.model;

import com.asset.management.asset.dao.graph.NodeType;

public class MarketValueDTO
{
  private final NodeType type;
  private final int value;

  public MarketValueDTO(NodeType type, int value)
  {
    this.type = type;
    this.value = value;
  }

  public NodeType getType()
  {
    return type;
  }

  public int getValue()
  {
    return value;
  }

  public static MarketValueDTO create(NodeType theNodeType, int value)
  {
    return new MarketValueDTO(theNodeType, value);
  }

}
