package perFeatureDifferentialAbundance;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

import perFeatureDifferentialAbundance.Statistics;

public class PrepareData {
	
	public static void CountFre(Statistics dataCounts, String[] content) {
		dataCounts.sumOfSquares = 0.0;
		for(int i = 1; i < content.length; i++){
			dataCounts.sumOfSquares += (Double.parseDouble((content[i]))*Double.parseDouble((content[i])));
			dataCounts.totalSum += Double.parseDouble((content[i]));
			if(Double.parseDouble(content[i]) > 0.0){
				dataCounts.numOfPresent++;
			}
		}
		dataCounts.numOfSamples = content.length-1;
	}
	
	public static class StatisticsData {
		public Statistics[] data;
		public int numOfTuples;
	}
	
	public static StatisticsData readFile(String filename) {
		File file = new File(filename);
		Scanner scanner; 
		StatisticsData d = new StatisticsData(); 
		LinkedList<Statistics> lsta = new LinkedList<Statistics>();
		try {
			scanner = new Scanner(file);
			String line = scanner.nextLine();
			while(scanner.hasNextLine()) {
				Statistics sta = new Statistics();
				line = scanner.nextLine();
				
				String[] counts = line.split(" ");
				CountFre(sta, counts);
				lsta.add(sta);
			}
			scanner.close();			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		d.data = lsta.toArray(new Statistics[0]);
		d.numOfTuples = d.data.length;
		return d;
	}
}
