import java.util.Objects;
import java.util.Optional;

public class Car {
    private final String brand;
    private final Insurance insurance;

    public  Car(String brand,Insurance insurance){
        this.brand= Objects.requireNonNull(brand,"brand cannot be null");
        this.insurance=insurance;
    }
    public String getBrand(){
        return brand;
    }

    public Optional<Insurance> getInsurance() {
        return Optional.ofNullable(insurance);
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", insurance=" + insurance +
                '}';
    }
}
