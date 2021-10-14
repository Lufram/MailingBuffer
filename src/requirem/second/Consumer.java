package requirem.second;

public class Consumer extends Thread {

    public String recipient;
    public Buffer buffer;

    //metodo constructor del Consumidor, a�adimos al mismo buffer que al productor
    public Consumer(String recipient , Buffer buffer) {
        super();
        this.recipient  = recipient;
        this.buffer = buffer;
    }

    public String getDestinatario() {
        return recipient;
    }

    public void setDestinatario(String destinatario) {
        this.recipient  = destinatario;
    }

    public void run() {
        //los consumidores se quedan siempre leyendo emails. El metodo run() no termina nunca por eso se utiliza while(true)

        while (true){ //buffer.getRecipients().size() == 0 && buffer.getBuffer().size() == 0
            Email email = buffer.getEmail();
            System.out.println(email.toString());
        }

    }
}
