package requirem.second;

public class Producer extends Thread {
    
    private String producerName;
    private Buffer buffer;
    
    // Constructor
    public Producer (String producerName, Buffer buffer) {
        super();
        this.producerName = producerName;
        this.buffer = buffer;
    }
    
    // Getters y setters
    public String getProducerName() {
        return producerName;
    }
    public Buffer getBuffer() {
        return buffer;
    }
    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }
    public void setBuffer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        // Cada hilo producira 10 Emails
        for (i = 1 ; i <= 10 ; i++) {
            // Crea un nuevo Email mediaten el metodo adEmail de Buffer
            buffer.addEmail();
        }
    }
}
