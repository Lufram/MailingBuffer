package requirem.first;

/**
 *  number to check
 *  Hilo de
 */
public class NumberToCheck extends Thread {

    private long num;
    private String numIsPrime;

    public NumberToCheck(long num) {
        super();
        this.num = num;
    }

    /**
     * get field
     *
     * @return num
     */
    public long getNum() {
        return this.num;
    }

    /**
     * set field
     *
     * @param num
     */
    public void setNum(long num) {
        this.num = num;
    }

    /**
     * get field
     *
     * @return numIsPrime
     */
    public String getNumIsPrime() {
        return this.numIsPrime;
    }

    /**
     * set field
     *
     * @param numIsPrime
     */
    public void setNumIsPrime(String numIsPrime) {
        this.numIsPrime = numIsPrime;
    }


    public void isPrime(long num) {
        long cont = 0;
        // Divide el numero por todos los numeros entre el numero y 1 y suma 1 al contador  cada vez que el resto es 0
        for (long i = 1; i <= num; i++) {
            if ((num % i) == 0) {
                cont++;
            }
        }
        // Si el contador es 0 o 2 el numero es primo
        if (cont <= 2 && cont != 1) {
            numIsPrime = "Es primo.";
        } else {
            numIsPrime = "No es primo";
        }
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        // comprueba si el numero es primo
        isPrime(num);

        long endTime = System.currentTimeMillis();
        double time = (double) ((endTime - startTime) / 1000);
        // Imprime por la información del numero y el proceso
        System.out.println("El numero "
                + num
                + " ha sido procesado por el hilo: "
                + Thread.currentThread().getName()
                + ". El proceso ha tardado: "
                + time
                + " seg. Resultado: "
                + numIsPrime);
    }

}