package com.asset.management.asset.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;

public class InvestInFunds
{
  private final Investor investor;
  private final Fund fund;

  @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
  public InvestInFunds(Investor investor, Fund fund)
  {
    this.investor = investor;
    this.fund = fund;
  }

  public Fund getFund()
  {
    return fund;
  }

  public Investor getInvestor()
  {
    return investor;
  }

  @Override
  public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    InvestInFunds that = (InvestInFunds) o;
    return investor.equals(that.investor) && fund.equals(that.fund);
  }

  @Override
  public int hashCode()
  {
    return Objects.hash(investor, fund);
  }

  @Override
  public String toString()
  {
    return "InvestInFunds{" +
        "investor=" + investor +
        ", fund=" + fund +
        '}';
  }
}
