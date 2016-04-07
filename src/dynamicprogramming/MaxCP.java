package dynamicprogramming;
//最大连续乘积子数组
/**
 * 
 * 题目描述 
给定一个浮点数组，任意取出数组中的若干个连续的数相乘，找出其中乘积最大的子数组 
例如：给定数组{-2.5，4，0，3，0.5，8，-1} 
则取出的最大乘积数组为{3，0.5, 8}
 *
 */
public class MaxCP {
	public static double maxProductSubstring(double[]a,int length){
		double maxResult=a[0];
		double temp=1;
		for(int i=0;i<length;i++){
			temp=a[i];
			for(int j=i+1;j<length;j++){
				temp=temp*a[j];
				maxResult=max(maxResult, temp);
			}
			
		}
		return maxResult;
	}
	public static double max(double a,double b){
		return a>b?a:b;
	}
	
	public static double min(double a,double b){
		return a>b?b:a;
	}
	
//	-----动态规划算法------
	public static double dMaxProducrSubstring(double[]a,int length){
		double maxEnd=a[0];
		double minEnd=a[0];
		double maxResult=a[0];
		for(int i=1;i<length;i++){
			double end1=maxEnd*a[i];
			double end2=minEnd*a[i];
			maxEnd=max(max(end1, end2), a[i]);
			minEnd=min(min(end1, end2),a[i]);
			maxResult=max(maxEnd,maxResult);
		}
		
		return maxResult;
	}
	
	
	
	
	public static void main(String[] args) {
		double max=maxProductSubstring(new double[]{-2.5,-4,-2,-3,-4.5,-8,-1},7);
		System.out.println(max);
		System.out.println(dMaxProducrSubstring(new double[]{-2.5,-4,-2,-3,-4.5,-8,-1},7));
	}
	
}
