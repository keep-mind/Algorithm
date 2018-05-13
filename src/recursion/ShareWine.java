/**
 * 泊松分酒
 */
package recursion;

public class ShareWine
{
	// 每个杯子的最大容量
	private int b1 = 12;
	private int b2 = 8;
	private int b3 = 5;
	
	private int m = 6; // 目标酒量
	
	// 假设初始状态12,0,0
	private void backBottle(int bb1, int bb2, int bb3)
	{
		System.out.println("bb1:" + bb1 +" bb2:" +bb2 +" bb3:" + bb3);
		if (bb1 ==m || bb2 == m || bb3 == m)
		{
			System.out.println("find the bottle");
			return;
		}
		
		if (bb2 !=0 && bb3!=b3)
		{
			if (bb2+bb3 <=b3) // 说明倒不满
			{
				backBottle(bb1, 0, bb2+bb3);
			}
			else
			{
				backBottle(bb1,bb2-(b3-bb3), b3);
			}
				
		}
		else if (bb3==b3) // 瓶子3已满，向瓶子1倒入
		{
			if (bb3 + bb1 <=b1)
			{
				backBottle(bb3+bb1, bb2, 0);
			}
			else
			{
				backBottle(b1, bb2, bb3-(b1-bb1));
			}
		}
		else if (bb2 == 0)
		{
			// 从瓶子1往瓶子2倒酒
			if (bb1 >= b2)
			{
				backBottle(bb1-b2, b2, bb3);
			}
			else
			{
				backBottle(0, bb1, bb3);
			}
		}
	}
	
	public static void main(String[] args)
	{
		ShareWine shareWine = new ShareWine();
		shareWine.backBottle(12, 0, 0);
	}
}
