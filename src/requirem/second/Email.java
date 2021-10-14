package requirem.second;

public class Email{

    private static long id = 1;

    private String recipient;
    private String sender;
    private String bodyEmail;
    private String subject;


    // Constructor
    public Email ( String recipient, String sender){
        super();
        id = crearID();
        this.recipient = recipient;
        this.sender = sender;
        generateBody();

    }

    // Getters
    public  String getRecipient() {
        return recipient;
    }
    public  String getSender() {
        return sender;
    }
    public  String getBodyEmail() {
        return bodyEmail;
    }

    // Setters
    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }
    public void setRecipient(String sender) {
        this.sender = sender;
    }
    public void setRecipient(String bodyEmail) {
        this.bodyEmail = bodyEmail;
    }

    // Generador de Id consecutivos y no repetidos
    public static synchronized String crearID() {
        return String.valueOf(id++);
    }
   
    // Genera el cuerpo del email
    private String generateBody(){
        bodyEmail = ("Estimad@ " + name +" ha sido seleccionado para una estafa piramidal. APUNTESE!! ")    
    }

     // Sobreescribe el metodo toString
    @Override
    public String toString() {
        System.out.println(subject);
    }
}
