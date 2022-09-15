import java.util.Optional;

public class main {
    public static void main(String[] args) {
        Person person = new Person("foo",null);
        //Person person1 = new Person("Elia",null);
       // String result1 = getCarInsuranceName(person1);
        String result = getCarInsuranceName(person);
        System.out.println(result);
       // System.out.println(result1);
    }


    private static Optional<String> getCarInsuranceName(Person person) {
        return person.getCar().flatMap(car -> car.getInsurance().map(insurance -> insurance.getName()));

    }
}
