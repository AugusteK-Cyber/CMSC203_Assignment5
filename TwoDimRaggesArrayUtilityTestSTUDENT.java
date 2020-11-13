package application;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.junit.After;
import org.junit.Before;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TwoDimRaggesArrayUtilityTestSTUDENT {
	
	//dataSetSTUDENT has negative elements as well as positive
	private double[][] dataSetSTUDENT = {{-6,-3, 4},{-4.5, 18.5},{10.5,-5.5}};
	private File inputFile,outputFile;
	
	@Before
	public void setUp() throws Exception {
		outputFile = new File("TestOut.txt");
	}

	@After
	public void tearDown() throws Exception {
		dataSetSTUDENT = null;
		inputFile = outputFile = null;
	}

	/**
	 * Test getTotal method
	 * Returns the total of all the elements in the two dimensional array
	 */
	@Test
	public void testGetTotal() {
		assertEquals(14.0,TwoDimRaggedArrayUtility.getTotal(dataSetSTUDENT),.001);
	}

	/**
	 * Test getAverage method
	 * Returns the average of all the elements in the two dimensional array
	 */
	@Test
	public void testGetAverage() {
		assertEquals(2.0,TwoDimRaggedArrayUtility.getAverage(dataSetSTUDENT),.001);
	}
	
	/**
	 * Test getRowTotal method
	 * Returns the total of all the elements of the row.
	 * Row 0 refers to the first row in the two dimensional array
	 */
	@Test
	public void testGetRowTotal() {
		assertEquals(-5.0,TwoDimRaggedArrayUtility.getRowTotal(dataSetSTUDENT,0),.001);
	}
	
	/**
	 * Test getColumnTotal method
	 * Returns the total of all the elements in the column. If a row in the two dimensional array
	 * doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * Column 0 refers to the first column in the two dimensional array
	 */
	@Test
	public void testGetColumnTotal() {
		assertEquals(10.0,TwoDimRaggedArrayUtility.getColumnTotal(dataSetSTUDENT,1),.001);
	}
	
	/**
	 * Test getHighestInRow method
	 * Returns the largest of all the elements in the row.
	 * Row 0 refers to the first row in the two dimensional array
	 */
	@Test
	public void testGetHighestInRow() {
		assertEquals(10.5,TwoDimRaggedArrayUtility.getHighestInRow(dataSetSTUDENT,2),.001);
	}
	
	/**
	 * Test getHighestInRowIndex method
	 * Returns the index of the largest of all the elements in the row.
	 * Row 0 refers to the first row in the two dimensional array
	 */
	@Test
	public void testGetHighestInRowIndex() {
		assertEquals(2,TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSetSTUDENT,0));
	}
	
	/**
	 * Test getLowestInRowIndex method
	 * Returns the index of the smallest of all the elements in the row.
	 * Row 0 refers to the first row in the two dimensional array
	 */
	@Test
	public void testGetLowestInRowIndex() {
		assertEquals(1,TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSetSTUDENT,2));
	}

	/**
	 * Test getLowestInRow method
	 * Returns the smallest of all the elements in the row.
	 * Row 0 refers to the first row in the two dimensional array
	 */
	@Test
	public void testGetLowestInRow() {
		assertEquals(-6.0,TwoDimRaggedArrayUtility.getLowestInRow(dataSetSTUDENT,0),.001);
	}

	/**
	 * Test getHighestInColumn method
	 * Returns the largest of all the elements in the column. If a row in the two dimensional array
	 * doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * Column 0 refers to the first column in the two dimensional array
	 */
	@Test
	public void testGetHighestInColumn() {
		assertEquals(4.0,TwoDimRaggedArrayUtility.getHighestInColumn(dataSetSTUDENT,2),.001);
	}

	/**
	 * Test getHighestInColumn method
	 * Returns the index of the largest of all the elements in the column. If a row in the two dimensional array
	 * doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * Column 0 refers to the first column in the two dimensional array
	 */
	@Test
	public void testGetHighestInColumnIndex() {
		assertEquals(1,TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSetSTUDENT,1));
	}
	
	/**
	 * Test getLowestInColumn method
	 * Returns the smallest of all the elements in the column. If a row in the two dimensional array
	 * doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * Column 0 refers to the first column in the two dimensional array
	 */

	@Test
	public void testGetLowestInColumn() {
		assertEquals(-5.5,TwoDimRaggedArrayUtility.getLowestInColumn(dataSetSTUDENT,1),.001);
	}

	/**
	 * Test getLowestInColumnIndex method
	 * Returns the index of the smallest of all the elements in the column. If a row in the two dimensional array
	 * doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * Column 0 refers to the first column in the two dimensional array
	 */

	@Test
	public void testGetLowestInColumnIndex() {
		assertEquals(0,TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSetSTUDENT,0));
	}
	
	/**
	 * Test getHighestInArray method
	 * Returns the largest of all the elements in the two dimensional array.
	 */
	@Test
	public void testGetHighestInArray() {
		assertEquals(18.5,TwoDimRaggedArrayUtility.getHighestInArray(dataSetSTUDENT),.001);
	}

	/**
	 * Test getLowestInArray method
	 * Returns the smallest of all the elements in the two dimensional array.
	 */
	@Test
	public void testGetLowestInArray() {
		assertEquals(-6.0,TwoDimRaggedArrayUtility.getLowestInArray(dataSetSTUDENT),.001);
	}
	
	/**
	 * Test the writeToFile method
	 * write the array to the outputFile File
	 * then read it back to make sure formatted correctly to read
	 * 
	 */
	@Test
	public void testWriteToFile() throws FileNotFoundException {
		double[][] array=null;
		try {
			TwoDimRaggedArrayUtility.writeToFile(dataSetSTUDENT, outputFile);
		} catch (Exception e) {
			fail("This should not have caused an Exception");
		}
		array = TwoDimRaggedArrayUtility.readFile(outputFile);
		assertEquals(-6.0, array[0][0],.001);
		assertEquals(-3.0, array[0][1],.001);
		assertEquals(4.0, array[0][2],.001);
		assertEquals(-4.5, array[1][0],.001);
		assertEquals(18.5, array[1][1],.001);
		assertEquals(10.5, array[2][0],.001);
		assertEquals(-5.5, array[2][1],.001);		
	}
	
	/**
	 * Test the readFile method
	 * reads from a file and then test that the returned two dimensional array of doubles
	 * is ragged.
	 */
	@Test
	public void testReadFile() {
		double[][] array=null;
		try {
			inputFile = new File("TestOut.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.print("-6.0 -3.0 4.0\n" +
					"-4.5 18.5\n" +
					"10.5 -5.5\n" +
					"-4.2 7.3 -5.9 2.6");
			inFile.close();
			array = TwoDimRaggedArrayUtility.readFile(inputFile);
			assertEquals(-6.0, array[0][0],.001);
			assertEquals(-3.0, array[0][1],.001);
			assertEquals(4.0, array[0][2],.001);
			assertEquals(-4.5, array[1][0],.001);
			assertEquals(18.5, array[1][1],.001);
			assertEquals(10.5, array[2][0],.001);
			assertEquals(-5.5, array[2][1],.001);	

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			fail("This should not have caused an FileNotFoundException");
		}

		//testing that the array is a ragged array
		try{
			assertEquals(0.0, array[1][2],.001);
			fail("This should have caused a ArrayIndexOutOfBoundsException");

		} catch (ArrayIndexOutOfBoundsException e){

			assertTrue("Correctly threw ArrayIndexOutOfBoundsException", true);
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			fail("This should not have caused an Exception");
		}

		//testing that the array is a ragged array
		try{
			assertEquals(0.0, array[2][2],.001);
			fail("This should have caused a ArrayIndexOutOfBoundsException");

		} catch (ArrayIndexOutOfBoundsException e){

			assertTrue("Correctly threw ArrayIndexOutOfBoundsException", true);
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			fail("This should not have caused an Exception");
		}
	}
	

}
