import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import com.google.gson.JsonObject;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

public class QueryJsonTest {

  QueryJson queryJson = new QueryJson(JsonMockObjects.jsonWithId(1),
      JsonMockObjects.jsonWithIdAndValid(2, true),
      JsonMockObjects.jsonWithIdAndValid(3, false),
      JsonMockObjects.jsonWithIdAndValid(3, true)
  );

  QueryJson peopleJson = new QueryJson(JsonMockPeople.getMockPeople());

  @Test
  public void getSameJsonAsInConstructorReturnsThatJson() {
    List<JsonObject> res = queryJson.get(JsonMockObjects.jsonWithId(1));

    assertThat(res, is(Collections.singletonList(JsonMockObjects.jsonWithId(1))));
  }

  @Test
  public void getJsonGivenOnlyOneParameter() {

    List<JsonObject> res = queryJson.get(JsonMockObjects.jsonWithId(2));

    assertThat(res, is(Collections.singletonList(JsonMockObjects.jsonWithIdAndValid(2, true))));
  }

  @Test
  public void getJsonGivenOnlyOneParameter2() {

    List<JsonObject> res = queryJson.get(JsonMockObjects.jsonWithIdAndValid(3, true));

    assertThat(res, is(Collections.singletonList(JsonMockObjects.jsonWithIdAndValid(3, true))));
  }

  @Test
  public void getUsingActive() {

    String json = "{\"active\":true}";
    List<JsonObject> res = peopleJson.get(QueryJson.jsonObjectFromString(json));

    assertThat(res, is(Arrays.asList(JsonMockPeople.john, JsonMockPeople.jane, JsonMockPeople.jim)));
  }

  @Test
  public void getUsingActiveAndId() {

    String json = "{\"id\":2,\"active\":true}";
    List<JsonObject> res = peopleJson.get(QueryJson.jsonObjectFromString(json));

    assertThat(res, is(Collections.singletonList(JsonMockPeople.jane)));
  }

  @Test
  public void getUsingActiveAndIdExpectingNothing() {

    String json = "{\"id\":4,\"active\":true}";
    List<JsonObject> res = peopleJson.get(QueryJson.jsonObjectFromString(json));

    assertThat(res, is(Collections.emptyList()));
  }

  @Test
  public void getUsingNestedJsonInLocationAndActive() {

    String json = "{\"location\":{\"state\":\"WA\"},\"active\":true}";
    List<JsonObject> res = peopleJson.get(QueryJson.jsonObjectFromString(json));

    assertThat(res, is(Collections.singletonList(JsonMockPeople.jim)));
  }

  @Test
  public void getEverythingWhenNoJsonSpecified() {

    assertThat(peopleJson.get(new JsonObject()), is(JsonMockPeople.getMockPeople()));
  }

  @Test
  public void canDeleteElementsSimpleCase() {

    queryJson.remove(JsonMockObjects.jsonWithId(3));

    assertThat(queryJson.get(new JsonObject()), is(Arrays.asList(JsonMockObjects.jsonWithId(1),
        JsonMockObjects.jsonWithIdAndValid(2, true))));
  }

  @Test
  public void canDeleteElementsUsingPeople() {

    String json = "{\"active\":true}";
    peopleJson.remove(QueryJson.jsonObjectFromString(json));

    assertThat(peopleJson.get(new JsonObject()), is(Collections.singletonList(JsonMockPeople.jack)));
  }


}