package kr.lul.json.model;

import java.util.List;

/**
 * @author justburrow
 * @since 2020/10/28
 */
public interface JsonArray extends JsonValue {
  JsonValue[] toArray();

  List<JsonValue> toList();
}
