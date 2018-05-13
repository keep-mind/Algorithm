/**
 * 实现二分法插入排序
 */
package sort;

import java.util.Arrays;

public class BinaryInsertSort
{
	private static int[] sort(int[] a)
	{
		for (int i = 1; i < a.length; i++)
		{
			int tmp = a[i]; // 待插入的元素
			int left = 0;
			int right = i-1;
			int mid = 0;
			// 查找插入位置
			while (left <= right)
			{
				mid = (left + right) / 2;  // -1 / 2 = 0
				System.out.print(mid + " ");
				if (a[mid] > tmp)
				{
					right = mid -1;
				}
				else
				{
					left = mid + 1;
				}
			}
			// 插入元素
			for (int j=i-1; j>=left; j-- ) {
				// 比left右边大的值往后移动一位
				a[j+1] = a[j];
			}
			if (left != i) // left恰好不在i位置
			{
				a[left] = tmp; //将tmp的值放置到left位置上
			}
		}
		return a;
	}
	
	public static void main(String[] args)
	{
		int[] array = new int[] {9, 3, 2, 6, 10, 44, 83, 28,5 ,1, 0, 36};
		System.out.println("排序前：" + Arrays.toString(array));
		int[] newArray = sort(array);
		System.out.println("排序后: " + Arrays.toString(newArray));
	}
	
	
}
