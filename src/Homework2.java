import transport.Car;
import transport.Car.Insurance;

import java.time.LocalDate;

public class Homework2 {
    public static void main(String[] args) {
        Car.Key remoteStartKey = new Car.Key(true, false);
        Car lada = new Car("Lada", "Grande", 1.7, "желтый", 2015, "Россия",
                "", 4, "МКП","P123OX150", Boolean.FALSE, null);
        Car audi = new Car("Audi", "A8 50L TDI Quattro", 3.0, "желтый", 2020, "Германия",
                "", 4, "АКП","P321OЙ199", false, remoteStartKey);
        Car bmw = new Car("BMW", "Z8", 3.0, "", 1980, "Германия",
                "", 2, "АКП", "", false, null);
        Car kia = new Car("Kia", null, 2.4, "желтый", 2018, "Южная Корея",
                "", 4, "АКП", "Н456АХ177", false, null);
        System.out.println();

        System.out.println(lada);
        System.out.println(audi);
        System.out.println(bmw);
        System.out.println(kia);

        LocalDate ladaInsDate = LocalDate.of(2022, 12, 1);
        LocalDate audiInsDate = LocalDate.of(2024, 5, 1);
        LocalDate bmwInsDate = LocalDate.of(2023, 1, 18);
        LocalDate kiaInsDate = LocalDate.of(2023, 1, 22);

        Insurance ladaIns = lada.new Insurance(6000, "BB3456456", ladaInsDate);
        Insurance audiIns = audi.new Insurance(24000, "AA3456456", audiInsDate);
        Insurance bmwIns = bmw.new Insurance(11000, "AB24564567", bmwInsDate);
        Insurance kiaIns = kia.new Insurance(10000, "BA1456456", kiaInsDate);

        System.out.println();

        lada.setInsurance(ladaIns);
        audi.setInsurance(audiIns);
        bmw.setInsurance(bmwIns);
        kia.setInsurance(kiaIns);

        lada.isActiveInsurance();
        audi.isActiveInsurance();
        bmw.isActiveInsurance();
        kia.isActiveInsurance();

        lada.isValidRegNumber();
        audi.isValidRegNumber();
        bmw.isValidRegNumber();
        kia.isValidRegNumber();
    }
}