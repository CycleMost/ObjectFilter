package com.cyclemost.objectfilter;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dbridges
 */
@XmlRootElement(name="ValueCondition")
public class ValueCondition extends Condition  {
  String property;
  String propertyType;
  String comparisonOperator;
  String value;
  
  public ValueCondition()
  {
  }
  
  public ValueCondition(String property, String propertyType, String operator, String value) {
    this.property = property;
    this.propertyType = propertyType;
    this.comparisonOperator = operator;
    this.value = value;
  }

  @XmlAttribute(name="Property")
  public String getProperty() {
    return property;
  }

  public void setProperty(String property) {
    this.property = property;
  }

  @XmlAttribute(name="Operator")
  public String getComparisonOperator() {
    return comparisonOperator;
  }

  public void setComparisonOperator(String comparisonOperator) {
    this.comparisonOperator = comparisonOperator;
  }

  @XmlAttribute(name="Value")
  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  @XmlAttribute(name="PropertyType")
  public String getPropertyType() {
    return propertyType;
  }

  public void setPropertyType(String propertyType) {
    this.propertyType = propertyType;
  }

  @Override
  public boolean evaluate(Context context) throws Exception {
    boolean result = false;
    Object contextValue = context.getValue(property);
    ComparisonOperator operator = ComparisonOperator.IsEqualTo;
    try {
      operator = ComparisonOperator.valueOf(comparisonOperator);
    } catch (Exception ex) {
      throw new InvalidOperatorException(String.format("Undefined operation '%s'", comparisonOperator), ex);
    }
    
    IComparer comparer = ComparerFactory.createComparer(propertyType);
    return comparer.compare(contextValue, operator, value);
  }
  
}
