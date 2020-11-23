package kr.lul.json.model

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import spock.lang.Specification
import spock.lang.Unroll

/**
 * @author justburrow* @since 2020/11/23
 */
@Unroll
class JsonObjectImplSpec extends Specification {
  private static final Logger LOGGER = LoggerFactory.getLogger(JsonObjectImplSpec)

  def "new with null"() {
    when: "생성자의 인자로 null 사용."
    def json = new JsonObjectImpl(null)
    LOGGER.info("[WHEN] json=$json")

    then: "예외 발생."
    def e = thrown(IllegalArgumentException)

    null != e
    "object is null." == e.message
  }

  def "object with null key"() {
    given: "null 문자열을 키인 엔트리가 있는 Map 인스턴스."
    def object = new HashMap()
    object.put(null, null)
    LOGGER.info("[GIVEN] object=$object")

    when: "생성자 호출."
    def json = new JsonObjectImpl(object)
    LOGGER.info("[WHEN] json=$json")

    then: "예외 발생."
    def e = thrown(IllegalArgumentException)
    LOGGER.info("[THEN] e=${e}", e)

    null != e
    e.message.startsWith("object has null key")
  }

  def "toMap"() {
    given:
    def object = new HashMap()
    object.put("a", new JsonStringImpl("a"))
    LOGGER.info("[GIVEN] object=$object")

    def json = new JsonObjectImpl(object)
    LOGGER.info("[GIVEN] json=$json")

    when:
    def map = json.toMap()
    LOGGER.info("[GIVEN] map=$map")

    then:
    null != map
    1 == map.size()
    with(map.get("a")) {
      "a" == (it as JsonStringImpl).value
    }
  }
}
