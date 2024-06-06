/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS;

import java.util.Properties;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author josel
 */
@WebService(serviceName = "WS")
public class WS {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    @WebMethod(operationName = "emailAutomatico")
    public void emailAutomatico(@WebParam(name = "destinatario") String destinatario, @WebParam(name = "asunto") String asunto, @WebParam(name = "texto") String texto){
        // Información de autenticación
        final String username = "biblioupo44@gmail.com";
        final String password = "ProyectoIT";

        // Propiedades de la sesión
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // Crear una sesión con autenticación
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            // Crear un mensaje de correo electrónico
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("joseluislealgarcia03@gmail.com"));
            message.setSubject("Asunto del correo");
            message.setText("Este es el contenido del correo");

            // Enviar el mensaje
            Transport.send(message);

            System.out.println("¡El correo fue enviado correctamente!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
