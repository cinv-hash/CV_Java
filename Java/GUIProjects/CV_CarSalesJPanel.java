// CarSalesJPanel

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;

public class CV_CarSalesJPanel extends JPanel implements ActionListener{
    JTextArea buildText;
    JButton   buildButton;
    //JButton   clickButton;

    JComboBox<String> makeMenu;
    JComboBox<String> modelMenu;

    String [] makeList;
    String [][] modelList;

    JCheckBox option_stereo, option_selfdrive, option_eject;

    JRadioButton color_red, color_black, color_silver;
    JRadioButton trans_manual, trans_automatic;

    ButtonGroup colorGroup, transGroup;

    Font appFontLarge = new Font("Arial", Font.PLAIN, 30);
    Font appFontSmall = new Font("Arial", Font.PLAIN, 14);
    Font appFontPrice = new Font("Arial", Font.BOLD, 14);
    
    public CV_CarSalesJPanel(){
        
        this.setLayout(new BorderLayout());

        JPanel titlePanel   = new JPanel();
        JPanel carPanel     = new JPanel();
        JPanel optionsPanel = new JPanel();
        JPanel colorPanel   = new JPanel();
        JPanel transPanel   = new JPanel();
        JPanel buildPanel   = new JPanel();
        JPanel centerPanel  = new JPanel();

        
        // title

        JLabel titleLabel   = new JLabel("New cars for sale!!!");
        titleLabel.setFont(appFontLarge);
        titlePanel.add(titleLabel);
        
        // make and model selection

        makeList = new String []
           {"Ford", "Toyota", "Chevy"};
        modelList = new String[3][];
        modelList[0] = new String []
           {"Mustang", "F150",  "Escape", "Fusion"};
        modelList[1] = new String []
           {"Avalon", "Camry", "Prius"};
        modelList[2] = new String []
           {"Corvette", "Silverado", "Camaro"};
       
        //Menu options
        makeMenu = new JComboBox<String>(makeList);
        modelMenu = new JComboBox<String>(modelList[0]);

        makeMenu.setFont(appFontSmall);
        modelMenu.setFont(appFontSmall);

        carPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        carPanel.add(makeMenu);
        carPanel.add(modelMenu);

        //Options
        option_stereo = new JCheckBox("Stereo Package", false);
        option_selfdrive = new JCheckBox("Automatic Drive", false);
        option_eject = new JCheckBox("Ejection Seat", false);

        option_stereo.setFont(appFontSmall);
        option_selfdrive.setFont(appFontSmall);
        option_eject.setFont(appFontSmall);
        
        optionsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        optionsPanel.add(option_stereo);
        optionsPanel.add(option_selfdrive);
        optionsPanel.add(option_eject);
        
        //Color options
        color_red = new JRadioButton("Red");
        color_black = new JRadioButton("Black");
        color_silver = new JRadioButton("Silver");

        color_red.setFont(appFontSmall);
        color_black.setFont(appFontSmall);
        color_silver.setFont(appFontSmall);
        
        colorGroup = new ButtonGroup();

        colorGroup.add(color_red);
        colorGroup.add(color_black);
        colorGroup.add(color_silver);
        color_red.setSelected(true);

        colorPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        colorPanel.add(color_red);
        colorPanel.add(color_black);
        colorPanel.add(color_silver);
        
        //clicker
        
        
        //Transmissions
        trans_manual = new JRadioButton("Manual");
        trans_automatic = new JRadioButton("Automatic");

        trans_manual.setFont(appFontSmall);
        trans_automatic.setFont(appFontSmall);
        
        transGroup = new ButtonGroup();
        
        transGroup.add(trans_manual);
        transGroup.add(trans_automatic);
        trans_manual.setSelected(true);
        
        transPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        transPanel.add(trans_manual);
        transPanel.add(trans_automatic);
        
        //build my car

        buildText = new JTextArea(7, 70);
        buildText.setFont(appFontSmall);
        buildText.setText("Click the 'build my car' to build your new car or " +
        "click the 'see image' button for your car's color!");
        buildButton = new JButton("Build my car!");
        buildButton.setFont(appFontSmall);

        buildPanel.setLayout(new BorderLayout());
        JPanel upperBuild = new JPanel(new GridLayout(1,1));
        JPanel lowerBuild = new JPanel(new FlowLayout(FlowLayout.CENTER));
        upperBuild.add(buildText);
        lowerBuild.add(buildButton);
        buildPanel.add(upperBuild, BorderLayout.NORTH);
        buildPanel.add(lowerBuild, BorderLayout.SOUTH);
        
        //click
        /*
        clickButton = new JButton("See Image!");
        JPanel centralBuild = new JPanel(new GridLayout(2,1));
        centralBuild.add(clickButton);
        buildPanel.add(centralBuild, BorderLayout.CENTER);
		*/
        centerPanel.setLayout(new GridLayout(7,2));

        centerPanel.add(carPanel);
        

        JPanel optionsLabelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel optionsLabel = new JLabel("OPTIONS");
        optionsLabel.setFont(appFontSmall);
        optionsLabelPanel.add(optionsLabel);
        centerPanel.add(optionsLabelPanel);
        centerPanel.add(optionsPanel);
        
        JPanel colorLabelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel colorLabel = new JLabel("COLORS");
        colorLabel.setFont(appFontSmall);
        colorLabelPanel.add(colorLabel);
        centerPanel.add(colorLabelPanel);
        centerPanel.add(colorPanel);
        
        JPanel transLabelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel transLabel = new JLabel("TRANSMISSIONS");
        transLabel.setFont(appFontSmall);
        transLabelPanel.add(transLabel);
        centerPanel.add(transLabelPanel);
        centerPanel.add(transPanel);
             
        this.add(titlePanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(buildPanel, BorderLayout.SOUTH);
        
        makeMenu.addActionListener(this);
        modelMenu.addActionListener(this);
        color_red.addActionListener(this);
        color_black.addActionListener(this);
        color_silver.addActionListener(this);
        trans_manual.addActionListener(this);
        trans_automatic.addActionListener(this);
        option_stereo.addActionListener(this);
        option_selfdrive.addActionListener(this);
        option_eject.addActionListener(this);
        buildButton.addActionListener(this);
        //clickButton.addActionListener(this);

     
    }
    @Override
   public void actionPerformed(ActionEvent e) {
    	buildText.setText("Click the button below to build your new car!");
    	 if (e.getSource() == makeMenu){
    	      int i = makeMenu.getSelectedIndex();
    	      modelMenu.removeAllItems();
    	      for(String s: modelList[i]){
    	         modelMenu.addItem(s);
    	      }
    	 }
    	 if (e.getSource() == buildButton) {
    		 buildText.append("\nMake: " + String.valueOf(makeMenu.getSelectedItem()) + "\n");
    	     buildText.append("Model: " + String.valueOf(modelMenu.getSelectedItem()) + "\n");
    	     Object model = modelMenu.getSelectedItem();
         	if(model.equals("Mustang")) {
        		if(color_red.isSelected()) {
        			JFrame centerPanel = new JFrame();             
        			centerPanel.setLayout(new FlowLayout()); 
        			centerPanel.setSize(600,600);
        			//add(centerPanel, BorderLayout.CENTER);             
        			JLabel imageLabel = new JLabel(new ImageIcon("CV_Images/mustang_red.jpg"));  
        			JLabel label = new JLabel("MSRP: $28,750");
        			centerPanel.add(imageLabel); 
        			centerPanel.add(label);
        			label.setFont(appFontPrice);
        			centerPanel.setVisible(true);
        			
        			
        		}
        		if(color_black.isSelected()) {
        			JFrame centerPanel = new JFrame();             
        			centerPanel.setLayout(new FlowLayout()); 
        			centerPanel.setSize(600,600);
        			//add(centerPanel, BorderLayout.CENTER);             
        			JLabel imageLabel = new JLabel(new ImageIcon("CV_Images/mustang_black.jpeg"));
        			JLabel label = new JLabel("MSRP: $27,750");
        			centerPanel.add(imageLabel); 
        			centerPanel.add(label);
        			label.setFont(appFontPrice); 
        			centerPanel.setVisible(true);
        		}
        		if(color_silver.isSelected()) {
        			JFrame centerPanel = new JFrame();             
        			centerPanel.setLayout(new FlowLayout()); 
        			centerPanel.setSize(600,600);
        			//add(centerPanel, BorderLayout.CENTER);             
        			JLabel imageLabel = new JLabel(new ImageIcon("CV_Images/mustang_silver.jpg"));
        			JLabel label = new JLabel("MSRP: $27,750");
        			centerPanel.add(imageLabel); 
        			centerPanel.add(label);
        			label.setFont(appFontPrice);   
        			centerPanel.setVisible(true);
        		}
        	}
        	//F150
        	
        	if(model.equals("F150")) {
        		if(color_red.isSelected()) {
        			JFrame centerPanel = new JFrame();             
        			centerPanel.setLayout(new FlowLayout()); 
        			centerPanel.setSize(600,600);
        			//add(centerPanel, BorderLayout.CENTER);             
        			JLabel imageLabel = new JLabel(new ImageIcon("CV_Images/f150_red.jpg")); 
        			JLabel label = new JLabel("MSRP: $28,750");
        			centerPanel.add(imageLabel); 
        			centerPanel.add(label);
        			label.setFont(appFontPrice);     
        			centerPanel.setVisible(true);
        			
        			
        		}
        		if(color_black.isSelected()) {
        			JFrame centerPanel = new JFrame();             
        			centerPanel.setLayout(new FlowLayout()); 
        			centerPanel.setSize(600,600);
        			//add(centerPanel, BorderLayout.CENTER);             
        			JLabel imageLabel = new JLabel(new ImageIcon("CV_Images/f150_black.jpg"));             
        			JLabel label = new JLabel("MSRP: $28,750");
        			centerPanel.add(imageLabel); 
        			centerPanel.add(label);
        			label.setFont(appFontPrice);    
        			centerPanel.setVisible(true);
        		}
        		if(color_silver.isSelected()) {
        			JFrame centerPanel = new JFrame();             
        			centerPanel.setLayout(new FlowLayout()); 
        			centerPanel.setSize(600,600);
        			//add(centerPanel, BorderLayout.CENTER);             
        			JLabel imageLabel = new JLabel(new ImageIcon("CV_Images/f150_silver.jpeg"));             
        			JLabel label = new JLabel("MSRP: $28,750");
        			centerPanel.add(imageLabel); 
        			centerPanel.add(label);
        			label.setFont(appFontPrice);    
        			centerPanel.setVisible(true);
        		}
        	}
        	//Escape
        	
        	if(model.equals("Escape")) {
        		if(color_red.isSelected()) {
        			JFrame centerPanel = new JFrame();             
        			centerPanel.setLayout(new FlowLayout()); 
        			centerPanel.setSize(600,600);
        			//add(centerPanel, BorderLayout.CENTER);             
        			JLabel imageLabel = new JLabel(new ImageIcon("CV_Images/escape_red.jpg")); 
        			JLabel label = new JLabel("MSRP: $24,105");
        			centerPanel.add(imageLabel); 
        			centerPanel.add(label);
        			label.setFont(appFontPrice);  
        			centerPanel.setVisible(true);
        			
        			
        		}
        		if(color_black.isSelected()) {
        			JFrame centerPanel = new JFrame();             
        			centerPanel.setLayout(new FlowLayout()); 
        			centerPanel.setSize(600,600);
        			//add(centerPanel, BorderLayout.CENTER);             
        			JLabel imageLabel = new JLabel(new ImageIcon("CV_Images/escape_black.jpg"));             
        			JLabel label = new JLabel("MSRP: $24,105");
        			centerPanel.add(imageLabel); 
        			centerPanel.add(label);
        			label.setFont(appFontPrice);  
        			centerPanel.setVisible(true);
        		}
        		if(color_silver.isSelected()) {
        			JFrame centerPanel = new JFrame();             
        			centerPanel.setLayout(new FlowLayout()); 
        			centerPanel.setSize(600,600);
        			//add(centerPanel, BorderLayout.CENTER);             
        			JLabel imageLabel = new JLabel(new ImageIcon("CV_Images/escape_silver.jpg"));             
        			JLabel label = new JLabel("MSRP: $24,105");
        			centerPanel.add(imageLabel); 
        			centerPanel.add(label);
        			label.setFont(appFontPrice);    
        			centerPanel.setVisible(true);
        		}
        	}
        	//Fusion
        	
        	if(model.equals("Fusion")) {
        		if(color_red.isSelected()) {
        			JFrame centerPanel = new JFrame();             
        			centerPanel.setLayout(new FlowLayout()); 
        			centerPanel.setSize(600,600);
        			//add(centerPanel, BorderLayout.CENTER);             
        			JLabel imageLabel = new JLabel(new ImageIcon("CV_Images/fusion_red.jpg")); 
        			JLabel label = new JLabel("MSRP: $22,845");
        			centerPanel.add(imageLabel); 
        			centerPanel.add(label);
        			label.setFont(appFontPrice);   
        			centerPanel.setVisible(true);
        			
        			
        		}
        		if(color_black.isSelected()) {
        			JFrame centerPanel = new JFrame();             
        			centerPanel.setLayout(new FlowLayout()); 
        			centerPanel.setSize(600,600);
        			//add(centerPanel, BorderLayout.CENTER);             
        			JLabel imageLabel = new JLabel(new ImageIcon("CV_Images/fusion_black.jpg"));             
        			JLabel label = new JLabel("MSRP: $22,845");
        			centerPanel.add(imageLabel); 
        			centerPanel.add(label);
        			label.setFont(appFontPrice); 
        			centerPanel.setVisible(true);
        		}
        		if(color_silver.isSelected()) {
        			JFrame centerPanel = new JFrame();             
        			centerPanel.setLayout(new FlowLayout()); 
        			centerPanel.setSize(600,600);
        			//add(centerPanel, BorderLayout.CENTER);             
        			JLabel imageLabel = new JLabel(new ImageIcon("CV_Images/fusion_silver.jpg"));             
        			JLabel label = new JLabel("MSRP: $22,845");
        			centerPanel.add(imageLabel); 
        			centerPanel.add(label);
        			label.setFont(appFontPrice);   
        			centerPanel.setVisible(true);
        		}
        	}
        	//Avalon
        	
        	if(model.equals("Avalon")) {
        		if(color_red.isSelected()) {
        			JFrame centerPanel = new JFrame();             
        			centerPanel.setLayout(new FlowLayout()); 
        			centerPanel.setSize(600,600);
        			//add(centerPanel, BorderLayout.CENTER);             
        			JLabel imageLabel = new JLabel(new ImageIcon("CV_Images/avalon_red.jpg")); 
        			JLabel label = new JLabel("MSRP: $35,650");
        			centerPanel.add(imageLabel); 
        			centerPanel.add(label);
        			label.setFont(appFontPrice);    
        			centerPanel.setVisible(true);
        			
        			
        		}
        		if(color_black.isSelected()) {
        			JFrame centerPanel = new JFrame();             
        			centerPanel.setLayout(new FlowLayout()); 
        			centerPanel.setSize(600,600);
        			//add(centerPanel, BorderLayout.CENTER);             
        			JLabel imageLabel = new JLabel(new ImageIcon("CV_Images/avalon_black.jpg"));             
        			JLabel label = new JLabel("MSRP: $35,650");
        			centerPanel.add(imageLabel); 
        			centerPanel.add(label);
        			label.setFont(appFontPrice);   
        			centerPanel.setVisible(true);
        		}
        		if(color_silver.isSelected()) {
        			JFrame centerPanel = new JFrame();             
        			centerPanel.setLayout(new FlowLayout()); 
        			centerPanel.setSize(600,600);
        			//add(centerPanel, BorderLayout.CENTER);             
        			JLabel imageLabel = new JLabel(new ImageIcon("CV_Images/avalon_silver.jpg"));             
        			JLabel label = new JLabel("MSRP: $35,650");
        			centerPanel.add(imageLabel); 
        			centerPanel.add(label);
        			label.setFont(appFontPrice);    
        			centerPanel.setVisible(true);
        		}
        	}
        	//Camry
        	
        	if(model.equals("Camry")) {
        		if(color_red.isSelected()) {
        			JFrame centerPanel = new JFrame();             
        			centerPanel.setLayout(new FlowLayout()); 
        			centerPanel.setSize(600,600);
        			//add(centerPanel, BorderLayout.CENTER);             
        			JLabel imageLabel = new JLabel(new ImageIcon("CV_Images/camry_red.jpg")); 
        			JLabel label = new JLabel("MSRP: $24,095");
        			centerPanel.add(imageLabel); 
        			centerPanel.add(label);
        			label.setFont(appFontPrice);    
        			centerPanel.setVisible(true);
        			
        			
        		}
        		if(color_black.isSelected()) {
        			JFrame centerPanel = new JFrame();             
        			centerPanel.setLayout(new FlowLayout()); 
        			centerPanel.setSize(600,600);
        			//add(centerPanel, BorderLayout.CENTER);             
        			JLabel imageLabel = new JLabel(new ImageIcon("CV_Images/camry_black.jpg"));             
        			JLabel label = new JLabel("MSRP: $24,095");
        			centerPanel.add(imageLabel); 
        			centerPanel.add(label);
        			label.setFont(appFontPrice);   
        			centerPanel.setVisible(true);
        		}
        		if(color_silver.isSelected()) {
        			JFrame centerPanel = new JFrame();             
        			centerPanel.setLayout(new FlowLayout()); 
        			centerPanel.setSize(600,600);
        			//add(centerPanel, BorderLayout.CENTER);             
        			JLabel imageLabel = new JLabel(new ImageIcon("CV_Images/camry_silver.jpg"));             
        			JLabel label = new JLabel("MSRP: $24,095");
        			centerPanel.add(imageLabel); 
        			centerPanel.add(label);
        			label.setFont(appFontPrice);   
        			centerPanel.setVisible(true);
        		}
        	}
        	//Prius
        	
        	if(model.equals("Prius")) {
        		if(color_red.isSelected()) {
        			JFrame centerPanel = new JFrame();             
        			centerPanel.setLayout(new FlowLayout()); 
        			centerPanel.setSize(600,600);
        			//add(centerPanel, BorderLayout.CENTER);             
        			JLabel imageLabel = new JLabel(new ImageIcon("CV_Images/prius_red.jpg")); 
        			JLabel label = new JLabel("MSRP: $23,770");
        			centerPanel.add(imageLabel); 
        			centerPanel.add(label);
        			label.setFont(appFontPrice); 
        			centerPanel.setVisible(true);
        			
        			
        		}
        		if(color_black.isSelected()) {
        			JFrame centerPanel = new JFrame();             
        			centerPanel.setLayout(new FlowLayout()); 
        			centerPanel.setSize(600,600);
        			//add(centerPanel, BorderLayout.CENTER);             
        			JLabel imageLabel = new JLabel(new ImageIcon("CV_Images/prius_black.jpg")); 
        			JLabel label = new JLabel("MSRP: $23,770");
        			centerPanel.add(imageLabel); 
        			centerPanel.add(label);
        			label.setFont(appFontPrice);    
        			centerPanel.setVisible(true);
        		}
        		if(color_silver.isSelected()) {
        			JFrame centerPanel = new JFrame();             
        			centerPanel.setLayout(new FlowLayout()); 
        			centerPanel.setSize(600,600);
        			//add(centerPanel, BorderLayout.CENTER);             
        			JLabel imageLabel = new JLabel(new ImageIcon("CV_Images/prius_silver.jpg"));             
        			JLabel label = new JLabel("MSRP: $23,770");
        			centerPanel.add(imageLabel); 
        			centerPanel.add(label);
        			label.setFont(appFontPrice);  
        			centerPanel.setVisible(true);
        		}
        	}
        	//Chevy
        	
        	if(model.equals("Corvette")) {
        		if(color_red.isSelected()) {
        			JFrame centerPanel = new JFrame();             
        			centerPanel.setLayout(new FlowLayout()); 
        			centerPanel.setSize(600,600);
        			//add(centerPanel, BorderLayout.CENTER);             
        			JLabel imageLabel = new JLabel(new ImageIcon("CV_Images/corvette_red.jpg")); 
        			JLabel label = new JLabel("MSRP: $55,900");
        			centerPanel.add(imageLabel); 
        			centerPanel.add(label);
        			label.setFont(appFontPrice);  
        			centerPanel.setVisible(true);
        			
        			
        		}
        		if(color_black.isSelected()) {
        			JFrame centerPanel = new JFrame();             
        			centerPanel.setLayout(new FlowLayout()); 
        			centerPanel.setSize(600,600);
        			//add(centerPanel, BorderLayout.CENTER);             
        			JLabel imageLabel = new JLabel(new ImageIcon("CV_Images/corvette_black.jpg"));             
        			JLabel label = new JLabel("MSRP: $55,900");
        			centerPanel.add(imageLabel); 
        			centerPanel.add(label);
        			label.setFont(appFontPrice);    
        			centerPanel.setVisible(true);
        		}
        		if(color_silver.isSelected()) {
        			JFrame centerPanel = new JFrame();             
        			centerPanel.setLayout(new FlowLayout()); 
        			centerPanel.setSize(600,600);
        			//add(centerPanel, BorderLayout.CENTER);             
        			JLabel imageLabel = new JLabel(new ImageIcon("CV_Images/corvette_silver.jpg"));             
        			JLabel label = new JLabel("MSRP: $55,900");
        			centerPanel.add(imageLabel); 
        			centerPanel.add(label);
        			label.setFont(appFontPrice);   
        			centerPanel.setVisible(true);
        		}
        	}
        	//Silverado
        	
        	if(model.equals("Silverado")) {
        		if(color_red.isSelected()) {
        			JFrame centerPanel = new JFrame();             
        			centerPanel.setLayout(new FlowLayout()); 
        			centerPanel.setSize(600,600);
        			//add(centerPanel, BorderLayout.CENTER);             
        			JLabel imageLabel = new JLabel(new ImageIcon("CV_Images/silverado_red.jpg")); 
        			JLabel label = new JLabel("MSRP: $29,795");
        			centerPanel.add(imageLabel); 
        			centerPanel.add(label);
        			label.setFont(appFontPrice);     
        			centerPanel.setVisible(true);
        			
        			
        		}
        		if(color_black.isSelected()) {
        			JFrame centerPanel = new JFrame();             
        			centerPanel.setLayout(new FlowLayout()); 
        			centerPanel.setSize(600,600);
        			//add(centerPanel, BorderLayout.CENTER);             
        			JLabel imageLabel = new JLabel(new ImageIcon("CV_Images/silverado_black.jpg"));             
        			JLabel label = new JLabel("MSRP: $29,795");
        			centerPanel.add(imageLabel); 
        			centerPanel.add(label);
        			label.setFont(appFontPrice);    
        			centerPanel.setVisible(true);
        		}
        		if(color_silver.isSelected()) {
        			JFrame centerPanel = new JFrame();             
        			centerPanel.setLayout(new FlowLayout()); 
        			centerPanel.setSize(600,600);
        			//add(centerPanel, BorderLayout.CENTER);             
        			JLabel imageLabel = new JLabel(new ImageIcon("CV_Images/silverado_silver.jpg"));             
        			JLabel label = new JLabel("MSRP: $29,795");
        			centerPanel.add(imageLabel); 
        			centerPanel.add(label);
        			label.setFont(appFontPrice);   
        			centerPanel.setVisible(true);
        		}
        	}
        	//Camaro
        	
        	if(model.equals("Camaro")) {
        		if(color_red.isSelected()) {
        			JFrame centerPanel = new JFrame();             
        			centerPanel.setLayout(new FlowLayout()); 
        			centerPanel.setSize(600,600);
        			//add(centerPanel, BorderLayout.CENTER);             
        			JLabel imageLabel = new JLabel(new ImageIcon("CV_Images/camaro_red.jpg")); 
        			JLabel label = new JLabel("MSRP: $25,300");
        			centerPanel.add(imageLabel); 
        			centerPanel.add(label);
        			label.setFont(appFontPrice);   
        			centerPanel.setVisible(true);
        			
        			
        		}
        		if(color_black.isSelected()) {
        			JFrame centerPanel = new JFrame();             
        			centerPanel.setLayout(new FlowLayout()); 
        			centerPanel.setSize(600,600);
        			//add(centerPanel, BorderLayout.CENTER);             
        			JLabel imageLabel = new JLabel(new ImageIcon("CV_Images/camaro_black.jpg"));             
        			JLabel label = new JLabel("MSRP: $25,300");
        			centerPanel.add(imageLabel); 
        			centerPanel.add(label);
        			label.setFont(appFontPrice);   
        			centerPanel.setVisible(true);
        		}
        		if(color_silver.isSelected()) {
        			JFrame centerPanel = new JFrame();             
        			centerPanel.setLayout(new FlowLayout()); 
        			centerPanel.setSize(600,600);
        			//add(centerPanel, BorderLayout.CENTER);             
        			JLabel imageLabel = new JLabel(new ImageIcon("CV_Images/camaro_silver.jpg"));             
        			JLabel label = new JLabel("MSRP: $25,300");
        			centerPanel.add(imageLabel); 
        			centerPanel.add(label);
        			label.setFont(appFontPrice);  
        			centerPanel.setVisible(true);
        		}
        	}
    	 }
    		 
    	 
    		 
    	 
    	 
    	 /*
    	 */
    	 if ( option_stereo.isSelected() || option_selfdrive.isSelected() || option_eject.isSelected() ){
    	       buildText.append("\nOPTIONS: \n");
    	       if ( option_stereo.isSelected() ){
    	         buildText.append("Super Surround Stereo System \n");
    	       }
    	       if ( option_selfdrive.isSelected() ){
    	         buildText.append("Automatic Drive System \n");
    	       }
    	       if ( option_eject.isSelected() ){
    	         buildText.append("Passenger Ejection Seat \n");
    	       }
    	}
    	 
    	 if (color_red.isSelected() || color_black.isSelected() || color_silver.isSelected() ) {
    		 buildText.append("\nCOLORS: \n");
    		 if( color_red.isSelected() ) {
    			 buildText.append("Red \n");
    		 }
    		 if( color_black.isSelected() ) {
    			 buildText.append("Black \n");
    		 }
    		 if( color_silver.isSelected() ) {
    			 buildText.append("Silver \n");
    		 }
    	 }
    	 
    	 if (trans_manual.isSelected() || trans_automatic.isSelected() ) {
    		 buildText.append("TRANSMISSIONS: \n");
    		 if( trans_manual.isSelected() ) {
    			 buildText.append("Manual");
    		 }
    		 if( trans_automatic.isSelected() ) {
    			 buildText.append("Automatic");
    		 }
    	 }
    	 
    	 

    	 
    	 
    	
    }

}
