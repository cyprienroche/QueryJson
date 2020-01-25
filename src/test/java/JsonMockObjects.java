import com.google.gson.JsonObject;

public class JsonMockObjects {

  public static JsonObject jsonWithIdOnly() {
    JsonObject json = new JsonObject();
    json.addProperty("id", 1);
    return json;
  }

  public static JsonObject jsonWithIdAndValid() {
    JsonObject json = jsonWithIdOnly();
    json.addProperty("valid", true);
    return json;
  }

  public static JsonObject otherJsonWithIdAndValid() {
    JsonObject json = jsonWithIdOnly();
    json.addProperty("valid", false);
    return json;
  }

}
