package com.asset.management.asset.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;

public class InvestInHolding
{
  private final Fund fund;
  private final Holding holding;
  private final int quantity;

  @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
  public InvestInHolding(Fund fund, Holding holding, int quantity)
  {
    this.fund = fund;
    this.holding = holding;
    this.quantity = quantity;
  }

  public Fund getFund()
  {
    return fund;
  }

  public Holding getHolding()
  {
    return holding;
  }

  public int getQuantity()
  {
    return quantity;
  }

  @Override
  public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    InvestInHolding that = (InvestInHolding) o;
    return quantity == that.quantity && fund.equals(that.fund) && holding.equals(that.holding);
  }

  @Override
  public int hashCode()
  {
    return Objects.hash(fund, holding, quantity);
  }
}
