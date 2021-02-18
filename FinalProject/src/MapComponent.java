
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MapComponent{
	private JComponent comp;
	private JPanel panel;
	private JFrame display;
	private BufferedImage image;
	private GraphDatabase db;
	
	
	public MapComponent(GraphDatabase db) {
		//this.comp = new JComponent();
		this.db = db;
		this.display = new JFrame("Panel Example");    
        this.panel =new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        //c.fill = GridBagConstraints.HORIZONTAL;
        JPanel inner = new JPanel();
        inner.setBackground(Color.GRAY);
        inner.setLayout(new GridLayout(9, 2));
        
        panel.setBounds(1500, 0, 500, 1000);    
        panel.setBackground(Color.gray);  
       
        
        JButton findRoute = new JButton("Calculate Distance");
        inner.add(findRoute);
       
        
         
   
        JLabel blank = new JLabel();
        blank.setBackground(Color.GRAY);
        inner.add(blank);
        
        addSpace(inner, blank);
        
		JLabel scLabel = new JLabel("Insert Start City Here: ");
		inner.add(scLabel);
		
		
		JTextField startCity = new JTextField();
		inner.add(startCity);
		String start = startCity.getSelectedText();
		addSpace(inner, blank);
		
		JLabel fcLabel = new JLabel("Insert Destination City Here: ");
		inner.add(fcLabel);
		
        JTextField finishCity = new JTextField();
        inner.add(finishCity);
        String finish = finishCity.getSelectedText();
        addSpace(inner, blank);
        
        JLabel mdLabel = new JLabel("Insert Max Distance Here: ");
		inner.add(mdLabel);
		
        JTextField maxDistance = new JTextField();
        inner.add(maxDistance);
        String distance = maxDistance.getSelectedText();
        
        addSpace(inner, blank);
        
        
        JLabel mtLabel = new JLabel("Insert Max Time Here: ");
		inner.add(mtLabel);
		
        JTextField maxTime = new JTextField();
        inner.add(maxTime);
        String time = maxDistance.getSelectedText();
        
         ActionListener button = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	 blank.setText(buttonPressed(start, finish, distance, time));
         }
        };
        findRoute.addActionListener(button);
        
        try {
        	image = ImageIO.read(new File("src/DaCapitols.png"));
        }catch(IOException ex) {
        	ex.printStackTrace();
        }
        
        JLabel picLabel = new JLabel(new ImageIcon(image));
        JPanel picPanel = new JPanel();
        picPanel.setBounds(0,0,1499,1000);
        picPanel.add(picLabel);
        display.add(picPanel);
        panel.add(inner);
        
        display.add(panel);  
        display.setSize(2000, 1000);    
        display.setLayout(null);
	}
	
	protected String buttonPressed(String start, String finish, String distance, String time) {
		ArrayList<String> resultString = db.findRoute(start, finish);
		String result = "Path: ";
		for(int i = 0; i < resultString.size(); i++) {
			if(i == resultString.size() -1) {
				result+= resultString.get(i);
			}
			result+= resultString.get(i)+" to ";
		}
		return result;
	}

	private void addSpace(JPanel inner, JLabel blank) {
		blank = new JLabel();
        blank.setBackground(Color.GRAY);
        inner.add(blank);
        
        blank = new JLabel();
        blank.setBackground(Color.GRAY);
        inner.add(blank);
	}

	public void drawScreen() {
		display.setVisible(true);
		panel.setVisible(true);
	}
}