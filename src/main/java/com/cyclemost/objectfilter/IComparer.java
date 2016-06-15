package com.cyclemost.objectfilter;

/**
 *
 * @author dbridges
 */
public interface IComparer {
  boolean compare(Object leftObject, ComparisonOperator operator, Object rightObject) throws InvalidOperatorException;
}
