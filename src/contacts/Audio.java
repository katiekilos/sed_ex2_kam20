package contacts;

public class Audio {

  private final String msg;

  public Audio(String msg) {
    this.msg = msg;
  }

  @Override
  public String toString() {
    return "contacts.Audio saying '" + msg + "'";
  }
}
