public class Person {

  private int id;
  private String last;
  private String first;
  private Location location;
  private boolean active;


  public Person(int id, String last, String first, Location location, boolean active) {
    this.id = id;
    this.last = last;
    this.first = first;
    this.location = location;
    this.active = active;
  }
}