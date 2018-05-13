/**
 * 利用DijkstraAlog求解单源最短路径
 * 已知图G=(V,E),找出从某给定的源节点S，到V中每一个节点的最短路径
 */
package dynamicplan;

import java.util.Scanner;

public class DijkstraAlgo
{
	private final static int MAXVEX = 9; // 最大顶点数
	private final static int MAXWEIGHT = 65535; // 最大的权重(表示两个顶点之间没有连线)
	private int shortTablePath[] = new int[MAXVEX]; // 存储v0到其余顶点的最短路径
	
	public void shortestPathDijkstra(int[][] matrix)
	{
		int min = 0;
		int k = 0; // 记录最小权值的顶点的位置
		boolean isGetPath[] = new boolean[MAXVEX]; // 判断v0到某个顶点的最短路径是否已经找到，默认没有找到
		for (int v=0; v<MAXVEX; v++)
		{
			shortTablePath[v] = matrix[0][v]; // 初始状态时，v0到各点的最短距离
		}
		
		shortTablePath[0] = 0;
		isGetPath[0] = true;
		
		for (int v=1; v<MAXVEX; v++)
		{
			min = MAXWEIGHT;
			for (int w=0; w<MAXVEX; w++)
			{
				if (!isGetPath[w] && shortTablePath[w] < min)
				{
					k = w;
					min = shortTablePath[w];
				}
			}
			
			// 找到到第k个顶点的最短路径
			isGetPath[k] = true;
			
			for (int j=0; j<MAXVEX; j++)
			{
				if (!isGetPath[j] && (min + matrix[k][j] < shortTablePath[j]))
				{
					shortTablePath[j] = min + matrix[k][j];
				}
			}
		}
		
		for (int i=0; i<shortTablePath.length; i++)
		{
			System.out.println("V0到V"+i+"的最短路径是:"+shortTablePath[i]);
		}
	}
	
	public static void main(String[] args)
	{
		// 邻接矩阵
		int[][] matrix = {
				{0,1,5,MAXWEIGHT,MAXWEIGHT,MAXWEIGHT,MAXWEIGHT,MAXWEIGHT,MAXWEIGHT},
				{1,0,3,7,5,MAXWEIGHT,MAXWEIGHT,MAXWEIGHT,MAXWEIGHT},
				{5,3,0,MAXWEIGHT,1,7,MAXWEIGHT,MAXWEIGHT,MAXWEIGHT},
				{MAXWEIGHT,7,MAXWEIGHT,0,2,MAXWEIGHT,3,MAXWEIGHT,MAXWEIGHT},
				{MAXWEIGHT,5,1,2,0,3,6,9,MAXWEIGHT},
				{MAXWEIGHT,MAXWEIGHT,7,MAXWEIGHT,3,0,MAXWEIGHT,5,MAXWEIGHT},
				{MAXWEIGHT,MAXWEIGHT,MAXWEIGHT,3,6,MAXWEIGHT,0,2,7},
				{MAXWEIGHT,MAXWEIGHT,MAXWEIGHT,MAXWEIGHT,9,5,2,0,4},
				{MAXWEIGHT,MAXWEIGHT,MAXWEIGHT,MAXWEIGHT,MAXWEIGHT,MAXWEIGHT,7,4,0},
		};
		
		new DijkstraAlgo().shortestPathDijkstra(matrix);
	}
}

