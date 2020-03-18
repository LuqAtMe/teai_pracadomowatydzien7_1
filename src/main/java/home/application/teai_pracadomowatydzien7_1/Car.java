package home.application.teai_pracadomowatydzien7_1;

public class Car {

    private long carId;
    private String carMark;
    private String carModel;
    private String carColor;
    private long carProduction;

    public Car(long carId, String carMark, String carModel, String carColor, long carProduction) {
        this.carId = carId;
        this.carMark = carMark;
        this.carModel = carModel;
        this.carColor = carColor;
        this.carProduction = carProduction;
    }

    public Car() {
    }

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }


    public String getCarMark() {
        return carMark;
    }

    public void setCarMark(String carMark) {
        this.carMark = carMark;
    }


    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }


    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }


    public long getCarProduction() {
        return carProduction;
    }

    public void setCarProduction(long carProduction) {
        this.carProduction = carProduction;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", carMark='" + carMark + '\'' +
                ", carModel='" + carModel + '\'' +
                ", carColor='" + carColor + '\'' +
                ", carProduction=" + carProduction +
                '}';
    }
}
