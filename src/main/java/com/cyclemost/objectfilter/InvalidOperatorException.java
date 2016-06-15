package com.cyclemost.objectfilter;

/**
 *
 * @author dbridges
 */
public class InvalidOperatorException extends Exception {

  public InvalidOperatorException(String message) {
    super(message);
  }

  public InvalidOperatorException(ComparisonOperator operator) {
    super("Invalid operation: " + operator.toString());
  }

  public InvalidOperatorException(String message, Throwable cause) {
    super(message, cause);
  }

}
