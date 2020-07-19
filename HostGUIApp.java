import java.awt.*;
import javax.swing.*;
public class HostGUIApp extends JFrame{
	private static final int WIDTH = 600;
    private static final int HEIGHT = 600;

    public static void main(String [] args){
	    HostGUI g = new HostGUI();
	  }
 // Constructor 

    public HostGUIApp(){
         super("My Generic GUI App");
         setDefaultCloseOperation(EXIT_ON_CLOSE);
         setLayout(new GridLayout(1,1));
         //JPanel jp = new CV_CarSalesJPanel();
         JPanel jp = new GUIPerson();
         add(jp);
         setSize(WIDTH, HEIGHT);
         setResizable(true);
         setVisible(true);
      }

    


}