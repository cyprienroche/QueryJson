import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Test;

public class JsonObjectFromStringTest {

  @Test
  public void canConvertStringToJsonObject() {
    String s = JsonMockObjects.jsonWithIdOnly().toString();
    assertThat(QueryJson.jsonObjectFromString(s), is(JsonMockObjects.jsonWithIdOnly()));
  }

  @Test
  public void canConvertStringToJsonComplexObject() {
    String s = JsonMockObjects.jsonWithIdAndValid().toString();
    assertThat(QueryJson.jsonObjectFromString(s), is(JsonMockObjects.jsonWithIdAndValid()));
  }

  @Test
  public void shouldThrowAnExceptionWhenConvertingNonObjectJson() {
    String s = "This is not a json object";
    try {
      QueryJson.jsonObjectFromString(s);
      fail();
    } catch (Exception e) {
      // should throw exception
    }
  }

}
