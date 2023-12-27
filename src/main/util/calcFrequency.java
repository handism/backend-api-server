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

        /* �ŏ��̃��[�v�ŕ��ςƍő�ŏ������߂� */
        for( int i = 0; i < d.length ; ++i) {
            x = d[i];
            if( min > x ) min = x;
            if( max < x ) max = x;
            sum += x;
        }

        /* ���ς̌v�Z */
        mean = sum / d.length;

        /* �ŏ��l���I�t�Z�b�g�����ɂ��炵���l��x�����z�̍ŏ����E�l�Ƃ��� */
        double base = min - offset;

        /* �ő�l�ƍŏ����E�l�̍����N���X�̕��Ŋ��������̂��\�̑傫���ƂȂ� */
        /* �������A�����_�ȉ��؂�グ */
        int ftable_size = (int)((max - base) / width) + 1;

        /* �\�̊���� */
        frequency = new int[ftable_size];

        /* �[���N���A�iJava�d�l��͕s�v�j */
        Arrays.fill(frequency,0); 

        int fix;
        double diff;
        double var = 0;

        /* ���U�̌v�Z�Ɠx�����z�\�̍쐬 */
        for( int i = 0; i < d.length ; ++i ) {
            x = d[i];
            diff = x - mean;
            var += diff * diff;
            fix = (int)((x - base) / width);
            frequency[fix] += 1;
        }

        /* �W���΍��̌v�Z */
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
        /* �I�t�Z�b�g1/2 */
        final double offset = 0.5;

        /* �K���� */
        final double width = 5;

        /* �x�����z�\�A���ρA�W���΍��v�Z */
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
