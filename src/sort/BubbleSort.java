/**
 * ʵ��ð�������㷨
 */
package sort;

import java.util.Arrays;

public class BubbleSort
{
	public static void main(String[] args)
	{
		int[] s = {8, 2, 5, 3, 9, 7};
		int[] newArray = bubbleSort(s);
		System.out.println("����ǰ��" + Arrays.toString(s));
		System.out.println("�����" + Arrays.toString(newArray));
	}
	
	/**
	 * ð������
	 * @param array
	 * @return
	 */
	public static int[] bubbleSort(int[] array)
	{
		int[] newArray = Arrays.copyOf(array, array.length); 
		for (int i = 0; i < newArray.length-1; i++) // �Ƚϵ�����
		{
			for (int j=0; j< newArray.length-1-i; j++) // ÿһ�������ȽϵĴ���
			{
				if (newArray[j] > newArray[j+1])
				{
					int tmp = newArray[j];
					newArray[j] = newArray[j+1];
					newArray[j+1] = tmp;
				}
			}
		}
		return newArray;
	}
}
