import java.util.Hashtable;

public class GraphDatabase {
	CityNode start;
	CityNode finish;
	PriorityQueue q;
	
	public GraphDatabase(CityNode start, CityNode finish) {
		this.start = start;
		this.finish = finish;
	}
	
	public void findRoute() {
		
	}
	
	public class CityNode {
		String name;
		Hashtable<String, Integer> neighborDistance;
		Hashtable<String, Integer> neighborTime;
	
		
		public void findClosest() {
			
		}
		
		public void planRoute() {
			
		}
		
	}
	
}
