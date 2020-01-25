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

}
