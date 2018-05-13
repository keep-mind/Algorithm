/**
 * 回溯法解决八皇后问题
 */
package backtracking;

import java.util.Arrays;

public class Queen
{
	public static int num = 1; // 累计方案
	public static final int MAXQUEEN = 8; 
	public static int[] cols = new int[MAXQUEEN]; //定义cols数组，表示8列皇后摆放的位置
	
	/**
	 * @param n 填第n列的皇后
	 */
	public void getCount(int n)
	{
		boolean [] rows = new boolean[MAXQUEEN]; // 记录每个方格是否可以放皇后，默认为false
		// 先确定哪些位置不能放皇后
		for (int m=0; m<n; m++)
		{
			rows[cols[m]] = true; // 这一列的cols[m]位置已经放置了一个皇后,不能再放
			int d = n-m;  // 斜对角
			// 正斜方向  /
			if (cols[m]-d >= 0)
			{
				rows[cols[m]-d] = true; // 不能填皇后
			}
			
			// 反斜方向 \
			if (cols[m] + d < 8)
			{
				rows[cols[m] + d] = true; // 不能放皇后
			}
		}
		
		for (int i=0; i<MAXQUEEN; i++)
		{
			if (rows[i])
			{
				// 不能放
				continue;
			}
			cols[n] = i;
			 // 还没排到第7列
			if (n <MAXQUEEN-1)
			{
				getCount(n+1); // 可能无法执行完，意味着排到后面没位置了
			}
			else
			{
				System.out.println("方案："+ num + " " +Arrays.toString(cols));
				printQueen(num);
				num++;
			}
			// 下面可能仍有合适的位置（回溯）
		}
	}
	
	private void printQueen(int num)
	{
		System.out.println("第" + num +"种方案");
		for (int i=0; i<MAXQUEEN; i++)
		{
			for (int j=0; j<MAXQUEEN; j++)
			{
				if (i==cols[j]) {
					System.out.print("0 ");
				}
				else
				{
					System.out.print("*　");
				}
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args)
	{
		Queen queen = new Queen();
		queen.getCount(0);
	}
	
}
