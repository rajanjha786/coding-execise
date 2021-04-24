package com.asset.management.asset.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;

public class Fund
{
  private final String fundName;

  @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
  public Fund(String fundName)
  {
    this.fundName = fundName;
  }

  public String getFundName()
  {
    return fundName;
  }

  @Override
  public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Fund fund = (Fund) o;
    return fundName.equals(fund.fundName);
  }

  @Override
  public int hashCode()
  {
    return Objects.hash(fundName);
  }

  @Override
  public String toString()
  {
    return "Fund{" +
        "Fund='" + fundName + '\'' +
        '}';
  }
}
