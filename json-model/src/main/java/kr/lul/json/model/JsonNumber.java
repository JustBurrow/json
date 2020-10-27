package kr.lul.json.model;

import java.math.BigDecimal;

/**
 * @author justburrow
 * @since 2020/10/20
 */
public interface JsonNumber extends JsonValue {
  BigDecimal toBigDecimal();
}
