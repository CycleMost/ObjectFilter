package com.cyclemost.objectfilter;

/**
 *
 * @author dbridges
 */
public class StringComparer implements IComparer {

  @Override
  public boolean compare(Object leftObject, ComparisonOperator operator, Object rightObject) throws InvalidOperatorException {
    String leftValue = leftObject.toString().trim();
    String rightValue = rightObject.toString().trim();
    
    switch (operator) {
      case Contains: return leftValue.contains(rightValue);
      case DoesNotContain: return !leftValue.contains(rightValue);
      case EndsWith: return leftValue.endsWith(rightValue);
      case IsContainedIn: return rightValue.contains(leftValue);
      case IsEqualTo: return leftValue.equals(rightValue); 
      case IsGreaterThan: return leftValue.compareTo(rightValue) > 0;
      case IsGreaterThanOrEqualTo: return leftValue.compareTo(rightValue) >= 0;
      case IsLessThan: return leftValue.compareTo(rightValue) < 0;
      case IsLessThanOrEqualTo: return leftValue.compareTo(rightValue) <= 0;
      case IsNotContainedIn: return !rightValue.contains(leftValue);
      case IsNotEqualTo: return !leftValue.equals(rightValue); 
      case StartsWith: return leftValue.startsWith(rightValue);
    }
    
    throw new InvalidOperatorException(operator);
  }
  
}
