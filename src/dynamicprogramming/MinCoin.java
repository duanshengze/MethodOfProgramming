package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ����Ǯ����
 * �����������ֵΪ1��3��5Ԫ��Ӳ�����ɣ���������ٵ�Ӳ�Ҵչ�11Ԫ��
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
            //ÿ��ѭ�����ȶ�Ҫ��MIN[i]��ֵi��Ҳ����Ϊ���ֵ��
            MIN[i] = i;
            for (int j = 0;j<a.length;j++) {
                //����Ҫ�ж����Ҫ�յ�Ӳ���Ƿ�������������öӲ�ҵ���ֵ{1,3,5}������ȥ��ĳ����ֵ֮���Ӳ�Ҹ�����1���ܸ���ҪС�ڸո����õ����ֵ
                if (i>=a[j] && (MIN[i-a[j]]+1)<MIN[i]) {
                    //Ҫ����˴εõ�����Сֵ
                    MIN[i] = MIN[i-a[j]]+1;
                    System.out.println("Temp --> MIN["+i+"] = "+MIN[i]);
                }

            }

           System.out.println("MIN["+i+"] = "+MIN[i]);
        }
    }
	
}
