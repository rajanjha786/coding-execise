package com.asset.management.asset.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
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

}
