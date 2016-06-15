package com.cyclemost.objectfilter;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;

 /**
 *
 * @author dbridges
 */

@XmlRootElement(name="Condition")
public class Condition {
 
  List<Condition>  conditions;

  public Condition() {
  }
  
  public Condition(Condition... args) {
    for (Condition childCondition : args) {
      getConditions().add(childCondition);
    }
  }
  
  @XmlElementRef
  public List<Condition> getConditions() {
    if (conditions == null) {
      conditions = new ArrayList<>();
    }
    return conditions;
  }

  public void setConditions(List<Condition> conditions) {
    this.conditions = conditions;
  }
 
  /**
   * Returns true if all child conditions evaluate to true.
   * Derived classes such as OrCondition will override this to implement their logic.
   * @return 
   */
  public boolean evaluate(Context context) throws Exception {
    // TODO: What to return if there are no conditions?
    for (Condition condition : getConditions()) {
      if (!condition.evaluate(context)) {
        return false;
      }
    }
    return true;
  }
  
  /**
   * Returns an XML string representing the condition
   * @return 
   */
  public String serialize() throws JAXBException, IOException {
    JAXBContext context = JAXBContext.newInstance(Condition.class, ValueCondition.class, AndCondition.class, OrCondition.class);
    Marshaller marshaller = context.createMarshaller();
    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

    try (StringWriter writer = new StringWriter()) {
      marshaller.marshal(this, writer);
      return writer.toString();
    }
  }
  
  /**
   * Returns a new Condition object from the specified XML string
   * @param xml
   * @return
   * @throws JAXBException 
   */
  public static Condition deserialize(String xml) throws JAXBException {
    JAXBContext context = JAXBContext.newInstance(Condition.class, ValueCondition.class, AndCondition.class, OrCondition.class);
    Unmarshaller unmarshaller = context.createUnmarshaller();
    try (StringReader reader = new StringReader(xml)) {
      return (Condition)unmarshaller.unmarshal(reader);
    }
  }

}
