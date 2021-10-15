package requirem.second;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Email{

    private static int cont = 0;

    private int id = 1;
    private String recipient;
    private String sender;
    private String bodyEmail;
    private String subject;

    // Constructor
    public Email ( String recipient, String sender){
        super();
        this.recipient = recipient;
        this.sender = sender;
        createID();
        generateBody();
        generateSubject();
    }
    public Email (){
        super();
    }

    // Getters y setters
    public  String getRecipient() {
        return recipient;
    }
    public  String getSender() {
        return sender;
    }
    public  String getBodyEmail() {
        return bodyEmail;
    }
    public  int getId() {
        return id;
    }
    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }
    public void setSender(String sender) {
        this.sender = sender;
    }
    public void setBodyEmail(String bodyEmail) {
        this.bodyEmail = bodyEmail;
    }

    // Generador de Id consecutivos y no repetidos
    public synchronized void createID() {
        id += cont;
        cont++;
    }

    // Genera el cuerpo del email
    private void generateBody(){
        bodyEmail = randomChain(17);
    }
    private void generateSubject(){
        subject = randomChain(8);
    }

    public static String randomChain(int longitud) {

        String resultado = "";

        for (int i = 1; i <= longitud; i++) {

            int num = (int) ((Math.random() * ('z' - 'a') + 1) + 'a');

            char letra = (char) num;

            resultado += letra;
        }

        return resultado;
    }

    @Override
    // Sobreescribimos el metodo toString como queremos que se impriman los mensajes
    public String toString() {
        // Capturamos la fecha y la hora en el momento en el que lo imprimimos
        var fechaHora = DateTimeFormatter.ofPattern("dd/MM/yy -- HH:mm:ss");
        return "Email id:" + id +
                "\n-------------------------------------------------------" +
                "\nEnviado por: " + sender + "------>" +
                "Fecha: " + fechaHora.format(LocalDateTime.now()) + "------>" +
                "Para: " + recipient + "------>" +
                "Asunto: " + subject + "------>" +
                "Dice: " + bodyEmail + "." +
                "\n-------------------------------------------------------"
                ;
    }
}
