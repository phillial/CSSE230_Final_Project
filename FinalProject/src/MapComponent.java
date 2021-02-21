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
import javax.swing.JComboBox;
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
	private String finish;
	private String start;
	
	
	public MapComponent(GraphDatabase db) {
		//this.comp = new JComponent();
		this.db = db;
		this.display = new JFrame("Panel Example");    
        this.panel =new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JPanel inner = new JPanel();
        inner.setBackground(Color.GRAY);
        inner.setLayout(new GridLayout(9, 2));
        
        panel.setBounds(1500, 0, 500, 1000);    
        panel.setBackground(Color.gray); 
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        panel.add(inner, c);
        
        
        JPanel outer = new JPanel();
        outer.setBackground(Color.GRAY);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1; 
        c.anchor = GridBagConstraints.SOUTH;
        panel.add(outer, c);
        
        JButton findRoute = new JButton("Calculate Distance");
        inner.add(findRoute);
        
        JLabel blank = new JLabel();
        blank.setBackground(Color.GRAY);
        inner.add(blank);
        
        addSpace(inner, blank);
        
		JLabel scLabel = new JLabel("Insert Start City Here: ");
		inner.add(scLabel);
		
		String[] possibleCities = {
				"", "Whitehorse", "Juneau","Yellowknife","Edmonton","Victoria","Regina","Winnipeg",	"Olympia","Salem","Sacramento","Carson City",
				"Boise","Helena","Salt Lake City","Phoenix","Santa Fe", "Denver","Bismarck","Pierre","Lincoln","Topeka","Oklahoma City","Austin",
				"Baton Rouge","Little Rock","Jefferson City", "Des Moines","St Paul","Madison", "Springfield","Jackson","Montgomery","Nashville",
				"Frankfort","Indianapolis","Atlanta","Columbia", "Tallahassee", "Raleigh","Richmond","Charleston","Columbus","Lansing","Harrisburg",
				"Annapolis","Dover","Trenton","Albany","Hartford", "Providence","Boston","Montpelier","Concord", "Augusta","Toronto","Quebec City",				"St. John's",
				"Fredericton","Charlottetown","Halifax","Iqaluit"
		};
		
		
		JComboBox startCity = new JComboBox(possibleCities);
		startCity.setEditable(true);

		inner.add(startCity);
		addSpace(inner, blank);
		
		startCity.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				finish = startCity.getSelectedItem().toString();
				startCity.removeAllItems();
				startCity.addItem(finish);
				String[] newList = search(finish, possibleCities);
				for(int i = 0; i < newList.length; i++) {
					startCity.addItem(newList[i]);
				}
			}
        });
		
		JLabel fcLabel = new JLabel("Insert Destination City Here: ");
		inner.add(fcLabel);
		
		
		JComboBox finishCity = new JComboBox(possibleCities);
		finishCity.setEditable(true);
        inner.add(finishCity);
        addSpace(inner, blank);
        
        finishCity.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String finish = finishCity.getSelectedItem().toString();
				finishCity.removeAllItems();
				finishCity.addItem(finish);
				String[] newList = search(finish, possibleCities);
				for(int i = 0; i < newList.length; i++) {
					finishCity.addItem(newList[i]);
				}
			}
        });
        
        JLabel mdLabel = new JLabel("Insert Max Distance Here: ");
		inner.add(mdLabel);
		
        JTextField maxDistance = new JTextField();
        inner.add(maxDistance);
        
        addSpace(inner, blank);
        
        
        JLabel mtLabel = new JLabel("Insert Max Time Here: ");
		inner.add(mtLabel);
		
        JTextField maxTime = new JTextField();
        inner.add(maxTime);
        
         ActionListener button = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	String start = (String) startCity.getSelectedItem();
       	 	String finish = (String) finishCity.getSelectedItem();
       	 	String distance = maxDistance.getText();
       	 	String time = maxTime.getText();
       	 	String result = buttonPressed(start, finish, distance, time);
       	 	System.out.println(result);
       	 	outer.removeAll();
       	 	outer.add(createAnswer(result, answer, distance, time));
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
        
        display.add(panel);  
        display.setSize(2000, 1000);    
        display.setLayout(null);
	}
	
	public JTextArea createAnswer(String result, JTextArea answer) {
		int distance = db.getDistance();
		int hours = distance / 60;
		int minutes = distance % 60;
		int max = Integer.MAX_VALUE;
		if(maxDistance == null || maxDistance.equals("") || Integer.parseInt(maxDistance) < 0)  {
			maxDistance = ""+max+"";
		}
		if(maxTime == null || maxTime.equals("") || Integer.parseInt(maxTime) < 0) {
			maxTime = ""+max+"";
		}
		if(distance > Integer.parseInt(maxDistance)) {
			if(hours >= Integer.parseInt(maxTime)) {
				answer = new JTextArea("You destination could not be reached in the time and distance requested.");
			}else {
				answer = new JTextArea("Your destination is too far away and cannot be reached in the distance requested.");
			}
		}else if(hours >= Integer.parseInt(maxTime)) {
			answer = new JTextArea("Your destination can not be reached in the time allowed.");
		}else {
			answer = new JTextArea(result + ".\n Total Distance is "+ db.getDistance() +" Miles. \n Total time is "+ hours +" hours and "+ minutes+" minutes.");
		}
		
        answer.setBackground(Color.WHITE);
        answer.setLineWrap(true);
        answer.setWrapStyleWord(true);
        answer.setEditable(false);
        answer.setSize(200, 200);
        answer.setVisible(true);
        JScrollPane scroll = new JScrollPane(answer);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		return answer;
	}

	protected String[] search(String city, String[] c) {
		ArrayList<String> newList = new ArrayList<String>();
		if(city.length() > 0) {
			int count = 0;
			for(int i = 0; i < c.length; i++) {
				for(int j = 0; j < c[i].length() && j < city.length(); j++) {
					if(city.charAt(j) != c[i].charAt(j)) {
						
					}else {
						count++;
					}
				}
				if(count >= city.length()) {//if what has been type, aligns with a result add result to list
					newList.add(c[i]);
				}
				count = 0;
			}
			String[] result = new String[newList.size()];
			for(int i = 0; i < newList.size(); i++) {
				result[i] = newList.get(i);
			}
			return result;
		}
		else {
			return c;
		}
	}
	
	protected String buttonPressed(String start, String finish, String distance, String time) {
		ArrayList<String> resultString = db.findRoute(start, finish);
		String result = "Path: ";
		for(int i = 0; i < resultString.size(); i++) {
			if(i == resultString.size() -1) {
				result+= resultString.get(i);
			} else {
				result+= resultString.get(i)+" to ";
			}
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