import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class JsonMockObjects {

  public static JsonObject jsonWithId(int id) {
    JsonObject json = new JsonObject();
    json.addProperty("id", id);
    return json;
  }

  public static JsonObject jsonWithIdAndValid(int id, boolean valid) {
    JsonObject json = jsonWithId(id);
    json.addProperty("valid", valid);
    return json;
  }

  public static JsonObject jsonPerson(int id, String last, String first, Location location , boolean active) {
    Gson gson = new Gson();
    return QueryJson.jsonObjectFromString(gson.toJson(new Person(id, last, first, location, active)));
  }

  public static JsonObject jsonLocation(String city, String state, String postcode) {
    Gson gson = new Gson();
    return QueryJson.jsonObjectFromString(gson.toJson(new Location(city, state, postcode)));
  }

}
