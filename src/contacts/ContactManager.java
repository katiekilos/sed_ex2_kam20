package contacts;

import java.util.LinkedList;
import java.util.List;

public class ContactManager {

    private List<Contact> list = new LinkedList<>();
    private List<ContactInfo> searched_list = new LinkedList<>();

    public void add(Person p, ContactInfo c) {
        Contact contact = new Contact(p, c);
        list.add( contact );
    }

    public List<ContactInfo> contactDetails(Person p){
        searched_list.clear();
        for(Contact c : list){
            Person temp = c.getPerson();
            if(temp.toString() == p.toString()){
                searched_list.add( c.getContactinfo() );
            }
        }
        return searched_list;
    }

    public void spam(String msg){
        for(Contact c : list){
            c.getContactinfo().sendMessage( msg );
        }
    }

}
