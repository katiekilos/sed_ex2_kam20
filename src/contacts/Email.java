package contacts;

public class Email extends ContactInfo implements TextMessageEnabled {

    String email;

    @Override
    public void sendTextMessage(String msg) {
        System.out.println( email );
        System.out.println( msg );
    }

    public Email(String address ){
        email = address;
    }


    @Override
    public String contactInfo() {
        return email;
    }

    @Override
    public String contactInfoType() {
        return "E-mail";
    }

    @Override
    public void sendMessage(String msg) {
        sendTextMessage(msg);
    }
}
