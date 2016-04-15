package dynamicprogramming;
/*题目描述 
输入三个字符串s1、s2、s3，
判断第三个字符串s3是否由前两个字符串s1和s2交错而成且不改变s1和s2中各个字符原有的相对顺序，
例如,如果 s1=”aabcc”,s2=”dbbbca”,s3=”aadbbcbcac”,
则输出true；
如果是s1=”aabcc”,s2=”dbbca”,s3=”accabdbbca”,
则输出false*/
public class AlternatingString {
	public static boolean dIsStaggeredComposition(String s1,String s2,String s3){
		int n=s1.length();
		int m=s2.length();
		int s=s3.length();
		if(n+m!=s) return false;
		
		//包括是s1为""s2为"a" s3为"a"的边界情况则应状态大小为n+1*m+1;
		boolean[][] dp=new boolean[n+1][m+1];
		dp[0][0]=true;
		for(int i=0;i<n+1;i++){
			for(int j=0;j<m+1;j++){
				boolean left=false;
				boolean right=false;
				if(i==0&&j-1>=0){
					dp[i][j]=(dp[i][j-1]&&(s2.charAt(j-1)==s3.charAt(i+j-1)));
				}
				if(i-1>=0&&j==0){
					dp[i][j]=(dp[i-1][j]&&(s1.charAt(i-1)==s3.charAt(i+j-1)));
				}
				if(i-1>=0&&j-1>=0){
					left=(dp[i-1][j]&&(s1.charAt(i-1)==s3.charAt(i+j-1)));
					right=(dp[i][j-1]&&(s2.charAt(j-1)==s3.charAt(i+j-1)));
					dp[i][j]=left||right;
				}
				
			}
		}
		return dp[n][m];
	
	}
	public static void main(String[] args) {
		System.out.println(dIsStaggeredComposition("aabcc", "dbbca", "aadbbcbcac"));
		System.out.println(dIsStaggeredComposition("aabcc", "dbbca", "accabdbbca"));
	}
}
