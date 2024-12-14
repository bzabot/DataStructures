import java.util.Scanner;

public class ED007 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Parentesis p = new Parentesis(s);
        p.getData();

        System.out.println(p.ans);

    }
}

class Parentesis {
    private Scanner scn;
    private MyStack<String> exp;
    String ans = "";

    Parentesis(Scanner s) {
        scn = s;

    }

    public void getData() {
        int n_linhas = scn.nextInt();
        scn.nextLine();
        for (int i = 0; i < n_linhas; i++) {
            if (i > 0) {
                ans += "\n";
            }
            ans += readLine(scn.nextLine());
        }
    }

    private String readLine(String line) {
        exp = new LinkedListStack<>();
        String[] l = line.split("");
        for (int i = 0; i < l.length; i++) {
            // [()]
            if (l[i].equals("(") || l[i].equals("["))
                exp.push(l[i]);
            else if (((l[i].equals(")") || l[i].equals("]")) && exp.size() == 0)
                    || l[i].equals(")") && !exp.pop().equals("(")
                    || l[i].equals("]") && !exp.pop().equals("[")) {
                return "Erro na posicao " + i;
            }
        }
        if (exp.size() > 0) {
            return "Ficam parenteses por fechar";
        } else {
            return "Expressao bem formada";
        }
    }
}