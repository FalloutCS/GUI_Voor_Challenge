import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class getAuthUser {

    getAuthUser(String username, String password) {

        //hier de database aanpassen, vergeet niet de Tabellen ook aan te passen onder de SQL statement

        //1e voor PC 2e voor laptop
        //final String DB_URL = "jdbc:mysql://localhost:3306/user_credentials";
        final String DB_URL = "jdbc:mysql://localhost:3306/Inlog_Gegevens";
        final String USERNAME = "root";
        final String PASSWORD = "Monkey123";


        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Connected to database successfully...

            Statement stmt = conn.createStatement();
            //String sql = "SELECT * FROM inlog_gegevens WHERE UserName=? AND Password=?";
            String sql = "SELECT * FROM Combinaties WHERE UserName=? AND Password=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            boolean uitkomst = resultSet.next();
            stmt.close();
            conn.close();

            if(uitkomst){

                DashBoard dashBoard = new DashBoard();
            }
            else JOptionPane.showMessageDialog(null,"Wrong password, Try again!","Login Failed",JOptionPane.ERROR_MESSAGE);

        } catch (SQLException e) {
            throw new RuntimeException(e);
            }




    }
}
