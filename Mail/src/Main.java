import mail.Mail;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start");

        Mail mail = new Mail(); //creating an instance of Mail class
        mail.setMsg("Hi");//email message
        mail.setTo("perera.alc2000@gmail.com"); //receiver's mail
        mail.setSubject("Test"); //email subject

        Thread thread = new Thread(mail);
        thread.start();

        System.out.println("end");
    }
}