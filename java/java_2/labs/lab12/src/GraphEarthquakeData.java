/*
Sam Taylor
12/1/2021
CMSC256

this program connects to the Bridges API and gets the top 100 highest magnitude earthquakes of the last 5000 and plots them on a map in
various ways
*/

package cmsc256;

import bridges.base.*;
import bridges.connect.Bridges;
import bridges.connect.DataSource;
import bridges.data_src_dependent.EarthquakeUSGS;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GraphEarthquakeData {

	public static double calcDistance(double latitude1, double longitude1, double latitude2, double longitude2) {
		final int radius = 6371; // Radius of the earth in km

		// Haversine formula to calculate a value between 0 and 1 between 2 points on a sphere,
		//  1 being the opposite side of the sphere
		double laDistance = Math.toRadians(latitude2 - latitude1);
		double loDistance = Math.toRadians(longitude2 - longitude1);

		double a = Math.sin(laDistance / 2) * Math.sin(laDistance / 2)
				+ Math.cos(Math.toRadians(latitude1)) * Math.cos(Math.toRadians(latitude2))
				* Math.sin(loDistance / 2) * Math.sin(loDistance / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

		double distance = radius * c;    //convert to km
		return distance;
	}


	public static void main(String[] args) throws Exception {
		// Create a Bridges object
		Bridges bridges = new Bridges(0, "sam_tlor", "1134158751539");

		// Get a DataSource object from Bridges
		DataSource ds = bridges.getDataSource();  

		// Set an assignment title 
		bridges.setTitle("Earthquake Data Graph Lab");
		bridges.setDescription("CMSC 256, Spring 2021");

		// Initialize a Graph 
		GraphAdjListSimple<String> graph = new GraphAdjListSimple<>();

		//zeroth part
		List<EarthquakeUSGS> eq_list = ds.getEarthquakeUSGSData(5000);
		eq_list.sort(new sortByMag());

		List<EarthquakeUSGS> sorted_eq_list = new ArrayList<EarthquakeUSGS>();
		for(int i = 0; i < 100; i++){
			sorted_eq_list.add(eq_list.get(i));
		}

		//first part
		for(EarthquakeUSGS quake : sorted_eq_list){
			graph.addVertex(quake.getTitle(), quake.getTitle());
			graph.getVisualizer(quake.getTitle()).setLocation(quake.getLongit(), quake.getLatit());
			if(quake.getMagnitude() > 6){
				graph.getVisualizer(quake.getTitle()).setColor("red");
			}
		}

		bridges.setCoordSystemType("equirectangular");
		bridges.setDataStructure(graph);
		bridges.setMapOverlay(true);
		bridges.setTitle("Earthquake Map");
		bridges.visualize();

		//second part
		for(EarthquakeUSGS quake : sorted_eq_list){
			for(EarthquakeUSGS compareQuake : sorted_eq_list){
				if(quake.equals(compareQuake)){
					continue;
				}
				if (calcDistance(quake.getLatit(), quake.getLongit(), compareQuake.getLatit(), compareQuake.getLongit()) < 500){
					graph.addEdge(quake.getTitle(), compareQuake.getTitle());
				}
			}
		}
		bridges.visualize();

		//third part
		for(EarthquakeUSGS i : sorted_eq_list){
			graph.getVisualizer(i.getTitle()).setLocation(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
		}

		bridges.setMapOverlay(false);
		bridges.visualize();
	}
}

class sortByMag implements Comparator<EarthquakeUSGS>{
	public int compare(EarthquakeUSGS a, EarthquakeUSGS b){
		return Double.compare(b.getMagnitude(), a.getMagnitude());
	}
}