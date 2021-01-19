package contacts;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestSuiteHelper {

  public static ByteArrayOutputStream replaceSystemOutStreamForTesting() {
    ByteArrayOutputStream outstream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outstream));
    return outstream;
  }
}
