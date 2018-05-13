package test;

import java.util.Arrays;

import javax.naming.ldap.SortControl;

public class ArrayCopy
{
	public static void main(String[] args)
	{
		int[] s = {4, 3, 2, 1};
		System.out.println("≈≈–Ú«∞£∫" + Arrays.toString(s));
		sort(s);
	}
	
	public static void sort(int[] array)
	{
		for (int i=0; i<array.length; i++)
		{
			for (int j=i+1; j<array.length; j++)
			{
				if (array[i] > array[j])
				{
					int tmp = array[i];
					array[i] = array[j];
					array[j] = tmp;
				}
			}
		}
		System.out.println("≈≈–Ú∫Û:" + Arrays.toString(array));
	}
}
