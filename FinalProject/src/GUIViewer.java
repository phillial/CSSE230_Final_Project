
import javax.swing.JComponent;
import javax.swing.JFrame;

public class GUIViewer {
	
	public GUIViewer(GraphDatabase db) {
		JFrame frame = new JFrame();
		frame.setTitle("Graphics Question");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MapComponent component = new MapComponent(db);
		component.drawScreen();
	}
	
	
}
