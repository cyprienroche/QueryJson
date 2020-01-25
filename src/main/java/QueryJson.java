import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class QueryJson {


    public QueryJson(JsonObject[] json) {

    }

    public static void main(String[] args) {

//        Gson gson = new GsonBuilder().create();
        Gson gson = new Gson();
//        String s1 = {"id":"100"}";
    }

    public JsonObject[] get(JsonObject json) {
        return new JsonObject[]{json};
    }
}
