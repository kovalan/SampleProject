package com.sample.test;

import org.junit.Assert;
import org.junit.Test;

import com.sample.service.MostOccurringElement;
import com.sample.service.MostOccurringElement.Tuple;

/**
 * Junit test class to test the getMostOccurringElement() utility function of MostOccurringElement class
 * @author kvenkate
 *
 */
public class MostOccurringElementTest {

	@Test
	public void testRtnElmtWithValidArrays() {
		
		int a[] = {1,0,3,2,1,2,5,2,0,2};
		int b[] = {1,1,6,0,2,10,2,0,1,3,2,9};
		Tuple mostOccurTuple = MostOccurringElement.getMostOccurringElement(a, b);
		
		Assert.assertTrue(mostOccurTuple.mostOccurElmt == 2);
	}
	
	@Test
	public void testRtnCountWithValidArrays() {
		
		int a[] = {1,0,3,2,1,2,5,2,0,2};
		int b[] = {1,1,6,0,2,10,2,0,1,3,2,9};
		Tuple mostOccurTuple = MostOccurringElement.getMostOccurringElement(a, b);
		
		Assert.assertTrue(mostOccurTuple.occurCount == 3);
		
	}
	
	@Test
	public void testRtnElmtWithOneElmtArray() {
		
		int a[] = {1};
		int b[] = {1,1,6,0,2,10,2,0,1,3,2,9};
		Tuple mostOccurTuple = MostOccurringElement.getMostOccurringElement(a, b);
		
		Assert.assertTrue(mostOccurTuple.mostOccurElmt == 1);
	}
	
	@Test
	public void testRtnCountWithOneElmtArray() {
		
		int a[] = {1};
		int b[] = {1};
		Tuple mostOccurTuple = MostOccurringElement.getMostOccurringElement(a, b);
		
		Assert.assertTrue(mostOccurTuple.occurCount == 1);
		
	}
	
	@Test
	public void testWithNullFirstArray() {
		
		int a[] = null;
		int b[] = {1,1,6,0,2,10,2,0,1,3,2,9};
		Tuple mostOccurTuple = MostOccurringElement.getMostOccurringElement(a, b);
		
		Assert.assertNull(mostOccurTuple);
		
	}
	
	@Test
	public void testWithNullSecondArray() {
		
		int a[] = {1,0,3,2,1,2,5,2,0,2};
		int b[] = null;
		Tuple mostOccurTuple = MostOccurringElement.getMostOccurringElement(a, b);
		
		Assert.assertNull(mostOccurTuple);
		
	}
	
	@Test
	public void testWithEmptyArray() {
		
		int a[] = new int[0];
		int b[] = {1,1,6,0,2,10,2,0,1,3,2,9};
		Tuple mostOccurTuple = MostOccurringElement.getMostOccurringElement(a, b);
		
		Assert.assertNull(mostOccurTuple);
		
	}
	
	@Test
	public void testWithNoCommonElementsArray() {
		
		int a[] = {-1, 8, 13, -8, 99, 7};
		int b[] = {1,1,6,0,2,10,2,0,1,3,2,9};
		Tuple mostOccurTuple = MostOccurringElement.getMostOccurringElement(a, b);
		
		Assert.assertNull(mostOccurTuple);
		
	}
	
	
}
