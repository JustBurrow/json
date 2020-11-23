package kr.lul.json.model;

import java.util.Objects;

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
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    JsonBooleanImpl that = (JsonBooleanImpl) o;
    return this.bool == that.bool;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.bool);
  }

  @Override
  public String toString() {
    return Boolean.toString(this.bool);
  }
}
