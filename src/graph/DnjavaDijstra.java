/**
 * ����Dijkstra����ⵥԴ���·��
 */
package graph;

public class DnjavaDijstra
{
	private final static int MAXVEX = 9; // ��󶥵���
	private final static int MAXWEIGHT = 65535;  // ����Ȩ��
	private int shortTablePath[] = new int[MAXVEX];  // ���ڴ洢v0���������·����Ȩֵ��
	
	/**
	 * ��ȡһ��ͼ�����·��
	 */
	public void shortestPathDijstra(Graph graph)
	{
		int min;
		int k = 0; // ��¼�±�
		boolean isgetPath[] = new boolean[MAXVEX]; // v0��ĳ����������·��,Ĭ����false����ʾ��û��ȷ��
		for (int v=0; v<graph.getVertexSize(); v++)
		{
			shortTablePath[v] = graph.getMatrix()[0][v];
		}
		shortTablePath[0] = 0;  // ���Լ��ľ���Ϊ0���Խ���Ϊ0��
		isgetPath[0] = true; // �õ��˵�����0����̾���
		
		for (int v=1; v<graph.getVertexSize(); v++)
		{
			min = MAXWEIGHT;
			// ����ÿһ�е�Ȩֵ���ҵ�������С�ģ���¼����
			for (int w=0; w<graph.getVertexSize(); w++)
			{
				// û���ҵ�������w����̾�����v��w֮���б�
				if (!isgetPath[w] && shortTablePath[w] < min) // ��ȡ�н���Ķ�����±�
				{
					k = w;
					min = shortTablePath[w];
				}
			}
			// �ҵ�����k����������·��
			isgetPath[k] = true;
			
			for (int j=0; j<graph.getVertexSize(); j++)
			{
				if (!isgetPath[j] && (min+graph.getMatrix()[k][j] < shortTablePath[j]))
				{
					shortTablePath[j] = min + graph.getMatrix()[k][j];
				}
			}
		}
		
		for (int i=0; i<shortTablePath.length; i++)
		{
			System.out.println("V0��V"+i+"�����·��Ϊ:"+shortTablePath[i]);
		}
	}
	
	public static void main(String[] args)
	{
		Graph graph = new Graph(MAXVEX);
		graph.createGraph();
		int[][] matrix = {};
		new DnjavaDijstra().shortestPathDijstra(graph);
	}
}
