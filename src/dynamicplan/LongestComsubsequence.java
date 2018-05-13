/**
 * ��̬�滮
 * �������������еĳ���
 * ��������������X={x1, x2, ...xn}��Y={y1, y2, y3,...yn}���ҳ�X��Y�������������
 */
package dynamicplan;

public class LongestComsubsequence
{
	public int findLCS(String X, String Y)
	{
		// �õ�����X��Y�ĳ���
		int n = X.length();
		int m = Y.length();
		char[] a = X.toCharArray();
		char[] b = Y.toCharArray();
		int[][] dp = new int[n][m]; // �洢Xi��Yj������������еĳ���
		
		// �����һ��
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
		
		// �����һ��
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
		
		// �ؼ�
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
		
		// ��ӡ����г��ȵļ������
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
		System.out.println("����������г�����:" + findLCS);
	}

}
