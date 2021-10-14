package requirem.second;

public class Producer extends Thread {

    private String threadName;
    private Buffer buffer;
    // Constructor
    public Producer (String threadName, Buffer buffer) {
        super();
        this.threadName = threadName;
        this.buffer = buffer;
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public Buffer getBuffer() {
        return buffer;
    }

    public void setBuffer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (buffer.getRecipients().size() != 0) {
            buffer.addEmail();
        }
    }
}
