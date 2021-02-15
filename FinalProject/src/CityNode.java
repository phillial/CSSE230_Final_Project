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
	
	public static void createCities() {
		CityNode whitehorse = new CityNode("Whitehorse", 520, 333);
		CityNode juneau = new CityNode("Juneau", 529, 416);
		CityNode yellowknife = new CityNode("Yellowknife", 867, 268);
		CityNode edmonton = new CityNode("Edmonton", 888, 577);
		CityNode victoria = new CityNode("Victoria", 789, 747);
		CityNode regina = new CityNode("Regina", 1083, 675);
		CityNode winnipeg = new CityNode("Winnipeg", 1248, 692);
		CityNode olympia = new CityNode("Olympia", 800, 794);
		CityNode salem = new CityNode("Salem", 796, 866);
		CityNode sacramento = new CityNode("Sacramento", 839, 1084);
		CityNode carsonCity = new CityNode("Carson City", 885, 1064);
		CityNode boise = new CityNode("Boise", 962, 906);
		CityNode helena = new CityNode("Helena", 1055, 805);
		CityNode saltLakeCity = new CityNode("Salt Lake City", 1055, 1006);
		CityNode phoenix = new CityNode("Phoenix", 1055, 1259);
		CityNode santaFe = new CityNode("Santa Fe", 1225, 1177);
		CityNode denver = new CityNode("Denver", 1250, 1036);
		CityNode cheyenne = new CityNode("Cheyenne", 1255, 988);
		CityNode bismarck = new CityNode("Bismarck", 1322, 794);
		CityNode pierre = new CityNode("Pierre", 1332, 879);
		CityNode lincoln = new CityNode("Lincoln", 1467, 992);
		CityNode topeka = new CityNode("Topeka", 1489, 1052);
		CityNode oklahomaCity = new CityNode("Oklahoma City", 1461, 1177);
		CityNode austin = new CityNode("Austin", 1451, 1358);
		CityNode batonRouge = new CityNode("Baton Rouge", 1647, 1345);
		CityNode littleRock = new CityNode("Little Rock", 1606, 1199);
		CityNode jeffersonCity = new CityNode("Jefferson City", 1611, 1067);
		CityNode desMoines = new CityNode("Des Moines", 1547, 966);
		CityNode stPaul = new CityNode("St Paul", 1562, 851);
		CityNode madison = new CityNode("Madison", 1656, 915);
		CityNode springfield = new CityNode("Springfield", 1650, 1028);
		CityNode jackson = new CityNode("Jackson", 1677, 1281);
		CityNode montgomery = new CityNode("Montgomery", 1790, 1281);
		CityNode nashville = new CityNode("Nashville", 1777, 1201);
		CityNode frankfort = new CityNode("Frankfort", 1830, 1131);
		CityNode indianapolis = new CityNode("Indianapolis", 1794, 1077);
		CityNode atlanta = new CityNode("Atlanta", 1849, 1233);
		CityNode columbia = new CityNode("Columbia", 1945, 1223);
		CityNode tallahassee = new CityNode("Tallahassee", 1849, 1346);
		CityNode raleigh = new CityNode("Raleigh", 2004, 1212);
		CityNode richmond = new CityNode("Richmond", 2037, 1152);
		CityNode charleston = new CityNode("Charleston", 1918, 1125);
		CityNode columbus = new CityNode("Columbus", 1879, 1069);
		CityNode lansing = new CityNode("Lansing", 1849, 923);
		CityNode harrisburg = new CityNode("Harrisburg", 2049, 1057);
		CityNode annapolis = new CityNode("Annapolis", 2059, 1102);
		CityNode dover = new CityNode("Dover", 2084, 1096);
		CityNode trenton = new CityNode("Trenton", 2105, 1057);
		CityNode albany = new CityNode("Albany", 2122, 923);
		CityNode hartford = new CityNode("Hartford", 2149, 951);
		CityNode providence = new CityNode("Providence", 2181, 951);
		CityNode boston = new CityNode("Boston", 2190, 933);
		CityNode montpelier = new CityNode("Montpelier", 2149, 865);
		CityNode concord = new CityNode("Concord", 2181, 902);
		CityNode augusta = new CityNode("Augusta", 2218, 865);
		CityNode toronto = new CityNode("Toronto", 1979, 865);
		CityNode quebecCity = new CityNode("Quebec City", 2190, 777);
		CityNode stJohns = new CityNode("St. John's", 2619, 730);
		CityNode fredericton = new CityNode("Fredericton", 2298, 803);
		CityNode charlottetown = new CityNode("Charlottetown", 2381, 793);
		CityNode halifax = new CityNode("Halifax", 2369, 843);
		CityNode iqaluit = new CityNode("Iqaluit", 2298, 188);
	}
	
	public static void main(String[] args) {
		createCities();
	}
	
	
}


