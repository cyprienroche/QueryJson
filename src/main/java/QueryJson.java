import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class QueryJson {


    private List<JsonObject> jsons;

    public QueryJson(List<JsonObject> jsons) {

        this.jsons = jsons;
    }

    public List<JsonObject> get(JsonObject json) {
        return jsons.stream()
            .filter(jsonObject -> jsonObject.equals(json))
            .collect(Collectors.toList());
    }

    public static JsonObject jsonObjectFromString(String string) {
        JsonParser parser = new JsonParser();
        JsonElement json = parser.parse(string);
        if (json.isJsonObject()) {
            return json.getAsJsonObject();
        }
        return null;
    }
}
