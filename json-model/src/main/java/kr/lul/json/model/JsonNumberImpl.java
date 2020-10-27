package kr.lul.json.model;

import java.math.BigDecimal;

import static kr.lul.common.util.Arguments.notNull;

/**
 * @author justburrow
 * @since 2020/10/20
 */
public class JsonNumberImpl implements JsonNumber {
  private BigDecimal number;

  public JsonNumberImpl(String number) {
    this(new BigDecimal(number));
  }

  public JsonNumberImpl(BigDecimal number) {
    notNull(number, "number");
    this.number = number;
  }

  @Override
  public BigDecimal toBigDecimal() {
    return this.number;
  }
}
