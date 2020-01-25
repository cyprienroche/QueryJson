import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import com.google.gson.JsonObject;
import org.junit.Test;

public class QueryJsonTest {

  JsonObject json = new JsonObject();
  JsonObject json2 = new JsonObject();

  @Test
  public void simpleJsonAddAndGetWithOneProperty() {
    json.addProperty("id", 1);
    QueryJson queryJson = new QueryJson(json);

    assertThat(queryJson.get(json).get("id"), is(json.get("id")));
  }

  @Test
  public void simpleJsonAddAndGetWithTwoProperties() {
    json.addProperty("id", 1);
    json.addProperty("valid", true);
    QueryJson queryJson = new QueryJson(json);

    assertThat(queryJson.get(json).get("id"), is(json.get("id")));
    assertThat(queryJson.get(json).get("valid"), is(json.get("valid")));
  }

  @Test
  public void addAndGetTwoDifferentJson() {
    json.addProperty("id", 1);
    json.addProperty("valid", true);

    json2.addProperty("id", 2);
    json2.addProperty("valid", false);
    QueryJson queryJson = new QueryJson(json);

    assertThat(queryJson.get(json).get("id"), is(json.get("id")));
    assertThat(queryJson.get(json).get("valid"), is(json.get("valid")));
  }
}