/**
 * 二分查找(递归实现)
 */
package search;

public class BinarySearch
{
	public static void main(String[] args)
	{
		int [] array = {1, 2, 3, 5, 8, 10, 12};
		BinarySearch bs = new BinarySearch();
		int res = bs.binarySearch3(12, array, 0, array.length-1);
		if (res == -1)
			System.out.println("没有找到该元素");
		else
			System.out.println("第"+ (res+1) + "个元素");
	}
	
	public int binarySearch(int elem, int[] a , int low, int high)
	{
		if (low > high)
		{
			return -1; // 表示没找到元素
		}
		int mid = (low + high) / 2;
		if (a[mid] == elem)
		{
			return mid;
		}
		
		if (a[mid] > elem)
		{
			// 找左边
			return binarySearch(elem, a, low, mid-1);
		}
		
		if (a[mid] < elem)
		{
			// 找右边
			return binarySearch(elem, a, mid+1, high);
		}
		return -1;
	}
	
	public int binarySearch2(int elem, int[] a, int low, int high)
	{
		while (low <= high)
		{
			int mid = (low + high) / 2;
			if (elem > a[mid])
			{
				low = mid + 1;
			}
			else if (elem < a[mid])
			{
				high = mid - 1;
			}
			else if (elem == a[mid])
			{
				return mid;
			}
		}
		return -1;
	}
	
	public int binarySearch3(int elem, int[] a, int low, int high)
	{
		while (low <= high)
		{
			int mid = (low + high) / 2;
			if (a[mid] == elem)
			{
				return mid;
			}
			else if (a[mid] > elem)
			{
				return binarySearch3(elem, a, low, mid-1);
			}else if (a[mid] < elem)
			{
				return binarySearch3(elem, a, mid+1, high);
			}
		}
		return -1;
	}
	
}
