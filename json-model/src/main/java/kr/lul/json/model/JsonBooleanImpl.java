package kr.lul.json.model;

/**
 * @author justburrow
 * @since 2020/10/28
 */
public class JsonBooleanImpl implements JsonBoolean {
  private boolean bool;

  public JsonBooleanImpl(boolean bool) {
    this.bool = bool;
  }

  @Override
  public boolean toBoolean() {
    return this.bool;
  }

  @Override
  public String toString() {
    return Boolean.toString(this.bool);
  }
}
