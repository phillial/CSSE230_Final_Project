import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;


public class GraphDatabase {
	CityNode start;
	CityNode finish;
	Hashtable<CityNode, Double> citiesHeuristic;
	HashSet<CityNode> cities;
	int totalDistance;
	
	public GraphDatabase() { 
//		this.start = null;
//		this.finish = null;
		this.citiesHeuristic = new Hashtable<CityNode, Double>();
	}
	
	
	public ArrayList<String> findRoute(String startName, String finishName) {
		for(CityNode city : cities) {
			if(startName.equals(city.name)) this.start = city;
			if(finishName.equals(city.name)) this.finish = city;	
		}
		for(CityNode city : cities) {
			double d = distance(city, finish);
			citiesHeuristic.put(city, d);
		}
		this.start = start;
		this.finish = finish;
		if(start == null || finish == null) return null;
	
		totalDistance = 0;
// ************************* END OF SETUP *************************
		
		Hashtable<CityNode, CityNode> closestParent = new Hashtable<CityNode, CityNode>();
		
		Hashtable<CityNode, Double> g = new Hashtable<CityNode, Double>();
		g.put(start, 0.);
		
		MyPriorityQueue<Double> q = new MyPriorityQueue<Double>(); //openSet
		q.add(citiesHeuristic.get(start));
		
		Hashtable<Double, CityNode> qMap = new Hashtable<Double, CityNode>();
		qMap.put(citiesHeuristic.get(start), start);	
		
		return start.planRoute(g, closestParent, qMap, q);
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
			this.neighborDistance = new Hashtable<CityNode, Double>();
		}
		
		
		public void findNeighbors() {
			MyPriorityQueue<Double> q = new MyPriorityQueue<Double>();
			Hashtable<Double, CityNode> f = new Hashtable<Double, CityNode>();
			for(CityNode city : cities) {
				double d = distance(this, city);
				f.put(distance(this, city), city);
				q.add(d);
			}
			q.poll();
			for(int i = 0; i < 4; i++) {
				double smallestDistance = q.poll();
				CityNode neighbor = f.get(smallestDistance);
				neighborDistance.put(neighbor, smallestDistance);
				neighbor.neighborDistance.put(this, smallestDistance);
			}
			
		}
		
		
		public ArrayList<String> makePath(Hashtable<CityNode, CityNode> closestParent, ArrayList<String> path) {
			if (!closestParent.containsKey(this)) {
				return path;
			}
			CityNode parent = closestParent.get(this);
			path.add(0, parent.name);
			closestParent.remove(this);
			return parent.makePath(closestParent, path);
		}
		
		
		public ArrayList<String> planRoute(Hashtable<CityNode, Double> g, Hashtable<CityNode, CityNode> closestParent, Hashtable<Double, CityNode> qMap, MyPriorityQueue<Double> q) {
			
			if(name.equals(finish.name)) {
				ArrayList<String> path = new ArrayList<String>();
				path.add(name);
				totalDistance += 0;
				return this.makePath(closestParent, path);
			}
			
			double fToRemove = q.poll();
			qMap.remove(fToRemove);
			
			for(CityNode neighbor : neighborDistance.keySet()) {
				double gTemp = g.get(this) + neighborDistance.get(neighbor);
				
				if (g.containsKey(neighbor)) {
					if (gTemp < g.get(neighbor)) {
						closestParent.remove(neighbor);
						closestParent.put(neighbor, this);

						g.remove(neighbor);
						g.put(neighbor, gTemp);

						double f = gTemp + citiesHeuristic.get(neighbor);
						q.add(f);
						qMap.put(f, neighbor);
					} 
				} else {
					g.put(neighbor, gTemp);
					
					double f = gTemp + citiesHeuristic.get(neighbor);
					q.add(f);
					qMap.put(f, neighbor);
					
					closestParent.put(neighbor, this);
				}
				
			}
			
			if(!q.isEmpty()) {
				double nextDistance = q.peek();
				CityNode next = qMap.get(nextDistance);
				totalDistance += nextDistnace;
				return next.planRoute(g, closestParent, qMap, q);
			}
			
			return null;
			
		}
		
	}
	
	pulic int getDistance() {
		return totalDistnace;
	}
}


