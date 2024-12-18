import java.util.Scanner;

public class ED241 {
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        int flag = s.nextInt();

        if (flag == 1)
            flag1();
        if (flag == 2)
            flag2();
        if (flag == 3)
            flag3();
        if (flag == 4)
            flag4();
    }

    static void flag1() {
        int n = s.nextInt();
        BSTree<String> alunos = new BSTree<>();
        for (int i = 0; i < n; i++) {
            alunos.insert(s.next());
            s.next();
            s.next();
        }
        System.out.println(alunos.numberNodes());
    }

    static void flag2() {
        int n = s.nextInt();
        BSTMap<String, Integer> problemas = new BSTMap<>();
        for (int i = 0; i < n; i++) {
            s.next();
            String problema = s.next();
            if (problemas.get(problema) == null) {
                problemas.put(problema, 1);
            } else {
                problemas.put(problema, problemas.get(problema) + 1);
            }
            s.next();
        }
        int maxSoFar = 0;
        String maxProblem = "";
        for (String c : problemas.keys()) {
            if (problemas.get(c) > maxSoFar) {
                maxSoFar = problemas.get(c);
                maxProblem = c;
            }
        }
        System.out.println(maxProblem + " " + maxSoFar);
    }

    static void flag3() {
        int n = s.nextInt();
        BSTMap<String, Integer> accepted = new BSTMap<>();
        BSTMap<String, Integer> occ = new BSTMap<>();
        for (int i = 0; i < n; i++) {
            s.next();
            String problema = s.next();
            String resultado = s.next();
            if (resultado.equals("Accepted")) {
                if (accepted.get(problema) == null) {
                    accepted.put(problema, 1);
                } else {
                    accepted.put(problema, accepted.get(problema) + 1);
                }
            }
            if (occ.get(problema) == null) {
                occ.put(problema, 1);
            } else {
                occ.put(problema, occ.get(problema) + 1);
            }
        }
        for (String c : accepted.keys()) {
            if (accepted.get(c) * 1.0 / occ.get(c) >= 0.5)
                System.out.println(c);
        }

    }

    static void flag4() {
        BSTMap<String, BSTree<String>> alunos = new BSTMap<>();
        BSTree<String> occ = new BSTree<>();
        int n = s.nextInt();
        for (int i = 0; i < n; i++) {
            String aluno = s.next();
            String problema = s.next();
            String resultado = s.next();
            if (resultado.equals("Accepted")) {
                if (alunos.get(aluno) == null) {
                    BSTree<String> alProblems = new BSTree<>();
                    alProblems.insert(problema);
                    alunos.put(aluno, alProblems);
                } else {
                    alunos.get(aluno).insert(problema);
                }
            }

            occ.insert(problema);

        }

        for (String c : alunos.keys()) {
            if (alunos.get(c).numberNodes() == occ.numberNodes())
                System.out.println(c);
        }
    }
}