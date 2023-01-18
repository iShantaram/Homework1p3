package transport;

import java.time.LocalDate;
import java.util.Objects;

public class Car {


    public static class Key {
        private final boolean remoteStartEngine;
        private final boolean accessWithoutKey;

        public Key(boolean remoteStartEngine, boolean accessWithoutKey) {
            this.remoteStartEngine = remoteStartEngine;
            this.accessWithoutKey = accessWithoutKey;
        }

        public Key() {
            this(false,false);
        }

        public boolean isRemoteStartEngine() {
            return remoteStartEngine;
        }

        public boolean isAccessWithoutKey() {
            return accessWithoutKey;
        }

        @Override
        public String toString() {
            String yes1 = "нет";
            String yes2 = "нет";
            if (remoteStartEngine || accessWithoutKey) {
                if (remoteStartEngine) yes1 = "есть";
                if (accessWithoutKey) yes2 = "есть";
                return " доп. опции: " +
                        "удаленный запуск двигателя - " + yes1 +
                        ", бесключевой доступ - " + yes2 +
                        '}';
            } else return "";
        }
    }

    public class Insurance {
        private int price;
        private String number;
        private LocalDate date;

        public Insurance(int price, String number, LocalDate date) {
            this.price = Math.abs(price);
            if (number.length() != 9) {
               System.out.println("Номер страховки " + number + " некорректный!");
            }
            this.number = number;
            this.date = date;
        }

        public boolean isActive() {
            if (date.isAfter(LocalDate.now())) {
                return true;
            } else {
                System.out.println("Необходимо срочно продлить страховку " + this.number + " !");
                return false;
            }
        }

        public int getPrice() {
            return price;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            if (number.length() == 9) {
                this.number = number;
            } else {
                System.out.println("Поптыка задать некорректный номер страховки - " + number);
            }
        }

        public void setDate(LocalDate date) {
            this.date = date;
        }

        @Override
        public String toString() {
            return "Insurance of " + Car.this.brand + " " + Car.this.model + " " + Car.this.registrationNumber + " {" +
                    "price=" + price +
                    ", number='" + number + '\'' +
                    ", expiration date=" + date +
                    '}';
        }
    }
    private final String brand;
    private final String model;
    private final int productionYear;
    private final String productionCountry;
    private final String bodyType;
    private final int seatsNumber;
    private double engineVolume;
    private String color;
    private String transmission;
    private String registrationNumber;
    private boolean winterTiers;
    private Key key;
    private Insurance insurance;

    public Car(String brand,
               String model,
               double engineVolume,
               String color,
               int productionYear,
               String productionCountry,
               String bodyType,
               int seatsNumber,
               String transmission,
               String registrationNumber,
               boolean winterTiers,
               Key key) {

        if (bodyType == null || bodyType.isEmpty() || bodyType.isBlank()) this.bodyType = "Unknown";
        else this.bodyType = bodyType;

        this.seatsNumber = Math.abs(seatsNumber);

        if (registrationNumber == null || registrationNumber.isEmpty() || registrationNumber.isBlank()) this.registrationNumber = "Unknown";
        else this.registrationNumber = registrationNumber;

        this.winterTiers = winterTiers;

        if (brand == null || brand.isEmpty() || brand.isBlank()) this.brand = "Unknown";
        else this.brand = brand;

        if (model == null || model.isEmpty() || model.isBlank()) this.model = "Unknown";
        else this.model = model;

        this.engineVolume = Math.abs(engineVolume);

        if (color == null || color.isEmpty() || color.isBlank()) this.color = "Unknown";
        else this.color = color;

        if (productionYear > LocalDate.now().getYear()) this.productionYear = LocalDate.now().getYear();
        else this.productionYear = Math.max(productionYear, 2000);

        if (productionCountry == null || productionCountry.isEmpty() || productionCountry.isBlank()) this.productionCountry = "Unknown";
        else this.productionCountry = productionCountry;

        if (transmission == null|| transmission.isEmpty() || transmission.isBlank()) this.transmission = "Unknown";
        else this.transmission = transmission;

        if (key == null) this.key = new Key();
        else this.key = key;
    }

    public boolean isActiveInsurance() {
        return this.insurance.isActive();
    }

    @Override
    public String toString() {
        return "Car{ " + brand + " " + model + ", сборка: " + productionCountry + ", " + productionYear + " год, цвет: " + color +
                ", объем двигателя: " + engineVolume + "L, кузов " + bodyType + ", кол-во мест " + seatsNumber + ", трансмиссия " + transmission +
                ", " + registrationNumber + ", " + infoWinterTiers() + "," + key + " }";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return productionYear == car.productionYear && brand.equals(car.brand) &&
                model.equals(car.model) && productionCountry.equals(car.productionCountry) && registrationNumber.equals(car.registrationNumber);
    }
    @Override
    public int hashCode() {
        return Objects.hash(brand, model, engineVolume, color, productionYear, productionCountry, transmission, registrationNumber, seatsNumber);
    }

    public String getBrand() {
        return brand;
    }
    public String getModel() {
        return model;
    }
    public int getProductionYear() {
        return productionYear;
    }
    public int getAge() {
        return LocalDate.now().getYear() - productionYear;
    }
    public String getProductionCountry() {
        return productionCountry;
    }
    public String getBodyType() {
        return bodyType;
    }
    public int getSeatsNumber() {
        return seatsNumber;
    }
    public String getTransmission() {
        return transmission;
    }
    public void setTransmission(String transmission) {
        if (transmission != null && !transmission.isEmpty() && !transmission.isBlank()) this.transmission = transmission;
    }
    public boolean isWinterTiers() {
        return winterTiers;
    }
    private String infoWinterTiers() {
        if (isWinterTiers()) return "зимние шины";
        else return "летние шины";
    }
    public void setWinterTiers(boolean winterTiers) {
        this.winterTiers = winterTiers;
    }
    public void changeTiers(){
        winterTiers = !winterTiers;
    }
    public Key getKey() {
        return key;
    }
    public void setKey(Key key) {
        this.key = key;
    }
    public String getRegistrationNumber() {
        return registrationNumber;
    }
    public void setRegistrationNumber(String registrationNumber) {
        if (registrationNumber != null && !registrationNumber.isEmpty() && !registrationNumber.isBlank()) this.registrationNumber = registrationNumber;
    }
    public boolean isValidRegNumber () {
        String validSymbols = "QWERTYUIOPASDFGHJKLZXCVBNMУКЕНХВАРОСМТ";
        String validNumbers = "0123456789";
        char[] regNumArray = registrationNumber.toCharArray();
        if (regNumArray.length == 9) {
            if ((validSymbols.indexOf(regNumArray[0]) >= 0) &&
                    (validSymbols.indexOf(regNumArray[4]) >= 0) &&
                    (validSymbols.indexOf(regNumArray[5]) >= 0) &&
                    (validNumbers.indexOf(regNumArray[1]) >= 0) &&
                    (validNumbers.indexOf(regNumArray[2]) >= 0) &&
                    (validNumbers.indexOf(regNumArray[3]) >= 0) &&
                    (validNumbers.indexOf(regNumArray[6]) >= 0) &&
                    (validNumbers.indexOf(regNumArray[7]) >= 0) &&
                    (validNumbers.indexOf(regNumArray[8]) >= 0)) {
                System.out.println("Number " + registrationNumber + " is valid.");
                return true;
            }
        }
        System.out.println("Number " + registrationNumber + " is not valid.");
        return false;
    }
    public double getEngineVolume() {
        return engineVolume;
    }
    public void setEngineVolume(double engineVolume) {
        this.engineVolume = Math.abs(engineVolume);
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        if (color == null || color.isEmpty() || color.isBlank()) this.color = "Unknown color";
        else this.color = color;
    }
    public Insurance getInsurance() {
        return insurance;
    }
    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }
}
