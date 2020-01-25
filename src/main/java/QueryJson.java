import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class QueryJson {


    private List<JsonObject> jsons;

    public QueryJson() {
        this(new LinkedList<>());
    }

    public QueryJson(List<JsonObject> jsons) {
        this.jsons = jsons;
    }

    public boolean add(JsonObject json) {
        return jsons.add(json);
    }

    public List<JsonObject> get(JsonObject json) {
        return jsons.stream()
            .filter(jsonObject -> jsonObject.equals(json))
            .collect(Collectors.toList());
    }

    public static JsonObject jsonObjectFromString(String string) {
        JsonParser parser = new JsonParser();
        return parser.parse(string).getAsJsonObject();
    }
}
