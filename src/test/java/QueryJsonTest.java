import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import com.google.gson.JsonObject;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class QueryJsonTest {

  QueryJson queryJson = new QueryJson(JsonMockObjects.jsonWithIdOnly(),
      JsonMockObjects.jsonWithIdAndValid(),
      JsonMockObjects.otherJsonWithIdAndValid());

  @Test
  public void getSameJsonAsInConstructorReturnsThatJson() {
    List<JsonObject> expect = Arrays.asList(JsonMockObjects.jsonWithIdOnly());

    List<JsonObject> res = queryJson.get(JsonMockObjects.jsonWithIdOnly());

    assertThat(res, is(Arrays.asList(JsonMockObjects.jsonWithIdOnly())));
  }


}