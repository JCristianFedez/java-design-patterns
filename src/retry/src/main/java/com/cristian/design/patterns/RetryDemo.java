package com.cristian.design.patterns;

import com.cristian.design.patterns.exceptions.BusinessException;
import com.cristian.design.patterns.exceptions.CustomerNotFoundException;
import com.cristian.design.patterns.retry.Retry;
import com.cristian.design.patterns.retry.RetryExponentialBackoff;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RetryDemo {

  private static final String NOT_FOUND = "Not found";
  private static BusinessOperation<Integer> op;

  public static void main(String[] args) throws BusinessException {
    noErrors();
    errorNoRetry();
    errorWithRetry();
    errorWithRetryExponentialBackoff();
  }

  private static void noErrors() throws BusinessException {
    op = new FindCustomer(123);
    op.perform();
    LOGGER.info("Sometimes the operation executes with no errors.");
  }

  private static void errorNoRetry() throws BusinessException {
    op = new FindCustomer(123, new CustomerNotFoundException(NOT_FOUND));
    try {
      op.perform();
    } catch (CustomerNotFoundException e) {
      LOGGER.info("Yet the operation will throw an error every once in a while.");
    }
  }

  private static void errorWithRetry() throws BusinessException {
    final Retry<Integer> retry = new Retry<>(
        new FindCustomer(123, new CustomerNotFoundException(NOT_FOUND)),
        3,
        100,
        e -> CustomerNotFoundException.class.isAssignableFrom(e.getClass())
    );
    op = retry;
    final Integer customerId = op.perform();
    LOGGER.info(String.format("However, retrying the operation while ignoring a recoverable error will eventually yield "
        + "the result %s after a number of attempts %s", customerId, retry.attempts()));
  }

  private static void errorWithRetryExponentialBackoff() throws BusinessException {
    final var retry = new RetryExponentialBackoff<>(
        new FindCustomer(123, new CustomerNotFoundException(NOT_FOUND)),
        6,
        30000,
        e -> CustomerNotFoundException.class.isAssignableFrom(e.getClass())
    );
    op = retry;
    final var customerId = op.perform();
    LOGGER.info(String.format("However, retrying the operation while ignoring a recoverable error will eventually yield "
        + "the result %s after a number of attempts %s", customerId, retry.attempts()));
  }
}
