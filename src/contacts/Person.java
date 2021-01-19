package contacts;

public class Person {

  private final String name;

  public Person(String name) {
    this.name = name;
  }

  public String name() {
    return name;
  }

  @Override
  public String toString() {
    return name;
  }
}
