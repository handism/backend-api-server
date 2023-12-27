public class Circle {
    private static double circleLength(double x) {
        return (2.0 * 3.14 * x);
    }

    public static void main(String[] args) {
        if( args.length > 0 ) {
            /* フルサイズの円周計算 */
            System.out.print("Circle is :");
            System.out.println( circleLength(Convert.atod(args[0])) 
                + " meters .");
            /* ハーフサイズの円周計算 */
            System.out.print("Half size Circle is :");
            System.out.println( circleLength(Convert.atod(args[0]) / 2.0)
                 + " meters .");
        } else {
            System.out.println("usage : java CircleFun <radius>");
        }
    }
}