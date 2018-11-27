package by.bsu.triangle.action;

import java.math.BigDecimal;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.bsu.triangle.exception.TriangleException;

/**
 * The Class TriangleAction.
 */
public class TriangleAction {
	/**
	 * Logger for this class.
	 */
	private static final Logger LOGGER = LogManager.getLogger();

	/**
	 * Checks if is form triangle.
	 *
	 * @param a the a
	 * @param b the b
	 * @param c the c
	 * @return true, if is form triangle
	 * @throws TriangleException the triangle exception
	 */
	public boolean isFormTriangle(Double a, Double b, Double c) throws TriangleException {
		LOGGER.log(Level.DEBUG, "Check values a=" + a + ", b=" + b + ", c=" + c);
		if (a == null || b == null || c == null) {
			LOGGER.log(Level.ERROR, "Null side");
			throw new TriangleException("Null side provided");
		}
		if (a < 0 || b < 0 || c < 0) {
			LOGGER.log(Level.ERROR, "Negative side");
			throw new TriangleException("Negative side provided");
		}
		if (Double.isNaN(a) || Double.isNaN(b) || Double.isNaN(c)) {
			LOGGER.log(Level.ERROR, "Nan sise");
			throw new TriangleException("NaN side provided");
		}
		if (a.equals(Double.POSITIVE_INFINITY) || b.equals(Double.POSITIVE_INFINITY) || c.equals(Double.POSITIVE_INFINITY)) {
			LOGGER.log(Level.ERROR, "+Infinity side");
			throw new TriangleException("+Infinity side provided");
		}
		if (a.equals(Double.NEGATIVE_INFINITY) || b.equals(Double.NEGATIVE_INFINITY) || c.equals(Double.NEGATIVE_INFINITY)) {
			LOGGER.log(Level.ERROR, "-Infinity side");
			throw new TriangleException("-Infinity side provided");
		}
		boolean isFormTriangle = (a != 0 && b != 0 && c != 0) && (
				((BigDecimal.valueOf(a).add(BigDecimal.valueOf(b)).compareTo(BigDecimal.valueOf(c)) == 1))
				&& (BigDecimal.valueOf(b).add(BigDecimal.valueOf(c)).compareTo(BigDecimal.valueOf(a)) == 1))
				&& (BigDecimal.valueOf(c).add(BigDecimal.valueOf(a)).compareTo(BigDecimal.valueOf(b)) == 1);
		LOGGER.log(Level.DEBUG, "Provided sides " + (isFormTriangle ? "can" : "can't") + " form a triangle.");
		return isFormTriangle;
	}
}
