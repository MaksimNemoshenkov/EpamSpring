package validations;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Driver {
    @NotNull(message = "where is your name?")
    private String name;

    @Min(value = 18, message = "too young to be a driver")
    private int age;

    @AssertFalse(message = "you are alcogolic")
    private boolean alcoholist;

    public Driver(String name,int age, boolean alcoholist) {
        this.name = name;
        this.age = age;
        this.alcoholist = alcoholist;
    }
}