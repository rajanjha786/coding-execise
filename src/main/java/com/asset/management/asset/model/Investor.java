package com.asset.management.asset.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class Investor
{
  private final String name;

  @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
  public Investor(String name)
  {
    this.name = name;
  }

}
