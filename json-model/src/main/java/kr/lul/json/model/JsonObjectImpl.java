package kr.lul.json.model;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import static kr.lul.common.util.Arguments.notNull;

/**
 * @author justburrow
 * @since 2020/11/23
 */
public class JsonObjectImpl implements JsonObject {
  private Map<String, JsonValue> object;

  public JsonObjectImpl(Map<String, JsonValue> object) {
    notNull(object, "object");

    for (String key : object.keySet()) {
      if (null == key)
        throw new IllegalArgumentException("object has null key : " + object);
    }

    if (object instanceof LinkedHashMap) {
      this.object = object;
    } else {
      this.object = new LinkedHashMap<>(object);
    }
  }

  @Override
  public JsonValue get(String key) {
    notNull(key, "key");
    return this.object.get(key);
  }

  @SuppressWarnings("unchecked")
  @Override
  public <V extends JsonValue> V get(String key, Class<V> type) {
    notNull(type, "type");
    return (V) get(key);
  }

  @Override
  public Map<String, JsonValue> toMap() {
    return Collections.unmodifiableMap(this.object);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    JsonObjectImpl that = (JsonObjectImpl) o;
    return this.object.equals(that.object);
  }

  @Override
  public int hashCode() {
    return this.object.hashCode();
  }

  @Override
  public String toString() {
    return this.object.toString();
  }
}
