public class Sum {
    private static int sum(int x) {
        if( x <= 0 ) return 0;
        return (x + sum( x - 1));
    }

    public static void main(String[] args) {
        if( args.length > 0 ) {
            System.out.print("Sum of " + (Convert.atoi(args[0])) + " :");
            System.out.println( sum(Convert.atoi(args[0])));
        } else {
            System.out.println("usage : java Sum <number>");
        }
    }
}