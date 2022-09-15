import java.util.Objects;

public class Insurance {
    private final String name;
    public Insurance(String name){
        this.name= Objects.requireNonNull(name);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Insurance{" +
                "name='" + name + '\'' +
                '}';
    }
}
