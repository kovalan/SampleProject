package com.sample.service;

import java.util.HashMap;
import java.util.Map;

/**
 * Utility class to retrieve most occurring element of the two integer arrays.
 * @author kvenkate
 *
 */
public class MostOccurringElement {

	/**
	 * Function to retrieve most occurring element of the two integer arrays.
	 * @param array1 - first integer array
	 * @param array2 - second integer array
	 * @return - return Tuple -  for valid input arrays, returns tuple containing most occurring element and its count.
	 * 						  -  for invalid/empty arrays, returns null.
	 */
	public static Tuple getMostOccurringElement(int[] array1, int[] array2) {
		
		Tuple mostOccurTuple = null;
		
		// Check if arrays are not null or empty
		if(array1!=null && array2!=null && array1.length !=0 && array2.length !=0) {
			
			int mostOccurCount = 0, mostOccurElmt =0 , mostOccurCountInArray1=0;
			
			Map<Integer, Integer> aMap = new HashMap<Integer, Integer>();
			// Count and save the no. of times each element appears in the first array
			for (int i : array1) {
				Integer firstArrElmtCount = aMap.get(i);
				firstArrElmtCount = firstArrElmtCount != null ? firstArrElmtCount+1 : 1;
				aMap.put(i, firstArrElmtCount);
				if(firstArrElmtCount > mostOccurCountInArray1) {
					mostOccurCountInArray1 = firstArrElmtCount;
				}
			}
				
			Map<Integer, Integer> bMap = new HashMap<Integer, Integer>();		
			// Count and save the no. of times each element appears in the second array and
			// check if the most occurring element in both the arrays.
			for (int i : array2) {
				
				Integer secondArrElmtCount = bMap.get(i);
				secondArrElmtCount  = secondArrElmtCount != null ? secondArrElmtCount+1 : 1;
				bMap.put(i, secondArrElmtCount);
				    
				Integer firstArrElmtCount = aMap.get(i);				    
				if(firstArrElmtCount !=null) {
					
					// Take the least of the 2 counts to ensure the element occurs in pair
					int lesserCountOfTheTwo = firstArrElmtCount <= secondArrElmtCount ? firstArrElmtCount : secondArrElmtCount;
					
					// If the count of the current element is greater than the previous most occur count,
				    // set this as the new mostOccurCount and save the element as well.
				    if(lesserCountOfTheTwo > mostOccurCount) {
				    	mostOccurCount = lesserCountOfTheTwo;
				    	mostOccurElmt = i;
				    	// Since the max possible count is already reached, no need to iterate array2 further
				    	if(mostOccurCount == mostOccurCountInArray1) {
				    		break;
				    	}
				    }
				}
				    
			}
			
			if(mostOccurCount > 0) {
				mostOccurTuple = new Tuple(mostOccurElmt, mostOccurCount);
			}
		}
		return mostOccurTuple;
		
	}
	
	public static class Tuple { 
		public final Integer mostOccurElmt; 
		public final Integer occurCount; 
		public Tuple(Integer mostOccurElmt, Integer occurCount) { 
			this.mostOccurElmt = mostOccurElmt; 
		    this.occurCount = occurCount; 
		}
	}

}
