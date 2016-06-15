package com.cyclemost.objectfilter;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

// NOTE: See http://jruleengine.sourceforge.net/xmlcontent.html for ideas.

/**
 *
 * @author dbridges
 */
public class Context {
  private Map<String, Object> values;

  public Context() {
    values = new HashMap<>();
  }
  
  public void set(String name, Object value) {
    values.put(name, value);
  }
  
  public Object getValue(String identifier) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
    // identifier is of the form name[.name].property
    Object obj = null;
    String[] names = identifier.split("\\.");
    for (int i = 0; i < names.length; i++) {
      String name = names[i];
      if (i == 0) {
        obj = values.get(name);
      }
      else if (obj != null) {
        Class clazz = obj.getClass();
        Field field = clazz.getDeclaredField(name);
        if (field != null) {
          field.setAccessible(true);
          obj = field.get(obj);
        }
      }
      else {
        // TODO: log and/or throw exception - unable to parse identifier
        break;
      }
    }
    
    return obj;
  }
  
  public Map<String, Object> getValues() {
    return values;
  }

  public void setValues(Map<String, Object> values) {
    this.values = values;
  }
  
}
