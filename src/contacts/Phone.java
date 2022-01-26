package contacts;

public class Phone extends ContactInfo implements AudioMessageEnabled{

    private String number;

    public Phone( String num ){
        number = num;
    }

    @Override
    public void sendAudioMessage(Audio msg) {
        System.out.println( number );
        System.out.println( msg.toString() );
    }

    @Override
    public String contactInfo() {
        return number;
    }

    @Override
    public String contactInfoType() {
        return "Phone Number";
    }

    @Override
    public void sendMessage(String msg) {
        sendAudioMessage(new Audio(msg));
    }
}
