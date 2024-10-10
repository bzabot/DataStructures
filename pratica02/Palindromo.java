import java.util.Scanner;

public class Palindromo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        System.out.println(N);
        input.nextLine();

        for (int i = 0; i < N; i++) {

            String phrase = input.nextLine();
            System.out.println(palindrome(phrase));

        }
        input.close();
    }

    public static String palindrome(String phrase) {
        phrase = phrase.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int phrase_length = phrase.length();
        for (int i = 0; i < phrase_length; i++) {
            if (phrase.charAt(i) != phrase.charAt(phrase_length - i - 1)) {
                return "nao";
            }
        }
        return "sim";
    }
}
