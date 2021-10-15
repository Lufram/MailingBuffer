package requirem.first;

import java.util.Scanner;

public class MainFirst {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        Long numbers[] = new Long[4];

        for (int i = 0 ; i <= 3 ; i++){
            System.out.println("Introduzca un numero: ");
            numbers[i] = read.nextLong();
        }

        NumberToCheck number1 = new NumberToCheck(numbers[0]);
        number1.setName("thread-1");
        NumberToCheck number2 = new NumberToCheck(numbers[1]);
        number1.setName("thread-2");
        NumberToCheck number3 = new NumberToCheck(numbers[2]);
        number1.setName("thread-3");
        NumberToCheck number4 = new NumberToCheck(numbers[3]);
        number1.setName("thread-4");

        number1.start();
        number2.start();
        number3.start();
        number4.start();
    }
}
