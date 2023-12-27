public class SquareRoot {
    /* ���ϒl���v�Z���� */
    private static double average(double u, double v) { 
        return (u + v) / 2;
    }
    /* ���̗\���l�����߂� */
    private static double improve(double x, double guess) { 
        return average(guess, x / guess);
    }
    /* �\���l�̋ߎ����[���ł��邩�ǂ����𔻒肷�� */
    private static boolean nearEnough(double u, double v) { 
        return Math.abs(u - v) < 0.001;
    }
    /* �����I�ɏ[���ȋߎ��ɒB����܂ŕ������̗\���l�����߂� */
    /* x�F�����l guess�F�\���l lastguess�F�O��̗\���l */
    private static double squareRootIter(double x, double guess, double lastguess) {
        if( nearEnough(guess,lastguess) ) {
            return guess;
        }
        return squareRootIter(x,improve(x,guess),guess);
    }
    /* x�̕����������߂� */
    private static double squareRoot(double x) {
        return squareRootIter(x, x / 2, x);
    }

    public static void main(String[] args) {
        if( args.length > 0 ) {
            System.out.print("Square Root of " + (Convert.atod(args[0])) + " :");
            System.out.println( squareRoot(Convert.atod(args[0])));
        } else {
            System.out.println("usage : java SquareRoot <number>");
        }
    }
}