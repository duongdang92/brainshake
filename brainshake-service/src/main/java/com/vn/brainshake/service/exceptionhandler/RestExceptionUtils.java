package com.vn.brainshake.service.exceptionhandler;

import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.Page;

@Slf4j
public final class RestExceptionUtils {

  private RestExceptionUtils() {
    // private instantiation
  }

  /**
   * Throws <code>ResultNotFoundException</code> when the <code>records</code> is empty.
   * 
   * @param records the data to check empty.
   * @throws ResultNotFoundException throws when <code>records</code> is empty.
   */
  public static <T> Page<T> doSafelyReturnNotEmptyRecords(final Page<T> records)
      throws ResultNotFoundException {
    if (records == null || records.getTotalElements() == 0) {
      final String errorMessage = "Search result not found";
      log.error(errorMessage);
      throw new ResultNotFoundException(errorMessage);
    }
    return records;
  }

}
