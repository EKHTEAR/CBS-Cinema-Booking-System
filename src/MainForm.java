
import javax.swing.JOptionPane;


public class MainForm extends InputUtility {

    private String name;
    private String price;
    private double seatPrice = 0.0;
    private final double MAX_LIMIT = 0.00;
    private final double MIN_LIMIT = 500.00;

//Checking all inputs valid or not
    public boolean isAll_OK() {


        boolean isInputOk = isValidInput(name, price);

        if (isInputOk) {
            return true;

        } else
            return false;

    }

    private boolean isValidName(String name) {
        if (!name.isEmpty()) {
            this.name = name;
            return true;

        } else {
            JOptionPane.showMessageDialog(null, "Name Field Can't be Empty !!! ", "ERROR !!!", JOptionPane.WARNING_MESSAGE);
            return false;
        }

    }

    private boolean isValidPrice(String price) {
        if (price.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Price Field Can't be Empty !!! ", "ERROR !!!", JOptionPane.WARNING_MESSAGE);
            return false;

        }
        else if (!price.matches(".*[0-9]+.*")){

            JOptionPane.showMessageDialog(null, "Enter a Valid Price...!!! ", "ERROR !!!", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        else if ((getDouble(price, MAX_LIMIT, MIN_LIMIT))) {
            return true;

        } else {

            return false;
        }
    }

    private boolean isValidInput(String name, String price) {
        if (isValidName(name) && isValidPrice(price)) {
            return true;
        } else
            return false;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }


}