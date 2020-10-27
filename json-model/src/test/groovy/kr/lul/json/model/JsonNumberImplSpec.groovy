package kr.lul.json.model

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import spock.lang.Specification
import spock.lang.Unroll

/**
 * @author justburrow* @since 2020/10/20
 */
@Unroll
class JsonNumberImplSpec extends Specification {
  private static final Logger LOGGER = LoggerFactory.getLogger(JsonNumberImplSpec)

  def "new with null"() {
    when:
    new JsonNumberImpl((BigDecimal) null)

    then:
    def e = thrown(IllegalArgumentException)
    LOGGER.info("[THEN] e=$e")
    null != e
    "number is null." == e.message

    when:
    new JsonNumberImpl((String) null)

    then:
    e = thrown(NullPointerException)
    LOGGER.info("[THEN] e=$e")
    null != e
  }

  def "new with string"() {
    given:
    LOGGER.info("[GIVEN] number=$number")

    when:
    def value = new JsonNumberImpl(number)
    LOGGER.info("[WHEN] value=$value")

    then:
    expected == value.toBigDecimal()

    where:
    number || expected
    "0"    || 0
    "1.0"  || 1.0
    "1e2"  || 1e2
  }
}
