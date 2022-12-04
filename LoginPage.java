import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JFrame implements ActionListener {

    JTextField userInput;
    JPasswordField passwordField;
    JButton button;



    LoginPage(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(250,125);
        this.setVisible(true);

        JLabel username = new JLabel("Username");
        userInput = new JTextField();
        username.setBounds(10,20,80,25);
        userInput.setBounds(100,20,130,25);

        JLabel password = new JLabel("Password");
        password.setBounds(10,45,80,25);
        passwordField = new JPasswordField();
        passwordField.setBounds(100,45,130,25);

        button = new JButton("Log In");
        button.setBounds(10,70,80,25);
        button.addActionListener(this);

        this.add(username);
        this.add(userInput);
        this.add(password);
        this.add(passwordField);
        this.add(button);





    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String user = userInput.getText();
        String password = passwordField.getText();

        GetAuthUser getAuthUser = new GetAuthUser(user,password);

        /*if(user.equals("admin")&&password.equals("admin")){
            MyFrame myFrame = new MyFrame();
            dispose();

        }
        else JOptionPane.showMessageDialog(null,"Wrong password, Try again!","Login Failed",JOptionPane.ERROR_MESSAGE);*/
        dispose();
    }
}
