/**
 * ��������������
 * (��������Щ�����������)
 */
package dynamicplan;

public class LCS
{
	public int findLCS(String A, String B)
	{
		int n = A.length();
		int m = B.length();
		char[] a = A.toCharArray();
		char[] b = B.toCharArray();
		int[][] dp = new int[n][m];
		// �ȴ�����һ�к͵�һ�е�Ԫ,��������Ϊ��֪��Ԫ�أ�Ϊ����������׼��
		for (int i=0; i<n; i++)
		{  
			// ������һ��
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
		
		
		for (int i=0; i<m; i++)
		{
			// ������һ��
			if (b[i] == a[0])
			{
				dp[0][i] = 1;
				for(int j=i+1; j<m; j++)
				{
					dp[0][j] = 1;
				}
				break;
			}
		}
		// ��dp[1][1]��ʼ,���������֪��Ԫ����Ϊ�������м��㣬ֱ�����㵽dp[n-1][m-1]
		for (int i=1; i<n; i++) // ��
		{
			for (int j=1; j<m; j++) // ��
			{
				if (a[i]==b[j])
				{
					dp[i][j] = dp[i-1][j-1] + 1;
				}
				else
				{
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		// ��ӡ����
		for (int i=0; i<n; i++)
		{
			for (int j=0; j<m; j++)
			{
				System.out.print(dp[i][j] +"  ");
			}
			System.out.println();
		}
		
		return dp[n-1][m-1];
	}
	
	public static void main(String[] args)
	{
		LCS lcs = new LCS();
		int len = lcs.findLCS("android", "random");
		System.out.println("������г��ȣ�" + len);
	}
}