package com.asset.management.asset.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
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


}
