/**
 * 实现希尔排序
 */
package sort;

import java.util.Arrays;

public class HeerSort
{
	public static void main(String[] args)
	{
		int[] array = {83, 3, 2, 6, 10, 44, 38, 28, 5, 1, 0, 36};
		System.out.println("排序前：" + Arrays.toString(array));
		int d = array.length / 2; // d为增量, 默认增量是6
		while (true)
		{
			for (int i=0; i<d; i++) // 增量是从0到d
			{
				for (int j=i; j+d<array.length; j+=d)
				{
					for (int k=i; k+d<array.length; k+=d)  // 和上一个for循环，构成冒泡排序
					{
						int tmp; // 临时变量
						if (array[k] > array[k+d])
						{
							tmp = array[k];
							array[k] = array[k+d];
							array[k+d] = tmp;
						}
					}
				}
			}
			System.out.println("增量d:"+ d + "  " +Arrays.toString(array));
			if (d < 1)
			{
				break;
			}
			d -= 2;
		}
		System.out.println("排序后：" + Arrays.toString(array));
	}
	
	/**
	 * 这个不是希尔排序(错误的)
	 */
	private void sort()
	{
		int[] array = {83, 3, 2, 6, 10, 44, 38, 28, 5, 1, 0, 36};
		System.out.println("排序前：" + Arrays.toString(array));
		int d = array.length / 2; // d为增量, 默认增量是6
		while (true)
		{
			for (int j=0; j+d<array.length; j+=1)
			{
				if (array[j] > array[j+d])
				{
					int tmp = array[j];
					array[j] = array[j+d];
					array[j+d] = tmp;
				}
			}
			System.out.println("增量d:"+ d + "  " +Arrays.toString(array));
			d--; // 减少增量
			if (d<1)
			{
				break;
			}
		}
		System.out.println("排序后：" + Arrays.toString(array));
	}
}
