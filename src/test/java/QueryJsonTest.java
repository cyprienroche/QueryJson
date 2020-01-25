import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import com.google.gson.JsonObject;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class QueryJsonTest {



  private JsonObject jsonWithIdOnly() {
    JsonObject json = new JsonObject();
    json.addProperty("id", 1);
    return json;
  }

  private JsonObject jsonWithIdAndValid() {
    JsonObject json = jsonWithIdOnly();
    json.addProperty("valid", true);
    return json;
  }

  private JsonObject otherJsonWithIdAndValid() {
    JsonObject json = jsonWithIdOnly();
    json.addProperty("valid", false);
    return json;
  }

  @Test
  public void simpleJsonAddAndGetWithOneProperty() {
    List<JsonObject> in = Arrays.asList(jsonWithIdOnly());

    QueryJson queryJson = new QueryJson(in);

    List<JsonObject> res = queryJson.get(jsonWithIdOnly());

    assertThat(res, is(in));
  }

  @Test
  public void simpleJsonAddAndGetWithTwoProperties() {
    List<JsonObject> in = Arrays.asList(jsonWithIdAndValid());

    QueryJson queryJson = new QueryJson(in);

    List<JsonObject> res = queryJson.get(jsonWithIdAndValid());

    assertThat(res, is(in));
  }

  @Test
  public void addAndGetTwoJsonWithSamePropertiesAndValues() {
    List<JsonObject> in = Arrays.asList(jsonWithIdAndValid(), jsonWithIdAndValid());

    QueryJson queryJson = new QueryJson(in);

    List<JsonObject> res = queryJson.get(jsonWithIdAndValid());

    assertThat(res, is(in));
  }

  @Test
  public void addAndGetTwoJsonWithSamePropertiesButDifferentValues() {
    List<JsonObject> in = Arrays.asList(jsonWithIdAndValid(), otherJsonWithIdAndValid());

    QueryJson queryJson = new QueryJson(in);

    List<JsonObject> res = queryJson.get(jsonWithIdAndValid());

    assertThat(res, is(Arrays.asList(jsonWithIdAndValid())));
  }

  @Test
  public void canConvertStringToJsonObject() {
    String s = jsonWithIdOnly().toString();
    assertThat(QueryJson.jsonObjectFromString(s), is(jsonWithIdOnly()));
  }

  @Test
  public void canConvertStringToJsonComplexObject() {
    String s = jsonWithIdAndValid().toString();
    assertThat(QueryJson.jsonObjectFromString(s), is(jsonWithIdAndValid()));
  }


}