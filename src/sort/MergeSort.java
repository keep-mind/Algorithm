/**
 * 归并排序
 * 归并排序（MERGE-SORT）是利用归并的思想实现的排序方法，
 * 该算法采用经典的分治（divide-and-conquer）策略（分治法将问题分(divide)成一些小的问题然后递归求解，
 * 而治(conquer)的阶段则将分的阶段得到的各答案"修补"在一起，即分而治之)。

 */
package sort;

import java.util.Arrays;

public class MergeSort
{
	public void mergeSort(int[] a, int left, int right)
	{
		if (left < right)  // 至少有两个元素
		{
			int middle = (left + right) / 2;
			mergeSort(a, left, middle);
			mergeSort(a, middle+1, right);
			merge(a, left, middle, right); // 将左右两个子序列合并
		}
	}

	private void merge(int[] a, int left, int middle, int right)
	{
		int[] tmpArray = new int[a.length]; // 创建一个临时数组，存放合并的数组
		int rightStart = middle + 1;
		int tmp = left;
		int third = left; // 合并后新数组的起始下标
		// 比较两个数组( [left,middle]和[middle+1, right] )中相应下标位置的元素大小，小的元素先放入新数组
		while (left <= middle && rightStart <= right)
		{
			if (a[left] <= a[rightStart])
			{
				tmpArray[third++] = a[left++];
			}
			else
			{
				tmpArray[third++] = a[rightStart++];
			}
		}
		// 如果左边数组还有元素，就把剩余的元素拷贝到新数组中
		while (left <= middle)
		{
			tmpArray[third++] = a[left++];
		}
		
		// 如果右边数组还有元素，就把剩余的元素拷贝到新数组中
		while (rightStart <= right)
		{
			tmpArray[third++] = a[rightStart++];
		}
		
		System.out.println("临时数组tmpArray:" + Arrays.toString(tmpArray));
		
		while (tmp <= right)
		{
			a[tmp] = tmpArray[tmp]; // 拷贝合并后的数组到原数组中
			tmp++;
		}
	}
	
	public static void main(String[] args)
	{
		int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1};
		System.out.println("排序前:" + Arrays.toString(array));
		MergeSort ms = new MergeSort();
		ms.mergeSort(array, 0, array.length-1);
		System.out.println("排序后：" + Arrays.toString(array));
	}
}
