package com.cyclemost.objectfilter;

/**
 *
 * @author dbridges
 */
public enum ComparisonOperator {
  // Summary:
  //     Left operand must be smaller than the right one.
  IsLessThan,
  //
  // Summary:
  //     Left operand must be smaller than or equal to the right one.
  IsLessThanOrEqualTo,
  //
  // Summary:
  //     Left operand must be equal to the right one.
  IsEqualTo,
  //
  // Summary:
  //     Left operand must be different from the right one.
  IsNotEqualTo,
  //
  // Summary:
  //     Left operand must be larger than the right one.
  IsGreaterThanOrEqualTo,
  //
  // Summary:
  //     Left operand must be larger than or equal to the right one.
  IsGreaterThan,
  //
  // Summary:
  //     Left operand must start with the right one.
  StartsWith,
  //
  // Summary:
  //     Left operand must end with the right one.
  EndsWith,
  //
  // Summary:
  //     Left operand must contain the right one.
  Contains,
  //
  // Summary:
  //     Left operand must not contain the right one.
  DoesNotContain,
  //
  // Summary:
  //     Left operand must be contained in the right one.
  IsContainedIn,
  //
  // Summary:
  //     Left operand must not be contained in the right one.
  IsNotContainedIn
}
