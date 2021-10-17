package requirem.third.main;

import requirem.third.Buffer;
import requirem.third.Consumer;
import requirem.third.Producer;


public class MainThird {

    public static void main(String[] args) {

        // Crea el buffer
        Buffer buffer = new Buffer();

        //Poblamos de correos remitentes el array
        String[] sender = new String[4];
        sender[0] = "miriam.dpt-comercial@piramidgold.com";
        sender[1] = "victor.dpt-comercial@piramidgold.com";
        sender[2] = "alfonso.dpt-comercial@piramidgold.com";
        sender[3] = "mar.dpt-comercial@piramidgold.com";
        buffer.setSenders(sender);


        //Poblamos de correos destinatarios la lista, enlazando con el archivo creado emails-clients.txt
        buffer.addRecipients("src/requirem/third/links/emails-clients.txt");


        //creamos 3 hilos productores. Y le a�adimos remitentes aleatorios del Array sender.
        Producer p1 = new Producer("producer1", buffer);
        p1.setName(p1.getProducerName());
        Producer p2 = new Producer("producer2", buffer);
        p2.setName(p2.getProducerName());
        Producer p3 = new Producer("producer3", buffer);
        p3.setName(p3.getProducerName());

        //creamos 2 hilos consumidores
        Consumer c1 = new Consumer("consumer1", buffer);
        Consumer c2 = new Consumer("consumer2", buffer);

        //arrancamos hilos Consumidores e hilos Productores
        p1.start();
        p2.start();
        p3.start();

        c1.start();
        c2.start();

        System.out.println("termina el main");
    }
}
