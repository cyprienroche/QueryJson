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
    json.addProperty("id", 1);
    return json;
  }

  @Test
  public void simpleJsonAddAndGetWithOneProperty() {
    QueryJson queryJson = new QueryJson(new JsonObject[]{jsonWithIdOnly()});

    JsonObject[] res = queryJson.get(jsonWithIdOnly());

    assertThat(res[0], is(jsonWithIdAndValid()));
  }

  @Test
  public void simpleJsonAddAndGetWithTwoProperties() {
    QueryJson queryJson = new QueryJson(new JsonObject[]{jsonWithIdAndValid()});

    JsonObject[] res = queryJson.get(jsonWithIdAndValid());

    assertThat(res[0], is(jsonWithIdAndValid()));
  }

}