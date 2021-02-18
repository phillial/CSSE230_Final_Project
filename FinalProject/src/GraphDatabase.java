import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;


public class GraphDatabase {
	CityNode start;
	CityNode finish;
	Hashtable<CityNode, Double> citiesHeuristic;
	HashSet<CityNode> cities;
	
	public GraphDatabase() { 
		this.start = null;
		this.finish = null;
	}
	
	public ArrayList<String> findRoute(String startName, String finishName) {
		for(CityNode city : cities) {
			if(this.start == null || this.finish == null) {
				if(startName.equals(city.name)) this.start = start;
				if(finishName.equals(city.name)) this.finish = finish;	
			}
		}
		
		
		for(CityNode city : cities) {
			citiesHeuristic.put(city, distance(city, finish));
		}
		
		
		PriorityQueue<Double> q = new PriorityQueue<Double>();
		ArrayList<String> path = new ArrayList<String>();
		this.start = start;
		this.finish = finish;
		
		if(start == null || finish == null) return path;		
		
		path.add(start.name);
		start.planRoute(q, 0, path);
		this.start = null;
		this.finish = null;
		citiesHeuristic.clear();
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
		public void findNeighbors() {
			PriorityQueue<Double> q = new PriorityQueue<Double>();
			Hashtable<Double, CityNode> f = new Hashtable<Double, CityNode>();
			
			for(CityNode city : cities) f.put(distance(this, city), city);
			
			q.addAll(f.keySet());
			
			for(int i = 0; i < 4; i++) {
				double smallestDistance = q.poll();
				neighborDistance.put(f.get(smallestDistance), smallestDistance);
			}
			
		}
		
		
		
		public void planRoute(PriorityQueue<Double> q, int g, ArrayList<String> path) {
			Hashtable<Double, CityNode> f = new Hashtable<Double, CityNode>();
			
			
			for(CityNode city : neighborDistance.keySet()) {
				f.put(g + neighborDistance.get(city) + citiesHeuristic.get(city), city);
			}
			
			q.addAll(f.keySet()); 
			
			
			double smallestF = q.poll();
			CityNode nextCity = f.get(smallestF);
			path.add(nextCity.name);
			g += neighborDistance.get(nextCity);
			if(nextCity.name.equals(finish.name)) {
				return;
			} else {
				nextCity.planRoute(q, g, path);
			}	
		}
		
	}
	
}
