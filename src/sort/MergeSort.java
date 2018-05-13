/**
 * �鲢����
 * �鲢����MERGE-SORT�������ù鲢��˼��ʵ�ֵ����򷽷���
 * ���㷨���þ���ķ��Σ�divide-and-conquer�����ԣ����η��������(divide)��һЩС������Ȼ��ݹ���⣬
 * ����(conquer)�Ľ׶��򽫷ֵĽ׶εõ��ĸ���"�޲�"��һ�𣬼��ֶ���֮)��

 */
package sort;

import java.util.Arrays;

public class MergeSort
{
	public void mergeSort(int[] a, int left, int right)
	{
		if (left < right)  // ����������Ԫ��
		{
			int middle = (left + right) / 2;
			mergeSort(a, left, middle);
			mergeSort(a, middle+1, right);
			merge(a, left, middle, right); // ���������������кϲ�
		}
	}

	private void merge(int[] a, int left, int middle, int right)
	{
		int[] tmpArray = new int[a.length]; // ����һ����ʱ���飬��źϲ�������
		int rightStart = middle + 1;
		int tmp = left;
		int third = left; // �ϲ������������ʼ�±�
		// �Ƚ���������( [left,middle]��[middle+1, right] )����Ӧ�±�λ�õ�Ԫ�ش�С��С��Ԫ���ȷ���������
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
		// ���������黹��Ԫ�أ��Ͱ�ʣ���Ԫ�ؿ�������������
		while (left <= middle)
		{
			tmpArray[third++] = a[left++];
		}
		
		// ����ұ����黹��Ԫ�أ��Ͱ�ʣ���Ԫ�ؿ�������������
		while (rightStart <= right)
		{
			tmpArray[third++] = a[rightStart++];
		}
		
		System.out.println("��ʱ����tmpArray:" + Arrays.toString(tmpArray));
		
		while (tmp <= right)
		{
			a[tmp] = tmpArray[tmp]; // �����ϲ�������鵽ԭ������
			tmp++;
		}
	}
	
	public static void main(String[] args)
	{
		int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1};
		System.out.println("����ǰ:" + Arrays.toString(array));
		MergeSort ms = new MergeSort();
		ms.mergeSort(array, 0, array.length-1);
		System.out.println("�����" + Arrays.toString(array));
	}
}
