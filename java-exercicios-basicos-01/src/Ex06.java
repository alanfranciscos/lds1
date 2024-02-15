import java.util.ArrayList;
import java.util.List;

public class Ex06 {
    public static void main(String[] args) {
        String[] cars = {"civic", "gol", "palio", "uno"};

        for (int i = 0; i < cars.length ; i ++) {
            System.out.println(cars[i]);
            if (cars[i].equals("gol")) {
                cars[i] = "L200";
            }
        }

        for(String car: cars) {
            System.out.println(car);
        }

        String[] newCars = new String[cars.length + 1];
        System.arraycopy(cars, 0, newCars, 0, cars.length);
        newCars[newCars.length - 1] = "gol";

        for(String car: newCars) {
            System.out.println(car);
        }

    }
}
