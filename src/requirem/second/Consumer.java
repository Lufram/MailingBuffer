package requirem.second;

public class Consumer extends Thread {

    public String recipient;
    public Buffer buffer;



    public Consumer(String recipient , Buffer buffer) {     //metodo constructor del Consumidor, a�adimos al mismo buffer que al productor
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
        while (true) {

            String email = buffer.getEmail();
            System.out.println("ID " + (Email.crearID()) + " --->   DESTINATARIO: " + getDestinatario() + email  );
        }
    }

}