import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JsonMockPeople {

  private static Gson gson = new Gson();

  public static final JsonObject john = personToJsonObject(new Person(1, "Doe", "John",
      new Location("Oakland", "CA", "94607"), true));

  public static final JsonObject jane = personToJsonObject(new Person(2, "Doe", "Jane",
      new Location("San Francisco", "CA", "94105"), true));

  public static final JsonObject jim = personToJsonObject(new Person(3, "Black", "Jim",
      new Location("Spokane", "WA", "99207"), true));

  public static final JsonObject jack = personToJsonObject(new Person(4, "Frost", "Jack",
      new Location("Seattle", "WA", "98204"), false));


  private static final List<JsonObject> people  = Arrays.asList(
      john, jane, jim, jack
  );

  public static List<JsonObject> getMockPeople() {
    return people;
  }

  public static JsonObject personToJsonObject(Person person) {
    return QueryJson.jsonObjectFromString(gson.toJson(person));
  }

  public static JsonObject locationToJsonObject(Location location) {
    return QueryJson.jsonObjectFromString(gson.toJson(location));
  }

}
