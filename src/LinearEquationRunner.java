import java.util.Scanner;

public class LinearEquationRunner {
    public static void main(String[] args){
    Scanner scan = new Scanner (System.in);

         System.out.print("Welcome!");
         System.out.print("Enter coordinate 1: ");
         String c1 = scan.nextLine();
         System.out.print("Enter coordinate 2: ");
         String c2 = scan.nextLine();

         int commaIdx1 = c1.indexOf(",");  //(4, -6)  "4" - last parenthesis can be found by length -1
        String xValue1 = c1.substring(0, commaIdx1);
        String yValue1 = c1.substring(commaIdx1 + 1, 9 ); //fix
        int x1 = -1;
        int y1 = 5;
        int x2 = 3;
        int y2 = 10;
    LinearEquation equation = new LinearEquation(x1, y1, x2, y2);

System.out.println();
System.out.println("----- Line info -----");
System.out.println(equation.lineInfo());
System.out.println();
System.out.println("Enter a value for x: ");
double x = scan.nextDouble();
System.out.println("Coordinate for x: " + equation.coordinateForX(x));
}
}