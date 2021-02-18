import javax.swing.JComponent;
import javax.swing.JFrame;

public class GUIViewer {
	
	public static void main(String[] args) {
		GraphDatabase db = new GraphDatabase();
		CityNodeCreator cnc = new CityNodeCreator(db);
		
		
		
		JFrame frame = new JFrame();
		frame.setTitle("Graphics Question");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MapComponent component = new MapComponent(db);
		component.drawScreen();
	}
	
}
