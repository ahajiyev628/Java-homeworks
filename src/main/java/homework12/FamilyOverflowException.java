package homework12;

public class FamilyOverflowException extends RuntimeException {
    public FamilyOverflowException(String message) {
        super(message);
        System.out.println("number of family members exceeds the limit");
    }
}
