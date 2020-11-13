package application;

import java.util.*;
import java.io.*;

public class TwoDimRaggedArrayUtility {

	//private static final int MAX_ROWS = 10, MAX_COLUMNS = 10;
	//private static String[][] dataStr = null;

	public TwoDimRaggedArrayUtility(){}

	/**
	 * Returns the average of the elements in the two dimensional array
	 * @param data - a two-dimensional ragged array of doubles
	 * @return average - the average of the elements of the array
	 */
	public static double getAverage(double[][] data) {

		double total = getTotal(data), average = 0, arrayElementsSize = 0;
		try {
			for (int row = 0; row < data.length; row++) {
				arrayElementsSize += data[row].length;
			}

			if (arrayElementsSize > 0) {
				average = total / arrayElementsSize;
			}
		}

		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Index Array out of bounds exception... ");
			e.printStackTrace();
		}

		catch (Exception e) {
			System.out.println("An exception has occured... ");
			e.printStackTrace();
		}

		return average;
	}
	/*public void setAverage(double average) {
		this.average = average;
	} */

	/**
	 * Returns the total of the selected row in the two dimensional 
	 * array index 0 refers to the first row.
	 * @param data - a two-dimensional ragged array of doubles
	 * @param row - the selected row in the array
	 * @return rowTotal - total of the elements of the row selected
	 */
	public static double getRowTotal(double[][] data, int row) {

		double rowTotal = 0;
		try {
			for (int col = 0, i = row; col < data[i].length; col++) {
				rowTotal += data[i][col];
			}
		}

		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Index Array out of bounds exception... ");
			e.printStackTrace();
		}

		catch (Exception e) {
			System.out.println("An exception has occured... ");
			e.printStackTrace();
		}

		return rowTotal;
	}

	/* public void setRowTotal(double rowTotal) {
		this.rowTotal = rowTotal;
	} */

	/**
	 * Returns the total of the selected column in the two dimensional array 
	 * index 0 refers to the first column.
	 * @param data - a two-dimensional ragged array of doubles
	 * @param col - the selected column in the array
	 * @return columnTotal - total of the elements of the column selected
	 */
	public static double getColumnTotal(double[][] data, int col) {
		double columnTotal = 0;

		try {
			for (int row = 0, j = col; row < data.length; row++) {
				if (j < data[row].length) {
					columnTotal += data[row][j];
				}	
			}
		}

		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Index Array out of bounds exception... ");
			e.printStackTrace();
		}

		catch (Exception e) {
			System.out.println("An exception has occured... ");
			e.printStackTrace();
		}

		return columnTotal;
	}

	/* public void setColumnTotal(double columnTotal) {
		this.columnTotal = columnTotal;
	} */

	/**
	 * Returns the smallest element in the two dimensional array
	 * @param data - a two-dimensional ragged array of doubles
	 * @return lowestInArray - the smallest element in the array
	 */
	public static double getLowestInArray(double[][] data) {

		double lowestInArray = data[0][0];
		try {
			for (int row = 0; row < data.length; row++) {
				for (int col = 0; col < data[row].length; col++) {
					if (data[row][col] < lowestInArray) {
						lowestInArray = data[row][col];
					}
				}
			}
		}

		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Index Array out of bounds exception...");
			e.printStackTrace();
		}

		catch (Exception e) {
			System.out.println("An exception has occured... ");
			e.printStackTrace();
		}

		return lowestInArray;
	}

	/* public void setLowestInArray(double lowestInArray) {
		this.lowestInArray = lowestInArray;
	}*/

	/**
	 * Returns the largest element in the two dimensional array
	 * @param data - a two-dimensional ragged array of doubles
	 * @return highestInArray - the largest element in the array
	 */
	public static double getHighestInArray(double[][] data) {

		double highestInArray = data[0][0];
		try {
			for (int row = 0; row < data.length; row++) {
				for (int col = 0; col < data[row].length; col++) {
					if (highestInArray < data[row][col]) {
						highestInArray = data[row][col];
					}
				}
			}
		}

		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Index Array out of bounds exception... ");
			e.printStackTrace();
		}

		catch (Exception e) {
			System.out.println("An exception has occured... ");
			e.printStackTrace();
		}

		return highestInArray;
	}

	/*public void setHighestInArray(double highestInArray) {
		this.highestInArray = highestInArray;
	}*/

	/**
	 * Returns the smallest element of the selected row in the two dimensional
	 * array index 0 refers to the first row.
	 * @param data - a two-dimensional ragged array of doubles
	 * @param row - the selected row in the array
	 * @return lowestInRow - the smallest element in the selected row
	 */
	public static double getLowestInRow(double[][] data, int row) {

		double lowestInRow = data[row][0];
		try {
			for (int col = 0, i = row; col < data[i].length; col++) {
				if (data[i][col] < lowestInRow) {
					lowestInRow = data[i][col];
				}
			}
		}

		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Index Array out of bounds exception... ");
			e.printStackTrace();
		}

		catch (Exception e) {
			System.out.println("An exception has occured... ");
			e.printStackTrace();
		}

		return lowestInRow;
	}

	/*public void setLowestInRow(double lowestInRow) {
		this.lowestInRow = lowestInRow;
	}*/

	/**
	 * Returns the smallest element of the selected column in the two dimensional 
	 * array index 0 refers to the first column.
	 * @param data - a two-dimensional ragged array of doubles
	 * @param col - the selected column in the array
	 * @return lowestInColumn - the lowest element in the selected column 
	 */
	public static double getLowestInColumn(double[][] data, int col) {

		double lowestInColumn = 0;
		// Declare and create an ArrayList of Doubles that hold elements of a column
		ArrayList<Double> columnList = new ArrayList<Double>();

		try {
			for (int row = 0, j = col; row < data.length; row++) {
				if (j < data[row].length) {
					lowestInColumn = data[row][j];
					columnList.add(lowestInColumn);
				}
			}

			lowestInColumn = columnList.get(0);
			for(int k = 0; k < columnList.size(); k++) {
				if (columnList.get(k) < lowestInColumn) {
					lowestInColumn = columnList.get(k);
				}
			}
		}

		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Index Array out of bounds exception... ");
			e.printStackTrace();
		}

		catch (Exception e) {
			System.out.println("An exception has occured... ");
			e.printStackTrace();
		}

		return lowestInColumn;
	}

	/*public void setLowestInColumn(double lowestInColumn) {
		this.lowestInColumn = lowestInColumn;
	}*/

	/**
	 * Returns the largest element of the selected row in the two dimensional 
	 * array index 0 refers to the first row.
	 * @param data - a two-dimensional ragged array of doubles
	 * @param row - the selected row in the array
	 * @return highestInRow - the largest element in the selected row
	 */
	public static double getHighestInRow(double[][] data, int row) {

		double highestInRow = data[row][0];
		try {
			for (int col = 0, i = row; col < data[i].length; col++) {
				if (highestInRow < data[i][col]) {
					highestInRow = data[i][col];
				}
			}
		}

		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Index Array out of bounds exception... ");
			e.printStackTrace();
		}

		catch (Exception e) {
			System.out.println("An exception has occured... ");
			e.printStackTrace();
		}
		return highestInRow;
	}

	/*public void setHighestInRow(double highestInRow) {
		this.highestInRow = highestInRow;
	}*/

	/**
	 * Returns the largest element of the selected column in the two dimensional 
	 * array index 0 refers to the first column.
	 * @param data - a two-dimensional ragged array of doubles
	 * @param col - the selected column in the array
	 * @return highestInColumn - the highest element in the selected column
	 */
	public static double getHighestInColumn(double[][] data, int col) {

		double highestInColumn = 0;
		// Declare and create an ArrayList of Doubles that hold elements of a column
		ArrayList<Double> columnList = new ArrayList<Double>();

		try {
			for (int row = 0, j = col; row < data.length; row++) {
				if (j < data[row].length) {
					highestInColumn = data[row][j];
					columnList.add(highestInColumn);
				}
			}

			highestInColumn = columnList.get(0);
			for(int k = 0; k < columnList.size(); k++) {
				if (highestInColumn < columnList.get(k)) {
					highestInColumn = columnList.get(k);
				}
			}
		}

		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Index Array out of bounds exception: " + e);
		}

		catch (Exception e) {
			System.out.println("An exception has occured... " + e);
		}
		return highestInColumn;

	}

	/*public void setHighestInColumn(double highestInColumn) {
		this.highestInColumn = highestInColumn;
	}*/

	/**
	 * Returns the total of all the elements of the two dimensional array
	 * @param data - a two-dimensional ragged array of doubles
	 * @return total - the total of all elements in the array
	 */
	public static double getTotal(double[][] data) {

		double total = 0;
		try {
			for (int row = 0; row < data.length; row++) {
				for (int col = 0; col < data[row].length; col++) {
					total += data[row][col];
				}
			}
		}

		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Index Array out of bounds exception... ");
			e.printStackTrace();
		}

		catch (Exception e) {
			System.out.println("An exception has occured... ");
			e.printStackTrace();
		}

		return total;
	}
	/*public void setTotal(double total) {
		this.total = total;
	}*/

	/**
	 * Returns index of the largest element of the selected row in the two dimensional 
	 * array index 0 refers to the first row.
	 * @param data - a two-dimensional ragged array of doubles
	 * @param row - the selected row in the array
	 * @return highestInRowIndex - the index of the highest element in the selected row
	 */
	public static int getHighestInRowIndex(double[][] data, int row) {

		double highestInRow = getHighestInRow(data, row);
		int highestInRowIndex = 0;
		try {
			for (int col = 0; col < data[row].length; col++) {
				if (data[row][col] == highestInRow) {
					highestInRowIndex = col;
				}
			}
		}

		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Index Array out of bounds exception... ");
			e.printStackTrace();
		}

		catch (Exception e) {
			System.out.println("An exception has occured... ");
			e.printStackTrace();
		}

		return highestInRowIndex;
	}
	/*public void setHighestInRowIndex(int highestInRowIndex) {
		this.highestInRowIndex = highestInRowIndex;
	}*/

	/**
	 * Returns index of the largest element of the selected column in the two dimensional 
	 * array index 0 refers to the first column.
	 * @param data - a two-dimensional ragged array of doubles
	 * @param col - the selected column in the array
	 * @return highestInColumnIndex - the index of the highest element in the selected column
	 */
	public static int getHighestInColumnIndex(double[][] data, int col) {

		double highestInColumn = getHighestInColumn(data, col);
		int highestInColumnIndex = 0;
		try {
			for (int row = 0, j = col; row < data.length; row++) {
				if ((j < data[row].length) && (data[row][j] == highestInColumn)) {
					highestInColumnIndex = row;
				}
			}
		}

		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Index Array out of bounds exception... ");
			e.printStackTrace();
		}

		catch (Exception e) {
			System.out.println("An exception has occured... ");
			e.printStackTrace();
		}
		
		return highestInColumnIndex;
	}

	/*public void setHighestInColumnIndex(int highestInColumnIndex) {
		this.highestInColumnIndex = highestInColumnIndex;
	}*/

	/**
	 * Returns the index of the smallest element of the selected row in the two dimensional array 
	 * index 0 refers to the first row.
	 * @param data - a two-dimensional ragged array of doubles
	 * @param row - the selected row in the array
	 * @return lowestInRowIndex - the index of the lowest element in the selected row
	 */
	public static int getLowestInRowIndex(double[][] data, int row) {

		double lowestInRow = getLowestInRow(data, row);
		int lowestInRowIndex = 0;
		try {
			for (int col = 0; col < data[row].length; col++) {
				if (data[row][col] == lowestInRow) {
					lowestInRowIndex = col;
				}
			}
		}

		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Index Array out of bounds exception... ");
			e.printStackTrace();
		}

		catch (Exception e) {
			System.out.println("An exception has occured... ");
			e.printStackTrace();
		}
		
		return lowestInRowIndex;
	}
	/*public void setLowestInRowIndex(int lowestInRowIndex) {
		this.lowestInRowIndex = lowestInRowIndex;
	}*/

	/**
	 * Returns the smallest element of the selected column in the two dimensional array 
	 * index 0 refers to the first column.
	 * @param data - a two-dimensional ragged array of doubles
	 * @param col - the selected column in the array
	 * @return lowestInColumnIndex - the index of the lowest element in the selected column
	 */
	public static int getLowestInColumnIndex(double[][] data, int col) {

		double lowestInColumn = getLowestInColumn(data, col);
		int lowestInColumnIndex = 0;
		try {
			for (int row = 0, j = col; row < data.length; row++) {
				if ((j < data[row].length) && (data[row][j] == lowestInColumn)) {
					lowestInColumnIndex = row;
				}
			}
		}

		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Index Array out of bounds exception... ");
			e.printStackTrace();
		}

		catch (Exception e) {
			System.out.println("An exception has occured... ");
			e.printStackTrace();
		}

		return lowestInColumnIndex;
	}
	/*public void setLowestInColumnIndex(int lowestInColumnIndex) {
		this.lowestInColumnIndex = lowestInColumnIndex;
	}*/

	/**
	 * Reads from a file and returns a ragged array of doubles. The maximum rows 
	 * is 10 and the maximum columns for each row is 10 Each row in the file is 
	 * separated by a new line Each element in the row is separated by a space 
	 * Suggestion: You need to know how many rows and how many columns there are 
	 * for each row to create a ragged array.
	 * @param file - the file to read from
	 * @throws java.io.FileNotFoundException
	 * @return data - a two-dimensional ragged array of doubles read on the file
	 */
	public static double[][] readFile(File file) {

		double[][] data = null;
		//String[][] stringData = null;
		String[] arrayOfRowLines = null;
		String rowLine = "";
		int count = 0;
		ArrayList<String> arr = new ArrayList<String>();
		
		FileReader inputFile = null;
		BufferedReader textReader = null;
		
		try {
			file = new File("TestOut.txt");
			inputFile = new FileReader(file);
			textReader = new BufferedReader(inputFile);
			
			while(textReader.ready()) {
				count++;
				rowLine = textReader.readLine();
				arr.add(rowLine);						
			}
			
			data = new double[count][];
			for (int i = 0; i < arr.size(); i++) {
				arrayOfRowLines = arr.get(i).split(" ");
				//stringData[i] = arrayOfRowLines;
				data[i] = new double[arrayOfRowLines.length];
				
				for (int j = 0; j < arrayOfRowLines.length; j++) {
					data[i][j] = Double.parseDouble(arrayOfRowLines[j]);
				}
			}
			
			// Close the file
			textReader.close();

		} catch (FileNotFoundException e) {
			System.out.println("The file was not found... ");
			e.printStackTrace();
		}
		
		catch (Exception e) {
			System.out.println("An Exception occured at readFile... ");
			e.printStackTrace();
		}

		return data;
	}

	/**
	 * Writes the ragged array of doubles into the file. Each row is on a separate 
	 * line within the file and each double is separated by a space.
	 * @param data - two dimensional ragged array of doubles
	 * @param outputFile - the file to write to
	 * @throws java.io.FileNotFoundException - if outputFile is not valid
	 */
	public static void writeToFile(double[][] data, File outputFile) {

		try {
			outputFile = new File("TestOut.txt");
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < data.length; i++) {
				for (int j = 0; j < data[i].length; j++) {
					builder.append(data[i][j] + "");
					if (j < data.length - 1) {
						builder.append(" ");
					}
				}
				
				builder.append("\n");
			}
			
			BufferedWriter textWriter = new BufferedWriter(new FileWriter(outputFile));
			textWriter.write(builder.toString());
			textWriter.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		catch (Exception e) {
			System.out.println("An Exception occured at WriteToFile... ");
			e.printStackTrace();
		}
	}

}
