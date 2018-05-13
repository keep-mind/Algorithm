/**
 * 实现堆排序
 * https://www.cnblogs.com/chengxiao/p/6129630.html
 * 堆排序的基本思想是：将待排序序列构造成一个大顶堆，此时，整个序列的最大值就是堆顶的根节点。
 * 将其与末尾元素进行交换，此时末尾就为最大值。然后将剩余n-1个元素重新构造成一个堆，
 * 这样会得到n个元素的次小值。如此反复执行，便能得到一个有序序列了
 */
package sort;

import java.util.Arrays;

public class HeapSort
{
	public static void main(String[] args)
	{
		int[] array = {83, 3, 2, 6, 10, 44, 38, 28, 5, 1, 0, 36};
		System.out.println("排序前：" + Arrays.toString(array));
		HeapSort hs = new HeapSort();
		hs.heapSort(array);
		System.out.println("排序后：" + Arrays.toString(array));
	}
	
	public void heapSort(int[] array)
	{
		if (array==null || array.length<=1)
		{
			return;
		}
		// 创建大堆
		buidMaxHeap(array);
		for (int i=array.length-1; i>=1; i--)
		{
			// 一次大堆构造后，最大元素就会变为下标为0的元素
			exchangeElements(array, 0, i); // 交换首尾两个元素
			maxHeap(array, i, 0); // 从0开始是因为进行第一次大堆构造后，除了二叉树中除了第0个元素外，其余的满足大顶堆要求
		}
	}

	private void buidMaxHeap(int[] a)
	{
		 int half = (a.length - 1) / 2; // 只需遍历一半，就可找到所有元素
		 for (int i=half; i>=0; i--) // 从后向前的构造容易
		 {
			 maxHeap(a, a.length, i); // 数据， 长度， 从第i的元素开始
		 }
	}

	/**
	 * 大堆 
	 * @param a 存放数据的数组
	 * @param length  数据的长度
	 * @param i   起始构造的位置
	 */
	private void maxHeap(int[] a, int length, int i)
	{
		int left = i*2+1;
		int right = i*2+2;
		int largest = i;
		// 找到该二叉树中的最大值
		if (left<length && a[left]>a[i])
		{
			largest = left;
		}
		
		if (right<length && a[right]>a[largest])
		{
			largest = right;
		}
		
		if (i != largest)
		{
			// 进行数据交换
			exchangeElements(a, i, largest);
			// 因为largest和它的父节点位置发生了改变，需要对以largest为根的二叉树进行调整
			maxHeap(a, length, largest); 
		}
	}
	
	private void exchangeElements(int[] a, int i, int largest)
	{
		int tmp = a[i];
		a[i] = a[largest];
		a[largest] = tmp;
	}
}
