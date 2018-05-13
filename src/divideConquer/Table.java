/**
 * 分治法实现循环赛日程表
 */
package divideConquer;

public class Table
{
	/**
	 * @param table
	 * @param n 球队数（偶数）
	 */
	private void scheduleTable(int[][] table, int n)
	{
		if (n==1)
			table[0][0] = 1;
		else
		{
			// 填充左上区域矩阵
			int m = n / 2;
			scheduleTable(table, m);
			// 填充右上区域矩阵
			for (int i=0; i<m; i++) // 代表行
			{
				for (int j=m; j<n; j++) // 右上角
				{
					table[i][j] = table[i][j-m] + m;
				}
			}
			// 填充左下区域矩阵
			for (int i=m; i<n; i++)
			{
				for (int j=0; j<m; j++)
				{
					table[i][j] = table[i-m][j] + m;
				}
			}
			// 填充右下区域矩阵
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
		int n = 8; // 球队数
		int[][] table = new int[8][8]; // 日程表
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
