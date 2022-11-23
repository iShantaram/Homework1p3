import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Car {
    private final String brand;
    private final String model;
    private final double engineVolume;
    private String color;
    private final int productionYear;
    private final String productionCountry;

    public Car(String brand, String model, double engineVolume, String color, int productionYear, String productionCountry) {
    if (brand == null || brand.isEmpty()) this.brand = "Unknown brand";
    else this.brand = brand;
    if (model == null || model.isEmpty()) this.model = "Unknown model";
    else this.model = model;

    this.engineVolume = Math.abs(engineVolume);

    if (color == null || color.isEmpty()) this.color = "Unknown color";
    else this.color = color;

    if (productionYear > LocalDate.now().getYear()) this.productionYear = LocalDate.now().getYear();
    else this.productionYear = Math.max(productionYear, 2000);

    if (productionCountry == null || productionCountry.isEmpty()) this.productionCountry = "Unknown country";
    else this.productionCountry = productionCountry;
    }

    @Override
    public String toString() {
        return "Car{ " + brand + " " + model + ", сборка: " + productionCountry + ", " + productionYear + " год, цвет: " + color +
                ", объем двигателя: " + engineVolume + "L }";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(car.engineVolume, engineVolume) == 0 && productionYear == car.productionYear && brand.equals(car.brand) && model.equals(car.model) && color.equals(car.color) && productionCountry.equals(car.productionCountry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, engineVolume, color, productionYear, productionCountry);
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public String getColor() {
        return color;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public String getProductionCountry() {
        return productionCountry;
    }
}
