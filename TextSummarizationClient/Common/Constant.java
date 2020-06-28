package Common;

import java.awt.Component;
import javax.swing.JOptionPane;

public class Constant {
    public static final String MESSAGE="";
    public static void showMessage(Component com,String header,String msg)
    {
        JOptionPane.showMessageDialog(com, msg, header, JOptionPane.INFORMATION_MESSAGE);
    }
}
