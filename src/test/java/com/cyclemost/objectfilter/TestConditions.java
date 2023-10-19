package com.cyclemost.objectfilter;

import jakarta.xml.bind.JAXBException;
import org.junit.Test;


/**
 *
 * @author dbridges
 */
public class TestConditions {
  
  class Item {
    String name;
    String description;
    int quantity;
    double cost;
    
    public Item(String name, String description, int quantity, double cost) {
      this.name = name;
      this.description = description;
      this.quantity = quantity;
      this.cost = cost;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getDescription() {
      return description;
    }

    public void setDescription(String description) {
      this.description = description;
    }

    public int getQuantity() {
      return quantity;
    }

    public void setQuantity(int quantity) {
      this.quantity = quantity;
    }

    public double getCost() {
      return cost;
    }

    public void setCost(double cost) {
      this.cost = cost;
    }
    
  }
  
  @Test
  public void testSerialize() throws JAXBException {
    try {
      
      Condition cond = new Condition(
        new AndCondition (
          new ValueCondition("Name", "String", "IsEqualTo", "Dave"),
          new ValueCondition("Age", "Integer", "IsEqualTo", "42"),
          new OrCondition (
            new ValueCondition("LastName", "String", "StartsWith", "Smith"),
            new ValueCondition("LastName", "String", "EndsWith", "Smith")
          )
        )
      );
      
      String xml = cond.serialize();
      
      Context context = createTestContext();
      context.set("foo", this);
      
      String cloneXml = xml.replace("Name", "ZName");
      Condition clone = Condition.deserialize(cloneXml);

      System.out.println(xml);
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }
  
  @Test
  public void testStringComparison() throws Exception {
    try {
      ValueCondition condition = new ValueCondition("item.name", "String", "IsContainedIn", "widgets");
      Context context = createTestContext();
      System.out.println(condition.evaluate(context));
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }
  
  public Context createTestContext()
  {
    Context context = new Context();
    context.set("item", new Item("widget", "professional strength widget", 42, 99.99));
    return context;
  }
  
}
