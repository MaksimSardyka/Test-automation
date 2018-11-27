package test.by.bsu.triangle.action;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.bsu.triangle.action.TriangleAction;
import by.bsu.triangle.exception.TriangleException;

public class TriangleActionTest {
	public TriangleAction triangleAction;
	
	@BeforeSuite
	public void init(){
		this.triangleAction = new TriangleAction();
	}
	
	@DataProvider(name = "null side")
	public Double[][] nullSides(){
		return new Double[][] {
			{null,1.0,1.0},
			{1.0,null,1.0},
			{1.0,1.0,null},
			{null,null,1.0},
			{1.0,null,null},
			{null,1.0,null},
			{null,null,null},
		};
	}

	@DataProvider(name = "negative side")
	public Double[][] negativeSides(){
		return new Double[][] {
			{-1.0,1.0,1.0},
			{1.0,-1.0,1.0},
			{1.0,1.0,-1.0},
			{-1.0,-1.0,1.0},
			{1.0,-1.0,-1.0},
			{-1.0,1.0,-1.0},
			{-1.0,-1.0,-1.0},
		};
	}
	
	@DataProvider(name = "zero side")
	public Double[][] zeroSides(){
		return new Double[][] {
			{0.0,1.0,1.0},
			{1.0,0.0,1.0},
			{1.0,1.0,0.0},
			{0.0,0.0,1.0},
			{0.0,1.0,0.0},
			{1.0,0.0,0.0},
			{0.0,0.0,0.0}
		};
	}
	
	@DataProvider(name = "nan side")
	public Double[][] nanSides(){
		return new Double[][] {
			{Double.NaN,1.0,1.0},
			{1.0,Double.NaN,1.0},
			{1.0,1.0,Double.NaN},
			{Double.NaN,Double.NaN,1.0},
			{1.0,Double.NaN,Double.NaN},
			{Double.NaN,1.0,Double.NaN},
			{Double.NaN,Double.NaN,Double.NaN}
		};
	}
	
	@DataProvider(name = "positive infinity side")
	public Double[][] positiveInfinitySides(){
		return new Double[][] {
			{Double.POSITIVE_INFINITY,1.0,1.0},
			{1.0,Double.POSITIVE_INFINITY,1.0},
			{1.0,1.0,Double.POSITIVE_INFINITY},
			{Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY,1.0},
			{1.0,Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY},
			{Double.POSITIVE_INFINITY,1.0,Double.POSITIVE_INFINITY},
			{Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY}
		};
	}
	
	@DataProvider(name = "negative infinity side")
	public Double[][] negativeInfinitySides(){
		return new Double[][] {
			{Double.NEGATIVE_INFINITY,1.0,1.0},
			{1.0,Double.NEGATIVE_INFINITY,1.0},
			{1.0,1.0,Double.NEGATIVE_INFINITY},
			{Double.NEGATIVE_INFINITY,Double.NEGATIVE_INFINITY,1.0},
			{1.0,Double.NEGATIVE_INFINITY,Double.NEGATIVE_INFINITY},
			{Double.NEGATIVE_INFINITY,1.0,Double.NEGATIVE_INFINITY},
			{Double.NEGATIVE_INFINITY,Double.NEGATIVE_INFINITY,Double.NEGATIVE_INFINITY}
		};
	}
	
	@DataProvider(name = "sides")
	public Object[][] maxValue(){
		return new Object[][] {
			{false, 100.0, 1.0, 1.0},
			{false, 1.0, 100.0, 1.0},
			{false, 1.0, 1.0, 100.0},
			{true, 100.0, 100.0, 1.0},
			{true, 1.0, 100.0, 100.0},
			{true, 100.0, 1.0, 100.0},
			{true, 1.0, 1.0, 1.0},
		};
	}
	
	@DataProvider(name = "max value side")
	public Object[][] sides(){
		return new Object[][] {
			{false, Double.MAX_VALUE, 1.0, 1.0},
			{false, 1.0, Double.MAX_VALUE, 1.0},
			{false, 1.0, 1.0, Double.MAX_VALUE},
			{true, Double.MAX_VALUE, Double.MAX_VALUE, 1.0},
			{true, 1.0, Double.MAX_VALUE, Double.MAX_VALUE},
			{true, Double.MAX_VALUE, 1.0, Double.MAX_VALUE},
			{true, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE},
		};
	}
	
	@Test(expectedExceptions = TriangleException.class, dataProvider = "null side", groups= {"functest"})
	public void isFormTriangleNullSideTest(Double a, Double b, Double c) throws TriangleException{
		triangleAction.isFormTriangle(a, b, c);
	}
	
	@Test(expectedExceptions = TriangleException.class, dataProvider = "negative side", groups= {"functest"})
	public void isFormTriangleNegativeSideTest(Double a, Double b, Double c) throws TriangleException{
		triangleAction.isFormTriangle(a, b, c);
	}
	
	@Test(expectedExceptions = TriangleException.class, dataProvider = "nan side", groups= {"functest"})
	public void isFormTriangleNaNTest(Double a, Double b, Double c) throws TriangleException{
		triangleAction.isFormTriangle(a, b, c);
	}
	
	@Test(expectedExceptions = TriangleException.class, dataProvider = "positive infinity side", groups= {"functest"})
	public void isFormTrianglePositiveInfinityTest(Double a, Double b, Double c) throws TriangleException{
		triangleAction.isFormTriangle(a, b, c);
	}
	
	@Test(expectedExceptions = TriangleException.class, dataProvider = "negative infinity side", groups= {"functest"})
	public void isFormTriangleNegativeInfinityTest(Double a, Double b, Double c) throws TriangleException{
		triangleAction.isFormTriangle(a, b, c);
	}
	
	@Test(dataProvider = "zero side", groups= {"functest"})
	public void isFormTriangleZeroSideTest(Double a, Double b, Double c) throws TriangleException{
			Assert.assertFalse(triangleAction.isFormTriangle(a, b, c));
	}
	
	@Test(dataProvider = "max value side", groups= {"functest"})
	public void isFormTriangleMaxValueSideTest(Object[] parameters) throws TriangleException{
		Assert.assertEquals(parameters[0], triangleAction.isFormTriangle((Double)parameters[1],(Double)parameters[2],(Double)parameters[3]));
	}

	@Test(dataProvider = "sides", groups= {"checkintest", "functest"})
	public void isFormTriangleTest(Object[] parameters) throws TriangleException{
		Assert.assertEquals(parameters[0], triangleAction.isFormTriangle((Double)parameters[1],(Double)parameters[2],(Double)parameters[3]));
	}
}
