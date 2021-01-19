package contacts;

import org.junit.Test;

import java.io.ByteArrayOutputStream;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

public class EmailTest {

  @Test
  public void sendMessage() {
    ByteArrayOutputStream outstream = TestSuiteHelper.replaceSystemOutStreamForTesting();

    String address = "myEmail@domain.com";
    String msg = "Hello";

    Email email = new Email(address);
    email.sendMessage(msg);

    String actualOutput = outstream.toString();

    assertThat(actualOutput, containsString(msg));
    assertThat(actualOutput, containsString(address));
    assertThat(actualOutput, not(containsString("Audio")));
  }
}
