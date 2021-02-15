import java.util.ArrayList;
import java.util.Hashtable;


public class GraphDatabase {
	CityNode start;
	CityNode finish;
	PriorityQueue q;
	
	public GraphDatabase(CityNode start, CityNode finish) {
		this.start = start;
		this.finish = finish;
	}
	
	public ArrayList<String> findRoute() {
		PriorityQueue q = new PriorityQueue();
		
		ArrayList<String> path = new ArrayList<String>();
		
		if(start == null || finish == null) {
			return path;
		}
		
		ArrayList<String> path = new ArrayList<String>();
		path.add(start.name);
		start.planRoute(q, 0, path);
		return path;
	}
	
	public class CityNode {
		String name;
		Hashtable<String, Integer> neighborDistance;
		Hashtable<String, Integer> neighborTime;
	
		
		public void findClosest() {
			
		}
		
		public void planRoute(PriorityQueue q, int g, ArrayList<String> path) {
			Hashtable<Integer, String> f;
			//q.addAll(neighborDistance.values());
			
			for(String key : neighborDistance.keySet()) {
				f.put(g + neighborTime.get(key) + neighborDistance.get(key), key);
			}
			
			q.addAll(f);
			
			int smallestF = q.remove();
			String nextCity = f.get(smallestF);
			path.add(nextCity);
			if(nextCity == finish.name) {
				return;
			} else {
				//need some way of storing the cityNode objects of the neighbors
				nextCity.planRoute(q, g + neighborTime.get(nextCity), path);
			}
			
		}
		
	}
	
}
