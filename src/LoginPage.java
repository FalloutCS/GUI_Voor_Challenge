import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JFrame implements ActionListener {

    JTextField userInput;
    JPasswordField passwordField;
    JButton button;
    JButton register;



    LoginPage(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(275,150);


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
        button.setFocusable(false);
        button.addActionListener(this);

        register = new JButton("register");
        register.setBounds(100,70,80,25);
        register.setFocusable(false);
        register.addActionListener(this);



        this.add(username);
        this.add(userInput);
        this.add(password);
        this.add(passwordField);
        this.add(button);
        this.add(register);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==button) {
            String user = userInput.getText();
            String password = passwordField.getText();

            getAuthUser getAuthUser = new getAuthUser(user, password);
        }
        if(e.getSource()==register){

            RegisterUser registerUser = new RegisterUser();
        }

        //Helaas blijft de login client nog open staan als er ingelogt is
    }
}
