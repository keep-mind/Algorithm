/**
 * 实现冒泡排序算法
 */
package sort;

import java.util.Arrays;

public class BubbleSort
{
	public static void main(String[] args)
	{
		int[] s = {8, 2, 5, 3, 9, 7};
		int[] newArray = bubbleSort(s);
		System.out.println("排序前：" + Arrays.toString(s));
		System.out.println("排序后：" + Arrays.toString(newArray));
	}
	
	/**
	 * 冒泡排序
	 * @param array
	 * @return
	 */
	public static int[] bubbleSort(int[] array)
	{
		int[] newArray = Arrays.copyOf(array, array.length); 
		for (int i = 0; i < newArray.length-1; i++) // 比较的趟数
		{
			for (int j=0; j< newArray.length-1-i; j++) // 每一次两两比较的次数
			{
				if (newArray[j] > newArray[j+1])
				{
					int tmp = newArray[j];
					newArray[j] = newArray[j+1];
					newArray[j+1] = tmp;
				}
			}
		}
		return newArray;
	}
}
