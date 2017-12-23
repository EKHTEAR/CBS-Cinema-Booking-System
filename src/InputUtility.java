import javax.swing.*;

public class InputUtility {


    InputUtility() {
    }


    public static boolean getDouble(String stringToConvert, double MIN_LIMIT, double MAX_LIMIT) {
        double doubleValue = Double.parseDouble(stringToConvert);
        if (doubleValue >= MIN_LIMIT && doubleValue <= MAX_LIMIT) {
            return true;
        }

        else{
            if (doubleValue<0){
                JOptionPane.showMessageDialog(null, "Are You Serious..??? Is this possible...!!!???", "ERROR !!!", JOptionPane.INFORMATION_MESSAGE);
                return false;
            }
            else {
                JOptionPane.showMessageDialog(null, "Price limit Exceeded (Maximum $500) !!! ", "ERROR !!!", JOptionPane.INFORMATION_MESSAGE);
                return false;
            }

        }


    }

    public static boolean getInteger(String stringToConvert, int intValue, int MIN_LIMIT, int MAX_LIMIT) {
        MIN_LIMIT = 0;
        MAX_LIMIT = 240;
        intValue = Integer.parseInt(stringToConvert);
        if (intValue >= MIN_LIMIT && intValue <= MAX_LIMIT) {
            return true;
        }
        return false;

    }

}

