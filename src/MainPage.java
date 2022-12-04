import javax.swing.*;
import java.awt.*;

public class MainPage extends JFrame {

    JPanel panel;

    MainPage(){

        panel = new JPanel();
        panel.setBackground(Color.RED);
        panel.setBounds(500,500,500,500);

        this.add(panel);

    }
}
