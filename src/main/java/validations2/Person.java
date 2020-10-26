package validations2;

public class Person {
    @CheckCase(groups = CustomValidation.class, value = CaseType.UPPER_CASE, message = "manager must have upperCased name")
    private String name;

    public Person(String name) {
        this.name = name;
    }
}