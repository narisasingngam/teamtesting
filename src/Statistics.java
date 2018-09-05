import java.util.Arrays;

/**
 * Methods for computing some common statistics, such as average, variance, and
 * correlation.
 */
public class Statistics {

	/**
	 * Compute the arithmetic average of an array of numbers.
	 * 
	 * @param x
	 *            is array to compute average of. Must not be null.
	 * @return the arithmetic average of values in x, or 0 if x is empty.
	 */
	public static double average(double[] x) {
		// Some fun: sum using a Stream instead of a loop.
		double sum = Arrays.stream(x).sum();
		return sum / x.length;
	}

	/**
	 * Compute the variance of values in an array.
	 * Variance uses the formula sum(x[k]*x[k])/length(x) - average(x)^2.
	 * 
	 * @param x is the array of values. Must contain at least 1 element.
	 * @return the variance of x
	 * @throws IllegalArgumentException if x is empty
	 */
	public static double variance(double[] x) {
		double sum = 0;
		double variance = 0;
		if(x.length == 0){
			throw new IllegalArgumentException("Array is empty");
		}
		for (int i = 0; i < x.length ; i++) {
			sum = sum + x[i]*x[i];
		}
		variance = (sum/x.length) - Math.pow(average(x), 2);
		
		return variance;
	}

	/**
	 * Compute the covariance between arrays x and y. The covariance is defined
	 * by
	 * 
	 * sum[ (x[k] - average(x)) * (y[k] - average(y)) ]/n where n is number of
	 * elements in the arrays.
	 * 
	 * But it is more efficient to compute using the equivalent formula:
	 * 
	 * sum( x[k]*y[k] )/n - average(x)*average(y)
	 * 
	 * Note that if x == y, this is the variance.
	 * 
	 * @param x
	 *            is the first array of values.
	 * @param y
	 *            is the second array of values
	 * @return the covariance between x and y
	 * @throws IllegalArgumentException
	 *             if arrays are not same length or length is 0.
	 */
	public static double covariance(double[] x, double[] y) {
		double covariance = 0;
		double sum = 0;
		
		if(x.length != y.length || x.length == 0 || y.length == 0){
			throw new IllegalArgumentException("Arrays are not same length or length is 0.");
		}
		
		if(x == y){
			return variance(x);
		}
		
		for (int i = 0; i < y.length; i++) {
				sum = sum+((x[i] - average(x)) * (y[i] - average(y)));
		}
		
		covariance = (sum/(y.length-1));
		
		
		return covariance;
	}

}
