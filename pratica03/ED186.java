// Uma classe simples para representar um ponto 2D
class Point {
   int x, y;

   Point() {
      x = y = 0;
   }

   Point(int x0, int y0) {
      x = x0;
      y = y0;
   }

   // Devolve uma representação em texto do conteúdo de um Ponto
   public String toString() {
      return "(" + x + "," + y + ")";
   }
}

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

// Classe principal com a função main
public class ED186 {
   public static void main(String[] args) {
      Point a = new Point(1, 1);
      Point b = new Point(2, 2);
      Point c = new Point(3, 4);
      Point d = new Point(8, 2);

      Rectangle amarelo = new Rectangle(a, c);
      Rectangle laranja = new Rectangle(2, 3, 9, 6);
      Rectangle verde = new Rectangle(3, 4, 4, 5);
      Rectangle azul = new Rectangle(5, 1, 6, 5);
      Rectangle vermelho = new Rectangle(7, 3, 9, 5);

      System.out.println("Perimetro do retangulo amarelo = " + amarelo.perimeter()); // 10
      System.out.println("Perimetro do retangulo laranja = " + laranja.perimeter()); // 20

      System.out.println("Area do retangulo amarelo = " + amarelo.area()); // 6
      System.out.println("Area do retangulo laranja = " + laranja.area()); // 21

      System.out.println("Ponto B dentro rectangulo amarelo? " + amarelo.pointInside(b)); // true
      System.out.println("Ponto D dentro rectangulo amarelo? " + amarelo.pointInside(d)); // false

      System.out.println("Retangulo verde dentro do laranja? " + laranja.rectangleInside(verde)); // true
      System.out.println("Retangulo azul dentro do laranja? " + laranja.rectangleInside(azul)); // false
      System.out.println("Retangulo vermelho dentro do laranja? " + laranja.rectangleInside(vermelho)); // true

   }
}
