import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import com.google.gson.JsonObject;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class QueryJsonTest {

  QueryJson queryJson = new QueryJson(JsonMockObjects.jsonWithId(1),
      JsonMockObjects.jsonWithIdAndValid(2, true),
      JsonMockObjects.jsonWithIdAndValid(3, false));

  @Test
  public void getSameJsonAsInConstructorReturnsThatJson() {
    List<JsonObject> res = queryJson.get(JsonMockObjects.jsonWithId(1));

    assertThat(res, is(Arrays.asList(JsonMockObjects.jsonWithId(1))));
  }

  @Test
  public void getJsonGivenOnlyOneParameter() {

    List<JsonObject> res = queryJson.get(JsonMockObjects.jsonWithId(2));

    assertThat(res, is(Arrays.asList(JsonMockObjects.jsonWithIdAndValid(2,true))));
  }


}