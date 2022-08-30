import java.util.Arrays;

public class SumOfCharValues {
    static final String VOCALS = "aeiou";

    static String myText = "There also could occur errors during search or poison application Or the search could take a very long time because the ants hide very well";

    public static void main(String[] args) {

//        Exercise -
//         Calculate the sum of the char values
        int sum = 0;
        for (int i = 0; i < myText.length(); i++) {
            if (VOCALS.contains(myText.charAt(i) + "")) {
                sum += (int) myText.charAt(i);
            }
        }
        System.out.println(sum);
        long num = Arrays.stream(myText.split("")).map(v -> VOCALS.contains(v) ? (int) v.charAt(0) : 0).reduce(Integer::sum).get();
        System.out.println(sum);

    }
}
