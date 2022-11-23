public class Homework1p3 {
    public static void main(String[] args) {
        Car lada = new Car("Lada", "Grande", 1.7, "желтый", 2015, "Россия");
        Car audi = new Car("Audi", "A8 50L TDI Quattro", 3.0, "желтый", 2020, "Германия");
        Car bmw = new Car("BMW", "Z8", 3.0, "желтый", 2021, "Германия");
        Car kia = new Car("Kia", "Sportage 4", 2.4, "желтый", 2018, "Южная Корея");
        Car hyundai = new Car("Hyundai", "Avante", 1.6, "желтый", 2016, "Южная Корея");

        System.out.println(lada);
        System.out.println(audi);
        System.out.println(bmw);
        System.out.println(kia);
        System.out.println(hyundai);
    }
}