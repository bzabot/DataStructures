import java.util.HashMap;
import java.util.Scanner;

public class ED172 {

    public static void main(String[] args) {
        HashMap<String, Integer> words = new HashMap<String, Integer>();

        Scanner textScanner = new Scanner(System.in);

        while (textScanner.hasNext()) {
            String c = textScanner.next();
            int count = 0;
            if (words.containsKey(c)) {
                count = words.get(c);
            }
            words.put(c, count + 1);
        }
        textScanner.useDelimiter("\\Z");

        words.entrySet()
                .stream()
                .sorted((e1, e2) -> e1.getKey().compareTo(e2.getKey()))
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));

        textScanner.close();
    }

}