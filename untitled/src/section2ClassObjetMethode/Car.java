package section2ClassObjetMethode;

import java.time.LocalDate;

public class Car {

    private Long carId;

    private String model;

    private LocalDate buildDate;

    private String marque;

    public Car(String model, LocalDate buildDate, String marque) {
        this.model = model;
        this.buildDate = buildDate;
        this.marque = marque;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public LocalDate getBuildDate() {
        return buildDate;
    }

    public void setBuildDate(LocalDate buildDate) {
        this.buildDate = buildDate;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    @Override
    public String toString() {
        return "section2ClassObjetMethode.Car{" +
                "carId=" + carId +
                ", model='" + model + '\'' +
                ", buildDate=" + buildDate +
                ", marque='" + marque + '\'' +
                '}';
    }
}
