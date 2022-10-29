import java.util.Scanner;

public class LinearEquationRunner {
    public static void main(String[] args){
    Scanner scan = new Scanner (System.in);

         System.out.print("Welcome!");
         System.out.print("Enter coordinate 1: ");
         String c1 = scan.nextLine();
         System.out.print("Enter coordinate 2: ");
         String c2 = scan.nextLine();

        int commaIdx1 = c1.indexOf(",");  // ex: (4, -6) : last parenthesis can be found by length -1
        int c1len = c1.length()-1;
        String xValue1 = c1.substring(1, commaIdx1);
        String yValue1 = c1.substring(commaIdx1 + 2, c1len); //fix
        int commaIdx2 = c2.indexOf(",");
        int c2len = c2.length()-1;
        String xValue2 = c2.substring(1, commaIdx2); //x2
        String yValue2 = c2.substring(commaIdx2 + 2, c2len); //y2
        int intX1 = Integer.parseInt(xValue1);
        System.out.println(intX1);
        int intX2 = Integer.parseInt(xValue2); //using integer parsing to get the coordinates values
        System.out.println(intX2);                      // individually
        int intY1 = Integer.parseInt(yValue1);
        System.out.println(intY1);
        int intY2 = Integer.parseInt(yValue2);
        System.out.println(intY2);


        int x1 = intX1;
        int y1 = intY1;
        int x2 = intX2;
        int y2 = intY2;
    LinearEquation equation = new LinearEquation(x1, y1, x2, y2);

System.out.println();
System.out.println("----- Line info -----");
System.out.println(equation.lineInfo());
System.out.println();
System.out.println("Enter a value for x: ");
double x = scan.nextDouble();
System.out.println("Coordinate for x: " + equation.coordinateForX(x));
scan.close();
}
}