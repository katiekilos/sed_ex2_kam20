package contacts;

import org.junit.Test;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayOutputStream;

public class PhoneTest {

  @Test
  public void sendMessage() {
    ByteArrayOutputStream outstream = TestSuiteHelper.replaceSystemOutStreamForTesting();

    String phoneNumber = "+501 323 33";
    String msg = "Hello";

    Phone p1 = new Phone(phoneNumber);
    p1.sendMessage(msg);

    String actualOutput = outstream.toString();

    assertThat(actualOutput, containsString(msg));
    assertThat(actualOutput, containsString(phoneNumber));
    assertThat(actualOutput, containsString("Audio"));
  }
}
