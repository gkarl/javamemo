package section9Collection.exo159;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Objects;

class Car implements Comparable {

    private String mark;
    private String model;
    private LocalDate year;

    public Car(String mark, String model, LocalDate year) {
        this.mark = mark;
        this.model = model;
        this.year = year;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public LocalDate getYear() {
        return year;
    }

    public void setYear(LocalDate year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return mark.equals(car.mark) && model.equals(car.model) && year.equals(car.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mark, model, year);
    }

    @Override
    public int compareTo(Object o) {
        Car car = (Car) o;
        return this.mark.compareTo(car.mark);
    }

    @Override
    public String toString() {
        return "Car{" +
                "mark='" + mark + '\'' +
                ", model='" + model + '\'' +
                ", date=" + year +
                '}';
    }
}
