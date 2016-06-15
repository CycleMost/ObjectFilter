package com.cyclemost.objectfilter;

/**
 *
 * @author dbridges
 */
public class LongComparer implements IComparer {

  @Override
  public boolean compare(Object leftObject, ComparisonOperator operator, Object rightObject) throws InvalidOperatorException {
    long leftValue = Long.parseLong(leftObject.toString());
    long rightValue = Long.parseLong(rightObject.toString());
    
    switch (operator) {
      case IsEqualTo: return leftValue == rightValue; 
      case IsGreaterThan: return leftValue > rightValue;
      case IsGreaterThanOrEqualTo: return leftValue >= rightValue;
      case IsLessThan: return leftValue < rightValue;
      case IsLessThanOrEqualTo: return leftValue <= rightValue;
      case IsNotEqualTo: return leftValue != rightValue;
    }
    
    throw new InvalidOperatorException(operator);
  }
  
}
