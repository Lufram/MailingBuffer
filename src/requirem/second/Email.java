package requirem.second;

public class Email{

    private static int id = 1;

    private String recipient;
    private String sender;
    private String bodyEmail;


    // Constructor
    public Email ( String recipient, String sender){
        super();
        id = createID();
        this.recipient = recipient;
        this.sender = sender;
        generateBody();
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
    public static synchronized int createID() {
        id++;
        return id;
    }

    // Genera el cuerpo del email
    private void generateBody(){
        bodyEmail = ("Estimad@ " + recipient +" ha sido seleccionado para una estafa piramidal. APUNTESE!! ");
    }

    @Override
    // Sobreescribimos el metodo toString como queremos que se impriman los mensajes
    public String toString() {
        // Capturamos la fecha y la hora en el momento en el que lo imprimimos
        var fechaHora = DateTimeFormatter.ofPattern("dd/MM/yy -- HH:mm:ss");
        return "Email " + id + 
                \n"-------------------------------------------------------" +
                \n "Enviado por: " + sender + "------>" +
                "Fecha: " + sender + "------>" +
                "Para: " + recipient + "------>" +
                "Dice: " + bodyEmail + "." +
                \n"-------------------------------------------------------"
                ;
    }
}
