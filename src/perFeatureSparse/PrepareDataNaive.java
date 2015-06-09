package perFeatureSparse;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PrepareDataNaive {
	
	public static int[][] readFile(String filename) {
		File file = new File(filename);
		Scanner scanner; 
		int numRows = 0;
		int numColumns = 0;
		try {
			scanner = new Scanner(file);
			String line = scanner.nextLine();
			while(scanner.hasNextLine()) {
				numRows++;
				line = scanner.nextLine();
				String[] counts = line.split(" ");
				numColumns = counts.length-1;
			}
			scanner.close();			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int[][] mat = new int[numRows][numColumns];
		int row = 0;
		double val = 0;
		try {
			scanner = new Scanner(file);
			String line = scanner.nextLine();
			while(scanner.hasNextLine()) {
				line = scanner.nextLine();
				String[] counts = line.split(" ");
				for(int i = 0; i < counts.length-1; i++){
					val = Double.parseDouble(counts[i+1]);
					if(val > 0)
						mat[row][i] = 1;
					else
						mat[row][i] = 0;
				}
				row++;
			}
			scanner.close();			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

    	return mat;
	}
}
