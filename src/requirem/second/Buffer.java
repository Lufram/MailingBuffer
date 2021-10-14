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
    private List<String> recipients = new List<>();

    // Metodo para añadir emails al buffer
    public synchronized void addEmail(String email) {

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
        String recipients = recipients.poll();
        // Selecciona un remitente del array si llega al ultimo reinicia el contador al final de la funcion
        String sender = sender[cont];
        cont++;



        // No se si sera un problema que siempre utiliz¡ce el mismo nombre para la variable del objeto
        // Crea un nuevo Email pasandole los datos que obtenidos
        Email e = new Email(sender,recipient);
        // Lo añade al buffer
        buffer.offer(e);

        if (cont == senders.lenght) {
            cont = 0;
        }
        // Despierta a los hilos en espera
        notify();
    }

    // Metodo que obtiene un Email del buffer
    public synchronized void getEmail() {
        String s = null;
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
        Email email = emailBuffer.poll();
        email.toString();

        // Despierta a los hilos en espera
        notifyAll();
    }
}