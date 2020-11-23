package kr.lul.json.model;

import java.util.Map;

/**
 * @author justburrow
 * @since 2020/11/23
 */
public interface JsonObject extends JsonValue {
  JsonValue get(String key);

  <V extends JsonValue> V get(String key, Class<V> type);

  Map<String, JsonValue> toMap();
}
