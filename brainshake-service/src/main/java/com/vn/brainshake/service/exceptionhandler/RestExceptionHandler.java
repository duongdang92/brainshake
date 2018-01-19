package com.vn.brainshake.service.exceptionhandler;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang.StringUtils;
import org.apache.http.conn.ConnectTimeoutException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.common.exceptions.UnauthorizedUserException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.ws.client.WebServiceIOException;

import java.net.SocketTimeoutException;

import javax.validation.ValidationException;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class RestExceptionHandler {

  private static final String NO_ERROR_CODE = StringUtils.EMPTY;

  private static final String NO_ADDITIONAL_INFO = StringUtils.EMPTY;

  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(ResultNotFoundException.class)
  @ResponseBody
  public RestErrorDto handleSearchResultNotFoundException(final Exception ex) {
    log.error("search result not found exception", ex);
    final String message = StringUtils.defaultIfBlank(ex.getMessage(),
        "Oops!. Sorry, Search result not found.");
    return new RestErrorDto(HttpStatus.NOT_FOUND, NO_ERROR_CODE, message, NO_ADDITIONAL_INFO, ex);
  }

  @ResponseStatus(HttpStatus.FORBIDDEN)
  @ExceptionHandler(AccessDeniedException.class)
  @ResponseBody
  public RestErrorDto handleForbiddenException(final Exception ex) {
    log.error("Access forbidden exception", ex);
    return new RestErrorDto(HttpStatus.FORBIDDEN, NO_ERROR_CODE,
        "Oops!. Sorry access denied.", NO_ADDITIONAL_INFO, ex);
  }

  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler({ InternalServerException.class, Exception.class })
  @ResponseBody
  public RestErrorDto handleGeneralException(final Exception ex) {
    log.error("Internal server error", ex);
    return new RestErrorDto(HttpStatus.INTERNAL_SERVER_ERROR, NO_ERROR_CODE,
        "Oops!. Internal server error.", NO_ADDITIONAL_INFO, ex);
  }

  @ResponseStatus(HttpStatus.REQUEST_TIMEOUT)
  @ExceptionHandler({ SocketTimeoutException.class, ConnectTimeoutException.class, WebServiceIOException.class })
  public @ResponseBody RestErrorDto handleRequestTimeOutException(final Exception ex) {
    log.error("Request timeout exception", ex);
    return new RestErrorDto(HttpStatus.REQUEST_TIMEOUT, NO_ERROR_CODE, "Nope!. I can't wait any longer than 10 seconds", NO_ADDITIONAL_INFO, ex);
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler({ BadRequestException.class })
  @ResponseBody
  public RestErrorDto handleBadRequestException(final Exception ex) {
    log.error("Bad request exception", ex);
    return new RestErrorDto(HttpStatus.BAD_REQUEST, NO_ERROR_CODE,
        "Oops!. Bad request.", NO_ADDITIONAL_INFO,  ex);
  }

  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler({ UsernameNotFoundException.class })
  @ResponseBody
  public RestErrorDto handleUsernameNotFoundException(final Exception ex) {
    log.error("Username not found", ex);
    return new RestErrorDto(HttpStatus.NOT_FOUND, NO_ERROR_CODE,
        "Oops!. Username is not correct.", NO_ADDITIONAL_INFO, ex);
  }

  @ResponseStatus(HttpStatus.UNAUTHORIZED)
  @ExceptionHandler({ UnauthorizedUserException.class })
  @ResponseBody
  public RestErrorDto handleUnauthorizedUserException(final Exception ex) {
    log.error("Unauthorized access exception", ex);
    return new RestErrorDto(HttpStatus.NOT_FOUND, NO_ERROR_CODE,
        "Oops!. Unauthorized access.", NO_ADDITIONAL_INFO, ex);
  }

  @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
  @ExceptionHandler({ HttpRequestMethodNotSupportedException.class })
  @ResponseBody
  public RestErrorDto handleHttpRequestMethodNotSupportedException(final Exception ex) {
    log.error("Method not supported exception", ex);
    return new RestErrorDto(HttpStatus.METHOD_NOT_ALLOWED, NO_ERROR_CODE,
        "Oops!. Method not supported.", NO_ADDITIONAL_INFO, ex);
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler({ ValidationException.class, IllegalArgumentException.class,
      RuntimeException.class })
  @ResponseBody
  public RestErrorDto handleValidationException(final Exception ex) {
    log.error(ex.getMessage(), ex);
    return new RestErrorDto(HttpStatus.BAD_REQUEST, NO_ERROR_CODE,
        ex.getMessage(), NO_ADDITIONAL_INFO, ex);
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler({ UserValidationException.class })
  @ResponseBody
  public RestErrorDto handleUserValidationException(final UserValidationException ex) {
    log.error(ex.getMessage(), ex);
    return new RestErrorDto(HttpStatus.BAD_REQUEST, ex.getErrorCode(),
        ex.getMessage(), NO_ADDITIONAL_INFO, ex);
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler({ VersionValidationException.class })
  @ResponseBody
  public RestErrorDto handleVersionException(final VersionValidationException ex) {
    log.error(ex.getMessage(), ex);
    return new RestErrorDto(HttpStatus.BAD_REQUEST, ex.getErrorCode(), ex.getMessage(),
        NO_ADDITIONAL_INFO, ex);
  }

}
