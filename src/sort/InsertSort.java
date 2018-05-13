/**
 * 实现直接插入排序
 */
package sort;

import java.util.Arrays;

public class InsertSort
{
	public static void main(String[] args)
	{
		int[] s = {8, 2, 5, 3, 9, 7};
		int[] newArray = InsertSort(s);
		System.out.println("排序前：" + Arrays.toString(s));
		System.out.println("排序后：" + Arrays.toString(newArray));
	}
	
	/**
	 * 直接插入排序
	 * @param array
	 * @return
	 */
	public static int[] InsertSort(int[] array)
	{
		int[] newArray = Arrays.copyOf(array, array.length); // 拷贝原数组
		for (int i=1; i<newArray.length; i++) // 只有一个元素时，不需要移动
		{
			int tmp = newArray[i]; // 新遍历的值，等待插入到前面的有序数组
			int j; 
			for (j=i-1; j>=0; j--)
			{
				// 将大于tmp的数，往后移动
				if (newArray[j] > tmp)
				{
					newArray[j+1] = newArray[j];
				}
				else
				{
					break;
				}
			}
			newArray[j+1] = tmp;
		}
		return newArray;
	}

}
