package requirem.second.main;

import requirem.second.Buffer;

public class Main {

    public static void main(String[] args) {

        Buffer buffer = new Buffer();   //se crea un unico objeto Buffer (cola de los emails). Productores y Consumidores estan unidos a este mismo buffer.

        //creamos 3 hilos productores
        
        Producer producer1 = new Producer(producer1, buffer);
        Producer producer2 = new Producer(null, buffer);
        Producer producer3 = new Producer(null, buffer);

        //creamos 2 hilos consumidores
        Consumer consumer1 = new Consumer(null, buffer);     
        Consumer consumer2 = new Consumer(null, buffer);



        //arrancamos hilos Consumidores e hilos Productores
        p1.start();
        p2.start();
        p3.start();
        c1.start();
        c2.start();



    }

}
