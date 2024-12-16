import java.util.Scanner;

public class ED234 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int flag = s.nextInt();
        if (flag == 1) {
            flag1(s);
        }
        if (flag == 2) {
            flag2(s);
        }
        if (flag == 3) {
            flag3(s);
        }
        s.close();
    }

    public static void flag1(Scanner s) {
        Scanner sc = s;
        BSTree<Filme> bst = new BSTree<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            Filme f = new Filme();
            f.nome = sc.next();
            f.nota = sc.nextInt();
            bst.insert(f);
        }
        System.out.println(bst.numberNodes());
    }

    public static void flag2(Scanner s) {
        Scanner sc = s;
        BSTMap<String, Integer> bst = new BSTMap<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String key = sc.next();
            if (bst.get(key) == null) {
                bst.put(key, 1);
            } else {
                bst.put(key, bst.get(key) + 1);
            }
            sc.nextInt();
        }

        int maxSoFar = 0;
        String nameOfMax = "";
        for (String c : bst.keys()) {
            if (bst.get(c) > maxSoFar) {
                maxSoFar = bst.get(c);
                nameOfMax = c;
            }
        }
        System.out.println(nameOfMax + " " + maxSoFar);
    }

    public static void flag3(Scanner s) {
        Scanner sc = s;
        BSTMap<String, Integer> ocorrencias = new BSTMap<>();
        BSTMap<String, Integer> notas = new BSTMap<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String key = sc.next();

            // colocar o número de ocorrencias
            if (ocorrencias.get(key) == null) {
                ocorrencias.put(key, 1);
            } else {
                ocorrencias.put(key, ocorrencias.get(key) + 1);
            }

            int value = sc.nextInt();

            // Colocar a soma das notas
            if (notas.get(key) == null) {
                notas.put(key, value);
            } else {
                notas.put(key, notas.get(key) + value);
            }

        }

        for (String c : notas.keys()) {
            notas.put(c, notas.get(c) / ocorrencias.get(c));
        }

        for (String c : notas.keys()) {
            if (notas.get(c) >= 5) {
                System.out.println(c);
            }
        }

    }

}

class Filme implements Comparable<Filme> {
    String nome;
    int nota;

    public int compareTo(Filme f) {
        return this.nome.compareTo(f.nome);
    }

}