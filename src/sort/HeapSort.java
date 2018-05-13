/**
 * ʵ�ֶ�����
 * https://www.cnblogs.com/chengxiao/p/6129630.html
 * ������Ļ���˼���ǣ������������й����һ���󶥶ѣ���ʱ���������е����ֵ���ǶѶ��ĸ��ڵ㡣
 * ������ĩβԪ�ؽ��н�������ʱĩβ��Ϊ���ֵ��Ȼ��ʣ��n-1��Ԫ�����¹����һ���ѣ�
 * ������õ�n��Ԫ�صĴ�Сֵ����˷���ִ�У����ܵõ�һ������������
 */
package sort;

import java.util.Arrays;

public class HeapSort
{
	public static void main(String[] args)
	{
		int[] array = {83, 3, 2, 6, 10, 44, 38, 28, 5, 1, 0, 36};
		System.out.println("����ǰ��" + Arrays.toString(array));
		HeapSort hs = new HeapSort();
		hs.heapSort(array);
		System.out.println("�����" + Arrays.toString(array));
	}
	
	public void heapSort(int[] array)
	{
		if (array==null || array.length<=1)
		{
			return;
		}
		// �������
		buidMaxHeap(array);
		for (int i=array.length-1; i>=1; i--)
		{
			// һ�δ�ѹ�������Ԫ�ؾͻ��Ϊ�±�Ϊ0��Ԫ��
			exchangeElements(array, 0, i); // ������β����Ԫ��
			maxHeap(array, i, 0); // ��0��ʼ����Ϊ���е�һ�δ�ѹ���󣬳��˶������г��˵�0��Ԫ���⣬���������󶥶�Ҫ��
		}
	}

	private void buidMaxHeap(int[] a)
	{
		 int half = (a.length - 1) / 2; // ֻ�����һ�룬�Ϳ��ҵ�����Ԫ��
		 for (int i=half; i>=0; i--) // �Ӻ���ǰ�Ĺ�������
		 {
			 maxHeap(a, a.length, i); // ���ݣ� ���ȣ� �ӵ�i��Ԫ�ؿ�ʼ
		 }
	}

	/**
	 * ��� 
	 * @param a ������ݵ�����
	 * @param length  ���ݵĳ���
	 * @param i   ��ʼ�����λ��
	 */
	private void maxHeap(int[] a, int length, int i)
	{
		int left = i*2+1;
		int right = i*2+2;
		int largest = i;
		// �ҵ��ö������е����ֵ
		if (left<length && a[left]>a[i])
		{
			largest = left;
		}
		
		if (right<length && a[right]>a[largest])
		{
			largest = right;
		}
		
		if (i != largest)
		{
			// �������ݽ���
			exchangeElements(a, i, largest);
			// ��Ϊlargest�����ĸ��ڵ�λ�÷����˸ı䣬��Ҫ����largestΪ���Ķ��������е���
			maxHeap(a, length, largest); 
		}
	}
	
	private void exchangeElements(int[] a, int i, int largest)
	{
		int tmp = a[i];
		a[i] = a[largest];
		a[largest] = tmp;
	}
}
