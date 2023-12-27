import java.util.*;

public class Stat {
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

        /* 最初のループで平均と最大最小を求める */
        for( int i = 0; i < d.length ; ++i) {
            x = d[i];
            if( min > x ) min = x;
            if( max < x ) max = x;
            sum += x;
        }

        /* 平均の計算 */
        mean = sum / d.length;

        /* 最小値よりオフセット分左にずらした値を度数分布の最小境界値とする */
        double base = min - offset;

        /* 最大値と最小境界値の差をクラスの幅で割ったものが表の大きさとなる */
        /* ただし、小数点以下切り上げ */
        int ftable_size = (int)((max - base) / width) + 1;

        /* 表の割りつけ */
        frequency = new int[ftable_size];

        /* ゼロクリア（Java仕様上は不要） */
        Arrays.fill(frequency,0); 

        int fix;
        double diff;
        double var = 0;

        /* 分散の計算と度数分布表の作成 */
        for( int i = 0; i < d.length ; ++i ) {
            x = d[i];
            diff = x - mean;
            var += diff * diff;
            fix = (int)((x - base) / width);
            frequency[fix] += 1;
        }

        /* 標準偏差の計算 */
        if( d.length > 1 ) {
            deviation = Math.sqrt(var / (d.length - 1));
        } else {
            deviation = 0;
        }
    }

    public static void main(String[] args) {
        final double[] bloodPressure = {
            120,115,108,111,116,132,93,107,114,118,126,124,117,102,155,123,
            124,117,152,130,114,126,133,120,148,135,110,100,120,108,125,136,
            142,113,147,155,132,110,136,125,96,112,120,118,115,122,168,160,
            126,153
        };
        /* オフセット1/2 */
        final double offset = 0.5;

        /* 階級幅 */
        final double width = 5;

        /* 度数分布表、平均、標準偏差計算 */
        calcFrequency(bloodPressure,width,offset);
        System.out.println("Frequency table of Blood Pressure.\nMinimum class : " 
            + (min + (width/2) - offset) + " width between classes : " + width );
        for( int i = 0; i < frequency.length ; ++i ) {
            System.out.print(frequency[i] + " ");
        }

        System.out.println("\nMean : " + mean);
        System.out.println("Standard deviation : " + deviation);
    }
}
