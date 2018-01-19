package com.vn.brainshake.service.exceptionhandler;

public class InternalServerException extends Exception {

  private static final long serialVersionUID = -8800859145922776178L;

  public InternalServerException() {
    super();
  }

  public InternalServerException(String message, Throwable cause) {
    super(message, cause);
  }

  public InternalServerException(String message) {
    super(message);
  }

  public InternalServerException(Throwable cause) {
    super(cause);
  }
}
