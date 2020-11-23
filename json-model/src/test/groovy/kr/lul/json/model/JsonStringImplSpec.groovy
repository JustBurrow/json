package kr.lul.json.model

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import spock.lang.Specification
import spock.lang.Unroll

import static java.util.concurrent.ThreadLocalRandom.current
import static org.apache.commons.lang3.RandomStringUtils.random

/**
 * @author justburrow* @since 2020/10/27
 */
@Unroll
class JsonStringImplSpec extends Specification {
  private static final Logger LOGGER = LoggerFactory.getLogger(JsonStringImplSpec)

  def "new(null)"() {
    when:
    new JsonStringImpl(null)

    then:
    def e = thrown(NullPointerException)

    null != e
    "value is null." == e.message
  }

  def "json string"() {
    given:
    LOGGER.info("[GIVEN] input=$input")

    when:
    def json = new JsonStringImpl(input)
    LOGGER.info("[WHEN] json=$json")

    then:
    actual == json.value
    actual == json.toString()

    where:
    input                                  || actual
    ""                                     || ""
    "12345"                                || new String("12345")
    random(1)                              || new String(input)
    random(100)                            || new String(input)
    random(current().nextInt(100, 10_000)) || new String(input)
    random(10_000)                         || new String(input)
  }
}
