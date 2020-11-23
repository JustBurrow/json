package kr.lul.json.model;

import static java.util.Objects.requireNonNull;

/**
 * @author justburrow
 * @since 2020/10/27
 */
public class JsonStringImpl implements JsonString {
  private String value;

  public JsonStringImpl(String value) {
    requireNonNull(value, "value is null.");
    this.value = value;
  }

  @Override
  public String getValue() {
    return this.value;
  }

  @Override
  public int hashCode() {
    return this.value.hashCode();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    JsonStringImpl that = (JsonStringImpl) o;
    return this.value.equals(that.value);
  }

  @Override
  public String toString() {
    return this.value;
  }
}
