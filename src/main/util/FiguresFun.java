public class FiguresFun {
    /* â~é¸ÇåvéZÇ∑ÇÈ */
    private static double circleLength(double x) {
        return (2.0 * 3.14 * x);
    }

    /* ê≥ï˚å`ÇÃäOé¸ÇåvéZÇ∑ÇÈ */
    private static double squareLength(double x) {
        return (4.0 * x);
    }

    /* éOäpå`ÇÃäOé¸ÇåvéZÇ∑ÇÈ */
    private static double triangleLength(double x) {
        return (3.0 * x);
    }

    public static void main(String[] args) {
        if( args.length > 1 ) {

            /* â~ */
            if( args[0].equals("circle") ) {
                System.out.print("Circle is :"); 
                System.out.println( circleLength(Convert.atod(args[1]))
                     + " meters .");
                System.out.print("Half size Circle is :");
                System.out.println( circleLength(Convert.atod(args[1]) / 2.0)
                     + " meters .");

            /* ê≥ï˚å` */
            } else if( args[0].equals("square") ) {
                System.out.print("Square is :");
                System.out.println( squareLength(Convert.atod(args[1]))
                     + " meters .");
                System.out.print("Half size Square is :");
                System.out.println(squareLength(Convert.atod(args[1])/ 2.0)
                     + " meters .");

            /* éOäpå` */
            } else if( args[0].equals("triangle") ) {
                System.out.print("Triangle is :");
                System.out.println( triangleLength(Convert.atod(args[1]))
                     + " meters .");
                System.out.print("Half size Triangle is :");
                System.out.println( triangleLength(Convert.atod(args[1]) / 2.0)
                     + " meters .");
            } else {
                System.out.println("Sorry unknown figure type");
            }
        } else {
            System.out.println(
                "usage : java FiguresFun <figure type> <length>");
        }
    }
}