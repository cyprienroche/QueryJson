import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class QueryJson {


    private List<JsonObject> jsons;

    public QueryJson() {
        this(new LinkedList<>());
    }

    public QueryJson(JsonObject... jsons) {
        this(Arrays.stream(jsons).collect(Collectors.toList()));
    }

    public QueryJson(List<JsonObject> jsons) {
        this.jsons = jsons;
    }

    public boolean add(JsonObject json) {
        return jsons.add(json);
    }

    public List<JsonObject> get(JsonObject json) {
        List<JsonObject> res = new LinkedList<>();

        json.entrySet().forEach(e ->
            res.addAll(getJsonsWithSameEntry(e.getKey(), e.getValue())));
        return res;
    }

    private List<JsonObject> getJsonsWithSameEntry(String memberName, JsonElement elem) {

        return jsons.stream()
            .filter(jsonObject -> jsonObject.has(memberName)
                && jsonObject.get(memberName).equals(elem))
            .collect(Collectors.toList());
    }

    public static JsonObject jsonObjectFromString(String string) {
        JsonParser parser = new JsonParser();
        return parser.parse(string).getAsJsonObject();
    }
}
