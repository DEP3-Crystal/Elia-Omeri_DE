import java.util.Optional;

public class Scratch {
    public static void main(String[] args) {
        Optional<String> emptyOptional = Optional.empty();
        var optional1 = Optional.of("Hello 1");
        var optional2 = Optional.ofNullable("HELLO 2");
//        optional1.ifPresentOrElse(value-> System.out.println("Optional contains a value  "+value),
//                ()-> System.out.println("Optional does not contain a value"));
        //var result = emptyOptional.map(value->value.toLowerCase());
        var result = getUserId("Foo").map(userId->getCar(userId));
        System.out.println(result);

    }
    private static Optional<Integer> getUserId(String name){
        return name.equals("Foo")? Optional.of(1):Optional.empty();
    }
    private static Optional<String> getCar(Integer userId){
        return userId == 1? Optional.of("Mercedes"):Optional.empty();
    }
}
