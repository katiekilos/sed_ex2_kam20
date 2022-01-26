package contacts;

public class Contact{

    private Person person;
    private ContactInfo contactinfo;

    public Person getPerson(){
        return person;
    }

    public ContactInfo getContactinfo(){
        return contactinfo;
    }


    Contact(Person p, ContactInfo c){
        person = p;
        contactinfo = c;
    }
}
