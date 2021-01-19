package contacts;

import org.junit.Test;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayOutputStream;

public class MobilePhoneTest {

  @Test
  public void sendMessage() {
    ByteArrayOutputStream outstream = TestSuiteHelper.replaceSystemOutStreamForTesting();

    String phoneNumber = "+501 323 33";
    String msg = "Hello";

    MobilePhone p1 = new MobilePhone(phoneNumber);
    p1.sendMessage(msg);

    String actualOutput = outstream.toString();

    assertThat(actualOutput, containsString(msg));
    assertThat(actualOutput, containsString(phoneNumber));
    assertThat(actualOutput, not(containsString("Audio")));
  }
}
