import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.*;
import java.time.LocalDate;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
  
public class GUIPerson extends JPanel implements ActionListener{
	JTextField fn,ln,str,ct,sta,dob1;
	
	JFormattedTextField ssn_1 = new JFormattedTextField();
	JFormattedTextField id_1 = new JFormattedTextField();
	JFormattedTextField zip_1 = new JFormattedTextField();
	
	JTextArea tout, resadd;
	JLabel title = new JLabel();
	JLabel res = new JLabel();
	JLabel res1 = new JLabel();
	JLabel fName = new JLabel();
	JLabel lName = new JLabel();
	JLabel dob = new JLabel();
	JLabel strt = new JLabel();
	JLabel city = new JLabel();
	JLabel stat = new JLabel();
	JLabel zip = new JLabel();
	JLabel social = new JLabel();
	JLabel id = new JLabel();
	JCheckBox term = new JCheckBox();
	
	JButton sub,reset;
	
	JPanel cal = new JPanel();
		
    	String [] months;
    	String [][] dates;
    
    	JSpinner state;
    
	JComboBox<String> month;
	JComboBox<String> date;
	ArrayList<String> year_s = new ArrayList<String>();

	
	JComboBox year;
    
	Font appFontCat = new Font("Arial", Font.PLAIN, 20);
	Font appFontTxt = new Font("Arial", Font.PLAIN, 15);
	
	
	
	public GUIPerson(){
		
		
	    months = new String []
	            {"1", "2", "3", "4", 
	             "5", "6", "7", "8", 
	             "9", "10", "11", "12" };
		dates = new String[12][];
        	dates[0] = new String []
                {"1", "2", "3", "4", "5", 
                        "6", "7", "8", "9", "10", 
                        "11", "12", "13", "14", "15", 
                        "16", "17", "18", "19", "20", 
                        "21", "22", "23", "24", "25", 
                        "26", "27", "28", "29", "30", "31"};
        	dates[1] = new String []
                {"1", "2", "3", "4", "5", 
                        "6", "7", "8", "9", "10", 
                        "11", "12", "13", "14", "15", 
                        "16", "17", "18", "19", "20", 
                        "21", "22", "23", "24", "25", 
                        "26", "27", "28", "29"};
        	dates[2] = new String []
                {"1", "2", "3", "4", "5", 
                        "6", "7", "8", "9", "10", 
                        "11", "12", "13", "14", "15", 
                        "16", "17", "18", "19", "20", 
                        "21", "22", "23", "24", "25", 
                        "26", "27", "28", "29", "30", "31"};
        	dates[3] = new String []
                {"1", "2", "3", "4", "5", 
                        "6", "7", "8", "9", "10", 
                        "11", "12", "13", "14", "15", 
                        "16", "17", "18", "19", "20", 
                        "21", "22", "23", "24", "25", 
                        "26", "27", "28", "29", "30"};
        	dates[4] = new String []
                {"1", "2", "3", "4", "5", 
                        "6", "7", "8", "9", "10", 
                        "11", "12", "13", "14", "15", 
                        "16", "17", "18", "19", "20", 
                        "21", "22", "23", "24", "25", 
                        "26", "27", "28", "29", "30", "31"};
       		dates[5] = new String []
                {"1", "2", "3", "4", "5", 
                        "6", "7", "8", "9", "10", 
                        "11", "12", "13", "14", "15", 
                        "16", "17", "18", "19", "20", 
                        "21", "22", "23", "24", "25", 
                        "26", "27", "28", "29", "30"};
        	dates[6] = new String []
                {"1", "2", "3", "4", "5", 
                        "6", "7", "8", "9", "10", 
                        "11", "12", "13", "14", "15", 
                        "16", "17", "18", "19", "20", 
                        "21", "22", "23", "24", "25", 
                        "26", "27", "28", "29", "30", "31"};
        	dates[7] = new String []
                {"1", "2", "3", "4", "5", 
                        "6", "7", "8", "9", "10", 
                        "11", "12", "13", "14", "15", 
                        "16", "17", "18", "19", "20", 
                        "21", "22", "23", "24", "25", 
                        "26", "27", "28", "29", "30", "31"};
        	dates[8] = new String []
                {"1", "2", "3", "4", "5", 
                        "6", "7", "8", "9", "10", 
                        "11", "12", "13", "14", "15", 
                        "16", "17", "18", "19", "20", 
                        "21", "22", "23", "24", "25", 
                        "26", "27", "28", "29", "30"};
        	dates[9] = new String []
                {"1", "2", "3", "4", "5", 
                        "6", "7", "8", "9", "10", 
                        "11", "12", "13", "14", "15", 
                        "16", "17", "18", "19", "20", 
                        "21", "22", "23", "24", "25", 
                        "26", "27", "28", "29", "30", "31"};
        	dates[10] = new String []
                {"1", "2", "3", "4", "5", 
                        "6", "7", "8", "9", "10", 
                        "11", "12", "13", "14", "15", 
                        "16", "17", "18", "19", "20", 
                        "21", "22", "23", "24", "25", 
                        "26", "27", "28", "29", "30"};
        	dates[11] = new String []
                {"1", "2", "3", "4", "5", 
                        "6", "7", "8", "9", "10", 
                        "11", "12", "13", "14", "15", 
                        "16", "17", "18", "19", "20", 
                        "21", "22", "23", "24", "25", 
                        "26", "27", "28", "29", "30", "31"};
        
        String[] stateStrings = {
                "Alabama (AL)",
                "Alaska (AK)",
                "Arizona (AZ)",
                "Arkansas (AR)",
                "California (CA)",
                "Colorado (CO)",
                "Connecticut (CT)",
                "Delaware (DE)",
                "District of Columbia (DC)",
                "Florida (FL)",
                "Georgia (GA)",
                "Hawaii (HI)",
                "Idaho (ID)",
                "Illinois (IL)",
                "Indiana (IN)",
                "Iowa (IA)",
                "Kansas (KS)",
                "Kentucky (KY)",
                "Louisiana (LA)",
                "Maine (ME)",
                "Maryland (MD)",
                "Massachusetts (MA)",
                "Michigan (MI)",
                "Minnesota (MN)",
                "Mississippi (MS)",
                "Missouri (MO)",
                "Montana (MT)",
                "Nebraska (NE)",
                "Nevada (NV)",
                "New Hampshire (NH)",
                "New Jersey (NJ)",
                "New Mexico (NM)",
                "New York (NY)",
                "North Carolina (NC)",
                "North Dakota (ND)",
                "Ohio (OH)",
                "Oklahoma (OK)",
                "Oregon (OR)",
                "Pennsylvania (PA)",
                "Rhode Island (RI)",
                "South Carolina (SC)",
                "South Dakota (SD)",
                "Tennessee (TN)",
                "Texas (TX)",
                "Utah (UT)",
                "Vermont (VT)",
                "Virginia (VA)",
                "Washington (WA)",
                "West Virginia (WV)",
                "Wisconsin (WI)",
                "Wyoming (WY)"
            };
	
	this.setLayout(null);
	
    //JLabel titleLabel   = new JLabel("JCPenney Rewards Member Application");
    //titleLabel.setFont(appFontLarge);
    //titlePanel.add(titleLabel);

	title = new JLabel("Person Application");
	title.setFont(new Font("Arial", Font.PLAIN, 27));
	title.setSize(500, 30);
	title.setLocation(220,10);
	this.add(title);
	
    	fName = new JLabel("First Name");
    	fName.setFont(appFontCat);
    	fName.setSize(100,20);
    	fName.setLocation(150,70);
    	this.add(fName);
    
    	fn = new JTextField();
   	fn.setFont(appFontTxt);
    	fn.setSize(190,20);
    	fn.setLocation(300,70);
    	this.add(fn);
    
    	lName = new JLabel("Last Name");
    	lName.setFont(appFontCat);
    	lName.setSize(100,20);
    	lName.setLocation(150,100);
    	this.add(lName);
    
    	ln = new JTextField();
    	ln.setFont(appFontTxt);
    	ln.setSize(190,20);
    	ln.setLocation(300, 100);
    	this.add(ln);

    	social = new JLabel("SSN");
    	social.setFont(appFontCat);
    	social.setSize(100,20);
    	social.setLocation(150, 130);
    	this.add(social);
   
    	try {
    		MaskFormatter format = new MaskFormatter("###-##-####");
    		ssn_1 = new JFormattedTextField(format);
    		format.setPlaceholderCharacter('_');
        	ssn_1.setFont(appFontTxt);
        	ssn_1.setSize(190,20);
        	ssn_1.setLocation(300, 130);
    	
   	    }
    	catch(ParseException ex){
    	
    	
	    }
    	this.add(ssn_1);
      
    	id = new JLabel("Student ID");
    	id.setFont(appFontCat);
    	id.setSize(100,20);
    	id.setLocation(150, 160);
    	this.add(id);
    
    	try {
    		MaskFormatter format = new MaskFormatter("#######");
    		format.setPlaceholderCharacter('_');
    		id_1 = new JFormattedTextField(format);	
    	    }
        catch(ParseException ex){
    		System.out.println("Incorrect");   	
    	    }
    	id_1.setFont(appFontTxt);
    	id_1.setSize(190,20);
    	id_1.setLocation(300, 160);
    	this.add(id_1);
    
    	dob = new JLabel("DOB");
    	dob.setFont(appFontCat);
    	dob.setSize(200,20);
    	dob.setLocation(150,190);
    	this.add(dob);
    	/*
    	dob1 = new JTextField();
    	dob1.setFont(appFontTxt);
    	dob1.setSize(190,20);
    	dob1.setLocation(300, 190);
    	this.add(dob1);
    	*/
    	/*
    	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    	try {
    	//DateFormat format1 = new SimpleDateFormat("MM/dd/yyyy");
    	dob1 = new JFormattedTextField(sdf);
    	String str = dob1.getText();
    	Date d = sdf.parse(str);
    	
        dob1.setFont(appFontTxt);
        dob1.setSize(190,20);
        dob1.setLocation(300, 190);
    	this.add(dob1);
    	throw new InvalidOCCCDateException();
    	}
    catch(Exception e){      
    	//JOptionPane.showMessageDialog(null,"Invalid Date!");
   	 }
    	*/
   	 try {
    	MaskFormatter format = new MaskFormatter("##/##/####");
    	format.setPlaceholderCharacter('/');
    	dob1 = new JFormattedTextField(format);
    	}
    	catch(ParseException e) {
    	System.out.println("Invalid Date!");
    	}
    	dob1.setFont(appFontTxt);
    	dob1.setSize(190,20);
    	dob1.setLocation(300, 190);
	this.add(dob1);
    	String s1 = "<html> Please enter in the date format as U.S. or U.K.  </html>"; 
    
    	// set tooltip text 
    	dob1.setToolTipText(s1);
    	/*
    	month = new JComboBox<String>(months);
    	month.setFont(appFontTxt);
    	month.setSize(50,20);
    	month.setLocation(300,190);
    	this.add(month);
    
    	date = new JComboBox<String>(dates[0]);
    	date.setFont(appFontTxt);
    	date.setSize(60,20);
    	date.setLocation(350,190);
    	this.add(date);
    

    
	for(int yearss = 1930; yearss <= Calendar.getInstance().get(Calendar.YEAR); yearss++) {
		year_s.add(yearss+"");
	}

	
    	year = new JComboBox(year_s.toArray()); 
    	year.setFont(appFontTxt); 
    	year.setSize(80, 20); 
    	year.setLocation(410, 190); 
    	this.add(year); 
    
    	*/
    	strt = new JLabel("Street");
    	strt.setFont(appFontCat);
    	strt.setSize(80,20);
    	strt.setLocation(150,220);
    	this.add(strt);
    
    	str = new JTextField();
    	str.setFont(appFontTxt);
    	str.setSize(190,20);
    	str.setLocation(300, 220);
    	this.add(str);
    
    	city = new JLabel("City");
    	city.setFont(appFontCat);
    	city.setSize(100,20);
    	city.setLocation(150,250);
    	this.add(city);
    
    	ct = new JTextField();
    	ct.setFont(appFontTxt);
    	ct.setSize(190,20);
    	ct.setLocation(300, 250);
    	this.add(ct);
  
    	stat = new JLabel("State");
    	stat.setFont(appFontCat);
    	stat.setSize(100,20);
    	stat.setLocation(150,280);
    	this.add(stat);
    
    	//sta = new JTextField();
    	state = new JSpinner(new SpinnerListModel(stateStrings));
    	state.setFont(appFontTxt);
    	state.setSize(190,20);
    	state.setLocation(300, 280);
    	this.add(state);
    
    	zip = new JLabel("Zip Code");
    	zip.setFont(appFontCat);
    	zip.setSize(100,20);
    	zip.setLocation(150,310);
    	this.add(zip);
    
    	try {
    	MaskFormatter format = new MaskFormatter("#####");
    	zip_1 = new JFormattedTextField(format);
    	format.setPlaceholderCharacter('_');
        zip_1.setFont(appFontTxt);
        zip_1.setSize(190,20);
        zip_1.setLocation(300, 310);   	
    	}
    	catch(ParseException ex){  	
    	}
    	this.add(zip_1);
     
    	term = new JCheckBox("Accept Terms And Conditions."); 
    	term.setFont(appFontTxt); 
    	term.setSize(250, 20); 
    	term.setLocation(230, 350); 
    	this.add(term); 

    	sub = new JButton("Submit"); 
    	sub.setFont(appFontTxt); 
    	sub.setSize(100, 20); 
    	sub.setLocation(200, 390); 
    	sub.addActionListener(this); 
    	this.add(sub); 

    	reset = new JButton("Reset"); 
    	reset.setFont(appFontTxt); 
    	reset.setSize(100, 20); 
    	reset.setLocation(370, 390); 
    	reset.addActionListener(this); 
    	this.add(reset);
    
    	tout = new JTextArea(); 
    	tout.setFont(appFontTxt); 
    	tout.setSize(300, 400); 
    	tout.setLocation(500, 100); 
    	tout.setLineWrap(true); 
    	tout.setEditable(false); 
    	//this.add(tout); 

    	res = new JLabel(""); 
    	res.setFont(appFontCat); 
    	res.setSize(500, 25); 
    	res.setLocation(100, 500); 
    	this.add(res);
    
    	res1 = new JLabel(""); 
    	res1.setFont(appFontCat); 
    	res1.setSize(500, 25); 
    	res1.setLocation(160, 420); 
    	this.add(res1); 

    	resadd = new JTextArea(); 
    	resadd.setFont(appFontTxt); 
    	resadd.setSize(200, 75); 
    	resadd.setLocation(580, 175); 
    	resadd.setLineWrap(true); 
    	this.add(resadd);
    
    	//month.addActionListener(this);
    	//date.addActionListener(this);
    
    	/*
    	fName = new JLabel("Name"); 
    	fName.setFont(new Font("Arial", Font.PLAIN, 20)); 
    	fName.setSize(100, 20); 
    	fName.setLocation(100, 100); 
    	this.add(fName); 

    	fn = new JTextField(); 
    	fn.setFont(new Font("Arial", Font.PLAIN, 15)); 
    	fn.setSize(190, 20); 
    	fn.setLocation(200, 100); 
    	this.add(fn); 

    	lName = new JLabel("Mobile"); 
    	lName.setFont(new Font("Arial", Font.PLAIN, 20)); 
    	lName.setSize(100, 20); 
    	lName.setLocation(100, 150); 
    	this.add(lName); 

    	ln = new JTextField(); 
    	ln.setFont(new Font("Arial", Font.PLAIN, 15)); 
    	ln.setSize(150, 20); 
    	ln.setLocation(200, 150); 
    	this.add(ln); 
    	*/

	}
	   public void actionPerformed(ActionEvent e) {
		   String states = (String)state.getValue();
		   /*
		   if(e.getSource() == month) {
			   int i = month.getSelectedIndex();
			   date.removeAllItems();
			   for(String s: dates[i]) {
				   date.addItem(s);
			   }
		   }
		   */
	        if (e.getSource() == sub) { 
                
    			JFrame centerPanel = new JFrame();             
    			centerPanel.setLayout(new FlowLayout()); 
    			centerPanel.setSize(600,600);
	            if (term.isSelected()) { 
	                String data1 = ""; 
	                String data 
	                    = "First Name      : "
	                      + fn.getText() + "\n"
	                      +"Last Name      : "
	                	  + ln.getText() + "\n"
	                	  +"SSN                : "
	                	  + ssn_1.getText() + "\n"
	                	  +"Student ID      : "
	                	  + id_1.getText() + "\n";
	                
	                    String data2 
	                    = "DOB               : "
	                      + dob1.getText() + "\n";
	                    
	                String data3 ="Street Name  : "
		                      + str.getText() + "\n"
		                      +"City                : "
		                      + ct.getText() + "\n"
		                      +"State              : "
		                      + states + "\n"
		                      +"Zip code        : "
		                      + zip_1.getText() + "\n"; 

	                tout.setText(data + data1 + data2 + data3); 
	                tout.setEditable(false); 
	                res.setFont(appFontTxt);
	                res.setText("You are registered sucessfully in the system."); 
	                centerPanel.add(tout);
	                centerPanel.add(res);
	                centerPanel.setVisible(true);
	            } 
	            else { 
	                tout.setText(""); 
	                resadd.setText(""); 
	                res1.setText("Please accept the terms & conditions"); 
	            } 

	        } 
	  
	        else if (e.getSource() == reset) { 
	            String def = ""; 
	            fn.setText(def); 
	            ln.setText(def);
	            str.setText(def);
	            ct.setText(def);
	            res.setText(def); 
	            tout.setText(def); 
	            ssn_1.setText(def);
	            id_1.setText(def);
	            dob1.setText(def);
	            state.setValue("Alabama (AL)");
	            term.setSelected(false); 
	           // date.setSelectedIndex(0); 
	            //month.setSelectedIndex(0); 
	            //year.setSelectedIndex(0); 
	            resadd.setText(def); 
	        } 
	    }
	   
}

	   
