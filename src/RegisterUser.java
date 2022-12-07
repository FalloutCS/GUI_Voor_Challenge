import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class RegisterUser extends JFrame implements ActionListener {

    JButton button;
    JTextField UserInput;
    JPasswordField UserPassword;

    RegisterUser(){

        ImageIcon Logo = new ImageIcon("ChallengeIconLOLOL.png");
        JLabel logo = new JLabel();
        button = new JButton("Registreer");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500,500);

        logo.setIcon(Logo);
        logo.setBounds(150,225,200,200);

        button.setBounds(10,90,120,25);
        button.addActionListener(this);
        button.setFocusable(false);

        JLabel Username = new JLabel();
        Username.setText("Kies uw gebruikersnaam:");
        Username.setBounds(10,20,200,25);

        UserInput = new JTextField();
        UserInput.setBounds(200,20,200,25);

        JLabel Password = new JLabel();
        Password.setText("Kies uw wachtwoord:");
        Password.setBounds(10,50,200,25);

        UserPassword = new JPasswordField();
        UserPassword.setBounds(200,50,200,25);

        this.add(Username);
        this.add(UserInput);
        this.add(Password);
        this.add(UserPassword);
        this.add(logo);
        this.add(button);
        this.setVisible(true);





    }



    @Override
    public void actionPerformed(ActionEvent e) {

        String RegisteredUsername = UserInput.getText();
        String RegisteredPassword = UserPassword.getText();

        DatabaseAddUser(RegisteredPassword,RegisteredUsername);



    }

    private void DatabaseAddUser(String registeredPassword, String registeredUsername) {

        //hier de database aanpassen, vergeet niet de Tabellen ook aan te passen onder de SQL statement

        //final String DB_URL = "jdbc:mysql://localhost:3306/user_credentials";
        final String DB_URL = "jdbc:mysql://localhost:3306/Inlog_Gegevens";
        final String USERNAME = "root";
        final String PASSWORD = "Monkey123";

        Boolean voltooid = false;


        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Connected to database successfully...

            Statement stmt = conn.createStatement();
            //String sql = "INSERT INTO inlog_gegevens (Username,Password) Values ('" + registeredUsername + "','" + registeredPassword +"')";
            String sql = "INSERT INTO Combinaties (UserName,Password) Values ('" + registeredUsername + "','" + registeredPassword +"')";

            stmt.executeUpdate(sql);

            stmt.close();
            conn.close();
            voltooid = true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Deze gebruikersnaam bestaat al","Registratie Mislukt",JOptionPane.WARNING_MESSAGE);
            throw new RuntimeException(e);

        }

        if(voltooid){
            JOptionPane.showMessageDialog(null,"Uw bent geregistreerd!","Registratie gelukt",JOptionPane.INFORMATION_MESSAGE);
            dispose();
        }

    }
}
