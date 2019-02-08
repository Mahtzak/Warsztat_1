package lotto;

import java.util.Arrays;

import java.util.Collections;

import java.util.Random;

import java.util.Scanner;



public class Lotto {

    public static void main(String[] args) {

        int[] randNumbers = generateSixNumbers();

        System.out.println(Arrays.toString(randNumbers));

        int[] userNumbers =  getUserNumbers();

        Arrays.sort(userNumbers);

        System.out.println(Arrays.toString(userNumbers));

        prize(countHits(userNumbers, randNumbers));

    }



    public static int[] getUserNumbers() {

        int[] userNumbers = new int[6];

        for(int i=0;i<6;i++){

            while(true) {

                System.out.println(i + 1+ ": Podaj liczbe z zakresu od 1-49");

                int userNumber = getInt();

                if(isUserNumberCorrect(userNumber, userNumbers)){

                    userNumbers[i] = userNumber;

                    break;

                }

                System.out.println("Wprowadzona liczba jest nieprawidlowa");

            }

        }

        return userNumbers;

    }



    public static int getInt() {

        Scanner scan = new Scanner(System.in);

        while (!scan.hasNextInt()) {



            scan.next();

            System.out.println("Nieprawidłowe dane. Podaj jeszcze raz:");

        }

        return scan.nextInt();

    }

    public static boolean isUserNumberCorrect(int number, int[] userNumbers)

    {

        if (number<1 || number >49)

        {

            return false;

        }

        for (int element : userNumbers)

        {

            if (number == element)

            {

                return false;

            }

        }

        return true;

    }

    static int[] generateSixNumbers() {

        Integer[] arr = new Integer[49];

        int[] tabNumbers = new int[6];

        for (int i = 0; i < arr.length; i++) {

            arr[i] = i + 1;

        }

        Collections.shuffle(Arrays.asList(arr));

        for (int i = 0; i < tabNumbers.length; i++) {

            tabNumbers[i] = arr[i];



        }

        return tabNumbers;

    }



    static int countHits(int[] userNumbers,int[] randomNumber){

        int count = 0;

        for (int i = 0; i < 6; i++) {

            for (int j = 0; j < 6; j++) {

                if(userNumbers[i] == randomNumber[j]) {

                    count++;

                }

            }

        }

        return count;

    }

    static void prize(int count) {

        if(count == 3){

            System.out.println("Trafiłeś 3 oczka! Brawo!");

        } else if(count == 4){

            System.out.println("Trafiłeś 4 oczka! Brawo!");

        } else if(count == 5) {

            System.out.println("Trafiłeś 5 oczka! Brawo!");

        } else if(count == 6) {

            System.out.println("Brawo! Wygrałeś miliony!");

        } else {

            System.out.println("Spróbuj ponownie!");

        }

    }

}