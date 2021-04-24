package com.asset.management.asset.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class Fund
{
  private final String fundName;

  @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
  public Fund(String fundName)
  {
    this.fundName = fundName;
  }
}
