/**
 * ʵ��ֱ�Ӳ�������
 */
package sort;

import java.util.Arrays;

public class InsertSort
{
	public static void main(String[] args)
	{
		int[] s = {8, 2, 5, 3, 9, 7};
		int[] newArray = InsertSort(s);
		System.out.println("����ǰ��" + Arrays.toString(s));
		System.out.println("�����" + Arrays.toString(newArray));
	}
	
	/**
	 * ֱ�Ӳ�������
	 * @param array
	 * @return
	 */
	public static int[] InsertSort(int[] array)
	{
		int[] newArray = Arrays.copyOf(array, array.length); // ����ԭ����
		for (int i=1; i<newArray.length; i++) // ֻ��һ��Ԫ��ʱ������Ҫ�ƶ�
		{
			int tmp = newArray[i]; // �±�����ֵ���ȴ����뵽ǰ�����������
			int j; 
			for (j=i-1; j>=0; j--)
			{
				// ������tmp�����������ƶ�
				if (newArray[j] > tmp)
				{
					newArray[j+1] = newArray[j];
				}
				else
				{
					break;
				}
			}
			newArray[j+1] = tmp;
		}
		return newArray;
	}

}
