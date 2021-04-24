package com.asset.management.asset.dao.graph;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class Edge
{
  private final NamedNode itsDestination;
  private final int itsWeight;

  public Edge(NamedNode itsDestination, int itsWeight)
  {
    this.itsDestination = itsDestination;
    this.itsWeight = itsWeight;
  }

}
