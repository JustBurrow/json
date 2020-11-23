package kr.lul.json.model;

import java.math.BigDecimal;
import java.util.Objects;

import static kr.lul.common.util.Arguments.notNull;

/**
 * @author justburrow
 * @since 2020/10/20
 */
public class JsonNumberImpl implements JsonNumber {
  private BigDecimal number;


  public JsonNumberImpl(int i) {
    this.number = new BigDecimal(i);
  }

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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    JsonNumberImpl that = (JsonNumberImpl) o;
    return this.number.equals(that.number);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.number);
  }

  @Override
  public String toString() {
    return this.number.toString();
  }
}
