import java.util.stream.IntStream;

public class SumOfCharPositions {
    static final String VOCALS = "aeiou";

    static String myText = "There also could occur errors during search or poison application Or the search could take a very long time because the ants hide very well";

    public static void main(String[] args) {
        int sum1 = IntStream.range(0, myText.length()).filter(v -> VOCALS.contains(myText.charAt(v) + "")).sum();

        System.out.println(sum1);


    }
}
