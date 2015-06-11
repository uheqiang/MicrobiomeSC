/*Original implementation of chi-square performed by xiao wang,
 *  slightly by justin wagner to handle microbiome count data
 */

package perFeatureOddsRatio;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

import perFeatureOddsRatio.Statistics;

public class PrepareData {
	
	public static void CountFre(Statistics sta, String[] content) {
		sta.totalNum = content.length-1;
		for(int i = 1; i< content.length; i++){
			if(Double.parseDouble(content[i]) > 0.0){
				sta.numOfPresent++;
			}
		}
	}
	
	public static class StatisticsData {
		public Statistics[] data;
		public int numberOftuples;
	}
	
	public static StatisticsData readFile(String filename) {
		File file = new File(filename);
		Scanner scanner; 
		StatisticsData d = new StatisticsData(); 
		LinkedList<Statistics> lsta = new LinkedList<Statistics>();
		int counter = 0;
		try {
			scanner = new Scanner(file);
			String line = scanner.nextLine();
			while(scanner.hasNextLine()) {
				Statistics sta = new Statistics();
				line = scanner.nextLine();
				String[] counts = line.split(" ");
				CountFre(sta, counts);
				lsta.add(sta);
				counter++;
			}
			scanner.close();			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		d.data = lsta.toArray(new Statistics[0]);
		d.numberOftuples = counter;
		return d;
	}
}
