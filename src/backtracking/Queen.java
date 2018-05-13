/**
 * ���ݷ�����˻ʺ�����
 */
package backtracking;

import java.util.Arrays;

public class Queen
{
	public static int num = 1; // �ۼƷ���
	public static final int MAXQUEEN = 8; 
	public static int[] cols = new int[MAXQUEEN]; //����cols���飬��ʾ8�лʺ�ڷŵ�λ��
	
	/**
	 * @param n ���n�еĻʺ�
	 */
	public void getCount(int n)
	{
		boolean [] rows = new boolean[MAXQUEEN]; // ��¼ÿ�������Ƿ���ԷŻʺ�Ĭ��Ϊfalse
		// ��ȷ����Щλ�ò��ܷŻʺ�
		for (int m=0; m<n; m++)
		{
			rows[cols[m]] = true; // ��һ�е�cols[m]λ���Ѿ�������һ���ʺ�,�����ٷ�
			int d = n-m;  // б�Խ�
			// ��б����  /
			if (cols[m]-d >= 0)
			{
				rows[cols[m]-d] = true; // ������ʺ�
			}
			
			// ��б���� \
			if (cols[m] + d < 8)
			{
				rows[cols[m] + d] = true; // ���ܷŻʺ�
			}
		}
		
		for (int i=0; i<MAXQUEEN; i++)
		{
			if (rows[i])
			{
				// ���ܷ�
				continue;
			}
			cols[n] = i;
			 // ��û�ŵ���7��
			if (n <MAXQUEEN-1)
			{
				getCount(n+1); // �����޷�ִ���꣬��ζ���ŵ�����ûλ����
			}
			else
			{
				System.out.println("������"+ num + " " +Arrays.toString(cols));
				printQueen(num);
				num++;
			}
			// ����������к��ʵ�λ�ã����ݣ�
		}
	}
	
	private void printQueen(int num)
	{
		System.out.println("��" + num +"�ַ���");
		for (int i=0; i<MAXQUEEN; i++)
		{
			for (int j=0; j<MAXQUEEN; j++)
			{
				if (i==cols[j]) {
					System.out.print("0 ");
				}
				else
				{
					System.out.print("*��");
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
