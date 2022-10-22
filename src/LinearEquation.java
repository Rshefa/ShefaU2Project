public class LinearEquation {
    /* Instance Variables */
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private boolean horizontal;


    /* Creates a LinearEquation object */
/* PRECONDITION: x1 and x2 are NOT equal (client programs are responsible for ensuring
   this precondition is not violated)

 */
public LinearEquation(int x1, int y1, int x2, int y2){
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;

}

/* Calculates and returns distance between (x1, y1) and (x2, y2), rounded to
   the nearest hundredth */
    public double distance(){
        double add = Math.pow(x2-x1,2) + Math.pow(y2-y1, 2);
        double dist = Math.sqrt(add);
        double roundDist = roundedToHundredth(dist) ;
        return roundDist;

    }

/* If y-intercept is less than 0, then return " - " + "y-intercept"*/

    /* Calculates and returns the y-intercept of the line between (x1, y1) and
       (x2, y2), rounded to the nearest hundredth */
    public double yIntercept(){
        double b = y1 - slope() * x1;
        double roundB = roundedToHundredth(b);
        return roundB;
    }

    /* Calculates and returns the slope of the line between (x1, y1) and
       (x2, y2), rounded to the nearest hundredth */
    public double slope(){
        double div = (double)(y2 - y1) / (x2 - x1);
        double slope = roundedToHundredth(div);
        return slope;
    }

    /* Returns a String that represents the linear equation of the line through points
       (x1, y1) and (x2, y2) in slope-intercept (y = mx + b) form, e.g. "y = 3x + 1.5".

        When generating the m value (slope), here are examples of "printable" slopes:
           5, -5, 1/2, 6/8 (reducing not required), 8/5, -2/3, -18/7

        Here are non-examples of "printable" slopes:
     1/-2 (should be -1/2), -4/-3 (should be 4/3), 8/4 (should be reduced to 2),
           -12/3 (should be -4), 3/3 (should be 1), -6/6 (should be -1)

        HINT: Be sure to check if the line is horizontal and return an appropriate string,
        e.g. y = 6
        HINT: Absolute value might be helpful for ensuring proper placement of negative sign!


        When generating the b value, here are some examples of "printable" y-intercepts:
           + 1.0 	- 2.35	      + 12.5		- 8.0		+ 17.19

        Here are non-examples of "printable" y-intercepts:
           - -1.0 	+ -2.35	- -12.5	+ -8.0	     - -17.19	+ 0	- 0

        HINT: Absolute value might be helpful for printing negative y-intercepts as
               subtraction!
     */
    public String equation(){
        int numerator = y2 - y1;
        int denominator = x2 - x1;

        if (y1 == y2) {
            horizontal = true;
        }else if (numerator < 0 && denominator < 0){ //Checks if both numbers are negative
            int absNum = Math.abs(numerator); //Turns ints into positive
            int absDen = Math.abs(denominator);

            if (absNum % absDen == 0 ) { //Checks if slope is an integer
                if (absNum/absDen == 1) { //Checks if slope = 1
                    return "x"; //If slope is 1, we want x to be by itself
                }else {
                    return Integer.toString(absNum / absDen) + "x"; //If slope isn't 1, we want the slope to be with x
                }
            }else{
                return absNum + "/" + absDen + "x"; //If slope is a fraction or decimal, we want it to return as a fraction.
            }
        }else{ //Numbers aren't negative or one is negative
            if (numerator % denominator == 0){ //Checks for integers
                if (numerator/denominator == -1) { //Checks if slope = -1
                    return "-x"; //If slope is -1, we want -x to be by itself
                }else {
                    return Integer.toString(numerator / denominator) + "x";
                }
            }else{
                return numerator + "/" + denominator + "x";
            }
        }
        return null; // y = slope +null
        //
    }

    /* Returns a String of the coordinate point on the line that has the given x value, with
       both x and y coordinates as decimals to the nearest hundredth, e.g (-5.0, 6.75) */
    public String coordinateForX(double xValue){
        double y = xValue * slope() + yIntercept();
        double yRound = roundedToHundredth(y);
        return "(" + xValue + "," + yRound + ")";
    }

    /* "Helper" method for use elsewhere in your methods; returns the value toRound rounded
        to the nearest hundredth

        HINT:  the Math.round method can help with this!
     */
    public double roundedToHundredth(double toRound){
        double roundNum = Math.round(toRound * 100) / 100.0;
        return roundNum;
    }

    /* Returns a string that includes all information about the linear equation, each on
       separate lines:
         - The original points: (x1, y1) and (x2, y2)
         - The equation of the line in y = mx + b format (using equation() method)
         - The slope of the line, as a decimal (using slope() method)
         - The y-intercept of the line (using yIntercept() method)
         - The distance between the two points (using distance() method)

      This method should call all other appropriate methods to get the info it needs:
      equation(), slope(), yIntercept(), distance().

      */
    public String lineInfo(){
        if (horizontal == true) {
            return ("These points are on a horizontal line: y = " + y1);

        }else {
            return ("The original points: " + "(" + x1 + "," + y1 + ")" + " and " + "(" + x2 + "," + y2 + ")");
            return ("The equation of the line: " + equation());
            return ("The slope of the line, as a decimal: " + slope());
            return ("The y-intercept of the line: " + yIntercept());
            return ("The distance between the two points: " + distance());

        }
    }
}
