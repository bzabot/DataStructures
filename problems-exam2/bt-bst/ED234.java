import java.util.Scanner;

public class ED234 {

    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {

        int flag = s.nextInt();

        if (flag == 1) {
            flag1();
        }
        if (flag == 2) {
            flag2();
        }
        if (flag == 3) {
            flag3();
        }
    }

    static void flag1() {
        BSTree<String> lista = new BSTree<>();
        int n = s.nextInt();
        for (int i = 0; i < n; i++) {

            lista.insert(s.next());
            s.nextInt();
        }
        System.out.println(lista.numberNodes());
    }

    static void flag2() {
        BSTMap<String, Integer> dict = new BSTMap<>();
        int n = s.nextInt();
        for (int i = 0; i < n; i++) {
            String filme = s.next();
            s.nextInt();
            if (dict.get(filme) == null)
                dict.put(filme, 1);
            else {
                dict.put(filme, dict.get(filme) + 1);
            }
        }

        // Maior do MAPA
        int biggestSoFar = 0;
        String name = "";
        for (String s : dict.keys()) {

            if (dict.get(s) > biggestSoFar) {

                biggestSoFar = dict.get(s);
                name = s;
            }
        }
        System.out.println(name + " " + biggestSoFar);

    }

    static void flag3() {
        BSTMap<String, Integer> notas = new BSTMap<>();
        BSTMap<String, Integer> ocorrencias = new BSTMap<>();
        int n = s.nextInt();

        for (int i = 0; i < n; i++) {
            String filme = s.next();
            int nota = s.nextInt();

            // Número de ocorrencias por filme:
            if (ocorrencias.get(filme) == null)
                ocorrencias.put(filme, 1);
            else {
                ocorrencias.put(filme, ocorrencias.get(filme) + 1);
            }

            // Nota total somada
            if (notas.get(filme) == null)
                notas.put(filme, nota);
            else {
                notas.put(filme, notas.get(filme) + nota);
            }
        }

        for (String s : notas.keys()) {
            if (notas.get(s) * 1.0 / ocorrencias.get(s) >= 5)
                System.out.println(s);

        }

    }

}