package com.vn.brainshake.service.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

import org.springframework.http.HttpStatus;

@Data
public class RestErrorDto {

  private final HttpStatus status;
  private final int code;

  @JsonProperty("error_code")
  private final String errorCode;

  private final String message;
  private final String additonalinfo;

  /**
   * Constructs the error response.
   *
   * @param status the status of the response.
   * @param message the error message
   */
  public RestErrorDto(final HttpStatus status, final String errorCode, final String message,
      final String additonalinfo, final Throwable throwable) {
    this.status = status;
    this.code = status.value();
    this.errorCode = errorCode;
    this.message = message;
    this.additonalinfo = additonalinfo;
  }

}
