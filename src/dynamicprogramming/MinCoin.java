package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目：最少钱币数
 * 如果我们有面值为1，3，5元的硬币若干，如何用最少的硬币凑够11元？
 * 分析
 * http://www.wisim.me/algorithm/2015/05/13/DP_MinCoins.html
 * 
 */
public class MinCoin {

	public static void main(String[] args) {
        int[] a = new int[]{1,2,5,21,25};
        minCoins(a,63);
    }
	
	private static int min(int a,int b) {
		return a>b?b:a;

	}
    public static void minCoins(int[] a,int value) {
    	//包括 minCoin[0]=0;所以数组的长度为value+1;
    	int[]minCoins=new int[value+1];
    	for(int i=0;i<minCoins.length;i++){
    		//先默认最小数量为 钱数本身即minCoins[i]=i;
    		minCoins[i]=i;
    		for(int j=0;j<a.length;j++){
    			int temp=0;
    			if(i>a[j]){
    				temp=minCoins[i-a[j]]+1;
    				minCoins[i]=min(temp,minCoins[i]);
    				System.out.println("遇到钱币"+a[j]+"时，"+"minCoins["+i+"]="+minCoins[i]);
    			}
    			
    		}
    		System.out.println("最终"+"minCoins["+i+"]="+minCoins[i]);
    	}
    	
    }
	
}
