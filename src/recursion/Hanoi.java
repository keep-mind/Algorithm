/**
 * ��ŵ��
 */
package recursion;

public class Hanoi
{
	/**
	 * 
	 * @param a ����A ��ʼ
	 * @param b ����B
	 * @param c ����C Ŀ��
	 * @param n ���Ӹ���
	 */
	public void hanoi(char a, char b, char c, int n)
	{
		if (n > 1)
		{
			hanoi(a, c, b, n-1); 
			move(a, c, n);     // �ƶ�����
			hanoi(b, a, c, n-1);
		}
		else if (n == 1)
		{
			move(a, c, n);
		}
	}

	private void move(char a, char c, int n)
	{
		System.out.println("��" + n + "�����Ӵ�" + a + "-->" + c);
	}
	
	public static void main(String[] args)
	{
		Hanoi hanoi = new Hanoi();
		hanoi.hanoi('A', 'B', 'C', 3);
	}
}
