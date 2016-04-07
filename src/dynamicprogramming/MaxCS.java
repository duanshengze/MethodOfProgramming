package dynamicprogramming;
//�������

/*
 * һ����N������Ԫ�ص�һλ����(A[0], A[1],...,A[n-1], A[n])��������鵱Ȼ�кܶ������飬��ô����֮�͵����ֵ��ʲô�أ�

	����һ���ܼ򵥵���Ŀ������Ҫ��д��ʱ�临�Ӷ�ΪO(n)�����Žⷨ������Ҫ��ϸ�����µġ�

	���������� int A[5] = {-1, 2, 3, -4, 2};

	����������������Ϊ  2,3  ����Ϊ 5;
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
