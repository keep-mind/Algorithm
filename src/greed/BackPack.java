/**
 * 使用贪心算法求解背包问题
 */
package greed;

import java.io.DataOutputStream;
import java.util.Arrays;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class BackPack
{
	private final static int MAX_WEIGHT = 20; // 背包最大承受量(kg)
	// 每件物品的重量
	private static int[] weights = new int[] {3, 4, 5, 7, 6}; 
	private static int[] values = new int[] {4, 5, 2, 8, 9};
	
	private void backPackGreedy(int capacity, int weights[], int[] values)
	{
		int n = weights.length; // 物品数量
		double[] r = new double[n]; // 性价比（单位质量的物品的价格）
		int[] index = new int[n]; // 按照性价比排序后的物品的下标
		for (int i=0; i<n; i++)
		{
			r[i] = (double)values[i] / weights[i];
			index[i] = i; // 默认排序
		}
		
		double temp = 0;
		int max = 0; // 记录性价比最大的物品
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
			
			if (max != i) // 说明第i+1次循环时，第i件物品的价值不是相对较大的
			{
				temp = r[i];
				r[i] = r[max];
				r[max] = temp;
				// 将第i件物品放置到合适的位置（按照性价比从大到小的顺序）
				int x = index[i];
				index[i] = index[max];
				index[max] = x;
			}
			
		}
		// 将排序好的重量和价值分别存到数组
		int[] w1 = new int[n];
		int[] v1 = new int[n];
		for (int i=0; i<n; i++)
		{
			int k = index[i]; // 性价比排名第i+1物品的下标
			w1[i] = weights[k];
			v1[i] = values[k];
		}
		// 装包
		int[] x = new int[n]; // 默认值是0，表示没有装入
		int maxValue = 0; // 记录放入背包的物品的总价值
		for (int i=0; i<n; i++)
		{
			if (w1[i] < capacity)  // 还有一种情况是性价比相同，这就要先对性价比相同的按照质量排序从大到小，不过这样也不一定就合适
			{
				// 还可以装得下
				x[i] = 1; // 表示该物品装入包中
				maxValue += v1[i];
				capacity -= w1[i];
			}
		}
		System.out.println("总共放下的物品数量:" + Arrays.toString(x));
		System.out.println("总价值：" + maxValue);
	}
	
	public static void main(String[] args)
	{
		BackPack b = new BackPack();
		b.backPackGreedy(MAX_WEIGHT, weights, values);
	}
}
