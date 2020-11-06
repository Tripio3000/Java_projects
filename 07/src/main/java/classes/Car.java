package classes;

import java.util.StringJoiner;

public class Car {
    private String firm;
    private Integer years;

    public Car() {
    }

    public Car(String firm, Integer years) {
        this.firm = firm;
        this.years = years;
    }

    public Integer age (Integer value) {
        this.years += value;
        return years;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class . getSimpleName() + "[", "]")
                . add("Firm='" + firm + "'")
                . add("Age=" + years)
                . toString();
    }
}
