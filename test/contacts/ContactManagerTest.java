package contacts;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class ContactManagerTest {

  @Test
  public void listsContactInfo() {
    ContactManager cm = new ContactManager();
    Person person1 = new Person("M. P. J.");
    Person person2 = new Person("M. P. Junior");
    Phone p1 = new Phone("23245242");
    Email m1 = new Email("sdf@dfodfs.asdf");
    Phone mp1 = new MobilePhone("sdfasdf");
    Email p2 = new Email("aslkdfa");

    cm.add(person1, p1);
    cm.add(person1, m1);
    cm.add(person1, mp1);
    cm.add(person1, p2);
    cm.add(person2, p2);

    List<ContactInfo> l = cm.contactDetails(person1);
    assertEquals(4, l.size());
    assertThat(l, hasItem(equalTo(p1)));
    assertThat(l, hasItem(equalTo(m1)));
    assertThat(l, hasItem(equalTo(mp1)));
    assertThat(l, hasItem(equalTo(p2)));

    l = cm.contactDetails(person2);
    assertEquals(1, l.size());
    assertThat(l, hasItem(equalTo(p2)));
    assertThat(l, not(hasItem(equalTo(p1))));

    assertEquals(0, cm.contactDetails(new Person("new person")).size());
  }

  @Test
  public void spamContacts() {
    ContactManager cm = new ContactManager();
    Person person1 = new Person("P1");
    Person person2 = new Person("P2");
    Phone p1 = new Phone("+114 53 132");
    Email m1 = new Email("emailP1@address.com");
    Phone mp1 = new MobilePhone("+434 9434 132");
    Email m2 = new Email("email2@address.com");

    ByteArrayOutputStream outstream = TestSuiteHelper.replaceSystemOutStreamForTesting();

    cm.add(person1, p1);
    cm.add(person1, m1);
    cm.add(person1, mp1);
    cm.add(person2, m2);

    cm.spam("Hello");

    String actualOutput = outstream.toString();

    assertThat(actualOutput, containsString(m1.contactInfo()));
    assertThat(actualOutput, containsString(mp1.contactInfo()));
    assertThat(actualOutput, containsString(m2.contactInfo()));
    assertThat(actualOutput, containsString(p1.contactInfo()));
    assertThat(actualOutput, containsString("Hello"));
  }
}
