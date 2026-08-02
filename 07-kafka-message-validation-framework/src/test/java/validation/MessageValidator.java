package validation;

public class MessageValidator {

    public boolean validate(
            String actual,
            String expected) {

        System.out.println("Actual Message   : " + actual);
        System.out.println("Expected Message : " + expected);
        return actual.equals(expected);
    }
}