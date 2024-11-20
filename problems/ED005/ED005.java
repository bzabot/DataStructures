import java.util.Scanner;

class ED005 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        NPI c = new NPI(s);

        c.getData();

        System.out.println(c.ans);

    }

    // + - * /

}

class NPI {
    private Scanner scn;
    String ans = "";
    private MyStack<Integer> numeros;

    NPI(Scanner s) {
        scn = s;
    }

    public void getData() {

        int n_linhas = scn.nextInt();
        // pular a linha
        scn.nextLine();
        for (int i = 0; i < n_linhas; i++) {
            if (i > 0) {
                ans += "\n"; // Apenas adiciona quebra de linha entre os resultados
            }
            // Para cada linha
            readLine(scn.nextLine());
        }

    }

    public void readLine(String line) {
        numeros = new LinkedListStack<>();
        // Separar os digitos
        String[] carac = line.split(" ");
        for (String c : carac) {
            // Se for uma operação
            if (c.equals("*") || c.equals("/") || c.equals("+") || c.equals("-")) {
                // Pode não ser possível realizar a operação, caso tenha apenas um operando
                // Caso não seja possível realizar a operação
                if (!operacao(c)) {
                    ans += "Expressao Incorrecta";
                    return;
                }
            } else {
                numeros.push(Integer.parseInt(c));
            }
        }

        if (numeros.size() != 1) {
            ans += "Expressao Incorrecta";
        } else {
            ans += numeros.pop();
        }

    }

    private boolean operacao(String operador) {
        if (numeros.size() == 1)
            return false; // Não foi possivel realizar
        switch (operador) {
            case "*":
                numeros.push(numeros.pop() * numeros.pop());
                return true;

            case "/":
                int n1 = numeros.pop();
                int n2 = numeros.pop();
                numeros.push(n2 / n1);
                return true;
            case "+":
                numeros.push(numeros.pop() + numeros.pop());
                return true;
            case "-":
                int n3 = numeros.pop();
                int n4 = numeros.pop();
                numeros.push(n4 - n3);
                return true;

            default:
                return false;
        }
    }
};
