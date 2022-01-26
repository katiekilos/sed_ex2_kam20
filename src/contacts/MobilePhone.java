package contacts;

public class MobilePhone extends Phone implements TextMessageEnabled{

    public MobilePhone(String num) {
        super(num);
    }

    @Override
    public void sendTextMessage(String msg) {
        System.out.println(contactInfo());
        System.out.println(msg);
    }
    @Override
    public void sendMessage(String msg) {
        sendTextMessage(msg);
    }
}
