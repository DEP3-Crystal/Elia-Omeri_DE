import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LetterCounter {
    static final String VOCALS = "aeiou";

    static String myText = "There also could occur errors during search or poison application Or the search could take a very long time because the ants hide very well";

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(myText.split("")));
        // TO DO - find 2 other ways to create a stream of chars from a string !!!!
        // ex myText.getChars();


             //First Method
        IntStream intStream = myText.chars();
        List<Character> k = intStream.mapToObj(c -> (char) c)
                .collect(Collectors.toList());
        System.out.println(k);


            //Second Method
        Arrays.stream(myText.split("")).forEach(c -> System.out.println(c));

        Arrays.stream(myText.split("")).forEach(System.out::println);

          //Third Method
        char[] num1 = myText.toCharArray();
        System.out.println(num1);


        long vc = Arrays.stream(myText.split(""))
//                .filter(l -> VOCALS.indexOf(l) >= 0)
//                .count();
                .filter(VOCALS::contains)
                .count();

        System.out.println(vc);
        System.out.println(myText.length() - vc);


        System.out.println(Arrays.stream(myText.split(""))
                .filter(l -> VOCALS.indexOf(l) < 0)
                .count());
    }
}
