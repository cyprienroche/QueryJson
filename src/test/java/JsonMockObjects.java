import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

  public static JsonObject jsonList(int... elem) {
    List<Integer> list = Arrays.stream(elem).boxed().collect(Collectors.toList());
    Gson gson = new Gson();
    return QueryJson.jsonObjectFromString(gson.toJson(new JsonList(list)));
  }

  private static class JsonList {
    private String type = "list";
    private List<Integer> list;

    public JsonList(List<Integer> list) {
      this.list = list;
    }
  }
}
