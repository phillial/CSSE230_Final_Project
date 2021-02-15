import java.util.ArrayList;
import java.util.HashMap;

public class CityNode {
	private int xpos;
	private int ypos;
	private String name;
	
	public CityNode(String name, int xpos, int ypos) {
		this.name = name;
		this.xpos = xpos;
		this.ypos = ypos;
	}
	
	public static void main(String[] args) {
		CityNode indy = new CityNode("Indianapolis", 0, 0);
		System.out.println(indy.xpos);
	}
	
	
}


