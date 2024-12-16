import java.util.Scanner;

public class ED172 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BSTMap<String, Integer> bst = new BSTMap<>();

        while (sc.hasNext()) {
            for (String s : sc.next().split(" "))
                if (bst.get(s) == null) {
                    bst.put(s, 1);
                } else {
                    bst.put(s, bst.get(s) + 1);
                }
        }

        for (String k : bst.keys())
            System.out.println(k + ": " + bst.get(k));
        sc.close();
    }

}