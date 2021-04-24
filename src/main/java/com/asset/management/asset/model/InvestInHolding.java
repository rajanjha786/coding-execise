package com.asset.management.asset.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
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
}
