package dynamicprogramming;

/*
题目描述 
给定一个源串和目标串，能够对源串进行如下操作：
	在任意位置上插入一个字符
	替换任意字符
	删除任意字符 
	写一个程序，实现返回最小操作次数，
使得对源串进行上述这些操作后等于目标串（源串和目标串的长度都小于2000）,
这就是字符串编辑距离问*/
public class MinStringEditDistance {
	public static int dEditDistance(String s,String t){
		
		int distance=-1;
//		输入参数合法性检查
		if(null==s||t==null||s.isEmpty()||t.isEmpty()){
			return distance;
		}
//      如果字符串相等，编辑距离为0
		if(s.equals(t)){
			return 0;
		}
		
		int srcLength=s.length();
		int targetLength=t.length();
		int[][]dp=new int[srcLength+1][targetLength+1];
		for(int i=1;i<=srcLength;i++){
			dp[i][0]=i;
		}
		for(int i=1;i<=targetLength;i++){
			dp[0][i]=i;
		}
		
		for(int i=1;i<=srcLength;i++){
			for(int j=1;j<=targetLength;j++){
				
				int mid=0;
				int left=0;
				int right=0;
				if(s.charAt(i-1)==t.charAt(j-1)){
					mid=dp[i-1][j-1];
				}else{
					mid=dp[i-1][j-1]+1;//更替	
				}
				
				left=dp[i-1][j]+1;//删除r
				right=dp[i][j-1]+1;//插入
				dp[i][j]=min(left,right,mid);
				
			}
			
		}
		
		return dp[srcLength][targetLength];
		
	}
	
	
	public static int dTwoEditDistance(String s,String t){
		if(s==null||t==null||s.isEmpty()||t.isEmpty()){
			return -1;
		}
		int sLength=s.length();
		int tLength=t.length();
		int[][]dp=new int[sLength+1][tLength+1];
		for(int i=1;i<=sLength;i++){
			dp[i][0]=i;
		}
		for(int i=1;i<=tLength;i++){
			dp[0][i]=i;
		}
		for(int i=1;i<=sLength;i++){
			for(int j=1;j<=tLength;j++){
				int middle=0;
				int left=0;
				int right=0;
				
				if(s.charAt(i-1)==t.charAt(j-1)){
					middle=dp[i-1][j-1];
				}else{
					middle=dp[i-1][j-1]+2;
				}
				left=dp[i-1][j]+1;
				right=dp[i][j-1]+1;
				dp[i][j]=min(middle, left, right);
			}
			
			
		}
		return dp[sLength][tLength];
	}
	
	public static int min(int a,int b,int c){
		int min=a>b?b:a;
		min=min>c?c:min;
		return min;
		
	}
	
	public static void main(String[] args) {
		System.out.println(dEditDistance("sada", "faiaing"));
		System.out.println(dTwoEditDistance("sada", "faiaing"));
	}

}
