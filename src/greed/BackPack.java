/**
 * ʹ��̰���㷨��ⱳ������
 */
package greed;

import java.io.DataOutputStream;
import java.util.Arrays;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class BackPack
{
	private final static int MAX_WEIGHT = 20; // ������������(kg)
	// ÿ����Ʒ������
	private static int[] weights = new int[] {3, 4, 5, 7, 6}; 
	private static int[] values = new int[] {4, 5, 2, 8, 9};
	
	private void backPackGreedy(int capacity, int weights[], int[] values)
	{
		int n = weights.length; // ��Ʒ����
		double[] r = new double[n]; // �Լ۱ȣ���λ��������Ʒ�ļ۸�
		int[] index = new int[n]; // �����Լ۱���������Ʒ���±�
		for (int i=0; i<n; i++)
		{
			r[i] = (double)values[i] / weights[i];
			index[i] = i; // Ĭ������
		}
		
		double temp = 0;
		int max = 0; // ��¼�Լ۱�������Ʒ
		for (int i=0; i<n-1; i++)
		{
			max = i;
			for (int j=i+1; j<n; j++)
			{
				if (r[max] < r[j])
				{
					max = j;
				}
			}
			
			if (max != i) // ˵����i+1��ѭ��ʱ����i����Ʒ�ļ�ֵ������Խϴ��
			{
				temp = r[i];
				r[i] = r[max];
				r[max] = temp;
				// ����i����Ʒ���õ����ʵ�λ�ã������Լ۱ȴӴ�С��˳��
				int x = index[i];
				index[i] = index[max];
				index[max] = x;
			}
			
		}
		// ������õ������ͼ�ֵ�ֱ�浽����
		int[] w1 = new int[n];
		int[] v1 = new int[n];
		for (int i=0; i<n; i++)
		{
			int k = index[i]; // �Լ۱�������i+1��Ʒ���±�
			w1[i] = weights[k];
			v1[i] = values[k];
		}
		// װ��
		int[] x = new int[n]; // Ĭ��ֵ��0����ʾû��װ��
		int maxValue = 0; // ��¼���뱳������Ʒ���ܼ�ֵ
		for (int i=0; i<n; i++)
		{
			if (w1[i] < capacity)  // ����һ��������Լ۱���ͬ�����Ҫ�ȶ��Լ۱���ͬ�İ�����������Ӵ�С����������Ҳ��һ���ͺ���
			{
				// ������װ����
				x[i] = 1; // ��ʾ����Ʒװ�����
				maxValue += v1[i];
				capacity -= w1[i];
			}
		}
		System.out.println("�ܹ����µ���Ʒ����:" + Arrays.toString(x));
		System.out.println("�ܼ�ֵ��" + maxValue);
	}
	
	public static void main(String[] args)
	{
		BackPack b = new BackPack();
		b.backPackGreedy(MAX_WEIGHT, weights, values);
	}
}
