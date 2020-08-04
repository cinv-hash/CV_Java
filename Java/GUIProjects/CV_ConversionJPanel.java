import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class CV_ConversionJPanel extends JPanel{
	public static void main(String[] args) {
		CV_ConversionJPanel c = new CV_ConversionJPanel();
	}
	JPanel titlePanel = new JPanel();
	JPanel centerPanel = new JPanel();
	JLabel celsiusLabel = new JLabel();
	JLabel fahrenheitLabel = new JLabel();
	JLabel kelvinLabel = new JLabel();
	JLabel kelToC = new JLabel();
	JLabel kelToF = new JLabel();
	
    private static final double FTOC = 5.0/9.0;
    private static final double CTOF = 9.0/5.0;
    private static final int DEFAULT = 32;
    private static final double CK = 273.15;
    private static final double FK = 255.372;
    private CtoF cToF;
	private FtoC fToC;
	private CtoK cToK;
	private KtoC kToC;
	private FtoK fToK;
	private KtoF kToF;
	
	JTextField textField1, textField2, textField3,textField4,textField5;
    Font appFontLarge = new Font("Arial", Font.PLAIN, 15);
	public CV_ConversionJPanel() {
        JLabel titleLabel = new JLabel("Temperature Conversion (Please clear all slots when a new number is entered)");
        titleLabel.setFont(appFontLarge);
        titlePanel.add(titleLabel);

        
        centerPanel.setLayout(new GridLayout(5,1));
        celsiusLabel = new JLabel("Temp in Celsius: ",SwingConstants.RIGHT);
        fahrenheitLabel = new JLabel("Temp in Fahrenheit: ",SwingConstants.RIGHT);
        kelvinLabel = new JLabel("Temp in Kelvin: ", SwingConstants.RIGHT);
        kelToC = new JLabel("Temp in Kelvin to Celsius: ", SwingConstants.RIGHT);
        kelToF = new JLabel("Temp in Kelvin to Fahrenheit: ", SwingConstants.RIGHT);
        
        
        textField1 = new JTextField(10);
        textField2 = new JTextField(10);
        textField3 = new JTextField(10);
        textField4 = new JTextField(10);
        textField5 = new JTextField(10);
        
        centerPanel.add(celsiusLabel);
        centerPanel.add(textField1);
        centerPanel.add(fahrenheitLabel);
        centerPanel.add(textField2);
        centerPanel.add(kelvinLabel);
        centerPanel.add(textField3);
        centerPanel.add(kelToC);
        centerPanel.add(textField4);
        centerPanel.add(kelToF);
        centerPanel.add(textField5);
                
        this.add(titlePanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        cToF = new CtoF();
        fToC = new FtoC();
        cToK = new CtoK();
        kToC = new KtoC();
        fToK = new FtoK();
        kToF = new KtoF();
        textField1.addActionListener(cToF);
        textField2.addActionListener(fToC);
        textField1.addActionListener(cToK);
        textField3.addActionListener(kToC);
        textField2.addActionListener(fToK);
        textField3.addActionListener(kToF);
	}
	private class CtoF implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
	        double cel, fahren;
	        cel = Double.parseDouble(textField1.getText());
	        fahren = cel * CTOF + DEFAULT;
	        textField2.setText(String.format("%.2f", fahren));
		}
	}
	private class FtoC implements ActionListener{
	public void actionPerformed(ActionEvent e) {
        double cel, fahren;  
        fahren = Double.parseDouble(textField2.getText());
        cel = (fahren - DEFAULT) * FTOC;
        textField1.setText(String.format("%.2f", cel));
	}
	}
	private class CtoK implements ActionListener{
	public void actionPerformed(ActionEvent e) {
        double cel,kel; 
        cel = Double.parseDouble(textField1.getText());
        kel = cel + CK;
        textField3.setText(String.format("%.2f", kel));
	}
	}
	private class KtoC implements ActionListener{
	public void actionPerformed(ActionEvent e) {
        double cel,kel; 
        kel = Double.parseDouble(textField3.getText());
        cel = kel - CK;
        textField4.setText(String.format("%.2f", cel));
	}
	}
	private class FtoK implements ActionListener{
	public void actionPerformed(ActionEvent e) {
        double fahren,kel; 
        fahren = Double.parseDouble(textField2.getText());
        kel = (fahren - DEFAULT) * FTOC + CK;
        textField3.setText(String.format("%.2f", kel));
	}
	}
	private class KtoF implements ActionListener{
	public void actionPerformed(ActionEvent e) {
        double fahren,kel; 
        kel = Double.parseDouble(textField3.getText());
        fahren = (kel - CK) * CTOF + DEFAULT;
        textField5.setText(String.format("%.2f", fahren));
	}
	}
}
