package duke.helper;

/**
 * Class to check if a string is Numeric
 *
 * @author Khenus Tan
 */
public class CheckNumeric {
    /**
     * Function to check whether a string can be converted into double
     *
     * @param toCheckString The String to be checked
     * @return boolean
     */
    public static boolean isNumeric(String toCheckString) {
        try {
            Double.parseDouble(toCheckString);
            return true;
        } catch(NumberFormatException numberFormatError){
            return false;
        }
    }
}
