package kr.lul.json.model

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import spock.lang.Specification
import spock.lang.Unroll

/**
 * @author justburrow* @since 2020/10/28
 */
@Unroll
class JsonArrayImplSpec extends Specification {
  private static final Logger LOGGER = LoggerFactory.getLogger(JsonArrayImplSpec)

  def "new with null"() {
    when:
    new JsonArrayImpl(null)

    then:
    def e = thrown(NullPointerException)
    null != e
  }

  def "toArray & toList"() {
    given:
    LOGGER.info("[GIVEN] array=$array")

    when:
    def json = new JsonArrayImpl(array)
    LOGGER.info("[WHEN] json=$json")

    then:
    toArray == json.toArray()
    toList == json.toList()

    where:
    array                                                || toArray                                                        | toList
    [new JsonBooleanImpl(true)]                          || [new JsonBooleanImpl(true)].toArray()                          | [new JsonBooleanImpl(true)]
    [new JsonBooleanImpl(false), new JsonStringImpl("")] || [new JsonBooleanImpl(false), new JsonStringImpl("")].toArray() | [new JsonBooleanImpl(false), new JsonStringImpl("")]
    [new JsonStringImpl(""), new JsonNumberImpl(1)]      || [new JsonStringImpl(""), new JsonNumberImpl(1)].toArray()      | [new JsonStringImpl(""), new JsonNumberImpl(1)]
  }
}
