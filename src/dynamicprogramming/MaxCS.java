package dynamicprogramming;
//连续求和

/*
 * 一个有N个整数元素的一位数组(A[0], A[1],...,A[n-1], A[n])，这个数组当然有很多子数组，那么数组之和的最大值是什么呢？

	这是一道很简单的题目，但是要想写出时间复杂度为O(n)的最优解法还是需要仔细推敲下的。

	例如有数组 int A[5] = {-1, 2, 3, -4, 2};

	符合条件的子数组为  2,3  即答案为 5;
 */
public class MaxCS {
	
	public static double maxSumSubString(double[]a,int length){
		double maxResult=a[0];
		for(int i=0;i<length;i++){
			double temp=a[i];
			for(int j=i+1;j<length;j++){
				temp=temp+a[j];
				maxResult=max(temp, maxResult);	
			}
		}
		return maxResult;
		
	}
	public static double dMaxSumSubstring(double[]a,int length){
		double maxEnd=a[0];
		double minEnd=a[0];
		double resultMax=a[0];
		for(int i=1;i<length;i++){
			double end1=maxEnd+a[i];
			double end2=minEnd+a[i];
			maxEnd=max(max(end2,end1),a[i]);
			minEnd=min(min(end1,end2),a[i]);
			resultMax=max(maxEnd, resultMax);
			
		}
		return resultMax;
		
	}
	public static double max(double a,double b){
		return a>b?a:b;
	} 
	
	public static double min(double a,double b){
		return a>b?b:a;
	}
	public static void main(String[] args) {
		System.out.println(dMaxSumSubstring(new double[]{1, -2, 3, 5, -3, 2}, 6));
		System.out.println(maxSumSubString(new double[]{1, -2, 3, 5, -3, 2}, 6));
	}
}
