package com.vn.brainshake.service.exceptionhandler;

import lombok.Getter;

@Getter
public class UserValidationException extends RuntimeException {

  private static final long serialVersionUID = -3123857820574377528L;

  private final String errorCode;

  public UserValidationException(String errorCode) {
    super();
    this.errorCode = errorCode;
  }

  public UserValidationException(String errorCode, String msg) {
    super(msg);
    this.errorCode = errorCode;
  }
}
