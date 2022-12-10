import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.statistics.HistogramDataset;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class Graphs extends JFrame implements ChangeListener {

    ImageIcon globe;
    JPanel picturePanel2;
    JSlider slider;

    void AddingLineGraph(JPanel infoBox3){

            double[] values = { 95, 49, 14, 59, 50, 66, 47, 40, 1, 67,
                    12, 58, 28, 63, 14, 9, 31, 17, 94, 71,
                    49, 64, 73, 97, 15, 63, 10, 12, 31, 62,
                    93, 49, 74, 90, 59, 14, 15, 88, 26, 57,
                    77, 44, 58, 91, 10, 67, 57, 19, 88, 84
            };


            HistogramDataset dataset = new HistogramDataset();
            dataset.addSeries("key", values, 20);

            JFreeChart chart = ChartFactory.createHistogram("Overzicht Metingen","Meting", "% water vervuiling", dataset, PlotOrientation.VERTICAL, false,true,false);
            XYPlot plot= chart.getXYPlot();
            plot.setBackgroundPaint(new Color(0xC4C4F1));
            chart.setBackgroundPaint(new Color(0x8E8EEF));



            ChartPanel barpChartPanel2 = new ChartPanel(chart);
            infoBox3.removeAll();
            infoBox3.add(barpChartPanel2, BorderLayout.CENTER);
            infoBox3.validate();
        }

    public void AddingPicture(JPanel infoBox2) {

        globe = new ImageIcon("globe.png");
        globe.setImage(globe.getImage().getScaledInstance(630,430,Image.SCALE_SMOOTH));
        JLabel picture = new JLabel();
        picture.setIcon(globe);

        JPanel sliderPanel = new JPanel();
        sliderPanel.setBounds(0,417,580,20);
        sliderPanel.setBackground(new Color(0x26154a));

        slider = new JSlider(0,100,0);
        slider.setForeground(new Color(0x26154a));
        slider.setBackground(new Color(0x26154a));
        slider.setFocusable(false);
        slider.addChangeListener(this);
        sliderPanel.add(slider);

        picturePanel2 = new JPanel();
        picturePanel2.setBounds(0,-15,580,430);
        picturePanel2.setBackground(new Color(0x26154a));
        picturePanel2.add(picture);
        picturePanel2.setOpaque(true);
        picturePanel2.setVisible(true);

        infoBox2.add(sliderPanel);
        infoBox2.add(picturePanel2);

    }

    @Override
    public void stateChanged(ChangeEvent e) {

        picturePanel2.setLocation(getX()+(slider.getValue()),-15);



    }
}
