package dynamicprogramming;
/*��Ŀ���� 
���������ַ���s1��s2��s3��
�жϵ������ַ���s3�Ƿ���ǰ�����ַ���s1��s2��������Ҳ��ı�s1��s2�и����ַ�ԭ�е����˳��
����,��� s1=��aabcc��,s2=��dbbbca��,s3=��aadbbcbcac��,
�����true��
�����s1=��aabcc��,s2=��dbbca��,s3=��accabdbbca��,
�����false*/
public class AlternatingString {
	public static boolean dIsStaggeredComposition(String s1,String s2,String s3){
		int n=s1.length();
		int m=s2.length();
		int s=s3.length();
		if(n+m!=s) return false;
		
		//������s1Ϊ""s2Ϊ"a" s3Ϊ"a"�ı߽������Ӧ״̬��СΪn+1*m+1;
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
