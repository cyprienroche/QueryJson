import com.google.gson.JsonArray;
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

    public void remove(JsonObject json) {
        List<JsonObject> toDelete = get(json);
        jsons = jsons.stream().filter(jsonObject -> !toDelete.contains(jsonObject))
            .collect(Collectors.toList());
    }

    public List<JsonObject> get(JsonObject json) {
        return jsons.stream()
            .filter(jsonObject -> hasAllSameEntries(json, jsonObject))
            .collect(Collectors.toList());
    }

    private boolean hasAllSameEntries(JsonObject jsonWithEntries, JsonObject jsonToDecide) {
        return jsonWithEntries.entrySet()
            .stream()
            .allMatch(e -> hasSameEntry(jsonToDecide, e.getKey(), e.getValue()));
    }

    private boolean hasSameEntry(JsonObject json, String memberName, JsonElement elem) {
        if (!json.has(memberName)) {
            return false;
        }
        if (elem.isJsonPrimitive() && json.get(memberName).isJsonPrimitive()) {
            return json.get(memberName).equals(elem);
        }

        if (elem.isJsonObject() && json.get(memberName).isJsonObject()) {
            JsonObject objectWithEntries = elem.getAsJsonObject();
            JsonObject objectToDecide = json.getAsJsonObject(memberName);
            return hasAllSameEntries(objectWithEntries, objectToDecide);
        }

        if (elem.isJsonArray() && json.get(memberName).isJsonArray()) {
            JsonArray objectWithEntries = elem.getAsJsonArray();
            JsonArray objectToDecide = json.getAsJsonArray(memberName);

            for (JsonElement element : objectWithEntries) {
                if (!objectToDecide.contains(element)) {
                    return false;
                }
            }
            return true;
        }

        return false;
    }

    public static JsonObject jsonObjectFromString(String string) {
        JsonParser parser = new JsonParser();
        return parser.parse(string).getAsJsonObject();
    }
}
