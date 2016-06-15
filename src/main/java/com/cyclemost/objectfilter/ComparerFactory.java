package com.cyclemost.objectfilter;

/**
 *
 * @author dbridges
 */
public class ComparerFactory {
  
  public static IComparer createComparer(String typeName) throws Exception {
    switch (typeName.toLowerCase()) {
      case "string": return new StringComparer();
      case "int":
      case "long":
      case "integer": return new LongComparer();
    }
    throw new Exception("No comparer found for type " + typeName);
  }
          
}
