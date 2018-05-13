/**
 * ��̬�滮
 * ������������  A1A2A3A4A5A6
 */
package dynamicplan;
import java.util.Scanner;

public class MultiplyMatrix
{
	public static final int MAT = 7; // �����±�����ֵ 
	
	public static void main(String[] args)
	{
		int[][] m = new int[MAT][MAT]; // ����A[i:j]ʱ����¼���ٵ����˴���
		int[][] s = new int[MAT][MAT]; // ����A[i:j]ʱ����¼�Ͽ���λ��
//		int[] p = new int[MAT]; // ��¼ÿһ�����������±� (�������)
		int[] p = new int[]{30, 35, 15, 5, 10, 20, 25}; // ��¼ÿһ�����������±� (�������)
		System.out.println("�������ˣ�");
		System.out.println("������ " + (MAT-1)+"��");
		
		Scanner sc = new Scanner(System.in);
//		for (int i=0; i<MAT; i++)
//		{
//			System.out.println("�������"+(i+1)+"�����±�:");
//			p[i] = sc.nextInt();
//		}
		
		System.out.println("������ľ�����:");
		for (int i=0; i<MAT-1; i++)
		{
			System.out.print("A"+(i+1)+"["+p[i]+"]"+"["+p[i+1]+"]  ");
		}
		System.out.println();
		matrixChain(p, m, s);
		System.out.println("���Ž�����:");
		System.out.println(String.format("s[%d][%d]:", MAT-1, MAT-1));
		display(m);
		
		System.out.println(String.format("m[%d][%d]:", MAT-1, MAT-1));
		display(s);
	}
	
	/**
	 * ˼�룺
	 * �㷨matrixChain���ȼ����m[i][i]=0,i=0,1,2...n,Ȼ���ٸ��ݵݹ�ʽ�����������������ķ�ʽ
	 * ���μ���m[i][i+1],i=1,2..n-1(��������Ϊ2)��m[i][i+2], i=1,2...n-2(��������Ϊ3)��...
	 * �ڼ���m[i][j]ʱ��ֻ�õ��Ѽ������m[i][k]��m[k+1][j]�� 
	 * 
	 * @param p ������±�
	 * @param m ���˴���
	 * @param s �Ͽ���λ��
	 */
	static void matrixChain(int[] p, int[][] m, int[][] s)
	{
		int n = MAT - 1;
		// ����A[i:i]���˴���Ϊ0
		for (int i=1; i<=n; i++)
			m[i][i] = 0;
		
		// rΪ����Ĺ�ģ(����������)
		for (int r=2; r<=n; r++)
		{
			// ��ģΪr��������ĸ���(����n-r+1��)
			for (int i=1; i<=n-r+1; i++)
			{
				int j = i+r-1;
				// ���վ����������ķ�ʽһ�μ���m[i][j], ���ݹ�ʽm[i][j] = m[i][k] + m[k+1][j] + pi-1*pk*pj   (k�ķ�Χ��i<=k<j)
				m[i][j] = m[i][i] + m[i+1][j] + p[i-1]*p[i]*p[j]; // m[1][2], m[2][3], m[3][4]... 
				s[i][j] = i; // ����ȡ����k=i
				// �������ǲ���֪���Ͽ���k��λ�ã�ֻ�ܴӲ��ϳ���  (k�ķ�Χ��i<=k<j)
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
	 * �������a�����b�ĳ˻�������˼·��
	 */
	void matrixMultiply(int[][] a, int[][] b, int[][] c, int ra, int ca, int rb, int cb)
	{
		int sum = 0;
		if (ca != rb)
		{
			System.out.println("���󲻿ɳ�");
			return;
		}
		
		// ����ca = rb
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
