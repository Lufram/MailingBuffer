package requirem.third;

public class Consumer extends Thread {

    public String recipient;
    public Buffer buffer;

    //metodo constructor del Consumidor, a�adimos al mismo buffer que al productor
    public Consumer(String recipient , Buffer buffer) {
        super();
        this.recipient  = recipient;
        this.buffer = buffer;
    }
    // setters y getters
    public String getRecipent() {
        return recipient;
    }
    public Buffer getBuffer() {
        return buffer;
    }
    public void setRecipent(String recipent) {
        this.recipient  = recipient;
    }
    public void setBuffer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        // El metodo se ejecuta permantentemente
        while (true){
            // Saca un objeto de buffer mediante el metodo getEmail lo almacena
            Email email = buffer.getEmail();
            // Imprime por consola el Email
            System.out.println(email.toString());
        }
    }
}
