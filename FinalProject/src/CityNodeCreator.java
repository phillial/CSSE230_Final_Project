import java.util.ArrayList;
import java.util.HashMap;


public class CityNodeCreator {
//	private int xpos;
//	private int ypos;
//	private String name;
//	
//	public CityNode(String name, int xpos, int ypos) {
//		this.name = name;
//		this.xpos = xpos;
//		this.ypos = ypos;
//	}
	
	public static void createCities(GraphDatabase g) {
		//GraphDatabase g = new GraphDatabase();
		ArrayList<GraphDatabase.CityNode> cities = new ArrayList<GraphDatabase.CityNode>();
		
		GraphDatabase.CityNode whitehorse = g. new CityNode("Whitehorse", 520, 333);
		GraphDatabase.CityNode juneau = g. new CityNode("Juneau", 529, 416);
		GraphDatabase.CityNode yellowknife = g. new CityNode("Yellowknife", 867, 268);
		GraphDatabase.CityNode edmonton = g. new CityNode("Edmonton", 888, 577);
		GraphDatabase.CityNode victoria = g. new CityNode("Victoria", 789, 747);
		GraphDatabase.CityNode regina = g. new CityNode("Regina", 1083, 675);
		GraphDatabase.CityNode winnipeg = g. new CityNode("Winnipeg", 1248, 692);
		GraphDatabase.CityNode olympia = g. new CityNode("Olympia", 800, 794);
		GraphDatabase.CityNode salem = g. new CityNode("Salem", 796, 866);
		GraphDatabase.CityNode sacramento = g. new CityNode("Sacramento", 839, 1084);
		GraphDatabase.CityNode carsonCity = g. new CityNode("Carson City", 885, 1064);
		GraphDatabase.CityNode boise = g. new CityNode("Boise", 962, 906);
		GraphDatabase.CityNode helena = g. new CityNode("Helena", 1055, 805);
		GraphDatabase.CityNode saltLakeCity = g. new CityNode("Salt Lake City", 1055, 1006);
		GraphDatabase.CityNode phoenix = g. new CityNode("Phoenix", 1055, 1259);
		GraphDatabase.CityNode santaFe = g. new CityNode("Santa Fe", 1225, 1177);
		GraphDatabase.CityNode denver = g. new CityNode("Denver", 1250, 1036);
		GraphDatabase.CityNode cheyenne = g. new CityNode("Cheyenne", 1255, 988);
		GraphDatabase.CityNode bismarck = g. new CityNode("Bismarck", 1322, 794);
		GraphDatabase.CityNode pierre = g. new CityNode("Pierre", 1332, 879);
		GraphDatabase.CityNode lincoln = g. new CityNode("Lincoln", 1467, 992);
		GraphDatabase.CityNode topeka = g. new CityNode("Topeka", 1489, 1052);
		GraphDatabase.CityNode oklahomaCity = g. new CityNode("Oklahoma City", 1461, 1177);
		GraphDatabase.CityNode austin = g. new CityNode("Austin", 1451, 1358);
		GraphDatabase.CityNode batonRouge = g. new CityNode("Baton Rouge", 1647, 1345);
		GraphDatabase.CityNode littleRock = g. new CityNode("Little Rock", 1606, 1199);
		GraphDatabase.CityNode jeffersonCity = g. new CityNode("Jefferson City", 1611, 1067);
		GraphDatabase.CityNode desMoines = g. new CityNode("Des Moines", 1547, 966);
		GraphDatabase.CityNode stPaul = g. new CityNode("St Paul", 1562, 851);
		GraphDatabase.CityNode madison = g. new CityNode("Madison", 1656, 915);
		GraphDatabase.CityNode springfield = g. new CityNode("Springfield", 1650, 1028);
		GraphDatabase.CityNode jackson = g. new CityNode("Jackson", 1677, 1281);
		GraphDatabase.CityNode montgomery = g. new CityNode("Montgomery", 1790, 1281);
		GraphDatabase.CityNode nashville = g. new CityNode("Nashville", 1777, 1201);
		GraphDatabase.CityNode frankfort = g. new CityNode("Frankfort", 1830, 1131);
		GraphDatabase.CityNode indianapolis = g. new CityNode("Indianapolis", 1794, 1077);
		GraphDatabase.CityNode atlanta = g. new CityNode("Atlanta", 1849, 1233);
		GraphDatabase.CityNode columbia = g. new CityNode("Columbia", 1945, 1223);
		GraphDatabase.CityNode tallahassee = g. new CityNode("Tallahassee", 1849, 1346);
		GraphDatabase.CityNode raleigh = g. new CityNode("Raleigh", 2004, 1212);
		GraphDatabase.CityNode richmond = g. new CityNode("Richmond", 2037, 1152);
		GraphDatabase.CityNode charleston = g. new CityNode("Charleston", 1918, 1125);
		GraphDatabase.CityNode columbus = g. new CityNode("Columbus", 1879, 1069);
		GraphDatabase.CityNode lansing = g. new CityNode("Lansing", 1849, 923);
		GraphDatabase.CityNode harrisburg = g. new CityNode("Harrisburg", 2049, 1057);
		GraphDatabase.CityNode annapolis = g. new CityNode("Annapolis", 2059, 1102);
		GraphDatabase.CityNode dover = g. new CityNode("Dover", 2084, 1096);
		GraphDatabase.CityNode trenton = g. new CityNode("Trenton", 2105, 1057);
		GraphDatabase.CityNode albany = g. new CityNode("Albany", 2122, 923);
		GraphDatabase.CityNode hartford = g. new CityNode("Hartford", 2149, 951);
		GraphDatabase.CityNode providence = g. new CityNode("Providence", 2181, 951);
		GraphDatabase.CityNode boston = g. new CityNode("Boston", 2190, 933);
		GraphDatabase.CityNode montpelier = g. new CityNode("Montpelier", 2149, 865);
		GraphDatabase.CityNode concord = g. new CityNode("Concord", 2181, 902);
		GraphDatabase.CityNode augusta = g. new CityNode("Augusta", 2218, 865);
		GraphDatabase.CityNode toronto = g. new CityNode("Toronto", 1979, 865);
		GraphDatabase.CityNode quebecCity = g. new CityNode("Quebec City", 2190, 777);
		GraphDatabase.CityNode stJohns = g. new CityNode("St. John's", 2619, 730);
		GraphDatabase.CityNode fredericton = g. new CityNode("Fredericton", 2298, 803);
		GraphDatabase.CityNode charlottetown = g. new CityNode("Charlottetown", 2381, 793);
		GraphDatabase.CityNode halifax = g. new CityNode("Halifax", 2369, 843);
		GraphDatabase.CityNode iqaluit = g. new CityNode("Iqaluit", 2298, 188);
		
		
	}
	
	public static void main(String[] args) {
		createCities();
	}
	
	
}


