/**
 * ���η�ʵ��ѭ�����ճ̱�
 */
package divideConquer;

public class Table
{
	/**
	 * @param table
	 * @param n �������ż����
	 */
	private void scheduleTable(int[][] table, int n)
	{
		if (n==1)
			table[0][0] = 1;
		else
		{
			// ��������������
			int m = n / 2;
			scheduleTable(table, m);
			// ��������������
			for (int i=0; i<m; i++) // ������
			{
				for (int j=m; j<n; j++) // ���Ͻ�
				{
					table[i][j] = table[i][j-m] + m;
				}
			}
			// ��������������
			for (int i=m; i<n; i++)
			{
				for (int j=0; j<m; j++)
				{
					table[i][j] = table[i-m][j] + m;
				}
			}
			// ��������������
			for (int i=m; i<n; i++)
			{
				for (int j=m; j<n; j++) 
				{
					table[i][j] = table[i-m][j]-m;
				}
			}
		}
	}
	
	public static void main(String[] args)
	{
		Table t = new Table();
		int n = 8; // �����
		int[][] table = new int[8][8]; // �ճ̱�
		t.scheduleTable(table, n);
		for (int[] row : table)
		{
			for (int col: row)
			{
				System.out.print(col +"  ");
			}
			System.out.println();
		}
	}
}
