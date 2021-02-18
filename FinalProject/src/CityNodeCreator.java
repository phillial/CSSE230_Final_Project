import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;



public class CityNodeCreator {
	GraphDatabase g;
	
	public CityNodeCreator(GraphDatabase g) {
		this.g = g;
		g.cities = createCities();
	}
	
	
	public HashSet<GraphDatabase.CityNode> createCities() {
		HashSet<GraphDatabase.CityNode> cities = new HashSet<GraphDatabase.CityNode>();
		
		
		GraphDatabase.CityNode whitehorse = g. new CityNode("Whitehorse", 520, 333);
		cities.add(whitehorse);
		
		GraphDatabase.CityNode juneau = g. new CityNode("Juneau", 529, 416);
		cities.add(juneau);
		
		GraphDatabase.CityNode yellowknife = g. new CityNode("Yellowknife", 867, 268);
		cities.add(yellowknife);
		
		GraphDatabase.CityNode edmonton = g. new CityNode("Edmonton", 888, 577);
		cities.add(edmonton);
		
		GraphDatabase.CityNode victoria = g. new CityNode("Victoria", 789, 747);
		cities.add(victoria);
		
		GraphDatabase.CityNode regina = g. new CityNode("Regina", 1083, 675);
		cities.add(regina);
		
		GraphDatabase.CityNode winnipeg = g. new CityNode("Winnipeg", 1248, 692);
		cities.add(winnipeg);
		
		GraphDatabase.CityNode olympia = g. new CityNode("Olympia", 800, 794);
		cities.add(olympia);
		
		GraphDatabase.CityNode salem = g. new CityNode("Salem", 796, 866);
		cities.add(salem);
		
		GraphDatabase.CityNode sacramento = g. new CityNode("Sacramento", 839, 1084);
		cities.add(sacramento);
		
		GraphDatabase.CityNode carsonCity = g. new CityNode("Carson City", 885, 1064);
		cities.add(carsonCity);
		
		GraphDatabase.CityNode boise = g. new CityNode("Boise", 962, 906);
		cities.add(boise);
		
		GraphDatabase.CityNode helena = g. new CityNode("Helena", 1055, 805);
		cities.add(helena);
		
		GraphDatabase.CityNode saltLakeCity = g. new CityNode("Salt Lake City", 1055, 1006);
		cities.add(saltLakeCity);
		
		GraphDatabase.CityNode phoenix = g. new CityNode("Phoenix", 1055, 1259);
		cities.add(phoenix);
		
		GraphDatabase.CityNode santaFe = g. new CityNode("Santa Fe", 1225, 1177);
		cities.add(santaFe);
		
		GraphDatabase.CityNode denver = g. new CityNode("Denver", 1250, 1036);
		cities.add(denver);
		
		GraphDatabase.CityNode cheyenne = g. new CityNode("Cheyenne", 1255, 988);
		cities.add(cheyenne);
		
		GraphDatabase.CityNode bismarck = g. new CityNode("Bismarck", 1322, 794);
		cities.add(bismarck);
		
		GraphDatabase.CityNode pierre = g. new CityNode("Pierre", 1332, 879);
		cities.add(pierre);
		
		GraphDatabase.CityNode lincoln = g. new CityNode("Lincoln", 1467, 992);
		cities.add(lincoln);
		
		GraphDatabase.CityNode topeka = g. new CityNode("Topeka", 1489, 1052);
		cities.add(topeka);
		
		GraphDatabase.CityNode oklahomaCity = g. new CityNode("Oklahoma City", 1461, 1177);
		cities.add(oklahomaCity);
		
		GraphDatabase.CityNode austin = g. new CityNode("Austin", 1451, 1358);
		cities.add(austin);
		
		GraphDatabase.CityNode batonRouge = g. new CityNode("Baton Rouge", 1647, 1345);
		cities.add(batonRouge);
		
		GraphDatabase.CityNode littleRock = g. new CityNode("Little Rock", 1606, 1199);
		cities.add(littleRock);
		
		GraphDatabase.CityNode jeffersonCity = g. new CityNode("Jefferson City", 1611, 1067);
		cities.add(jeffersonCity);
		
		GraphDatabase.CityNode desMoines = g. new CityNode("Des Moines", 1547, 966);
		cities.add(desMoines);
		
		GraphDatabase.CityNode stPaul = g. new CityNode("St Paul", 1562, 851);
		cities.add(stPaul);
		
		GraphDatabase.CityNode madison = g. new CityNode("Madison", 1656, 915);
		cities.add(madison);
		
		GraphDatabase.CityNode springfield = g. new CityNode("Springfield", 1650, 1028);
		cities.add(springfield);
		
		GraphDatabase.CityNode jackson = g. new CityNode("Jackson", 1677, 1281);
		cities.add(jackson);
		
		GraphDatabase.CityNode montgomery = g. new CityNode("Montgomery", 1790, 1281);
		cities.add(montgomery);
		
		GraphDatabase.CityNode nashville = g. new CityNode("Nashville", 1777, 1201);
		cities.add(nashville);
		
		GraphDatabase.CityNode frankfort = g. new CityNode("Frankfort", 1830, 1131);
		cities.add(frankfort);
		
		GraphDatabase.CityNode indianapolis = g. new CityNode("Indianapolis", 1794, 1077);
		cities.add(indianapolis);
		
		GraphDatabase.CityNode atlanta = g. new CityNode("Atlanta", 1849, 1233);
		cities.add(atlanta);
		
		GraphDatabase.CityNode columbia = g. new CityNode("Columbia", 1945, 1223);
		cities.add(columbia);
		
		GraphDatabase.CityNode tallahassee = g. new CityNode("Tallahassee", 1849, 1346);
		cities.add(tallahassee);
		
		GraphDatabase.CityNode raleigh = g. new CityNode("Raleigh", 2004, 1212);
		cities.add(raleigh);
		
		GraphDatabase.CityNode richmond = g. new CityNode("Richmond", 2037, 1152);
		cities.add(richmond);
		
		GraphDatabase.CityNode charleston = g. new CityNode("Charleston", 1918, 1125);
		cities.add(charleston);
		
		GraphDatabase.CityNode columbus = g. new CityNode("Columbus", 1879, 1069);
		cities.add(columbus);
		
		GraphDatabase.CityNode lansing = g. new CityNode("Lansing", 1849, 923);
		cities.add(lansing);
		
		GraphDatabase.CityNode harrisburg = g. new CityNode("Harrisburg", 2049, 1057);
		cities.add(harrisburg);
		
		GraphDatabase.CityNode annapolis = g. new CityNode("Annapolis", 2059, 1102);
		cities.add(annapolis);
		
		GraphDatabase.CityNode dover = g. new CityNode("Dover", 2084, 1096);
		cities.add(dover);
		
		GraphDatabase.CityNode trenton = g. new CityNode("Trenton", 2105, 1057);
		cities.add(trenton);
		
		GraphDatabase.CityNode albany = g. new CityNode("Albany", 2122, 923);
		cities.add(albany);
		
		GraphDatabase.CityNode hartford = g. new CityNode("Hartford", 2149, 951);
		cities.add(hartford);
		
		GraphDatabase.CityNode providence = g. new CityNode("Providence", 2181, 951);
		cities.add(providence);
		
		GraphDatabase.CityNode boston = g. new CityNode("Boston", 2190, 933);
		cities.add(boston);
		
		GraphDatabase.CityNode montpelier = g. new CityNode("Montpelier", 2149, 865);
		cities.add(montpelier);
		
		GraphDatabase.CityNode concord = g. new CityNode("Concord", 2181, 902);
		cities.add(concord);
		
		GraphDatabase.CityNode augusta = g. new CityNode("Augusta", 2218, 865);
		cities.add(augusta);
		
		GraphDatabase.CityNode toronto = g. new CityNode("Toronto", 1979, 865);
		cities.add(toronto);
		
		GraphDatabase.CityNode quebecCity = g. new CityNode("Quebec City", 2190, 777);
		cities.add(quebecCity);
		
		GraphDatabase.CityNode stJohns = g. new CityNode("St. John's", 2619, 730);
		cities.add(stJohns);
		
		GraphDatabase.CityNode fredericton = g. new CityNode("Fredericton", 2298, 803);
		cities.add(fredericton);
		
		GraphDatabase.CityNode charlottetown = g. new CityNode("Charlottetown", 2381, 793);
		cities.add(charlottetown);
		
		GraphDatabase.CityNode halifax = g. new CityNode("Halifax", 2369, 843);
		cities.add(halifax);
		
		GraphDatabase.CityNode iqaluit = g. new CityNode("Iqaluit", 2298, 188);
		cities.add(iqaluit);
		
		
		return cities;
	}
	
	
}


