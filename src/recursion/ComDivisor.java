/**
 * 求解最大公约数
 */
package recursion;

public class ComDivisor
{
	public static void main(String[] args)
	{
		int a = 48, b=12;
		ComDivisor comDivisor = new ComDivisor();
//		int maxComDivisor = comDivisor.getMaxComDivisor(a, b);
		int gcd = comDivisor.gcd(a, b);
		System.out.println(gcd);
	}
	
	/**
	 * 获得两个数的最大公约数
	 * m、n(m>n)最大公约数 = n 和  m%n 的最大公约数
	 * @param a
	 * @param b
	 * @return
	 */
	public int getMaxComDivisor(int a, int b)
	{
		int tmp = 0;
		int k = 0; 
		if (a < b)
		{
			tmp = a;
			a = b;
			b = tmp;
		}
		while ((k = a % b)!=0)
		{
			a = b;
			b = k;
		}
		return b;
	}
	
	public int gcd(int m, int n)
	{
		if (n==0)
		{
			return m;
		}
		else
		{
			return gcd(n, m%n);
		}
	}
}
