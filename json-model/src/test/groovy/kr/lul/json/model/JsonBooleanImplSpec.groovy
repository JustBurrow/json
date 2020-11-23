package kr.lul.json.model

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import spock.lang.Specification
import spock.lang.Unroll

/**
 * @author justburrow* @since 2020/10/28
 */
@Unroll
class JsonBooleanImplSpec extends Specification {
  private static final Logger LOGGER = LoggerFactory.getLogger(JsonBooleanImplSpec)

  def "new"() {
    given:
    LOGGER.info("[GIVEN] b=$b")

    when:
    def json = new JsonBooleanImpl(b)
    LOGGER.info("[WHEN] json=$json")

    then:
    expected == json.toBoolean()

    where:
    b     || expected
    true  || true
    false || false
  }
}
