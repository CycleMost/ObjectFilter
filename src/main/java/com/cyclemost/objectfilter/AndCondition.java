package com.cyclemost.objectfilter;

import jakarta.xml.bind.annotation.XmlRootElement;

/** 
 * Represents an And condition. 
 * Returns true if all child conditions are true.
 *
 * @author dbridges
 */
@XmlRootElement(name="And")
public class AndCondition extends Condition {

  public AndCondition() {
  }
  
  public AndCondition(Condition... args) {
    super(args);
  }
  
  @Override
  public boolean evaluate(Context context) throws Exception {
    return super.evaluate(context); 
  }
}
