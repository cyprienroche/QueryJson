import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.Arrays;
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
        return jsons.stream()
            .filter(jsonObject -> hasAllSameEntries(json, jsonObject))
            .collect(Collectors.toList());
    }

    private boolean hasSameEntry(JsonObject json, String memberName, JsonElement elem) {
        return json.has(memberName) && json.get(memberName).equals(elem);
    }

    private boolean hasAllSameEntries(JsonObject jsonWithEntries, JsonObject jsonToDecide) {
        return jsonWithEntries.entrySet()
            .stream()
            .allMatch(e -> hasSameEntry(jsonToDecide, e.getKey(), e.getValue()));
    }

    public static JsonObject jsonObjectFromString(String string) {
        JsonParser parser = new JsonParser();
        return parser.parse(string).getAsJsonObject();
    }
}
