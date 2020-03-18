package home.application.teai_pracadomowatydzien7_1;

import java.util.List;

public interface DaoCars {

    List<Car> getCarList();
    void saveCar(Car car);
    List<Car> updateCarsFromDB();
    List<Car> getCarsInSpecificRange(int yearMin, int yearMax);

}
