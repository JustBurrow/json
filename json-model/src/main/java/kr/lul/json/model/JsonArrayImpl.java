package kr.lul.json.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Objects.requireNonNull;

/**
 * @author justburrow
 * @since 2020/10/28
 */
public class JsonArrayImpl implements JsonArray {
  private List<JsonValue> list;

  public JsonArrayImpl(JsonValue[] array) {
    requireNonNull(array, "array is null.");

    this.list = new ArrayList<>();
  }

  public JsonArrayImpl(List<JsonValue> list) {
    requireNonNull(list, "list is null.");

    this.list = list;
  }

  @Override
  public JsonValue[] toArray() {
    JsonValue[] array = new JsonValue[this.list.size()];
    for (int i = 0; i < this.list.size(); i++) {
      array[i] = this.list.get(i);
    }
    return array;
  }

  @Override
  public List<JsonValue> toList() {
    return new ArrayList<>(this.list);
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null || getClass() != other.getClass()) return false;
    JsonArrayImpl that = (JsonArrayImpl) other;
    return this.list.equals(that.list);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.list);
  }

  @Override
  public String toString() {
    return this.list.toString();
  }
}
