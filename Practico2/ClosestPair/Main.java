/**
 * Main class of the Java program.  
 */
import java.util.Random;
import java.util.Date;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Main {

    public static void main(String[] args) {
        
        // we print a heading and make it bigger using HTML formatting
        System.out.println("<h4>-- Closest Pair Computation --</h4>");
        System.out.println("Enter the number of points to consider, and then their coordinates one by one");

        try  {
            Scanner in = new Scanner(System.in);
            int numPoints;
            numPoints = in.nextInt();
            Point[] points = new Point[numPoints];
            for (int i=0; i<numPoints; i++) {
                Point point = new Point();
                point.setX(in.nextFloat());
                point.setY(in.nextFloat());
                points[i] = point;
            }
            System.out.println(closestPair(points));
            long start = (new Date()).getTime();
            System.out.println("Closest distance: " + closestPair(points));
            long elapsed = (new Date()).getTime()-start;
            System.out.println("Elapsed computation time: "+ elapsed);    
        }
        catch (Exception e) {
            System.out.println("An error has occurred. Make sure you entered the inputs correctly.");
        }
    }
    
    public static double closestPair(Point[] points) {
        double distMin=10000; //simula infinito
        double distAux=10000; //simula infinito
        Point p1 = new Point();
        for (int i=0; i<points.length; i++){
            p1=points[i];
            Point p2 = new Point();
            for (int j=i+1; j<points.length; j++){
                p2=points[j];
                distAux=Math.hypot(p2.getX()-p1.getX(),p2.getY()-p1.getY());
                if (distAux<distMin){
                    distMin=distAux;
                }
            }
        }
        return distMin;
    }
}
