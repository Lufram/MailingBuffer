package requirem.second;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Buffer {

    // Maximo de emails que acepta el buffer
    public final static int MAX_ELEMENTS = 5;

    // Implementa una cola
    private Queue<Email> buffer = new LinkedList<>();

    // Array que almacena los correos de los destinatarios
    private String[] senders = new String[4];

    // Contador que utilizaremos para repetir los correos de los remitentes
    private int cont = 0;
    private Queue<String> recipients = new LinkedList<>();

    // Getters y setters
    public Queue<Email> getBuffer() {
        return buffer;
    }
    public void setBuffer(Queue<Email> buffer) {
        this.buffer = buffer;
    }
    
    //getters & setters
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

    // Metodo que introduce los destinatarios desde un archivo externo
    public void addRecipients(String src){
        try {
            // Declara el escaner que utilizaremos para leer el archivo
            Scanner sc = new Scanner(new FileInputStream(src));
            // Bucle que recorrera cada linea del archivo
            while (sc.hasNextLine()){
                // Almacena el texto del escaner a cada vuelta
                String recipient = sc.nextLine();
                // Introduce el texto a la lista
                recipients.offer(recipient);
            }
            // Apagamos el scanner
            sc.close();
        }
        // Atrapa la excepcion en caso de error por que no exista el archivo
        catch (FileNotFoundException e) {
            System.out.println("ERROR OPENING FILE") ;
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("\nProgram terminated Safely...");
        }
    }
    
    // Metodo para introducir emails al buffer
    public synchronized void addEmail() {
            try {
                Thread.sleep(500);  //dormimos 0.5 segundos cada hilo que introduce emails
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

            // No se si sera un problema que siempre utilice el mismo nombre para la variable del objeto
            // Crea un nuevo Email pasandole los datos que obtenidos
            Email e = new Email(recipient, sender);

            // Lo anadir al buffer
             buffer.offer(e);
             // Despierta a los hilos en espera
             notify();
             System.out.println("El Productor: " + Thread.currentThread().getName() + " ha introducido a la cola el email: " + e.getId());
            // Reinicia el contador cuando llegue al final del array para que vuelva a empezar por el valor 0
            if (cont == senders.length) {
                cont = 0;
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
