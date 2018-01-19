package com.vn.brainshake.service.exceptionhandler;

public class BadRequestException extends Exception {

  private static final long serialVersionUID = -8800859145922776178L;

  public BadRequestException() {
    super();
  }

  public BadRequestException(String message, Throwable cause) {
    super(message, cause);
  }

  public BadRequestException(String message) {
    super(message);
  }

  public BadRequestException(Throwable cause) {
    super(cause);
  }
}
