package NumberTeller;

import java.util.Scanner;



public class AI {

    public static void main(String[] args) {

        System.out.println(

                "Pomyśl liczbę od 1 do 1000," +

                        " a ja ją zgadnę w mniej niż 10 krokach");

        int min = 0;

        int max = 1000;

        int guess = 0;

        for (int i = 0; i < 10; i++) {

            guess = (int)Math.round((max - min) / 2.0) + min;

            System.out.println(i+1+" Zgaduję: " + guess);

            String userAnswer = getUserAnswer();

            if (userAnswer.equalsIgnoreCase("Trafiles")||userAnswer.equalsIgnoreCase("t")){

                System.out.println("wygralem");

                break;

            } else if (userAnswer.equalsIgnoreCase("mniej")||userAnswer.equalsIgnoreCase("m")){

                max = guess;

            } else {

                min = guess;

            }

        }

    }

    static String getUserAnswer(){

        Scanner scan = new Scanner(System.in);

        System.out.println("Użyj odpowiedzi z zestawu " +

                "'Mniej' lub 'Wiecej' lub 'Trafiles'. ");

        String userAnswer = scan.nextLine();

        while (!isAnswerCorrect(userAnswer)) {

            System.out.println("Niepoprawna odpowiedź!");

            userAnswer = scan.nextLine();

        }

        return userAnswer;

    }

    static boolean isAnswerCorrect (String userAnswer) {

        switch(userAnswer.toLowerCase()) {

            case "mniej":

            case "wiecej":

            case "trafiles":

            case "m":

            case "w":

            case "t": return true;

            default: return false;

        }

    }

}
