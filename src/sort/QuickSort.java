/**
 * 快速排序算法
 * 基本思想是：通过一趟排序将要排序的数据分割成独立的两部分，
 * 其中一部分的所有数据都比另外一部分的所有数据都要小，然后再按此方法对这两部分数据分别进行快速排序，
 * 整个排序过程可以递归进行，以此达到整个数据变成有序序列
 */
package sort;

import java.util.Arrays;

public class QuickSort
{
	public void quick(int[] a)
	{
		if (a.length > 0)
		{
			quickSort(a, 0, a.length-1);
		}
	}
	
	public void quickSort(int[] a, int low, int high)
	{
		if (low < high)
		{
			int middle = getMiddle(a, low, high);
			quickSort(a, 0, middle-1);
			quickSort(a, middle+1, high);
		}
	}
	
	
	private int getMiddle(int[] a, int low, int high)
	{
		int tmp = a[low]; // 基准元素
		while (low < high)
		{
			while (low < high && a[high] >= tmp)
			{
				high--;
			}
			a[low] = a[high];
			
			while (low < high && a[low] <= tmp)
			{
				low++;
			}
			a[high] = a[low];
		}
		a[low] = tmp; // 将基准元素放入到正确的位置上(原数组分为三段   左边  基准点 右边)
		return low;
	}
	
	public static void main(String[] args)
	{
		int[] a = {9, 8, 7, 6, 5, 4, 3, 2, 1};
		System.out.println("排序前：" + Arrays.toString(a));
		QuickSort qs = new QuickSort();
		qs.quick(a);
		System.out.println("排序后：" + Arrays.toString(a));
	}
}
