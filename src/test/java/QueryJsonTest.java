import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import com.google.gson.JsonObject;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class QueryJsonTest {

  @Test
  public void simpleJsonAddAndGetWithOneProperty() {
    List<JsonObject> in = Arrays.asList(JsonMockObjects.jsonWithIdOnly());

    QueryJson queryJson = new QueryJson(in);

    List<JsonObject> res = queryJson.get(JsonMockObjects.jsonWithIdOnly());

    assertThat(res, is(in));
  }

  @Test
  public void simpleJsonAddAndGetWithTwoProperties() {
    List<JsonObject> in = Arrays.asList(JsonMockObjects.jsonWithIdAndValid());

    QueryJson queryJson = new QueryJson(in);

    List<JsonObject> res = queryJson.get(JsonMockObjects.jsonWithIdAndValid());

    assertThat(res, is(in));
  }

  @Test
  public void addAndGetTwoJsonWithSamePropertiesAndValues() {
    List<JsonObject> in = Arrays.asList(
        JsonMockObjects.jsonWithIdAndValid(), JsonMockObjects.jsonWithIdAndValid());

    QueryJson queryJson = new QueryJson(in);

    List<JsonObject> res = queryJson.get(JsonMockObjects.jsonWithIdAndValid());

    assertThat(res, is(in));
  }

  @Test
  public void addAndGetTwoJsonWithSamePropertiesButDifferentValues() {
    List<JsonObject> in = Arrays.asList(
        JsonMockObjects.jsonWithIdAndValid(), JsonMockObjects.otherJsonWithIdAndValid());

    QueryJson queryJson = new QueryJson(in);

    List<JsonObject> res = queryJson.get(JsonMockObjects.jsonWithIdAndValid());

    assertThat(res, is(Arrays.asList(JsonMockObjects.jsonWithIdAndValid())));
  }


}