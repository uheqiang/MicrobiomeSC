/*Original implementation of chi-square performed by xiao wang,
 *  slightly by justin wagner to handle microbiome count data
 */

package perFeatureSparse;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class PrepareDataDA {
	public static void CountFre(LinkedList<Double> indices, LinkedList<Double> values, String[] content) {
		for(int i = 1; i< content.length; i++){
			if(Double.parseDouble(content[i]) > 0.0){
				indices.add(new Double(i));
				values.add(new Double(content[i]));
			}
		}
	}
	
	public static double[][] readFile(String filename) {
		File file = new File(filename);
		Scanner scanner; 
		LinkedList<Double> indices = new LinkedList<Double>();
		LinkedList<Double> values = new LinkedList<Double>();

        float numFeatures = 0;
        float numSamples = 0;
		try {
			scanner = new Scanner(file);
			String line = scanner.nextLine();
			while(scanner.hasNextLine()) {
				line = scanner.nextLine();
				String[] counts = line.split(" ");
				numFeatures = (float)counts.length-1;
				numSamples++;
				CountFre(indices, values, counts);
				//lsta.add(indices);
			}
			scanner.close();			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Double[] indicesAr = indices.toArray(new Double[0]);		
		Double[] valuesAr = values.toArray(new Double[0]);
		double[][] out = new double[2][indicesAr.length+2];

		out[0][0] = numSamples;
		out[1][0] = numSamples;

		System.out.println("num samples PrepareData :" + numSamples);
		out[0][1] = numFeatures;
		out[1][1] = numFeatures;

		System.out.println("num features PrepareData :" + numFeatures);

		for(int i = 0; i < indicesAr.length; i++){
			out[0][i+2] = indicesAr[i].doubleValue();
			out[1][i+2] =valuesAr[i].doubleValue();
		}
	
		return out;
	}
}
