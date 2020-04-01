package fit.compiler;

import javax.lang.model.element.Element;

/**
 * @author Tu enum@foxmail.com.
 * @since 1.0.1
 */

public class PropertyDescriptor {
  private Element getter;
  private Element setter;
  private Element field;

  public Element getGetter() {
    return getter;
  }

  public void setGetter(Element getter) {
    this.getter = getter;
  }

  public Element getSetter() {
    return setter;
  }

  public void setSetter(Element setter) {
    this.setter = setter;
  }

  public Element getField() {
    return field;
  }

  public void setField(Element field) {
    this.field = field;
  }
}
