import domain.Car;
import domain.Passenger;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IllegalAccessException {
        Passenger bob = new Passenger("Bob", 12, "Krakkov");
        Passenger Jhon = new Passenger("Jhon", 12, "Rommanoff");
        Passenger maria = new Passenger("Maria", 12, "Wayne");
        Passenger alice = new Passenger("Alice", 12, "Banner");
        Passenger sam = new Passenger("Samantha", 12, "Maximoff");
        Passenger marcus = new Passenger("Marcus", 12, "Kreovak");
        Passenger mark = new Passenger("Mark", 12, "Neosalgina");

        Car ferrariM12 = new Car("M12 AX", 324.00, 2, Arrays.asList(bob, sam));
        Car enterpriseCar = new Car("Some Enterprise Car", 120.00, 6, Arrays.asList(Jhon, maria, alice));
        Car familyCar = new Car("Some Family Car", 120.00, 10, Arrays.asList(bob, Jhon, maria, sam, marcus, alice, mark));

        System.out.println("============================ CARS TIME ===================================");
        System.out.println(JsonGenerator.getJson(ferrariM12));
        System.out.println(JsonGenerator.getJson(enterpriseCar));
        System.out.println(JsonGenerator.getJson(familyCar));

        System.out.println();
        System.out.println("============================ PASSENGERS TIME ===================================");
        System.out.println(JsonGenerator.getJson(bob));
        System.out.println(JsonGenerator.getJson(maria));



//        System.out.println(Util.getJson(Jhon));
    }
}
