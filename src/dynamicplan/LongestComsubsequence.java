/**
 * 动态规划
 * 求解最长公共子序列的长度
 * 给定两个子序列X={x1, x2, ...xn}和Y={y1, y2, y3,...yn}，找出X和Y的最长公共子序列
 */
package dynamicplan;

public class LongestComsubsequence
{
	public int findLCS(String X, String Y)
	{
		// 得到序列X、Y的长度
		int n = X.length();
		int m = Y.length();
		char[] a = X.toCharArray();
		char[] b = Y.toCharArray();
		int[][] dp = new int[n][m]; // 存储Xi和Yj的最长公共子序列的长度
		
		// 处理第一列
		for (int i=0; i<n; i++)
		{
			if (a[i] == b[0])
			{
				dp[i][0] = 1;
				for (int j=i+1; j<n; j++)
				{
					dp[j][0] = 1;
				}
				break;
			}
		}
		
		// 处理第一行
		for (int i=0; i<m; i++)
		{
			if (a[0] == b[i])
			{
				dp[0][i] = 1;
				for (int j=i+1; j<m; j++)
					dp[0][j]=1;
				break;
			}
		}
		
		// 关键
		for (int i=1; i<n; i++)
		{
			for (int j=1; j<m; j++)
			{
				if (a[i] == b[j])
				{
					dp[i][j] = dp[i-1][j-1] + 1;
				}
				else
				{
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		// 打印最长序列长度的计算过程
		for (int i=0; i<n; i++)
		{
			for (int j=0; j<m; j++)
			{
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		
		return dp[n-1][m-1];
	}
	
	public static void main(String[] args)
	{
		LongestComsubsequence lcs = new LongestComsubsequence();
		int findLCS = lcs.findLCS("android", "random");
		System.out.println("最长公共子序列长度是:" + findLCS);
	}

}
