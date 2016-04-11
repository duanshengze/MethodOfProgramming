package dynamicprogramming;

public class MinStringEditDistance {
	public static int editDistance(String s,String t){
		
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
		int targetLength=s.length();
		int[][]dp=new int[srcLength+1][targetLength+1];
		for(int i=1;i<=srcLength;i++){
			dp[i][0]=i;
		}
		for(int i=1;i<=targetLength;i++){
			dp[0][i]=i;
		}
		
		for(int i=1;i<=srcLength;i++){
			for(int j=1;j<=targetLength;j++){
				
			}
			
			
		}
		
		for(int i)
		
	}

}
