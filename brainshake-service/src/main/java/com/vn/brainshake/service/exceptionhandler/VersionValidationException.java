package com.vn.brainshake.service.exceptionhandler;

import lombok.Getter;

@Getter
public class VersionValidationException extends RuntimeException {

  private static final long serialVersionUID = 7623052114092892174L;
  private final String errorCode;

  public VersionValidationException(String errorCode) {
    super();
    this.errorCode = errorCode;
  }

  public VersionValidationException(String errorCode, String msg) {
    super(msg);
    this.errorCode = errorCode;
  }
}
