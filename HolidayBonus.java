package application;

public class HolidayBonus {

	/**
	 * No-arg constructor
	 */
	public HolidayBonus() {}

	/**
	 * Holiday bonuses for Retail District #5. The bonuses are calculated 
	 * based on how much each retail store sold in each category. The retail 
	 * store with the highest amount sold in a category will receive $5,000. 
	 * The retail store with the lowest amount sold in a category will receive 
	 * $1,000. All other retail stores in district #5 will receive $2,000. If a 
	 * retail store didn’t sale anything in a category, or they have a negative 
	 * sales amount, they are not eligible for a bonus in that category. If only 
	 * one retail store sold items in a category, they are eligible to receive only 
	 * the bonus of $5000 for that category.
	 * 
	 * @param data - the two dimensional array of store sales
	 * @param high - bonus for the highest store in a category
	 * @param low - bonus for the lowest store in a category
	 * @param other - bonus for all other stores in a category
	 * @return bonus - an array of bonuses
	 */
	public static double[] calculateHolidayBonus(double[][] data,
			double high, double low, double other) {

		// Array of bonuses
		double[] bonus = new double[data.length];
		int highestIndex = 0, lowestIndex = 0; // Highest and lowest sales index

		int categories = 0; // Different categories

		for (int i = 0; i < data.length; i++) {
			if (categories < data.length) {
				categories = data[i].length; 
			}
		}

		for (int i = 0; i < categories; i++) {
			highestIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, i);
			lowestIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, i);	

			/* Store not eligible for a bonus for a negative sales amount
			 * and highest bonus for having the highest sales amount in this
			 * particular category
			 */
			if (TwoDimRaggedArrayUtility.getHighestInColumn(data, i) > 0) {
				bonus[highestIndex] += high;
			}

			/* Store not eligible for a bonus for a negative sales amount
			 * and lowest bonus is given to the store different from the store
			 * with the highest sales amount
			 */
			if ((TwoDimRaggedArrayUtility.getLowestInColumn(data, i) > 0) &&
					(highestIndex != lowestIndex)) {
				bonus[lowestIndex] += low;
			}

			/* All other stores not eligible for a bonus for a negative sales amount if they
			 * are different from the stores with the highest and lowest sales amount, they
			 * are entitled to a bonus if selling in this particular category. || i > data[j].length
			 */

			for (int j = 0; j < data.length; j++) {
				if (data[i][j] <= 0 || j == highestIndex || j == lowestIndex) {
					continue;
				}
				else {

					bonus[j] += other;
				}
			}
		}

		return bonus;
	}

	/**
	 * Total bonus distributed to stores in Retail District #5.
	 * @param data - the two dimensional array of store sales
	 * @param high - bonus for the highest store in a category
	 * @param low - bonus for the lowest store in a category
	 * @param other - bonus for all other stores in a category
	 * @return total - the total bonus
	 */
	public static double calculateTotalHolidayBonus(double[][] data,
			double high, double low, double other) {

		double total = 0; // Total of the bonuses for each category

		double[] arrayOfBonuses = calculateHolidayBonus(data, high, low, other);
		for (double bonus: arrayOfBonuses) {
			total += bonus;
		}

		return total;
	}

}
