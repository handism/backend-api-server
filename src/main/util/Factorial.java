public class Factorial {
    private static long factorialIter(long x,long fact) {
        if( x <= 0L ) {
            return fact;
        }
        return factorialIter( x - 1L, x * fact);
    }

    private static long factorial(long x) {
        return factorialIter(x, 1L);
    }

    public static void main(String[] args) {
        if( args.length > 0 ) {
            System.out.print("Factorial of " + (Convert.atol(args[0])) + " :");
            System.out.println( factorial(Convert.atol(args[0])));
        } else {
            System.out.println("usage : java FactorialT <number>");
        }
    }

}