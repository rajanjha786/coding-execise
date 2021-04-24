package com.asset.management.asset.dao.graph;

import java.util.Objects;

public class Edge
{
  private final NamedNode itsDestination;
  private final int itsWeight;

  public Edge(NamedNode itsDestination, int itsWeight)
  {
    this.itsDestination = itsDestination;
    this.itsWeight = itsWeight;
  }

  public NamedNode getItsDestination()
  {
    return itsDestination;
  }

  public int getItsWeight()
  {
    return itsWeight;
  }

  @Override
  public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Edge edge = (Edge) o;
    return itsDestination.equals(edge.itsDestination);
  }

  @Override
  public int hashCode()
  {
    return Objects.hash(itsDestination);
  }
}
