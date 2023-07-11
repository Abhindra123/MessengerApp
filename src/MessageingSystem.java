import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

interface MessagingService{
    public void sendMessage();
}
class SMSMessagingService implements MessagingService{
    public void sendMessage(){
        System.out.println("Message sent through SMS");
    }
}
class EmailMessagingService implements MessagingService{
    public void sendMessage(){
        System.out.println("Message sent through email");
    }
}
class WhatsAppMessagingService implements MessagingService{
    public void sendMessage(){
        System.out.println("Message sent through  whatsappp");
    }
}
class Message{
    public void sendMessage(MessagingService mem){
        mem.sendMessage();
    }
}


public class MessageingSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Message message = new Message();

        System.out.println("Enter 1 for SMS or Enter 2 for Email or Enter 3 for Whatsapp ");
        int choice;
        do {
            choice = sc.nextInt();

            if (choice == 2) {
                System.out.println("Enter the email address: ");
                sc.nextLine();
                String email = sc.nextLine();
                boolean flag = checkEmail(email);
                if (flag) {
                    MessagingService messagingService = new EmailMessagingService();
                    message.sendMessage(messagingService);
                } else {
                    System.out.println("Please enter a valid email");
                }
            } else if (choice == 1) {
                System.out.println("Enter the PhoneNumber: ");
                long num = sc.nextLong();
                boolean flag1 = checkNumber(num);
                if (flag1) {
                    //System.out.println("valid Number");
                    MessagingService messagingService = new SMSMessagingService();
                    message.sendMessage(messagingService);
                } else {
                    System.out.println("Invalid Number");
                }
            } else if (choice == 3) {
                System.out.println("Enter 1 if you have whatsapp or Enter 2 if you dont have whatsapp or Press 0 for exit");
                int Whatsapp_choice = sc.nextInt();
                if (Whatsapp_choice == 1) {
                    System.out.println("Enter the WhatsappNumber: ");
                    long num = sc.nextLong();
                    boolean flag1 = checkNumber(num);
                    if (flag1) {
                        //System.out.println("valid Number");
                        MessagingService messagingService = new WhatsAppMessagingService();
                        message.sendMessage(messagingService);
                    } else {
                        System.out.println("Invalid Number");
                    }
                }
                 else {
                    System.out.println("Please try another method");
                }

            }

    }while (choice!=0);

}








     static boolean checkEmail(String email){
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(email);
        return matcher.matches();
    }
    static boolean checkNumber(long num){
        String regex="(0|91)?[6-9][0-9]{9}";
        String c=String.valueOf(num);
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(c);
        return  matcher.matches();
    }
}