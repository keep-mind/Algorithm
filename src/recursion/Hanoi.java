/**
 * 汉诺塔
 */
package recursion;

public class Hanoi
{
	/**
	 * 
	 * @param a 柱子A 起始
	 * @param b 柱子B
	 * @param c 柱子C 目标
	 * @param n 盘子个数
	 */
	public void hanoi(char a, char b, char c, int n)
	{
		if (n > 1)
		{
			hanoi(a, c, b, n-1); 
			move(a, c, n);     // 移动方法
			hanoi(b, a, c, n-1);
		}
		else if (n == 1)
		{
			move(a, c, n);
		}
	}

	private void move(char a, char c, int n)
	{
		System.out.println("第" + n + "个盘子从" + a + "-->" + c);
	}
	
	public static void main(String[] args)
	{
		Hanoi hanoi = new Hanoi();
		hanoi.hanoi('A', 'B', 'C', 3);
	}
}
