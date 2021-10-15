package requirem.second;

import java.util.LinkedList;
import java.util.Queue;

public class Buffer {
    // Maximo de emails que acepta el buffer
    public final static int MAX_ELEMENTS = 5;
    // Implementa una cola
    private Queue<Email> buffer = new LinkedList<>();

    private String[] senders = new String[4];
    private int cont = 0;
    private Queue<String> recipients = new LinkedList<>();

    // Getters y setters
    public Queue<Email> getBuffer() {
        return buffer;
    }
    public void setBuffer(Queue<Email> buffer) {
        this.buffer = buffer;
    }
    public String[] getSenders() {
        return senders;
    }
    public void setSenders(String[] senders) {
        this.senders = senders;
    }
    public int getCont() {
        return cont;
    }
    public void setCont(int cont) {
        this.cont = cont;
    }
    public Queue<String> getRecipients() {
        return recipients;
    }
    public void setRecipients(Queue<String> recipients) {
        this.recipients = recipients;
    }
    
    public void addRecipients(String url){
        
        try {
	        Scanner sc = new Scanner(new FileInputStream(url));
	        
	        while (sc.hasNextLine()){
	        String recipient = sc.nextLine();
	        recipients.offer(recipient);
   		 }
   		 sc.close();
        }

        catch (FileNotFoundException e) {
        System.out.println("ERROR OPENING FILE") ;
       	e.printStackTrace();
        }
        catch (Exception e) {
		e.printStackTrace();
		System.out.println("\nProgram terminated Safely...");
		}
    }
    /*
    public void addRecipients(String recipient){
        recipients.offer(recipient);
    }
    */

    // Metodo para añadir emails al buffer
    public synchronized void addEmail() {
        if (recipients.size() != 0){

            try {
                Thread.sleep(500);  //dormimos 0.5 segundos cada hilo que añade emails
                // Si llega al maximo de emails de capacidad deja en espera el hilo
                while (buffer.size() == MAX_ELEMENTS) {



                    try {
                        // Hilo en espera de un notify
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                }
            } catch (InterruptedException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            // Saca un nombre de la lista
            String recipient = recipients.poll();
            // Selecciona un remitente del array si llega al ultimo reinicia el contador al final de la funcion
            String sender = senders[cont];
            cont++;

            // No se si sera un problema que siempre utiliz¡ce el mismo nombre para la variable del objeto
            // Crea un nuevo Email pasandole los datos que obtenidos
            Email e = new Email(recipient, sender);
            // Lo añade al buffer
            buffer.offer(e);

            if (cont == senders.length) {
                cont = 0;
            }
            // Despierta a los hilos en espera
            notify();
        }
    }

    // Metodo que obtiene un Email del buffer
    public synchronized Email getEmail() {
        // Si el buffer se queda sin emails deja el hilo en espera
        while (buffer.size() == 0) {
            try {
                // Hilo en espera de un notify
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        // Extrae el Email del buffer y lo almacena en s
        Email email = buffer.poll();

        // Despierta a los hilos en espera
        notifyAll();
        return email;
    }
}
