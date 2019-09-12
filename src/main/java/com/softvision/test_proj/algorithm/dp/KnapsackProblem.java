package com.softvision.test_proj.algorithm.dp;

public class KnapsackProblem {

	  //Recursive solution
	  public int getMaxValueKnapsack(int[] values, int[] weights, int n, int W) {
	    
	    //
	    if(n == 0 || W <= 0) {
	      return 0;
	    }
	    
	    int withoutCurrent = getMaxValueKnapsack(values, weights, n - 1, W);
	    if(weights[n-1] > W) {
	      return withoutCurrent;
	    }
	    
	    int withCurrent = values[n-1] + getMaxValueKnapsack(values, weights, n - 1, W - weights[n-1]);
	                                                        
	    return Math.max(withoutCurrent, withCurrent);
	    
	  }
	  
	  public static void main(String[] args) {
		  KnapsackProblem driver = new KnapsackProblem();
	    int val[] = new int[]{60, 100, 120}; 
	    int wt[] = new int[]{10, 20, 30};
	    int W = 50;
	    
	    int res = driver.getMaxValueKnapsack(val, wt, val.length, W);
	    //int res = driver.getMaxValueKnapsackDP(val, wt, W);
	    
	    System.out.println(res);
	    
	  }
	}
