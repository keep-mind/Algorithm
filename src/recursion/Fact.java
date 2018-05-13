/**
 * ½×³Ë 
 */
package recursion;

public class Fact
{
	public int f(int n)
	{
		int res = 1;
		for (int i=1; i<=n; i++)
		{
			res *= i;
		}
		return res;
	}
	
	public int f2(int n)
	{
		if (n == 1)
			return n;
		else
		{
			return n*f2(n-1);
		}
	}
	
	public static void main(String[] args)
	{
		Fact fact = new Fact();
		System.out.println(fact.f(5));
		System.out.println(fact.f2(5));
	}
}
