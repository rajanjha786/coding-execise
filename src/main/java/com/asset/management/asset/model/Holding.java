package com.asset.management.asset.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;

public class Holding
{
  private final String name;
  private final int value;

  @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
  public Holding(String name, int value)
  {
    this.name = name;
    this.value = value;
  }

  public String getName()
  {
    return name;
  }

  public int getValue()
  {
    return value;
  }

  @Override
  public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Holding holdings = (Holding) o;
    return value == holdings.value && name.equals(holdings.name);
  }

  @Override
  public int hashCode()
  {
    return Objects.hash(name, value);
  }
}
