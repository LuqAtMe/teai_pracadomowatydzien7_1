package home.application.teai_pracadomowatydzien7_1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class DaoCarsImpl implements DaoCars {

    private JdbcTemplate jdbcTemplate;

    private List<Car> carList;

    @Autowired
    public DaoCarsImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void saveCar(Car car) {
        String sql = "INSERT INTO cars VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, car.getCarId(), car.getCarMark(), car.getCarModel(), car.getCarColor(), car.getCarProduction());
        updateCarsFromDB();
    }

    @Override
    public List<Car> updateCarsFromDB() {

        String sql = "SELECT * FROM cars";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        setCarList(getCars(maps));
        return getCarList();
    }

    @Override
    public List<Car> getCarsInSpecificRange(int yearMin, int yearMax) {

        String sql = "SELECT * FROM cars WHERE car_production BETWEEN ? AND ?";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql, yearMin, yearMax);
        setCarList(getCars(maps));
        return getCarList();
    }

    @Override
    public List<Car> getCarList() {
        if (carList == null) {
            updateCarsFromDB();
        }
        return carList;
    }

    //This method only convert output from DB (Map) to the List class
    private List<Car> getCars(List<Map<String, Object>> maps) {
        List<Car> carList = new ArrayList<>();
        maps.stream().forEach(car -> carList.add(
                new Car(
                        Long.parseLong(String.valueOf(car.get("car_id"))),
                        String.valueOf(car.get("car_mark")),
                        String.valueOf(car.get("car_model")),
                        String.valueOf(car.get("car_color")),
                        Long.parseLong(String.valueOf(car.get("car_production")))
                )
        ));
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }
}

