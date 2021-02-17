import java.util.ArrayList;
import java.util.Hashtable;


public class GraphDatabase {
	CityNode start;
	CityNode finish;
	Hashtable<CityNode, Double> citiesHeuristic;
	PriorityQueue q;
	
	public GraphDatabase(CityNode start, CityNode finish) {
		this.start = start;
		this.finish = finish;
		for(CityNode city : citiesHeuristic.keySet()) {
			citiesHeuristic.put(city, distance(city, finish));
		}
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
	
	public double distance(CityNode c1, CityNode c2) {
	        double y = c1.ypos - c2.ypos;
	        double x = c1.xpos - c2.xpos;
	        double distance = Math.sqrt(Math.pow(y, 2) + Math.pow(x, 2));
	        return distance;
	}
	
	public class CityNode {
		String name;
		Hashtable<CityNode, Double> neighborDistance;
		double xpos;
		double ypos;
		
		public CityNode(String name, int xpos, int ypos) {
			this.name = name;
			this.xpos = xpos;
			this.ypos = ypos;
		}
		
		/**
		 * THIS METHOD REALLY SHOULDENT BE HERE IT INCREASES THE RUNTIME BY A LOT
		 * I THINK AND IT SHOULD PROBABLY BE DONE EARLEIR WHEN THE CITIES ARE ALL 
		 * ADDED IN THE FIRST PLACE
		 */
		public void findClosest() {
			PriorityQueue q = new PriorityQueue();
			
			for(int i = 0; i < 4; i++) {	
				neighborDistance.put(city, distance(city, finish))
			}
		}
		
		public void planRoute(PriorityQueue q, int g, ArrayList<String> path) {
			Hashtable<Double, CityNode> f;
			//q.addAll(neighborDistance.values());
			
			for(CityNode city : neighborDistance.keySet()) {
				f.put(g + neighborDistance.get(city) + citiesHeuristic.get(city), city);
			}
			
			q.addAll(f); //might need to replace with another for loop that iterates through f and puts every double in
			
			
			double smallestF = q.remove();
			CityNode nextCity = f.get(smallestF);
			path.add(nextCity.name);
			g += neighborDistance.get(nextCity);
			if(nextCity.name == finish.name) { // might need to do .equals() for comparing two strings
				return;
			} else {
				nextCity.planRoute(q, g, path);
			}
			
		}
		
	}
	
}
