import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class QueryJson {


    private JsonObject[] jsons;

    public QueryJson(JsonObject[] jsons) {

        this.jsons = jsons;
    }

    public JsonObject[] get(JsonObject json) {
        return jsons;
    }
}
