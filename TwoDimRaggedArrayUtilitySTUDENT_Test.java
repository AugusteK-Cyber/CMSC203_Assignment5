package application;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



//import static org.junit.Assert.*;

import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.PrintWriter;
//import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.junit.After;
import org.junit.Before;
//import org.junit.Test;

public class TwoDimRaggedArrayUtilitySTUDENT_Test {
	//STUDENT fill in dataSetSTUDENT with values, it must be a ragged array
	private double[][] dataSetSTUDENT = {{2,4,8},{2,17},{1,5,9}};
	
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
	 * Student Test getTotal method
	 * Return the total of all the elements in the two dimensional array
	 */
	@Test
	public void testGetTotal() {
		//fail("Student testGetTotal not implemented");
		assertEquals(48.0,TwoDimRaggedArrayUtility.getTotal(dataSetSTUDENT),.001);
	}

	/**
	 * Student Test getAverage method
	 * Return the average of all the elements in the two dimensional array
	 */
	@Test
	public void testGetAverage() {
		//fail("Student testGetAverage not implemented");
		assertEquals(6.0,TwoDimRaggedArrayUtility.getAverage(dataSetSTUDENT),.001);
	}

	/**
	 * Student Test getRowTotal method
	 * Return the total of all the elements of the row.
	 * Row 0 refers to the first row in the two dimensional array
	 */
	@Test
	public void testGetRowTotal() {
		//fail("Student testGetRowTotal not implemented");
		assertEquals(15.0,TwoDimRaggedArrayUtility.getRowTotal(dataSetSTUDENT,2),.001);
	}


	/**
	 * Student Test getColumnTotal method
	 * Return the total of all the elements in the column. If a row in the two dimensional array
	 * doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * Column 0 refers to the first column in the two dimensional array
	 */
	@Test
	public void testGetColumnTotal() {
		//fail("Student testGetColumnTotal not implemented");
		assertEquals(26.0,TwoDimRaggedArrayUtility.getColumnTotal(dataSetSTUDENT,1),.001);
	}


	/**
	 * Student Test getHighestInArray method
	 * Return the largest of all the elements in the two dimensional array.
	 */
	@Test
	public void testGetHighestInArray() {
		//fail("Student testGetHighestInArray not implemented");
		assertEquals(17.0,TwoDimRaggedArrayUtility.getHighestInArray(dataSetSTUDENT),.001);
	}
	

	/**
	 * Test the writeToFile method
	 * write the array to the outputFile File
	 * then read it back to make sure formatted correctly to read
	 * 
	 */
	@Test
	public void testWriteToFile() {
		double[][] array=null;
		try {
			TwoDimRaggedArrayUtility.writeToFile(dataSetSTUDENT, outputFile);
		} catch (Exception e) {
			fail("This should not have caused an Exception");
		}
		array = TwoDimRaggedArrayUtility.readFile(outputFile);
		assertEquals(2.0, array[0][0],.001);
		assertEquals(4.0, array[0][1],.001);
		assertEquals(8.0, array[0][2],.001);
		assertEquals(2.0, array[1][0],.001);
		assertEquals(17.0, array[1][1],.001);
		assertEquals(1.0, array[2][0],.001);
		assertEquals(5.0, array[2][1],.001);
		assertEquals(9.0, array[2][2],.001);		
		//fail("Student testWriteToFile not implemented");	
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
			PrintWriter inFile = new PrintWriter(inputFile);//{2,4,8},{2,17},{1,5,9}
			inFile.print("2.0 4.0 8.0\n" +
					"2.0 17.0\n" +
					"1.0 5.0 9.0\n");
			inFile.close();
			array = TwoDimRaggedArrayUtility.readFile(inputFile);
			assertEquals(2.0, array[0][0],.001);
			assertEquals(4.0, array[0][1],.001);
			assertEquals(8.0, array[0][2],.001);
			assertEquals(2.0, array[1][0],.001);
			assertEquals(17.0, array[1][1],.001);
			assertEquals(1.0, array[2][0],.001);
			assertEquals(5.0, array[2][1],.001);
			assertEquals(9.0, array[2][2],.001);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			fail("This should not have caused an FileNotFoundException");
		}

		//testing that the array is a ragged array
		try{
			assertEquals(0.0, array[5][2],.001);
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
			assertEquals(0.0, array[4][4],.001);
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
