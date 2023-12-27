import java.util.*;

public class StatSecurity {
    private static double min;
    private static double max;
    private static double mean;
    private static double deviation;
    private static int[] frequency;

    private static void calcFrequency(double[] d,double width,double offset) {
        min = Double.POSITIVE_INFINITY;
        max = Double.NEGATIVE_INFINITY;
        double x;

        double sum = 0;
        for( int i = 0; i < d.length ; ++i) {
            x = d[i];
            if( min > x ) min = x;
            if( max < x ) max = x;
            sum += x;
        }
        mean = sum / d.length;

        double base = min - offset;
        int ftable_size = (int)((max - base) / width) + 1;

        frequency = new int[ftable_size];
        Arrays.fill(frequency,0);

        int fix;
        double diff;
        double var = 0;
        for( int i = 0; i < d.length ; ++i ) {
            x = d[i];
            diff = x - mean;
            var += diff * diff;
            fix = (int)((x - base) / width);
            frequency[fix] += 1;
        }
        if( d.length > 1 ) {
            deviation = Math.sqrt(var / (d.length - 1));
        } else {
            deviation = 0;
        }
    }

    public static void main(String[] args) {
        final double[] security = {
            14.6,25.4,12.2, 9.3,20.3, 7.6,
            13.4, 9.6,14.7,25.3,13.7,10.1,
            11.9,18.9, 8.5,12.3,14.8, 8.6,
            28.2,16.2,12.8,16.2,12.1,14.0,
            15.4,27.5,30.4,16.2,16.5,11.6,
             9.7,21.1,12.9, 9.8,30.4,13.3,
            11.7, 8.7,31.6,19.5,22.4, 8.3
        };
        final double offset = 0.05;
        final double width = 2;
        calcFrequency(security,width,offset);
        System.out.println("ROE of 42 stocks.\nMinimum class : " 
            + (min + (width/2) - offset) + " width between classes : " + width );
        for( int i = 0; i < frequency.length ; ++i ) {
            System.out.print(frequency[i] + " ");
        }

        System.out.println("\nMean : " + mean);
        System.out.println("Standard deviation : " + deviation);
    }
}