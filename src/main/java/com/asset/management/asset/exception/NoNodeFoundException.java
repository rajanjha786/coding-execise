package com.asset.management.asset.exception;

public class NoNodeFoundException extends RuntimeException
{
  private final String itsMessage;

  public NoNodeFoundException(String message)
  {
    super(message);
    this.itsMessage = message;
  }

}
