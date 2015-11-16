/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rotating_wheel;

/**
 *
 * @author Robin
 */
public class LED_Handling {

    /*
    
    public static void main(String[] args) {
        double x = 0.0;
        int numberOfSegments = 360;
        int numberOfLEDs = 16;

        int[][] statusLED = new int[numberOfSegments][numberOfLEDs];

       
        for (int LEDNumber = 0; LEDNumber <= numberOfLEDs-1; LEDNumber++) {

            for (int segment = 0; segment <= numberOfSegments - 1; segment++) {

                double coordinateX = Math.round(vectorCalcX(x, LEDNumber, segment) * 100d) / 100d;
                double coordinateY = Math.round(vectorCalcY(x, LEDNumber, segment) * 100d) / 100d;

                if ((coordinateX <= 1.0 && coordinateX >= -1.0) && (coordinateY >= 0 && coordinateY <= numberOfLEDs)) {
                    statusLED[segment][LEDNumber] = 1;
                } else {
                    statusLED[segment][LEDNumber] = 0;
                }

                //System.out.printf("Degree: %3d° \t X: %5.2f", degree, Math.round(vectorCalcX(x, y, degree) * 100d) / 100d);
                //System.out.printf("\t Y: %5.2f \n", Math.round(vectorCalcY(x, y, degree) * 100d) / 100d);
            }
        }

        for (int i = 1; i <= numberOfLEDs; i++) {
            System.out.printf("LED%2d ", i);
        }
        System.out.println("");

        for (int segment = 0; segment <= numberOfSegments - 1; segment++) {

            System.out.printf("[");

            for (int LEDNumber = 0; LEDNumber <= numberOfLEDs-1; LEDNumber++) {
                if (LEDNumber == 0) {
                    System.out.printf("%2d, ", statusLED[segment][LEDNumber]);
                } else if (LEDNumber < numberOfLEDs-1) {
                    System.out.printf("%4d, ", statusLED[segment][LEDNumber]);
                } else {
                    System.out.printf("%4d", statusLED[segment][LEDNumber]);
                }
            }
            System.out.println(" ]");
        }

        System.out.printf("\n%d Segments\n", numberOfSegments);
        System.out.printf("%d LEDs\n", numberOfLEDs);

    }

    public static double vectorCalcX(double x, double y, double degree) {

        return x * Math.cos(Math.toRadians(degree)) - y * Math.sin(Math.toRadians(degree));

    }

    public static double vectorCalcY(double x, double y, double degree) {

        return x * Math.sin(Math.toRadians(degree)) + y * Math.cos(Math.toRadians(degree));

    }
*/
}
