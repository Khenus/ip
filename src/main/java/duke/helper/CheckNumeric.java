package duke.helper;

public class CheckNumeric {
    public static boolean isNumeric(String toCheckString) {
        try {
            Double.parseDouble(toCheckString);
            return true;
        } catch(NumberFormatException numberFormatError){
            return false;
        }
    }
}
