package com.cyclemost.objectfilter;

import java.util.Map;
import javax.xml.bind.annotation.XmlRootElement;

/** Represents an Or condition. Returns true if at least one
 * child condition evaluates to true.
 *
 * @author dbridges
 */
@XmlRootElement(name="Or")
public class OrCondition extends Condition {
  
  public OrCondition() {
  }

  public OrCondition(Condition... args) {
    super(args);
  }
  
  @Override
  public boolean evaluate(Context context) throws Exception {
    for (Condition condition : getConditions()) {
      if (condition.evaluate(context)) {
        // At least one condition is true
        return true;
      }
    }
    // No conditions are true
    return false;
  }
  
}
