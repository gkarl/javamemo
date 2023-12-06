package section10StreamsAndLambdas.exo181;

import java.math.BigDecimal;
import java.time.Year;
import java.util.Objects;

class Car implements Comparable {

    private String mark;
    private String model;
    private Year year;

    private BigDecimal price;


    public Car(String mark, String model, Year year, BigDecimal price) {
        this.mark = mark;
        this.model = model;
        this.year = year;
        this.price = price;
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

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }


    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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
                ", year=" + year +
                ", price=" + price +
                '}';
    }
}
