import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import com.google.gson.JsonObject;
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
    JsonObject[] in = new JsonObject[]{jsonWithIdOnly()};

    QueryJson queryJson = new QueryJson(in);

    JsonObject[] res = queryJson.get(jsonWithIdOnly());

    assertThat(res[0], is(jsonWithIdOnly()));
  }

  @Test
  public void simpleJsonAddAndGetWithTwoProperties() {
    JsonObject[] in = new JsonObject[]{jsonWithIdAndValid()};

    QueryJson queryJson = new QueryJson(in);

    JsonObject[] res = queryJson.get(jsonWithIdAndValid());

    assertThat(res[0], is(jsonWithIdAndValid()));
  }

  @Test
  public void addAndGetTwoJsonWithSamePropertiesAndValues() {
    JsonObject[] in = new JsonObject[]{jsonWithIdAndValid(), jsonWithIdAndValid()};

    QueryJson queryJson = new QueryJson(in);

    JsonObject[] res = queryJson.get(jsonWithIdAndValid());

    assertThat(res, is(in));
  }

  @Test
  public void addAndGetTwoJsonWithSamePropertiesButDifferentValues() {
    JsonObject[] in = new JsonObject[]{jsonWithIdAndValid(), otherJsonWithIdAndValid()};

    QueryJson queryJson = new QueryJson(in);

    JsonObject[] res = queryJson.get(jsonWithIdAndValid());

    assertThat(res, is(in));
  }



}