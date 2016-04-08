package dynamicprogramming;

import java.util.Arrays;
import java.util.List;

/*
 *>          ，并写出算法的时间复杂度。
  >例如：给定数组{-1，-3，-5，6}
  >则取出的最大乘积数组为{-3，-5，6}
 */
public class MaxCombinationProduct {
	
	public static double dMaxCombinationProduct(double[]a,int length){
		if(a==null||length==0)return 0;
		
		double max=a[0];
		boolean init=true;
		double[] left=new double[length];
		double[] right=new double[length];
		left[0]=a[0];
		right[length-1]=a[length-1];
		
		for(int i=1;i<length;i++){
			left[i]=left[i-1]*a[i];
		}
		for(int i=length-2;i>=0;i--){
			right[i]=right[i+1]*a[i];
		}
		
	
		
		double leftP;
		double rightP;
		double p;
		for(int i=0;i<length;i++){
			 leftP=(i==0?1:left[i-1]);
			 rightP=(i==length-1?1:right[i+1]);
			 p=leftP*rightP;
			 if(init){
				 max=p;
				 init=false;
			 }
			 max=max>p?max:p;
		}
		
		
		return max;
		
	}
	public static double maxCombinationProduct(double[]a,int length){
		
		double maxResult=1;
		boolean init=true;
		for(int i=0;i<length;i++){
			//用于存放a[i]的值方便之后还原
			double temp=a[i];
			a[i]=1.0;
			double tempProduct=1;
			for(int j=0;j<length;j++){
				
	
				tempProduct*=a[j];
			}
			
			a[i]=temp;
			if(init){
				maxResult=tempProduct;
				init=false;
			}
			maxResult=max(tempProduct, maxResult);
		}
		return maxResult;
	}
	
	public static double max(double a,double b){
		return a>b?a:b;
	}
	
	public static void main(String[] args) {
		System.out.println(maxCombinationProduct(new double[]{-1.0,-8.0,-5.0,-6.0}, 4));
		System.out.println(dMaxCombinationProduct(new double[]{-1.0,-8.0,-5.0,-6.0}, 4));
	}
}
