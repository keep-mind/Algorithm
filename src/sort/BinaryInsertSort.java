/**
 * ʵ�ֶ��ַ���������
 */
package sort;

import java.util.Arrays;

public class BinaryInsertSort
{
	private static int[] sort(int[] a)
	{
		for (int i = 1; i < a.length; i++)
		{
			int tmp = a[i]; // �������Ԫ��
			int left = 0;
			int right = i-1;
			int mid = 0;
			// ���Ҳ���λ��
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
			// ����Ԫ��
			for (int j=i-1; j>=left; j-- ) {
				// ��left�ұߴ��ֵ�����ƶ�һλ
				a[j+1] = a[j];
			}
			if (left != i) // leftǡ�ò���iλ��
			{
				a[left] = tmp; //��tmp��ֵ���õ�leftλ����
			}
		}
		return a;
	}
	
	public static void main(String[] args)
	{
		int[] array = new int[] {9, 3, 2, 6, 10, 44, 83, 28,5 ,1, 0, 36};
		System.out.println("����ǰ��" + Arrays.toString(array));
		int[] newArray = sort(array);
		System.out.println("�����: " + Arrays.toString(newArray));
	}
	
	
}
