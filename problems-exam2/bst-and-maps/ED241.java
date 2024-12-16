import java.util.Scanner;

public class ED241 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int flag = s.nextInt();

        if (flag == 1)
            flag1(s);
        if (flag == 2)
            flag2(s);
        if (flag == 3)
            flag3(s);
        if (flag == 4)
            flag4(s);
        s.close();
    }

    public static void flag1(Scanner s) {
        Scanner sc = s;
        int n = s.nextInt();
        BSTMap<String, Integer> bstm = new BSTMap<>();

        for (int i = 0; i < n; i++) {
            String nome = sc.next();
            if (bstm.get(nome) == null) {
                bstm.put(nome, 1);
            } else {
                bstm.put(nome, bstm.get(nome) + 1);
            }
            sc.next();
            sc.next();
        }

        System.out.println(bstm.size());

    }

    public static void flag2(Scanner s) {
        Scanner sc = s;
        int n = s.nextInt();
        BSTMap<String, Integer> bstm = new BSTMap<>();

        for (int i = 0; i < n; i++) {
            sc.next();
            String problema = sc.next();
            if (bstm.get(problema) == null) {
                bstm.put(problema, 1);
            } else {
                bstm.put(problema, bstm.get(problema) + 1);
            }

            sc.next();
        }
        int maxSoFar = 0;
        String problema = "";
        for (String c : bstm.keys()) {
            if (bstm.get(c) > maxSoFar) {
                problema = c;
                maxSoFar = bstm.get(c);
            }
        }
        System.out.println(problema + " " + maxSoFar);
    }

    public static void flag3(Scanner s) {
        Scanner sc = s;
        int n = s.nextInt();
        BSTMap<String, Integer> ocorr = new BSTMap<>();
        BSTMap<String, Integer> accept = new BSTMap<>();

        for (int i = 0; i < n; i++) {
            sc.next();
            String problema = sc.next();
            String resultado = sc.next();

            // Número de submissoes por problema
            if (ocorr.get(problema) == null) {
                ocorr.put(problema, 1);
            } else {
                ocorr.put(problema, ocorr.get(problema) + 1);
            }

            // Número de accepts por problema
            if (resultado.equals("Accepted")) {
                if (accept.get(problema) == null) {
                    accept.put(problema, 1);
                } else {
                    accept.put(problema, accept.get(problema) + 1);
                }
            }

        }

        for (String c : ocorr.keys()) {
            if (accept.get(c) * 1.0 / ocorr.get(c) >= 0.5)
                System.out.println(c);
        }

    }

    public static void flag4(Scanner s) {
        Scanner sc = s;
        int n = s.nextInt();
        BSTMap<String, BSTree<String>> alunos = new BSTMap<>();
        BSTree<String> problemas = new BSTree<>();

        for (int i = 0; i < n; i++) {
            String aluno = sc.next();
            String problema = sc.next();
            String resultado = sc.next();
            // Número de problemas aceitos por aluno
            if (resultado.equals("Accepted")) {
                // Se o aluno não existe ainda, cria-se uma árvore para ele
                if (alunos.get(aluno) == null) {
                    BSTree<String> bt_problem = new BSTree<>();
                    bt_problem.insert(problema);
                    alunos.put(aluno, bt_problem);
                }
                // Se o aluno já existe, coloca o problema atual na arvore binária dele
                else {
                    alunos.get(aluno).insert(problema);
                }
            }
            // Número total de problemas
            problemas.insert(problema);

        }

        for (String c : alunos.keys()) {
            if (alunos.get(c).numberNodes() == problemas.numberNodes()) {
                System.out.println(c);
            }
            // System.out.println(c + " " + alunos.get(c));
        }
        // System.out.println(problemas.numberNodes());

    }

}