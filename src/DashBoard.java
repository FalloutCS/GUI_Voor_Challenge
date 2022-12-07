import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

public class DashBoard extends JFrame implements ActionListener {
    JPanel buttons;
    ArrayList<Integer> percentageArray;
    int percentage1;
    JPanel menuField;
    JButton button1;
    Boolean knop1 = false;
    Boolean knop2 = false;
    Boolean knop3 = false;
    Boolean knop4 = false;
    JButton refreshKnop;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;
    JLabel logoLabel;
    JPanel RefreshPanel;

    JPanel InfoBoxDashboard;
    JPanel InfoBox1;
    JPanel InfoBox2;
    JPanel InfoBox3;
    JPanel InfoBox4;

    ImageIcon icon;

    JLabel Percentage1; JLabel Percentage2;
    JLabel Percentage3; JLabel Percentage4;

    DashBoard(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setSize(1800,1000);
        this.setSize(1500,1000);
        this.setLayout(null);
        this.setResizable(false);

        JPanel footer =  new JPanel();
        footer.setBounds(300,900,1200,100);
        footer.setBackground(new Color(0x65658C));

        refreshKnop = new JButton();
        refreshKnop.addActionListener(this);
        refreshKnop.setPreferredSize(new Dimension(150,40));
        refreshKnop.setText("Request new DATA");
        refreshKnop.setForeground(new Color(0xC6C6DA));
        refreshKnop.setFocusable(false);
        refreshKnop.setBackground(new Color(0x474764));
        refreshKnop.setVisible(false);


        menuField = new JPanel();
        menuField.setBounds(0,0,300,1000);
        menuField.setLayout(new BorderLayout());
        menuField.setBackground(new Color(0xFF373770, true));

        buttons = new JPanel();
        buttons.setBounds(0,600,300,300);
        buttons.setLayout(new GridLayout(5,1));
        buttons.setBackground(new Color(0xFF373770));

        AddingButtons();

        logoLabel = new JLabel();
        icon = new ImageIcon("ChallengeIconLOLOL.png");
        logoLabel.setIcon(icon);
        logoLabel.setBounds(50,75,200,200);

        DesignInfoboxPanel();
        RefreshPanel = new JPanel();
        RefreshPanel.setBackground(new Color(0x65658C));
        RefreshPanel.setBounds(300,0,1200,50);
        RefreshPanel.add(refreshKnop);

        //server design pattern




        this.add(buttons);
        this.add(footer);
        this.add(RefreshPanel);
        this.add(InfoBoxDashboard);
        this.add(logoLabel);
        this.add(menuField);
        this.setVisible(true);

    }

    private void DesignInfoboxPanel() {

        InfoBoxDashboard = new JPanel();
        InfoBoxDashboard.setBounds(300,50,1200,900);
        InfoBoxDashboard.setBackground(new Color(0x65658C));
        InfoBoxDashboard.setLayout(new GridLayout(2,2,10,10));


        InfoBox1 = new JPanel();InfoBox2 = new JPanel();InfoBox3 = new JPanel();InfoBox4 = new JPanel();

        InfoBox1.setLayout(new BorderLayout()); InfoBox2.setLayout(new BorderLayout());
        InfoBox3.setLayout(new BorderLayout()); InfoBox4.setLayout(new BorderLayout());

        InfoBox1.setBackground(new Color(0xC4C4F1)); InfoBox2.setBackground(new Color(0xC4C4F1));
        InfoBox3.setBackground(new Color(0xC4C4F1)); InfoBox4.setBackground(new Color(0xC4C4F1));
        InfoBox1.setVisible(false);InfoBox2.setVisible(false);
        InfoBox3.setVisible(false);InfoBox4.setVisible(false);

        DesignInfobox();

        InfoBoxDashboard.add(InfoBox1);
        InfoBoxDashboard.add(InfoBox2);
        InfoBoxDashboard.add(InfoBox3);
        InfoBoxDashboard.add(InfoBox4);
    }

    private void DesignInfobox() {
        JPanel HeaderEEN = new JPanel(); JPanel HeaderTWEE = new JPanel();
        JPanel HeaderDRIE = new JPanel(); JPanel HeaderVIER = new JPanel();

        HeaderEEN.setPreferredSize(new Dimension(100,40));
        HeaderTWEE.setPreferredSize(new Dimension(100,40));
        HeaderDRIE.setPreferredSize(new Dimension(100,40));
        HeaderVIER.setPreferredSize(new Dimension(100,40));

        HeaderEEN.setBackground(new Color(0xA6A6EF));
        HeaderTWEE.setBackground(new Color(0xA6A6EF));
        HeaderDRIE.setBackground(new Color(0xA6A6EF));
        HeaderVIER.setBackground(new Color(0xA6A6EF));

        JLabel Header1 = new JLabel();
        JLabel Header2 = new JLabel();
        JLabel Header3 = new JLabel();
        JLabel Header4 = new JLabel();

        Header1.setText("De waarde van Sensor ... is momenteel:");
        Header1.setForeground(new Color(0x595962));
        Header1.setFont(new Font("Consolas", Font.BOLD,20));

        Header2.setText("De waarde van Sensor ... is momenteel:");
        Header2.setForeground(new Color(0x595962));
        Header2.setFont(new Font("Consolas", Font.BOLD,20));

        Header3.setText("De waarde van Sensor ... is momenteel:");
        Header3.setForeground(new Color(0x595962));
        Header3.setFont(new Font("Consolas", Font.BOLD,20));

        Header4.setText("De waarde van Sensor ... is momenteel:");
        Header4.setForeground(new Color(0x595962));
        Header4.setFont(new Font("Consolas", Font.BOLD,20));

        addingPercenteges();

        HeaderEEN.add(Header1); HeaderTWEE.add(Header2);
        HeaderDRIE.add(Header3); HeaderVIER.add(Header4);
        InfoBox1.add(HeaderEEN,BorderLayout.NORTH);
        InfoBox2.add(HeaderTWEE,BorderLayout.NORTH);
        InfoBox3.add(HeaderDRIE,BorderLayout.NORTH);
        InfoBox4.add(HeaderVIER,BorderLayout.NORTH);

    }

    private void addingPercenteges() {

        JPanel PercentageContainer = new JPanel();JPanel PercentageContainer2 = new JPanel();
        JPanel PercentageContainer3 = new JPanel();JPanel PercentageContainer4 = new JPanel();

        PercentageContainer.setBackground(new Color(0x8B8BDC)); PercentageContainer2.setBackground(new Color(0x8B8BDC));
        PercentageContainer3.setBackground(new Color(0x8B8BDC)); PercentageContainer4.setBackground(new Color(0x8B8BDC));

        PercentageContainer.setLayout(null);PercentageContainer2.setLayout(null);
        PercentageContainer3.setLayout(null);PercentageContainer4.setLayout(null);

        PercentageContainer.setPreferredSize(new Dimension(200,250));PercentageContainer2.setPreferredSize(new Dimension(200,250));
        PercentageContainer3.setPreferredSize(new Dimension(200,250));PercentageContainer4.setPreferredSize(new Dimension(200,250));

        Percentage1 = new JLabel(); Percentage2 = new JLabel();
        Percentage3 = new JLabel(); Percentage4 = new JLabel();

        //Dit nummer veranderen naar de waarde die uit de database komt, een manier vinden om deze automatisch te laten refreshen.
        // Er komt dus een sql statement

        int counter = 0;
        if (counter == 0) {
            percentageArray = SQLPercentage();
            percentage1 = percentageArray.get(0);
            counter++;
        }
        int percentage2 = 50;
        int percentage3 = 47;
        int percentage4 = 86;

        //Als de waarde van de sensor boven een bepaalde randwaarde komt wordt de Kleur van de tekst GROEN of ROOD
        PercentageKleur(percentage1,percentage2,percentage3,percentage4);


        Percentage1.setText(percentage1+"%"); Percentage2.setText(percentage2+"%");
        Percentage3.setText(percentage3+"%"); Percentage4.setText(percentage4+"%");

        Percentage1.setFont(new Font("Consolas", Font.BOLD,100));Percentage2.setFont(new Font("Consolas", Font.BOLD,100));
        Percentage3.setFont(new Font("Consolas", Font.BOLD,100));Percentage4.setFont(new Font("Consolas", Font.BOLD,100));

        Percentage1.setBounds(185,50,250,250); Percentage2.setBounds(185,50,250,250);
        Percentage3.setBounds(185,50,250,250); Percentage4.setBounds(185,50,250,250);

        PercentageContainer.add(Percentage1);PercentageContainer2.add(Percentage2);
        PercentageContainer3.add(Percentage3);PercentageContainer4.add(Percentage4);

        InfoBox1.add(PercentageContainer, BorderLayout.CENTER);InfoBox2.add(PercentageContainer2, BorderLayout.CENTER);
        InfoBox3.add(PercentageContainer3, BorderLayout.CENTER);InfoBox4.add(PercentageContainer4, BorderLayout.CENTER);

        refreshKnop.setText("Request new DATA");
    }



    private void PercentageKleur(int percentage1, int percentage2, int percentage3, int percentage4) {

        if(percentage1>75){
            Percentage1.setForeground(Color.RED);
        }
        if(percentage1<25){
            Percentage1.setForeground(Color.GREEN);
        }
        if(percentage2>75){
            Percentage2.setForeground(Color.RED);
        }
        if(percentage2<25){
            Percentage2.setForeground(Color.GREEN);
        }
        if(percentage3>75){
            Percentage3.setForeground(Color.RED);
        }
        if(percentage3<25){
            Percentage3.setForeground(Color.GREEN);
        }
        if(percentage4>75){
            Percentage4.setForeground(Color.RED);
        }
        if(percentage4<25){
            Percentage4.setForeground(Color.GREEN);
        }

    }


    private void AddingButtons() {


        button1 = new JButton("Boot 1");
        button1.addActionListener(this);
        button2 = new JButton("Boot 2");
        button2.addActionListener(this);
        button3 = new JButton("Boot 3");
        button3.addActionListener(this);
        button4 = new JButton("Boot 4");
        button4.addActionListener(this);
        button5 = new JButton("HOME");
        button5.addActionListener(this);

        button1.setBackground(new Color(0x5454A9)); button1.setFocusable(false);
        button2.setBackground(new Color(0x5454A9)); button2.setFocusable(false);
        button3.setBackground(new Color(0x5454A9)); button3.setFocusable(false);
        button4.setBackground(new Color(0x5454A9)); button4.setFocusable(false);
        button5.setBackground(new Color(0x5454A9)); button5.setFocusable(false);

        button1.setForeground(new Color(0xFFACACFF, true));
        button2.setForeground(new Color(0xFFACACFF, true));
        button3.setForeground(new Color(0xFFACACFF, true));
        button4.setForeground(new Color(0xFFACACFF, true));
        button5.setForeground(new Color(0xFFACACFF, true));

        buttons.add(button1);
        buttons.add(button2);
        buttons.add(button3);
        buttons.add(button4);
        buttons.add(button5);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==button1){
            knop1 = true; knop2 = false; knop3 = false; knop4 = false;
            InfoBox1.setVisible(true);InfoBox2.setVisible(true);
            InfoBox3.setVisible(true);InfoBox4.setVisible(true);
            refreshKnop.setVisible(true);
        }
        if (e.getSource()==button2){
            knop1 = false; knop2 = true; knop3 = false; knop4 = false;

            InfoBox1.setVisible(true);InfoBox2.setVisible(true);
            InfoBox3.setVisible(true);InfoBox4.setVisible(true);
            refreshKnop.setVisible(true);

        }
        if (e.getSource()==button3){
            knop1 = false; knop2 = false; knop3 = true; knop4 = false;
            InfoBox1.setVisible(true);InfoBox2.setVisible(true);
            InfoBox3.setVisible(true);InfoBox4.setVisible(true);
            refreshKnop.setVisible(true);

        }
        if (e.getSource()==button4){
            knop1 = false; knop2 = false; knop3 = false; knop4 = true;

            InfoBox1.setVisible(true);InfoBox2.setVisible(true);
            InfoBox3.setVisible(true);InfoBox4.setVisible(true);
            refreshKnop.setVisible(true);

        }

        if(e.getSource()==button5){
            knop1 = false; knop2 = false; knop3 = false; knop4 = false;
            InfoBox1.setVisible(false);InfoBox2.setVisible(false);
            InfoBox3.setVisible(false);InfoBox4.setVisible(false);
            refreshKnop.setVisible(false);
        }

        if(e.getSource()==refreshKnop){
            percentageArray = SQLPercentage();
            percentage1 = percentageArray.get(0);
            Percentage1.setText(percentage1+"%");
        }
    }

    private ArrayList<Integer> SQLPercentage() {

        //final String DB_URL = "jdbc:mysql://localhost:3306/user_credentials";
        final String DB_URL = "jdbc:mysql://localhost:3306/Inlog_Gegevens";
        final String USERNAME = "root";
        final String PASSWORD = "Monkey123";

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Connected to database successfully...

            //String sql = "SELECT Percentages FROM user_credentials.sensor_1 order by Measurement DESC;";
            String sql = "SELECT Percentages FROM Inlog_Gegevens.sensor_1 order by Measurement DESC;";
            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet result = stmt.executeQuery();

            ArrayList<Integer> array = new ArrayList<Integer>();
            while(result.next()){
                System.out.println(result.getInt("Percentages"));

                array.add(result.getInt("Percentages"));
            }
            System.out.println("alles is ingevuld");
            stmt.close();
            conn.close();
            return array;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Unkown Error","Error",JOptionPane.WARNING_MESSAGE);
            throw new RuntimeException(e);

        }

    }

}
