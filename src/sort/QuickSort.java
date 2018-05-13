/**
 * ���������㷨
 * ����˼���ǣ�ͨ��һ������Ҫ��������ݷָ�ɶ����������֣�
 * ����һ���ֵ��������ݶ�������һ���ֵ��������ݶ�ҪС��Ȼ���ٰ��˷����������������ݷֱ���п�������
 * ����������̿��Եݹ���У��Դ˴ﵽ�������ݱ����������
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
		int tmp = a[low]; // ��׼Ԫ��
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
		a[low] = tmp; // ����׼Ԫ�ط��뵽��ȷ��λ����(ԭ�����Ϊ����   ���  ��׼�� �ұ�)
		return low;
	}
	
	public static void main(String[] args)
	{
		int[] a = {9, 8, 7, 6, 5, 4, 3, 2, 1};
		System.out.println("����ǰ��" + Arrays.toString(a));
		QuickSort qs = new QuickSort();
		qs.quick(a);
		System.out.println("�����" + Arrays.toString(a));
	}
}
