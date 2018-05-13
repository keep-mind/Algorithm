/**
 * 动态规划
 * 计算矩阵的连乘  A1A2A3A4A5A6
 */
package dynamicplan;
import java.util.Scanner;

public class MultiplyMatrix
{
	public static final int MAT = 7; // 数组下标的最大值 
	
	public static void main(String[] args)
	{
		int[][] m = new int[MAT][MAT]; // 计算A[i:j]时，记录最少的数乘次数
		int[][] s = new int[MAT][MAT]; // 计算A[i:j]时，记录断开的位置
//		int[] p = new int[MAT]; // 记录每一个输入矩阵的下标 (输入参数)
		int[] p = new int[]{30, 35, 15, 5, 10, 20, 25}; // 记录每一个输入矩阵的下标 (输入参数)
		System.out.println("矩阵连乘：");
		System.out.println("矩阵共有 " + (MAT-1)+"个");
		
		Scanner sc = new Scanner(System.in);
//		for (int i=0; i<MAT; i++)
//		{
//			System.out.println("请输入第"+(i+1)+"个的下标:");
//			p[i] = sc.nextInt();
//		}
		
		System.out.println("您输入的矩阵是:");
		for (int i=0; i<MAT-1; i++)
		{
			System.out.print("A"+(i+1)+"["+p[i]+"]"+"["+p[i+1]+"]  ");
		}
		System.out.println();
		matrixChain(p, m, s);
		System.out.println("最优解如下:");
		System.out.println(String.format("s[%d][%d]:", MAT-1, MAT-1));
		display(m);
		
		System.out.println(String.format("m[%d][%d]:", MAT-1, MAT-1));
		display(s);
	}
	
	/**
	 * 思想：
	 * 算法matrixChain首先计算出m[i][i]=0,i=0,1,2...n,然后，再根据递归式，按矩阵链长递增的方式
	 * 依次计算m[i][i+1],i=1,2..n-1(矩阵链长为2)；m[i][i+2], i=1,2...n-2(矩阵链长为3)；...
	 * 在计算m[i][j]时，只用到已计算出的m[i][k]和m[k+1][j]。 
	 * 
	 * @param p 矩阵的下标
	 * @param m 数乘次数
	 * @param s 断开的位置
	 */
	static void matrixChain(int[] p, int[][] m, int[][] s)
	{
		int n = MAT - 1;
		// 矩阵A[i:i]连乘次数为0
		for (int i=1; i<=n; i++)
			m[i][i] = 0;
		
		// r为问题的规模(矩阵链长度)
		for (int r=2; r<=n; r++)
		{
			// 规模为r的子问题的个数(共有n-r+1个)
			for (int i=1; i<=n-r+1; i++)
			{
				int j = i+r-1;
				// 按照矩阵链递增的方式一次计算m[i][j], 根据公式m[i][j] = m[i][k] + m[k+1][j] + pi-1*pk*pj   (k的范围是i<=k<j)
				m[i][j] = m[i][i] + m[i+1][j] + p[i-1]*p[i]*p[j]; // m[1][2], m[2][3], m[3][4]... 
				s[i][j] = i; // 这里取的是k=i
				// 由于我们并不知道断开点k的位置，只能从不断尝试  (k的范围是i<=k<j)
				for (int k=i+1; k<j; k++)  
				{
					int t = m[i][k] + m[k+1][j] + p[i-1]*p[k]*p[j];
					if (t < m[i][j])
					{
						m[i][j] = t;
						s[i][j] = k;
					}
				}
			}
		}
	}
	
	static void display(int[][] s)
	{
		for (int i=1; i<=MAT-1; i++)
		{
			System.out.print(String.format("     %9d", i));
		}
		
		System.out.println();
		for (int i=1; i<=MAT-1; i++)
		{
			System.out.print(String.format("    %9d", i));
			for (int j=1; j<=MAT-1; j++)
			{
				System.out.print(String.format("%9d", s[i][j]));
			}
			System.out.println();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * 计算矩阵a与矩阵b的乘积（常规思路）
	 */
	void matrixMultiply(int[][] a, int[][] b, int[][] c, int ra, int ca, int rb, int cb)
	{
		int sum = 0;
		if (ca != rb)
		{
			System.out.println("矩阵不可乘");
			return;
		}
		
		// 满足ca = rb
		for (int i=0; i<ra; i++)
		{
			for (int j=0; j<cb; j++)
			{
				sum = a[i][0] * b[0][j];
				for (int k=1; k<ca; k++)
				{
					sum += a[i][k] * b[k][j];
				}
				c[i][j] = sum;
			}
		}
	}
}
