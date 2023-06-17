# Send-mail-using-java
Java provides Java Mail API - a platform and protocol independent framework to build mail and messaging applications. In this guide, you will get detailed steps on how to setup JavaMail in your Java Project and implement JavaMail API to build and send emails on SMTP protocol.

This Java application demonstrates sending emails using the JavaMail API. It provides a simple interface to set the email message, recipient's email address, and subject, and sends the email asynchronously.

## Dependencies

- javax.mail.jar
- activation-1.1.1.jar

Make sure to include these JAR files in your project's classpath.

## Getting Started

1. Clone or download the repository to your local machine.
2. Set up the necessary dependencies and ensure they are added to the classpath of your project.
3. Open the project in your preferred Java IDE.
4. Locate the `Mail` class.
5. Customize the email configurations in the `outMail` method:
   - Set the sender's email address and password in the `from` and `getPasswordAuthentication` methods.
   - Adjust the SMTP server, port, and other properties if necessary.
6. Build and run the application.
7. In your code, create an instance of the `Mail` class.
8. Use the `setMsg`, `setTo`, and `setSubject` methods to set the email message, recipient's email address, and subject, respectively.
9. Start a new thread with the `Mail` object to send the email asynchronously.

Here's an example:

```java
import mail.Mail;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start");

        Mail mail = new Mail();
        mail.setMsg("Hi");
        mail.setTo("recipient@example.com");
        mail.setSubject("Test");

        Thread thread = new Thread(mail);
        thread.start();

        System.out.println("end");
    }
}
```

## SMTP Configuration
SMTP (Simple Mail Transfer Protocol) is a protocol used for sending email messages between servers. To send emails using the JavaMail API, you need to configure the SMTP server details in the Mail class.

In the outMail method, the following properties are set for the SMTP server:

mail.smtp.host: The hostname or IP address of the SMTP server.
mail.smtp.port: The port number on which the SMTP server is listening.
mail.smtp.auth: Specifies whether authentication is required for the SMTP server.
mail.smtp.starttls.enable: Specifies whether to use the STARTTLS command to switch the connection to a secure communication channel.
You need to modify these properties based on your SMTP server configuration. Additionally, the from and getPasswordAuthentication methods should be updated with the sender's email address and password for authentication.

Make sure to consult your email service provider or system administrator to obtain the correct SMTP server details and authentication credentials.

## Contributing
Contributions to this project are welcome. If you find any issues or have suggestions for improvements, please open an issue or submit a pull request.
