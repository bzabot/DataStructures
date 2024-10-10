class Rectangle {
    int x1, x2, y1, y2;
    int area;

    Rectangle(int a1, int a2, int b1, int b2) {
        x1 = a1;
        y1 = a2;

        x2 = b1;
        y2 = b2;
    };

    Rectangle(Point p1, Point p2) {
        x1 = p1.x;
        x2 = p2.x;

        y1 = p1.y;
        y2 = p2.y;
    };

    // Com base na distancia entre os pontos é possivel calcular a área
    public int area() {
        // Lado 1
        int comprimento = comprimento();
        // Lado2
        int altura = altura();
        return comprimento * altura;
    }

    // Distancia entre os pontos x*2 + distancia entre os y*2
    public int perimeter() {
        return 2 * comprimento() + 2 * altura();

    }

    private int comprimento() {
        return x2 - x1;
    }

    private int altura() {
        return y2 - y1;
    }

    // Um ponto estará dentro do retangulo se:
    // x1 <= p.x <= x2
    // y1 <= p.y <= y2
    public boolean pointInside(Point p) {
        if (p.x >= x1 && p.x <= x2 && p.y >= y1 && p.y <= y2) {
            return true;
        } else {
            return false;
        }
    }

    // Um retangulo r estará contido em outro retangulo se:
    // r.x1 >= x1, r.x2 <= x2, r.y1>=y1 e r.y2 <= y2
    public boolean rectangleInside(Rectangle r) {
        if (r.x1 >= x1 && r.x2 <= x2 && r.y1 >= y1 && r.y1 <= y2) {
            return true;
        } else {
            return false;
        }
    }

}