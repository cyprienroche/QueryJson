import com.google.gson.JsonObject;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    List<JsonObject> jsons = new LinkedList<>();
    QueryJson queryJson = new QueryJson();

    while (scanner.hasNext()) {
      String line = scanner.nextLine();

      if (line.startsWith("help")) {
        System.out.println(help());
        continue;
      }

      if (line.startsWith("exit")) {
        break;
      }

      try {
        int firstSpace = line.indexOf(' ');
        String command = line.substring(0, firstSpace);
        String jsonString = line.substring(firstSpace);
        JsonObject json = QueryJson.jsonObjectFromString(jsonString);

        switch (command) {
          case "add":
            queryJson.add(json);
            break;
          case "get":
            jsons = queryJson.get(json);
            jsons.forEach(System.out::println);
            break;
          case "delete":
            queryJson.remove(json);
            break;
          default:
            System.out.println("unknown command");
        }
      } catch (Exception e) {
        System.out.println("Error occurred: " + e);
      }
    }
  }

  private static String help() {
    StringBuilder help = new StringBuilder();
    help.append("available commands: \n");
    help.append("add json - adds the specified json to the store\n");
    help.append("get json - retrieves all json with specified \n");
    help.append("remove json - deletes specified json from the store\n");
    help.append("help\n");
    return help.toString();
  }
}
