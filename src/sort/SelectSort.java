/**
 * 选择排序算法的实现
 */
package sort;

import java.util.Arrays;

public class SelectSort
{
	public static void main(String[] args)
	{
		int[] s = {8, 2, 5, 3, 9, 7};
		int[] news = selectSort(s);
		System.out.println("排序前：" + Arrays.toString(s));
		System.out.println("排序后:" + Arrays.toString(news));
	}

	/**
	 * 实现选择排序的算法
	 * @param array
	 * @return
	 */
	public static int[] selectSort(int[] array)
	{
		int[] newArray = Arrays.copyOf(array, array.length); // 深拷贝(避免修改原来的数组元素顺序)
		int min = 0; // 记录最元素所在的位置
		for (int i = 0; i < array.length; i++)
		{
			min = i;
			for (int j=i+1; j<newArray.length; j++)
			{
				if (newArray[min] > newArray[j])
				{
					min = j; // 记录每一轮最小元素所在的位置
				}
			}
			
			if (min != i)     // 如果当前位置不是最小元素的话，就交换
			{
				int tmp = newArray[i];
				newArray[i] = newArray[min];
				newArray[min] = tmp;
			}
		}
		return newArray;
	}
}
