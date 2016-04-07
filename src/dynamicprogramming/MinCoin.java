package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 最少钱币数
 * 如果我们有面值为1，3，5元的硬币若干，如何用最少的硬币凑够11元？
 */
public class MinCoin {
//	public static void minCoin(int[]coin,int typeSize,int value){
//		int[]coinUsed=new int[value+1];
//		int[] coinTrack =new int[value+1];
//		coinUsed[0]=0;
//		coinTrack[0]=0;
//		
//		for(int i=0;i<value;i++){
//			int mincoin=i;
//			int lastin=0;
//			for(int j=0;j<typeSize;j++){
//				if(coin[j]<=i){
//					
//					if(coinUsed[i-coin[j]]+1<mincoin){
//						mincoin=coinUsed[i-coin[j]]+1;
//						lastin=coin[j];
//					}
//				}
//				
//				
//			}
//			coinUsed[i]=mincoin;
//			coinTrack[i]=lastin;
//			
//		}
//		while(value>0){
//			System.out.println(coinTrack[value]);
//			value-=coinTrack[value];
//		}
//		
//	}
//	public static void main(String[] args) {
//		minCoin(new int[]{1,2,5,21,25}, 5, 63);
//	}
	public static void main(String[] args) {
        int[] a = new int[]{1,3,5};
        minCoins(a,11);
    }

    public static void minCoins(int[] a,int x) {

        int[] MIN = new int[x+1];

        MIN[0] = 0;

        for (int i = 0 ; i < MIN.length; i++) {
            //每次循环首先都要将MIN[i]设值i，也就置为最大值。
            MIN[i] = i;
            for (int j = 0;j<a.length;j++) {
                //接着要判断这次要凑的硬币是否大于最基本的三枚硬币的面值{1,3,5}，并且去除某个面值之后的硬币个数加1的总个数要小于刚刚设置的最大值
                if (i>=a[j] && (MIN[i-a[j]]+1)<MIN[i]) {
                    //要保存此次得到的最小值
                    MIN[i] = MIN[i-a[j]]+1;
                    System.out.println("Temp --> MIN["+i+"] = "+MIN[i]);
                }

            }

           System.out.println("MIN["+i+"] = "+MIN[i]);
        }
    }
	
}
