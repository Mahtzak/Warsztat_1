package NumberGuessingName;



import java.util.Random;

import java.util.Scanner;



public class GameOfNumbers {

    public static void main(String[] args) {

        Random rand = new Random();

        int computerNumber = rand.nextInt(100) + 1 ;

        while (true) {

            System.out.println("Zgadnij liczbę: ");

            int userNumber = getInt();

            if (computerNumber == userNumber) {

                System.out.println("Zgadłeś!");

                break;

            } else if (computerNumber < userNumber) {

                System.out.println("Za dużo!");

            } else {

                System.out.println("Za mało!");

            }

        }

    }



    public static int getInt() {

        Scanner scan = new Scanner(System.in);

        while (!scan.hasNextInt()) {

            scan.next();

            System.out.println("Nieprawidłowe dane. Podaj jeszcze raz:");

        }

        return scan.nextInt();

    }

}
