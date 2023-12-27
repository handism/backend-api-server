public class Area {
    public static void main(String[] args) {
        if( args.length > 1 ) {
            System.out.print("Area is :");
            System.out.println(Convert.atod(args[0]) * Convert.atod(args[1]) 
                + " meters square.");
        } else {
            System.out.println("usage : java Areav3 <length> <height>");
        }
    }
}