/**
 * ѡ�������㷨��ʵ��
 */
package sort;

import java.util.Arrays;

public class SelectSort
{
	public static void main(String[] args)
	{
		int[] s = {8, 2, 5, 3, 9, 7};
		int[] news = selectSort(s);
		System.out.println("����ǰ��" + Arrays.toString(s));
		System.out.println("�����:" + Arrays.toString(news));
	}

	/**
	 * ʵ��ѡ��������㷨
	 * @param array
	 * @return
	 */
	public static int[] selectSort(int[] array)
	{
		int[] newArray = Arrays.copyOf(array, array.length); // ���(�����޸�ԭ��������Ԫ��˳��)
		int min = 0; // ��¼��Ԫ�����ڵ�λ��
		for (int i = 0; i < array.length; i++)
		{
			min = i;
			for (int j=i+1; j<newArray.length; j++)
			{
				if (newArray[min] > newArray[j])
				{
					min = j; // ��¼ÿһ����СԪ�����ڵ�λ��
				}
			}
			
			if (min != i)     // �����ǰλ�ò�����СԪ�صĻ����ͽ���
			{
				int tmp = newArray[i];
				newArray[i] = newArray[min];
				newArray[min] = tmp;
			}
		}
		return newArray;
	}
}
