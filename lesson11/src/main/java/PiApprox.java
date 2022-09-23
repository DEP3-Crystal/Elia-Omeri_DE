import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;


public class PiApprox {
    public static void main(String[] args) {
//        int insideCircle = 0;
//        int insideRect = 0;
//        //for(int i=0;i < 100_000_000;i++) {
        // double x = -1 + 2*Math.random(); // [-1,+1)
//            double y = -1 + 2*Math.random();
        //if(x*x + y*y <= 1) {
        //  insideCircle++;
        //}
        // insideRect++;
//        }
//        System.out.println("Approx PI=" + (insideCircle*4.0)/insideRect);
        // TODO
        // implement it functional style - streaming/ parallel streaming
        int sum = IntStream.range(0, 100_000_000)
                .parallel()
                .map(i -> {
                    double x = -1 + 2 * ThreadLocalRandom.current().nextDouble(); // [-1,+1)
                    double y = -1 + 2 * ThreadLocalRandom.current().nextDouble();
                    if (x * x + y * y <= 1) {
                        return 1;
                    }
                    return 0;
                })
                .sum();
        System.out.println("Approx PI=" + (sum * 4.0) / 100_000_000);


    }
}
