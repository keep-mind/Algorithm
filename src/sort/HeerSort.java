/**
 * ʵ��ϣ������
 */
package sort;

import java.util.Arrays;

public class HeerSort
{
	public static void main(String[] args)
	{
		int[] array = {83, 3, 2, 6, 10, 44, 38, 28, 5, 1, 0, 36};
		System.out.println("����ǰ��" + Arrays.toString(array));
		int d = array.length / 2; // dΪ����, Ĭ��������6
		while (true)
		{
			for (int i=0; i<d; i++) // �����Ǵ�0��d
			{
				for (int j=i; j+d<array.length; j+=d)
				{
					for (int k=i; k+d<array.length; k+=d)  // ����һ��forѭ��������ð������
					{
						int tmp; // ��ʱ����
						if (array[k] > array[k+d])
						{
							tmp = array[k];
							array[k] = array[k+d];
							array[k+d] = tmp;
						}
					}
				}
			}
			System.out.println("����d:"+ d + "  " +Arrays.toString(array));
			if (d < 1)
			{
				break;
			}
			d -= 2;
		}
		System.out.println("�����" + Arrays.toString(array));
	}
	
	/**
	 * �������ϣ������(�����)
	 */
	private void sort()
	{
		int[] array = {83, 3, 2, 6, 10, 44, 38, 28, 5, 1, 0, 36};
		System.out.println("����ǰ��" + Arrays.toString(array));
		int d = array.length / 2; // dΪ����, Ĭ��������6
		while (true)
		{
			for (int j=0; j+d<array.length; j+=1)
			{
				if (array[j] > array[j+d])
				{
					int tmp = array[j];
					array[j] = array[j+d];
					array[j+d] = tmp;
				}
			}
			System.out.println("����d:"+ d + "  " +Arrays.toString(array));
			d--; // ��������
			if (d<1)
			{
				break;
			}
		}
		System.out.println("�����" + Arrays.toString(array));
	}
}
