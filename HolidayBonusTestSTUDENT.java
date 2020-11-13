package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HolidayBonusTestSTUDENT {

	private double[][] dataSet1 = {{1,4,7},{11,51},{9,17,23}};

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	/**
	 * Test calculateHolidayBonus method with a high of 5000, low of 1000 and 2000 as other		 
	 */

		@Test
		public void testCalculateHolidayBonusA() {
			try{
			double[] result = HolidayBonus.calculateHolidayBonus(dataSet1,5000,1000,2000);
			assertEquals(3000.0,result[0],.001);
			}
			catch (Exception e) {
				//fail("This should not have caused an Exception");
				e.printStackTrace();
			} 
		}

}
