package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ��Ŀ������Ǯ����
 * �����������ֵΪ1��3��5Ԫ��Ӳ�����ɣ���������ٵ�Ӳ�Ҵչ�11Ԫ��
 * ����
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
    	//���� minCoin[0]=0;��������ĳ���Ϊvalue+1;
    	int[]minCoins=new int[value+1];
    	for(int i=0;i<minCoins.length;i++){
    		//��Ĭ����С����Ϊ Ǯ������minCoins[i]=i;
    		minCoins[i]=i;
    		for(int j=0;j<a.length;j++){
    			int temp=0;
    			if(i>a[j]){
    				temp=minCoins[i-a[j]]+1;
    				minCoins[i]=min(temp,minCoins[i]);
    				System.out.println("����Ǯ��"+a[j]+"ʱ��"+"minCoins["+i+"]="+minCoins[i]);
    			}
    			
    		}
    		System.out.println("����"+"minCoins["+i+"]="+minCoins[i]);
    	}
    	
    }
	
}
