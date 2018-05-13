/**
 * ����DijkstraAlog��ⵥԴ���·��
 * ��֪ͼG=(V,E),�ҳ���ĳ������Դ�ڵ�S����V��ÿһ���ڵ�����·��
 */
package dynamicplan;

import java.util.Scanner;

public class DijkstraAlgo
{
	private final static int MAXVEX = 9; // ��󶥵���
	private final static int MAXWEIGHT = 65535; // ����Ȩ��(��ʾ��������֮��û������)
	private int shortTablePath[] = new int[MAXVEX]; // �洢v0�����ඥ������·��
	
	public void shortestPathDijkstra(int[][] matrix)
	{
		int min = 0;
		int k = 0; // ��¼��СȨֵ�Ķ����λ��
		boolean isGetPath[] = new boolean[MAXVEX]; // �ж�v0��ĳ����������·���Ƿ��Ѿ��ҵ���Ĭ��û���ҵ�
		for (int v=0; v<MAXVEX; v++)
		{
			shortTablePath[v] = matrix[0][v]; // ��ʼ״̬ʱ��v0���������̾���
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
			
			// �ҵ�����k����������·��
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
			System.out.println("V0��V"+i+"�����·����:"+shortTablePath[i]);
		}
	}
	
	public static void main(String[] args)
	{
		// �ڽӾ���
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

