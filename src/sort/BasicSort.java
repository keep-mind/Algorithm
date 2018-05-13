package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BasicSort
{
	public void sort(int[] array)
	{
		int max = 0;  // ��¼������
		for (int i=0; i<array.length; i++)
		{
			if (max < array[i])
			{
				max = array[i];
			}
		}
		int times = 0; // ��ȡ��������λ��
		while (max > 0)
		{
			max /= 10;
			times++;
		}
		// ����һ����ά����
		List<ArrayList> queue = new ArrayList<>(); // ��ά����
		for (int i=0; i<10; i++)
		{
			ArrayList q = new ArrayList();
			queue.add(q);
		}
		
		for (int i=0; i<times; i++)
		{
			for (int j=0; j<array.length; j++)
			{
				// ��ȡ��Ӧ��λ��ֵ(iΪ0�Ǹ�λ��1��ʮλ����������)
				int x = array[j] % (int)Math.pow(10, i+1) / (int)Math.pow(10, i);
				ArrayList q = queue.get(x);
				q.add(array[j]);
//				queue.set(x,  q); // ����
			}
			// ��ʼ�ռ�
			int count = 0;
			for (int j=0; j<10; j++)
			{
				while (queue.get(j).size()>0)
				{
					ArrayList<Integer> q = queue.get(j); // �õ�ÿһ������
					array[count] = q.get(0); // �õ��������еĵ�һ��Ԫ��
					q.remove(0);
					count++;
				}
			}
		}
	}
	
	public static void main(String[] args)
	{
		int [] a = {136,2,6,8,9,2,8,11,23,56,34,90,89,29,145,209,320,78,3};
		BasicSort bs = new BasicSort();
		bs.sort(a);
		System.out.println("�����" + Arrays.toString(a));
	}
}
