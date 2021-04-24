package com.asset.management.asset.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;

public class Investor
{
  private final String name;

  @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
  public Investor(String name)
  {
    this.name = name;
  }

  public String getName()
  {
    return name;
  }

  @Override
  public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Investor investor = (Investor) o;
    return name.equals(investor.name);
  }

  @Override
  public int hashCode()
  {
    return Objects.hash(name);
  }

  @Override
  public String toString()
  {
    return "Investor{" +
        "name='" + name + '\'' +
        '}';
  }
}
