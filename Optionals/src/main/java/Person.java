import java.util.Objects;
import java.util.Optional;

public class Person {
    private final String name;
    private final Car car;
    public Person(String name,Car car){
        this.name= Objects.requireNonNull(name,"name must not be null");
        this.car = car;
    }
    public String getName(){
        return name;
    }
    public Optional<Car> getCar(){
        return Optional.ofNullable(car);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", car=" + car +
                '}';
    }
}
